package dataaccess;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class SensorDataConfiguration {
	
	@Bean
	public SensorDataDao sensorDataDao(JdbcTemplate jdbcTemplate) {
		SensorDataDaoImpl sensorDataDao = new SensorDataDaoImpl();
		sensorDataDao.setJdbcTemplate(jdbcTemplate);
		return sensorDataDao;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("csabi");
		dataSource.setPassword("ae293147");
		dataSource.setJdbcUrl("jdbc:mysql://localhost/sajat");
		dataSource.setMinimumIdle(2);
		dataSource.setMaximumPoolSize(5);
		return dataSource;
	}
}
