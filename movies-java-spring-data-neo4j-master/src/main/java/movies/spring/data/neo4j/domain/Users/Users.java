package movies.spring.data.neo4j.domain.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private List<IS_FRIEND_OF> is_friend_ofs = new ArrayList<IS_FRIEND_OF>();


    @JsonIgnoreProperties("endUsers")
    @Relationship(type = "IS_FRIEND_OF",direction = Relationship.INCOMING)
    private List<IS_FRIEND_OF_IN> is_friend_of_in = new ArrayList<IS_FRIEND_OF_IN>();

    //忽略掉HAS_SEEN中的users（自身节点），不然会递归调用自身节点，形成死循环
    @JsonIgnoreProperties("users")
    @Relationship(type = "HAS_SEEN")
    private List<HAS_SEEN> has_seens = new ArrayList<HAS_SEEN>();

    public List<IS_FRIEND_OF_IN> getIs_friend_of_in() {
        return is_friend_of_in;
    }

    public void setIs_friend_of_in(List<IS_FRIEND_OF_IN> is_friend_of_in) {
        this.is_friend_of_in = is_friend_of_in;
    }

    public List<IS_FRIEND_OF> getIs_friend_ofs() {
        return is_friend_ofs;
    }

    public void setIs_friend_ofs(List<IS_FRIEND_OF> is_friend_ofs) {
        this.is_friend_ofs = is_friend_ofs;
    }

    public List<HAS_SEEN> getHas_seens() {
        return has_seens;
    }

    public void setHas_seens(List<HAS_SEEN> has_seens) {
        this.has_seens = has_seens;
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
