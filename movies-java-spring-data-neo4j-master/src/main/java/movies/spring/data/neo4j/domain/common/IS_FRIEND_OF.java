package movies.spring.data.neo4j.domain.common;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.Users.Users;
import org.neo4j.ogm.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@RelationshipEntity(type = "IS_FRIEND_OF")
public class IS_FRIEND_OF extends LabelClassName {
    @Id
    @GeneratedValue
    private Long id;
    private String friend;

    @StartNode
    private Users startUsers;

    @EndNode
    private Users endUsers;
    private String className = "IS_FRIEND_OF";

    public String getClassName() {
        return "IS_FRIEND_OF";
    }



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

    private String mySelf = "IS_FRIEND_OF";

    public String getMySelf() {
        return "IS_FRIEND_OF";
    }

    public void setMySelf(String mySelf) {
        this.mySelf = mySelf;
    }


}
