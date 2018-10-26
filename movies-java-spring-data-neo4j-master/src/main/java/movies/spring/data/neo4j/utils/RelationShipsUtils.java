package movies.spring.data.neo4j.utils;

import movies.spring.data.neo4j.domain.common.ACTED_IN;
import movies.spring.data.neo4j.domain.common.HAS_SEEN;
import movies.spring.data.neo4j.domain.common.IS_FRIEND_OF;
import movies.spring.data.neo4j.domain.common.LabelClassName;

//关系处理
public class RelationShipsUtils {
    private static String tmp;
    private static LabelClassName exps;

    /**
     * @param viewString
     * @param rel
     * @param exp
     */
    public static String ACTED_IN_Rel(StringBuilder viewString, LabelClassName rel, LabelClassName exp) {
        ACTED_IN acted_in = (ACTED_IN) rel;
        tmp = null;
        //判断方向
        if (exp.getId().equals(acted_in.getMovies().getId())) {
            viewString.append("<--[").append(acted_in.getClassName()).append("]--");
            tmp = acted_in.getRoles().getName();
            exps = acted_in.getRoles();
        } else {
            viewString.append("--[").append(acted_in.getClassName()).append("]-->");
            tmp = acted_in.getMovies().getName();
            exps = acted_in.getMovies();
        }
        return tmp;
    }

    public static String HAS_SEEN_Rel(StringBuilder viewString, LabelClassName rel, LabelClassName exp) {
        HAS_SEEN has_seen = (HAS_SEEN) rel;
        //判断方向
        if (exp.getId().equals(has_seen.getMovies().getId())) {
            viewString.append("<--[").append(has_seen.getClassName()).append("]--");
            tmp = has_seen.getUsers().getName();
            exps = has_seen.getUsers();
        } else {
            viewString.append("--[").append(has_seen.getClassName()).append("]-->");
            tmp = has_seen.getMovies().getName();
            exps = has_seen.getMovies();
        }
        return tmp;
    }

    public static String IS_FRIEND_OF_Rel(StringBuilder viewString, LabelClassName rel, LabelClassName exp) {
        IS_FRIEND_OF is_friend_of = (IS_FRIEND_OF) rel;
        //判断方向
        if (exp.getId().equals(is_friend_of.getEndUsers().getId())) {
            viewString.append("<--[").append(is_friend_of.getClassName()).append("]--");
            tmp = is_friend_of.getStartUsers().getName();
            exps = is_friend_of.getStartUsers();
        } else {
            viewString.append("--[").append(is_friend_of.getClassName()).append("]-->");
            tmp = is_friend_of.getEndUsers().getName();
            exps = is_friend_of.getEndUsers();
        }
        return tmp;
    }

    public static LabelClassName getExps() {
        return exps;
    }
}
