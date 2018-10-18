package movies.spring.data.neo4j.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//@Configuration
public class DataSourceConfig {
//    @Value("${spring.datasource.url}")
//    private String dbUrl;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.driverClassName}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.initialSize}")
//    private int initialSize;
//
//    @Value("${spring.datasource.minIdle}")
//    private int minIdle;
//
//    @Value("${spring.datasource.maxActive}")
//    private int maxActive;
//
//    @Value("${spring.datasource.maxWait}")
//    private int maxWait;
//
//    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
//    private int timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
//    private int minEvictableIdleTimeMillis;
//
//    @Value("${spring.datasource.validationQuery}")
//    private String validationQuery;
//
//    @Value("${spring.datasource.testWhileIdle}")
//    private boolean testWhileIdle;
//
//    @Value("${spring.datasource.testOnBorrow}")
//    private boolean testOnBorrow;
//
//    @Value("${spring.datasource.testOnReturn}")
//    private boolean testOnReturn;
//
//    @Value("${spring.datasource.poolPreparedStatements}")
//    private boolean poolPreparedStatements;
//
//    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
//    private int maxPoolPreparedStatementPerConnectionSize;
//
//    @Value("${spring.datasource.filters}")
//    private String filters;
//
//    @Value("${spring.datasource.connectionProperties}")
//    private String connectionProperties;
//
////    @Bean(name = "Neo4j")
////    @ConfigurationProperties(prefix = "spring.neo4j")
////    public DataSource dataSourceNeo4j() {
////        System.out.println("主配:Neo4j");
////        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
////                .uri("bolt://localhost")
////                .credentials("user", "secret")
////                .build();
////        return DataSourceBuilder.create().build();
////    }
//
//    @Bean(name = "MySql")
//   // @ConfigurationProperties(prefix = "spring.mysql")
//    public DataSource dataSourceMySql() {
//        System.out.println("从配:MySql");
//        DruidDataSource datasource = new DruidDataSource();
//
//        datasource.setUrl(this.dbUrl);
//        datasource.setUsername(username);
//        datasource.setPassword(password);
//        datasource.setDriverClassName(driverClassName);
//
//        //configuration
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setValidationQuery(validationQuery);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//            System.out.println("druid configuration initialization filter");
//        }
//        datasource.setConnectionProperties(connectionProperties);
//
//        return datasource;
//      //  return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name="dynamicDataSource")
//    @Primary    //优先使用，多数据源
//    public DataSource dataSource() {
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//   //     DataSource master = dataSourceNeo4j();
//        DataSource slave = dataSourceMySql();
//        //设置默认数据源
//        dynamicDataSource.setDefaultTargetDataSource(slave);
//        //配置多数据源
//        Map<Object,Object> map = new HashMap<>();
//    //    map.put(DataSourceType.Neo4j.getName(), master);	//key需要跟ThreadLocal中的值对应
//        map.put(DataSourceType.MySql.getName(), slave);
//        dynamicDataSource.setTargetDataSources(map);
//        return dynamicDataSource;
//    }

}

