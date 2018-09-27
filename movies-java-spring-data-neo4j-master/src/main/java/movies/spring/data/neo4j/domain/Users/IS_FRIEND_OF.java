package movies.spring.data.neo4j.domain.Users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@RelationshipEntity(type = "IS_FRIEND_OF")
public class IS_FRIEND_OF {
    @Id
    @GeneratedValue
    private Long id;
    private String friend;

    @StartNode
    private Users startUsers;

    @EndNode
    private Users endUsers;

    public Users getStartUsers() {
        return startUsers;
    }

    public void setStartUsers(Users startUsers) {
        this.startUsers = startUsers;
    }

    public Users getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(Users endUsers) {
        this.endUsers = endUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }
}
