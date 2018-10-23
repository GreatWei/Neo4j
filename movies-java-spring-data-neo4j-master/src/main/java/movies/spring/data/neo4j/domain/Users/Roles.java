package movies.spring.data.neo4j.domain.Users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.common.LabelClassName;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@JsonIgnoreProperties(ignoreUnknown = true)
@NodeEntity(label = "ROLES")
public class Roles extends LabelClassName {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

   // private final String className = "Roles";
    private String className = "Roles";
    public String getClassName() {
        return "Roles";
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
    private String mySelf = "Roles";

    public String getMySelf() {
        return mySelf;
    }

    public void setMySelf(String mySelf) {
        this.mySelf = mySelf;
    }


}
