package movies.spring.data.neo4j.domain.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity(label = "MOVIES")
public class Movies {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @JsonIgnoreProperties("movies")
//    @Relationship(type = "HAS_SEEN", direction = Relationship.INCOMING)
//    List<HAS_SEEN> has_seens;

//    public List<HAS_SEEN> getHas_seens() {
//        return has_seens;
//    }
//
//    public void setHas_seens(List<HAS_SEEN> has_seens) {
//        this.has_seens = has_seens;
//    }

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
