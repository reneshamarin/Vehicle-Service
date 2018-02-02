package com.tutycarcare.service.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tutycarcare.service.backend.constants.MyBatisConstants;

/**
 * Contains the configuration details of the MyBatis ORM and SqlSession Factory
 * to connect master_db
 * 
 * @author renesha
 *
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = { "com.tutycarcare.service.backend.mapper" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class MyBatisConfig {
	
	DataSourceTransactionManager txManager;

	@Autowired
	Environment environment;
	
	@Primary
	@Bean(name = MyBatisConstants.POOLED_DATA_SOURCE)
	DataSource pooledDataSource() {
		PooledDataSourceFactory factory = new PooledDataSourceFactory();

		Properties properties = new Properties();
		properties.setProperty(MyBatisConstants.DRIVER, environment.getProperty(MyBatisConstants.DB_DRIVER));
		properties.setProperty(MyBatisConstants.URL, environment.getProperty(MyBatisConstants.DB_URL));
		properties.setProperty(MyBatisConstants.USERNAME, environment.getProperty(MyBatisConstants.DB_USERNAME));
		properties.setProperty(MyBatisConstants.PASSWORD, environment.getProperty(MyBatisConstants.DB_PASSWORD));
		properties.setProperty(MyBatisConstants.POOL_PING_ENABLED, "true");
		properties.setProperty(MyBatisConstants.POOL_PING_QUERY, "SELECT 1");
		factory.setProperties(properties);
		return factory.getDataSource();
	}

	@Bean(name = MyBatisConstants.SQL_SESSION_FACTORY)
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		// factoryBean.setConfiguration(configuration);
		factoryBean.setDataSource(pooledDataSource());
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
		config.setAutoMappingBehavior(AutoMappingBehavior.FULL);
		config.setMapUnderscoreToCamelCase(true);
		// config.setJdbcTypeForNull(JdbcType.UNDEFINED);
		config.setCallSettersOnNulls(true);
		factoryBean.setConfiguration(config);
		return factoryBean.getObject();

	}

	/**
	 * Creating a bean to get the transaction manager.
	 * 
	 * @return {@link PlatformTransactionManager}
	 */
	@Bean(name = MyBatisConstants.TRANSACTION_MANAGER)
	public PlatformTransactionManager transactionManager() {
		if (txManager == null)
			txManager = new DataSourceTransactionManager(pooledDataSource());
		return txManager;
	}

}
