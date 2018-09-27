package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Users.Movies;
import movies.spring.data.neo4j.domain.Users.Users;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;


public interface UsersRepository extends Neo4jRepository<Movies, Long> {

    @Query("match (startUsers:USERS)-[r:IS_FRIEND_OF]->(endUsers:USERS) return startUsers,r,endUsers")
    Collection<Users> AllFriend();

    @Query("match (users:USERS)-[r:HAS_SEEN]->(movies:MOVIES) return users,r,movies")
    Collection<Users> AllHaseen();
}
