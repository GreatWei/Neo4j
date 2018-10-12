package movies.spring.data.neo4j.domain.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.common.ACTED_IN;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity(label = "MOVIES")
public class Moviess {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

   @JsonIgnoreProperties("movies")
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private List<ACTED_IN> in_acted_in;


//    //忽略掉HAS_SEEN中的users（自身节点），不然会递归调用自身节点，形成死循环
//    @JsonIgnoreProperties("movies")
//    @Relationship(type = "HAS_SEEN", direction = Relationship.INCOMING)
//    private List<HAS_SEEN> in_has_seen_movies = new ArrayList<HAS_SEEN>();

//    public List<HAS_SEEN> getIn_has_seen_movies() {
//        return in_has_seen_movies;
//    }
//
//    public void setIn_has_seen_movies(List<HAS_SEEN> in_has_seen_movies) {
//        this.in_has_seen_movies = in_has_seen_movies;
//    }

    public List<ACTED_IN> getIn_acted_in() {
        return in_acted_in;
    }

    public void setIn_acted_in(List<ACTED_IN> in_acted_in) {
        this.in_acted_in = in_acted_in;
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
