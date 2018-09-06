package com.my.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        GraphDatabaseService graphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(new File("J:\\Neo4j\\neo4j-community-3.4.5-windows-chs-2.0.0-with-samples\\data\\databases\\temp"));
        try (Transaction tx = graphDatabaseService.beginTx()){
            Node user1 = graphDatabaseService.createNode();
            System.out.println("create user:"+user1.getId());
            Node user2 = graphDatabaseService.createNode();
            System.out.println("create user:"+user2.getId());
            Node user3 = graphDatabaseService.createNode();
            System.out.println("create user:"+user3.getId());
            tx.success();

            user1.createRelationshipTo(user2,MyRelationshipTypes.IS_FRIEND_OF);
            user1.createRelationshipTo(user3,MyRelationshipTypes.IS_FRIEND_OF);

            user1.setProperty("name","user1");
            user1.setProperty("year_of_birth",1999);
            user2.setProperty("name","user2");
            user2.setProperty("locked",true);
            user3.setProperty("name","user3");
            user3.setProperty("cars_owned",new String[]{"BMW","Audi"});

        }

        System.out.println( "Hello World!" );
    }
}
