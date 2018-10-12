package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Users.Roles;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.Collection;

@Repository
public interface RolesRepository extends Neo4jRepository<Roles, Long> {

    @Query("match (n:ROLES{name:{name}}),p=((n)-[*]-(m)) return p")
    Collection<Roles> path_Roles(@Param("name") String name);
}
