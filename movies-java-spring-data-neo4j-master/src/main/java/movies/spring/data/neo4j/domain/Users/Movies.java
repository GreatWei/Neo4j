package movies.spring.data.neo4j.domain.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.common.ACTED_IN;
import movies.spring.data.neo4j.domain.common.HAS_SEEN;
import movies.spring.data.neo4j.domain.common.LabelClassName;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity(label = "MOVIES")
public class Movies extends LabelClassName {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnoreProperties("movies")
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private List<ACTED_IN> in_acted_in;

  //  private final String className = "Movies";

    public String getClassName() {
        return "Movies";
    }

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
