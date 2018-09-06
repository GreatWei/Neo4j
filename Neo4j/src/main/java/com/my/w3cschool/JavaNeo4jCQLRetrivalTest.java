package com.my.w3cschool;


import org.neo4j.cypher.internal.ExecutionEngine;
import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

public class JavaNeo4jCQLRetrivalTest {

    public static void main(String[] args) {
        GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();

        GraphDatabaseService graphDb = graphDbFactory.newEmbeddedDatabase(new File("J:\\Neo4j\\neo4j-community-3.4.5-windows-chs-2.0.0-with-samples\\data\\databases\\temp"));

        ExecutionEngine execEngine = new ExecutionEngine(graphDb);
        ExecutionResult execResult = execEngine.execute("MATCH (java:JAVA) RETURN java");
        String results = execResult.dumpToString();
        System.out.println(results);
    }
}
