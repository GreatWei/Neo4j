package movies.spring.data.neo4j.repositories;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import movies.spring.data.neo4j.domain.Users.Movies;
import movies.spring.data.neo4j.domain.Users.Roles;
import movies.spring.data.neo4j.domain.Users.Users;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface UsersRepository extends Neo4jRepository<Map<String, Map<String, Object>>, Long> {


    @Query("match (startUsers:USERS)-[r:IS_FRIEND_OF]->(endUsers:USERS) return startUsers,r,endUsers")
    Collection<Users> AllFriend();

    @Query("match (users:USERS)-[r:HAS_SEEN]->(movies:MOVIES) return users,r,movies")
    Collection<Users> AllHaseen();

    @Query("match (users:USERS{name:\"John Johnson\"})-[r*1..2]->(m) return users,r,m")
    Collection<Users> AllRelation();


    @Query("match (n:USERS{name:\"Kate Smith\"}),(m:MOVIES{name:\"Fargo\"}),p=AllShortestPaths((n)-[*]-(m)) return p")
    Collection<Users> shortPath();

    @Query("match (n:USERS)-[r*1..2]-(m) where n.name =\"Kate Smith\" return n,r,m\n" +
            "union\n" +
            "match (n:MOVIES)-[r*1..2]-(m) where n.name=\"Fargo\" return n,r,m\n" +
            "union\n" +
            "match (n:USERS)-[r*1..2]-(m) where n.name =\"Kate Smith\" return n,r,m\n"+
            "union\n"+
            "match (n:ROLES)-[r*1..2]-(m) where n.name=\"HeHHH\" return n,r,m\n" )
    List<Map<String, Map<String, Object>>> path(@Param("name") String name, @Param("deep") String deep, @Param("nameList") String[] nameList);

    @Query("optional match(u:USERS) where u.name in[\"Kate Smith\",\"John Johnson\"] \n" +
            "optional match(m:MOVIES) where m.name in[\"Alien\"] \n" +
            "optional match(r:ROLES) where r.name in[\"AlAAA\"]\n" +
            "with collect(u)+collect(m)+collect(r) as nodes\n" +
            "unwind nodes as source\n" +
            "unwind nodes as target\n" +
            "with source,target where id(source)<id(target)\n" +
            "match path=allshortestpaths((source)-[r*1..]-(target)) where all(x in nodes(path) where 1=1)\n" +
            "with source,r,target\n" +
            "return r\n")
    List<Map<String, Map<String, Object>>> mixPath();

    @Query("optional match(u:USERS) where u.name in[\"John Johnson\"] \n" +
            "optional match(m:MOVIES) where m.name in[\"Alien\"] \n" +
            "optional match(r:ROLES) where r.name in[\"AlAAA\"]\n" +
            "with collect(u)+collect(m)+collect(r) as nodes\n" +
            "unwind nodes as source\n" +
            "unwind nodes as target\n" +
            "with source,target where id(source)<id(target)\n" +
            "match path=allshortestpaths((source)-[r*1..]-(target)) where all(x in nodes(path) where 1=1)\n" +
            "with r\n" +
            "match (n)-[r1]-(m) where r1 in r \n"+
            "return n,r1,m\n")
    List<Map<String, Map<String, Object>>> mixPath2();


    @Query(" match (n) where id(n) in {idList}  return n")
    List<Map<String, Map<String, Object>>> node(@Param("idList") List<Long> idList);

}
