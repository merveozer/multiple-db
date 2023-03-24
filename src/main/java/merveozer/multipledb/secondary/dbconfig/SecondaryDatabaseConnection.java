package merveozer.multipledb.secondary.dbconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondaryEntityManagerFactory", 
		transactionManagerRef = "secondaryTransactionManager", 
		basePackages = {"merveozer.multipledb.secondary.repository"})
public class SecondaryDatabaseConnection {


	@Value("${spring.secondary.datasource.url}")
	private String url;
	
	@Value("${spring.secondary.datasource.username}")
	private String username;
	
	@Value("${spring.secondary.datasource.password}")
	private String password;

	
    @Bean(name="secondaryDbDataSource")
    public DataSource secondaryDbDataSource() {
        return DataSourceBuilder.create()
        		.url(url)
        		.username(username)
        		.password(password)
        		.build();
    }
	
    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
    		@Qualifier("secondaryDbDataSource") DataSource secondaryDataSource, 
    		EntityManagerFactoryBuilder builder) {
        return builder
        		.dataSource(secondaryDataSource)
        		.packages("merveozer.multipledb.secondary.model")
                .build();
    }
	

    @Bean(name = "secondaryTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(
			@Qualifier("secondaryEntityManagerFactory") EntityManagerFactory
			secondaryEntityManagerFactory) {
		return new JpaTransactionManager(secondaryEntityManagerFactory);
	}
	
}
