package dataaccess;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class SensorDataConfiguration2 {
	
	@Bean
	public SensorDataDao2 sensorDataDao2(SessionFactory sessionFactory) {
		return new SensorDataDao2Impl(sessionFactory);
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
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setAnnotatedClasses(SensorData2.class);
		return sessionFactoryBean;
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.DIALECT, MySQLDialect.class.getName());
		properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
