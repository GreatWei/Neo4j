package movies.spring.data.neo4j.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark Angrish
 * @author Michael J. Simons
 */
@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/graph")
    public Collection<Movie> graph(@RequestParam(value = "limit", required = false) Integer limit) {
        return movieService.graph(limit == null ? 100 : limit);
    }

    @GetMapping("/graphs")
    public  Collection<Movie> graphs(@RequestParam(value = "limit", required = false) Integer limit) {
        return movieService.graphs(limit == null ? 100 : limit);
    }

    @GetMapping("/add")
    public Map<String, Object> add() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.add());
        return map;


    }
}
