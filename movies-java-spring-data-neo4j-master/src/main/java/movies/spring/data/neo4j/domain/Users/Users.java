package movies.spring.data.neo4j.domain.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;


@NodeEntity(label = "USERS")
public class Users {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnoreProperties("startUsers")
    @Relationship(type = "IS_FRIEND_OF")
    private List<IS_FRIEND_OF>  friends= new ArrayList<IS_FRIEND_OF>();

    //忽略掉HAS_SEEN中的users（自身节点），不然会递归调用自身节点，形成死循环
    @JsonIgnoreProperties("users")
    @Relationship(type = "HAS_SEEN")
    private List<HAS_SEEN> users_seens = new ArrayList<HAS_SEEN>();


    public List<IS_FRIEND_OF> getFriends() {
        return friends;
    }

    public void setFriends(List<IS_FRIEND_OF> friends) {
        this.friends = friends;
    }

    public List<HAS_SEEN> getUsers_seens() {
        return users_seens;
    }

    public void setUsers_seens(List<HAS_SEEN> users_seens) {
        this.users_seens = users_seens;
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
