package movies.spring.data.neo4j.domain.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.common.HAS_SEEN;
import movies.spring.data.neo4j.domain.common.IS_FRIEND_OF;
import movies.spring.data.neo4j.domain.common.LabelClassName;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity(label = "USERS")
public class Users extends LabelClassName {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnoreProperties("startUsers")
    @Relationship(type = "IS_FRIEND_OF")
    private List<IS_FRIEND_OF> out_friend_of_user = new ArrayList<IS_FRIEND_OF>();


    //忽略掉HAS_SEEN中的users（自身节点），不然会递归调用自身节点，形成死循环
    @JsonIgnoreProperties("users")
    @Relationship(type = "HAS_SEEN", direction = Relationship.OUTGOING)
    private List<HAS_SEEN> has_seen_movies = new ArrayList<HAS_SEEN>();


//    private final String className = "Users";
//
//    public String getClassName() {
//        return className;
//    }


    public List<IS_FRIEND_OF> getOut_friend_of_user() {
        return out_friend_of_user;
    }

    public void setOut_friend_of_user(List<IS_FRIEND_OF> out_friend_of_user) {
        this.out_friend_of_user = out_friend_of_user;
    }

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

    public String getClassName(){
        return "Users";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        if (getId() != null ? !getId().equals(users.getId()) : users.getId() != null) return false;
        if (getName() != null ? !getName().equals(users.getName()) : users.getName() != null) return false;
        if (getOut_friend_of_user() != null ? !getOut_friend_of_user().equals(users.getOut_friend_of_user()) : users.getOut_friend_of_user() != null)
            return false;
        return getHas_seen_movies() != null ? getHas_seen_movies().equals(users.getHas_seen_movies()) : users.getHas_seen_movies() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getOut_friend_of_user() != null ? getOut_friend_of_user().hashCode() : 0);
        result = 31 * result + (getHas_seen_movies() != null ? getHas_seen_movies().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", out_friend_of_user=" + out_friend_of_user +
                ", has_seen_movies=" + has_seen_movies +
                '}';
    }
}
