package movies.spring.data.neo4j.services;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
import movies.spring.data.neo4j.config.DataSourceType;
import movies.spring.data.neo4j.config.ToDataSource;
import movies.spring.data.neo4j.domain.Users.Roles;
import movies.spring.data.neo4j.domain.Users.Users;
import movies.spring.data.neo4j.domain.common.ACTED_IN;
import movies.spring.data.neo4j.domain.common.LabelClassName;
import movies.spring.data.neo4j.domain.entity.Movie;
import movies.spring.data.neo4j.domain.entity.Person;
import movies.spring.data.neo4j.domain.entity.Role;
import movies.spring.data.neo4j.repositories.MovieRepository;
import movies.spring.data.neo4j.repositories.PersonRepository;
import movies.spring.data.neo4j.repositories.RolesRepository;
import movies.spring.data.neo4j.repositories.UsersRepository;
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

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

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
    public Collection<Movie> graphs(int limit) {
        Collection<Movie> result = movieRepository.graphs(limit);
        return result;
    }

    @Transactional
    public String add() {

//        for (int i = 0; i < 10; i++) {

        String uuid = UUID.randomUUID().toString();

        Movie matrix = new Movie("The Matrix" + uuid, 1999, "Welcome to the Real World");

        movieRepository.save(matrix);

        Person keanu = new Person("Keanu Reeves" + uuid, 1964);

        personRepository.save(keanu);

        Role neo = new Role(matrix, keanu);
        neo.addRoleName("Neo");
        neo.setName(uuid);
        matrix.addRole(neo);

        movieRepository.save(matrix);
        //  }

        return "success";
    }

    @Transactional
    public Collection<Users> All() {
        return usersRepository.AllFriend();
    }

    @Transactional
    public Collection<Users> AllRelation() {
        return usersRepository.AllRelation();
    }

    @Transactional
    public Collection<Users> shortPath() {
        return usersRepository.shortPath();
    }

    public Collection<Roles> path_Roles(String name) {
        return rolesRepository.path_Roles(name);
    }

    //  @ToDataSource(DataSourceType.Neo4j)
    @Transactional
    public Map<String, Object> path(String name, int deep) {
        Map<String, Object> map = new HashMap<String, Object>();
        //String[] list = name.split(",");
        List<Map<String, Map<String, Object>>> mapList = usersRepository.path(name, "", null);

        StringBuilder viewString= new StringBuilder();

        for (Map<String, Map<String, Object>> mapMap : mapList) {
            System.out.println("source:" + ((LabelClassName) mapMap.get("n")).getClass());
            List<LabelClassName> labelClassNames = (List<LabelClassName>) mapMap.get("r");
            LabelClassName tmp = (LabelClassName) mapMap.get("n");
            for (LabelClassName labelClassName : labelClassNames) {

                switch (labelClassName.getClassName()) {
                    case "ACTED_IN":
                        ACTED_IN acted_in = (ACTED_IN) labelClassName;
                        if ()
                        viewString.append("<--[").append(acted_in.getClassName()).append("]--");
                        break;
                    case "HAS_SEEN":
                        break;
                    case "IS_FRIEND_OF":
                        break;
                    default:
                        break;
                }
            }
            System.out.println("target:" + ((LabelClassName) mapMap.get("m")).getMySelf());

        }
        System.out.println(mapList.toArray());

        map.put("data", mapList);
        return map;
    }

    @Transactional
    public Map<String, Object> mixPath() {
        Map<String, Object> map = new HashMap<String, Object>();
        //      String[] list = name.split(",");
        List<Map<String, Map<String, Object>>> mapList = usersRepository.mixPath();
        //   List<Users> mapList = usersRepository.mixPath();
        for (Map<String, Map<String, Object>> mapMap : mapList) {
            //   System.out.println("source:" + ((LabelClassName)mapMap.get("source")).getClass());
            System.out.println("r:" + mapMap.get("r"));
            // System.out.println("target:" + ((LabelClassName)mapMap.get("target")).getMySelf());

        }
        List<Map<String, Map<String, Object>>> mapList2 = usersRepository.mixPath2();
        //   List<Users> mapList = usersRepository.mixPath();
        for (Map<String, Map<String, Object>> mapMap : mapList2) {
            //   System.out.println("n:" + ((LabelClassName)mapMap.get("n")).toString());
            //  System.out.println("r:"+mapMap.get("r").toString());
            //    System.out.println("m:" + ((LabelClassName)mapMap.get("m")).toString());

        }
        List<Long> idList = new ArrayList<Long>();
        idList.add(10L);
        idList.add(7L);

        usersRepository.node(idList);
        // map.put("data", mapList);
        map.put("node", usersRepository.node(idList));
        //map.put("data2", mapList2);
        // map.put("data3",usersRepository.node());
        return map;
    }


}
