package movies.spring.data.neo4j.controller;

import java.util.*;


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
    public Collection<Movie> graphs(@RequestParam(value = "limit", required = false) Integer limit) {
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
    public Map<String, Object> path(String name, int deep) {
        System.out.println("All");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.path(name, deep));
        return map;


    }

    @GetMapping("/mixPath")
    public Map<String, Object> mixPath() {
        System.out.println("All");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.mixPath());
        return map;


    }

    @GetMapping("/path_Roles")
    public Map<String, Object> path_Roles(String name) {
        System.out.println("All");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", movieService.path_Roles(name));
        return map;


    }


//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/EhcacheTest")
//    public String EhcacheTest() {
//        //      logger.info("进行Encache缓存测试");
//        System.out.println("====生成第一个用户====");
//        UserInfo user1 = new UserInfo();
//        //生成第一个用户的唯一标识符 UUID
//        String u1_uuid = UUID.randomUUID().toString();
//        //去掉 UUID 的 - 符号
//        String uuid1 = u1_uuid.substring(0, 8) + u1_uuid.substring(9, 13) + u1_uuid.substring(14, 18) + u1_uuid.substring(19, 23) + u1_uuid.substring(24);
//        user1.setName("张三" + new Random().doubles());
//        user1.setAge("18");
//        user1.setUuid(uuid1);
//        if (userService.save(user1) == 0) {
//            throw new JdbcException("用户对象插入数据库失败");
//        }
//
//        //第一次查询
//        System.out.println("find:" + userService.findByUuid(user1.getUuid()));
//        //通过缓存查询
//        System.out.println("find:" + userService.findByUuid(user1.getUuid()));
//
//        System.out.println("====修改数据====");
//        UserInfo user2 = new UserInfo();
//        user2.setName("李四-update");
//        user2.setAge("22");
//        user2.setUuid(user1.getUuid());
//        try {
//            System.out.println(userService.update(user2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(userService.findByUuid(user2.getUuid()));
//        return "success";
//    }


}
