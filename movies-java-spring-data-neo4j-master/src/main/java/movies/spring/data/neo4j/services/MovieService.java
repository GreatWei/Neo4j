package movies.spring.data.neo4j.services;

import java.util.*;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.domain.Role;
import movies.spring.data.neo4j.repositories.MovieRepository;
import movies.spring.data.neo4j.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private final static Logger LOG = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PersonRepository personRepository;

    private Map<String, Object> toD3Format(Collection<Movie> movies) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<Movie> result = movies.iterator();
        while (result.hasNext()) {
            Movie movie = result.next();
            nodes.add(map("title", movie.getTitle(), "label", "movie"));
            int target = i;
            i++;
            for (Role role : movie.getRoles()) {
                Map<String, Object> actor = map("title", role.getPerson().getName(), "label", "actor");
                int source = nodes.indexOf(actor);
                if (source == -1) {
                    nodes.add(actor);
                    source = i++;
                }
                rels.add(map("source", source, "target", target));
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    @Transactional(readOnly = true)
    public Movie findByTitle(String title) {
        Movie result = movieRepository.findByTitle(title);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Movie> findByTitleLike(String title) {
        Collection<Movie> result = movieRepository.findByTitleLike(title);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Movie> graph(int limit) {
        Collection<Movie> result = movieRepository.graph(limit);
        return result;
    }

    @Transactional(readOnly = true)
    public  Collection<Movie> graphs(int limit) {
        Collection<Movie> result = movieRepository.graphs(limit);
        return result;
    }

    @Transactional
    public String add() {

        for (int i=0;i<10;i++){

            String uuid = UUID.randomUUID().toString();

            Movie matrix = new Movie("The Matrix"+uuid, 1999, "Welcome to the Real World");

            movieRepository.save(matrix);

            Person keanu = new Person("Keanu Reeves"+uuid, 1964);

            personRepository.save(keanu);

            Role neo = new Role(matrix, keanu);
            neo.addRoleName("Neo");

            matrix.addRole(neo);

            movieRepository.save(matrix);
        }

        return "success";
    }
}
