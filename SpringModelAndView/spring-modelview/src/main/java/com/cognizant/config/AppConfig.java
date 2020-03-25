package com.cognizant.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.cognizant")
@PropertySource("classpath:db.properties")
public class AppConfig {

	@Bean
	public ViewResolver internalResourceViewResolver() {

	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	   // bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}

	@Autowired
	private Environment env;


	@Bean("datasource")
	public DataSource dataSource() {
	

        DriverManagerDataSource datasource = new DriverManagerDataSource();

        //MySQL database we are using

        datasource.setDriverClassName(env.getProperty("DB_DRIVER_CLASS"));
        datasource.setUrl(env.getProperty("DB_URL"));
        datasource.setUsername(env.getProperty("DB_USERNAME"));
        datasource.setPassword(env.getProperty("DB_PASSWORD"));
        return datasource;

	}


	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
	       JdbcTemplate js = new JdbcTemplate(ds);
	        return js;
	}
}
