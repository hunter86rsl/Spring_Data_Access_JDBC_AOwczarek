package info.owczarek.spring.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


@Repository
public class ProductsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getNumberOfProducts() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM products", Integer.class);
    }

    public int getNumberOfProductsWithPriceGreaterThan(double priceLimit) {
        String sql = "SELECT count(*) FROM products WHERE buyPrice > ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, priceLimit);
    }
	
	public Map<String, Object> getProductByProductCode(String productCode) {
        String sql = "SELECT * FROM products WHERE productCode = ?";
        return jdbcTemplate.queryForMap(sql, productCode);
    }

    public List<Map<String, Object>> getProductsWithPriceGreaterThen(double priceLimit) {
        String sql = "SELECT * FROM products WHERE buyPrice > ?";
        return jdbcTemplate.queryForList(sql, priceLimit);
    }
}
