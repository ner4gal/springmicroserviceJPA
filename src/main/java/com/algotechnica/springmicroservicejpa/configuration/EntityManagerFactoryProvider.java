package com.algotechnica.springmicroservicejpa.configuration;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import static org.eclipse.persistence.config.PersistenceUnitProperties.CACHE_SHARED_DEFAULT;
import static org.eclipse.persistence.config.PersistenceUnitProperties.CLASSLOADER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.CONNECTION_POOL_MAX;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_DATABASE_GENERATION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_GENERATION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_GENERATION_MODE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DROP_AND_CREATE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.LOGGING_LEVEL;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.springframework.instrument.classloading.SimpleLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

/**
 * This class EntityManagerFactoryProvider provides EntityManager services
 * 
 * @author 
 * @version 1.0
 * @since 
 */
public class EntityManagerFactoryProvider {

	/**
	 * Based on the given {@link DataSource} instance, create and configure an
	 * EntityManagerFactory. Part of this configuration is that the given packages
	 * are scanned for entity classes, so that the created EntityManagers know about
	 * them.
	 */
	public static LocalContainerEntityManagerFactoryBean get(DataSource dataSource, String... packagesToScan) {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setPersistenceProvider(new PersistenceProvider());
		entityManagerFactoryBean.setPackagesToScan(packagesToScan);
		entityManagerFactoryBean.setDataSource(dataSource);

		// for JPA we use the classloader that Spring uses to avoid classloader issues
		entityManagerFactoryBean.setJpaPropertyMap(getJPAProperties(dataSource.getClass().getClassLoader()));
		entityManagerFactoryBean.setLoadTimeWeaver(new SimpleLoadTimeWeaver());
		entityManagerFactoryBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());

		entityManagerFactoryBean.afterPropertiesSet();

		return entityManagerFactoryBean;
	}

	/**
	 * Set some basic properties. In our case the database schema is created (or
	 * extended) automatically. Find more properties under
	 * org.eclipse.persistence.config.PersistenceUnitProperties
	 */
	private static Map<String, Object> getJPAProperties(ClassLoader classLoader) {
		Map<String, Object> properties = new HashMap<>();

		properties.put(DDL_GENERATION, DROP_AND_CREATE);
		properties.put(DDL_GENERATION_MODE, DDL_DATABASE_GENERATION);
		properties.put(CLASSLOADER, classLoader);
		properties.put(LOGGING_LEVEL, "INFO"); // "FINE" provides more details

		// do not cache entities locally, as this causes problems if multiple
		// application instances are used
		properties.put(CACHE_SHARED_DEFAULT, "false");

		// You can also tweak your application performance by configuring your database
		// connection pool.
		// http://www.eclipse.org/eclipselink/documentation/2.4/jpa/extensions/p_connection_pool.htm
		properties.put(CONNECTION_POOL_MAX, 50);

		return properties;
	}
}