package movies.spring.data.neo4j.domain.Users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.common.ACTED_IN;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity(label = "ROLES")
public class Roles {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @JsonIgnoreProperties("roles")
//    @Relationship(type = "ACTED_IN")
//    private List<ACTED_IN> out_acted_in;

//    public List<ACTED_IN> getOut_acted_in() {
//        return out_acted_in;
//    }
//
//    public void setOut_acted_in(List<ACTED_IN> out_acted_in) {
//        this.out_acted_in = out_acted_in;
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
