package movies.spring.data.neo4j.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import movies.spring.data.neo4j.domain.entity.Movie;
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
@RequestMapping("/movie")
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
        System.out.println("add");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.add());
        return map;


    }

    @GetMapping("/All")
    public Map<String, Object> All() {
        System.out.println("All");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.All());
        return map;


    }

    @GetMapping("/AllRelation")
    public Map<String, Object> AllRelation() {
        System.out.println("All");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.AllRelation());
        return map;


    }

    @GetMapping("/shortPath")
    public Map<String, Object> shortPath() {
        System.out.println("All");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.shortPath());
        return map;


    }

    @GetMapping("/path")
    public Map<String, Object> path() {
        System.out.println("All");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.path());
        return map;


    }
}
