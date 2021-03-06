package movies.spring.data.neo4j.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.common.LabelClassName;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Mark Angrish
 */
@NodeEntity(label = "Movie")
public class Movie extends LabelClassName {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int released;
    private String tagline;

    @JsonIgnoreProperties("movie")
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private List<Role> roles;

    public Movie() {
    }

    public Movie(String title, int released, String tagline) {
        this.title = title;
        this.released = released;
        this.tagline = tagline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleased() {
        return released;
    }

    public String getTagline() {
        return tagline;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", released=" + released +
                ", tagline='" + tagline + '\'' +
               ", roles=" + roles +
                '}';
    }
}