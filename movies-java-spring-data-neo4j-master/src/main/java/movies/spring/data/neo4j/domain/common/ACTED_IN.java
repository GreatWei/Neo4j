package movies.spring.data.neo4j.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.Users.Movies;
import movies.spring.data.neo4j.domain.Users.Roles;
import org.neo4j.ogm.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@RelationshipEntity(type = "ACTED_IN")
public class ACTED_IN {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @StartNode
    private Roles roles;

    @EndNode
    private Movies movies;

    public ACTED_IN(){

    }
    public ACTED_IN(Roles roles,Movies movies){
        this.roles=roles;
        this.movies=movies;
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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }
}
