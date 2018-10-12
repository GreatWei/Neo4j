package movies.spring.data.neo4j.domain.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.common.HAS_SEEN;
import movies.spring.data.neo4j.domain.common.IS_FRIEND_OF;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity(label = "USERS")
public class Users {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnoreProperties("startUsers")
    @Relationship(type = "IS_FRIEND_OF")
    private List<IS_FRIEND_OF> out_friend_of_user = new ArrayList<IS_FRIEND_OF>();

//    @JsonIgnoreProperties("startUsers")
//    @Relationship(type = "IS_FRIEND_OF")
//    private List<IS_FRIEND_OF> in_friend_of = new ArrayList<IS_FRIEND_OF>();


    //忽略掉HAS_SEEN中的users（自身节点），不然会递归调用自身节点，形成死循环
    @JsonIgnoreProperties("users")
    @Relationship(type = "HAS_SEEN",direction = Relationship.OUTGOING)
    private List<HAS_SEEN> has_seen_movies = new ArrayList<HAS_SEEN>();


    public List<IS_FRIEND_OF> getOut_friend_of_user() {
        return out_friend_of_user;
    }

    public void setOut_friend_of_user(List<IS_FRIEND_OF> out_friend_of_user) {
        this.out_friend_of_user = out_friend_of_user;
    }

//    public List<IS_FRIEND_OF> getIn_friend_of() {
//        return in_friend_of;
//    }
//
//    public void setIn_friend_of(List<IS_FRIEND_OF> in_friend_of) {
//        this.in_friend_of = in_friend_of;
//    }

    public List<HAS_SEEN> getHas_seen_movies() {
        return has_seen_movies;
    }

    public void setHas_seen_movies(List<HAS_SEEN> has_seen_movies) {
        this.has_seen_movies = has_seen_movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
