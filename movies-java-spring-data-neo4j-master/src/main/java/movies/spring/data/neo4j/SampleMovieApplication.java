package movies.spring.data.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
//@SpringBootApplication
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableTransactionManagement(order = 2)	//设置事务执行顺序(需要在切换数据源之后，否则只走默认库)
//@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
public class SampleMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleMovieApplication.class, args);
    }
}