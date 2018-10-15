package movies.spring.data.neo4j.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

//    @Bean(name = "Neo4j")
//    @ConfigurationProperties(prefix = "spring.neo4j")
//    public DataSource dataSourceNeo4j() {
//        System.out.println("主配:Neo4j");
//        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
//                .uri("bolt://localhost")
//                .credentials("user", "secret")
//                .build();
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "MySql")
    @ConfigurationProperties(prefix = "spring.mysql")
    public DataSource dataSourceMySql() {
        System.out.println("从配:MySql");
        return DataSourceBuilder.create().build();
    }

    @Bean(name="dynamicDataSource")
    @Primary    //优先使用，多数据源
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
   //     DataSource master = dataSourceNeo4j();
        DataSource slave = dataSourceMySql();
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(slave);
        //配置多数据源
        Map<Object,Object> map = new HashMap<>();
    //    map.put(DataSourceType.Neo4j.getName(), master);	//key需要跟ThreadLocal中的值对应
        map.put(DataSourceType.MySql.getName(), slave);
        dynamicDataSource.setTargetDataSources(map);
        return dynamicDataSource;
    }

}

