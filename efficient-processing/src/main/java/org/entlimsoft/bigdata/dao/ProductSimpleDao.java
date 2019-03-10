package org.entlimsoft.bigdata.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

import org.entlimsoft.bigdata.entity.ProductEntity;
import org.entlimsoft.bigdata.framework.QueueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

public class ProductSimpleDao extends NamedParameterJdbcDaoSupport implements ProductDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductSimpleDao.class);

	private static final String PRODUCT_ID_FIELD = "product_id";

	private static final String DESCRIPTION_FIELD = "description";

	private static final String PRICE_FIELD = "price";

	private static final String STOCK_FIELD = "stock";

	private static final String insertSqlSentence = "INSERT INTO products (" + DESCRIPTION_FIELD + ", " + PRICE_FIELD
			+ ", " + STOCK_FIELD + ") VALUES (:description, :price, :stock)";

	private static final String selectSqlSentence = "SELECT " + PRODUCT_ID_FIELD + " , " + DESCRIPTION_FIELD + ", "
			+ PRICE_FIELD + ", " + STOCK_FIELD + " FROM products ORDER BY product_id";

	public static final RowMapper<ProductEntity> rowMapper = new RowMapper<ProductEntity>() {

		@Override
		public ProductEntity mapRow(ResultSet rs, int row) throws SQLException {

			return extract(rs);
		}

	};

	@Override
	public List<ProductEntity> findAll() {
		
		LOGGER.info("Fetch Size: {}", this.getJdbcTemplate().getFetchSize());
		

		return this.getNamedParameterJdbcTemplate().query(selectSqlSentence, rowMapper);

	}

	@Override
	public BlockingQueue<ProductEntity> getAllQueue() {

		BlockingQueue<ProductEntity> result = QueueFactory.createQueue(100);

		RowCallbackHandler rch = new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {

				try {
					result.put(extract(rs));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}
		};
		this.getNamedParameterJdbcTemplate().query(selectSqlSentence, rch);

		return result;

	}

	private static ProductEntity extract(ResultSet rs) throws SQLException {
		Integer idProduct = rs.getInt(PRODUCT_ID_FIELD);
		String description = rs.getString(DESCRIPTION_FIELD);
		Double price = rs.getDouble(PRICE_FIELD);
		Integer stock = rs.getInt(STOCK_FIELD);
		return new ProductEntity(idProduct, description, price, stock);

	}

	@Override
	public int[] insertProducts(List<ProductEntity> products) {

		List<SqlParameterSource> batchArgs = new ArrayList<>();
		
		
		products.forEach(product -> batchArgs.add(setParameters(product)));
		
		
		return this.getNamedParameterJdbcTemplate().batchUpdate(insertSqlSentence, batchArgs.stream().toArray(SqlParameterSource[]::new));

	}

	private SqlParameterSource setParameters(ProductEntity product) {
		return new MapSqlParameterSource().addValue(DESCRIPTION_FIELD, product.getProductTO().getDescription())
				.addValue(PRICE_FIELD, product.getProductTO().getPrice()).addValue(STOCK_FIELD, product.getProductTO().getStock());
	}

}
