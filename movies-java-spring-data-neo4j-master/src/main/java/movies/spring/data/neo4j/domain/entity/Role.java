package movies.spring.data.neo4j.domain.entity;

import java.util.ArrayList;
import java.util.List;

import movies.spring.data.neo4j.domain.common.LabelClassName;
import movies.spring.data.neo4j.domain.entity.Movie;
import movies.spring.data.neo4j.domain.entity.Person;
import org.neo4j.ogm.annotation.*;

/**
 * @author Mark Angrish
 */
@RelationshipEntity(type = "ACTED_INsss")
public class Role extends LabelClassName {

    @Id
    @GeneratedValue
	private Long id;
    private String name;
	private List<String> roles = new ArrayList<>();

	@StartNode
	private Person person;

	@EndNode
	private Movie movie;

	public Role() {
	}

	public Role(Movie movie, Person actor) {
		this.movie = movie;
		this.person = actor;
	}

	public Long getId() {
	    return id;
	}

	public List<String> getRoles() {
	    return roles;
	}

	public Person getPerson() {
	    return person;
	}

	public Movie getMovie() {
	    return movie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addRoleName(String name) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(name);
    }


	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", name='" + name + '\'' +
				", roles=" + roles +
				", person=" + person +
				", movie=" + movie +
				'}';
	}
}