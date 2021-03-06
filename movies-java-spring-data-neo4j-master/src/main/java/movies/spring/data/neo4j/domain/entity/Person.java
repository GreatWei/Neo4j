package movies.spring.data.neo4j.domain.entity;


import java.util.ArrayList;
import java.util.List;

import movies.spring.data.neo4j.domain.common.LabelClassName;
import movies.spring.data.neo4j.domain.entity.Movie;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Mark Angrish
 */
@NodeEntity(label = "Person")
public class Person extends LabelClassName {

    @Id
    @GeneratedValue
	private Long id;

	private String name;
	private int born;

	@Relationship(type = "ACTED_IN")
	private List<Movie> movies = new ArrayList<>();

	public Person() {
	}

	public Person(String name, int born) {
		this.name = name;
		this.born = born;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBorn() {
		return born;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", born=" + born +
				", movies=" + movies +
				'}';
	}
}