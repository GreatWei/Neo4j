package movies.spring.data.neo4j.controller;

public class JdbcException extends RuntimeException {

    public JdbcException(String message){ super(message);}

    public JdbcException(String message, Throwable cause){ super(message, cause);}
}