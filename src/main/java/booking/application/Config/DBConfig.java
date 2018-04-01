package booking.application.Config;



import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;



@Configuration
@ComponentScan("booking.application")
@EnableJpaRepositories("booking.application")
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/booking");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root_123");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter vendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		//adapter.setShowSql(true);
		//adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		return adapter;
	}
	
	@Bean
	public EntityManager entityManager() {
		
		return entityManagerFactory().getObject().createEntityManager();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setJpaVendorAdapter(vendorAdapter());
		em.setPackagesToScan("booking.application");
		return em;
	}
}
