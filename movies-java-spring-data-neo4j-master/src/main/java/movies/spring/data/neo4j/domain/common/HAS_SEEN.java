package movies.spring.data.neo4j.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import movies.spring.data.neo4j.domain.Users.Movies;
import movies.spring.data.neo4j.domain.Users.Users;
import org.neo4j.ogm.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@RelationshipEntity(type = "HAS_SEEN")
public class HAS_SEEN {
    @Id
    @GeneratedValue
    private Long id;
    private Long stars;

    @StartNode
    private Users users;

    @EndNode
    private Movies movies;

    public  HAS_SEEN(){

    }

    public HAS_SEEN(Users users,Movies movies){
        this.users=users;
        this.movies=movies;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStars() {
        return stars;
    }

    public void setStars(Long stars) {
        this.stars = stars;
    }
}