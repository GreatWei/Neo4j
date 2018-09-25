package com.my.neo4j.api;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.graphdb.index.RelationshipIndex;
import org.neo4j.graphdb.traversal.Evaluators;

import java.io.File;

public class Neo4jCypherJavaAPI {
	public static void main(String[] args) {
		// 指定 Neo4j 存储路径
		File file = new File("E:\\TOOL\\neo4j-community-3.4.5-windows-chs-2.0.0-with-samples\\data\\databases\\temp");
		// Create a new Object of Graph Database
		GraphDatabaseService graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(file);
		System.out.println("Server is up and Running");

		try (Transaction tx = graphDB.beginTx()) {
			// 通过Cypher查询获得结果
			StringBuilder sb = new StringBuilder();
			sb.append("MATCH (p:USERS{name:'John Johnson'}) ");
			sb.append("RETURN p limit 1");
			// String te = "MATCH (n) RETURN n LIMIT 25";
			Result result = graphDB.execute(sb.toString());
			// result = graphDB.execute(te);
			System.out.println(result.toString());
			Node startNode = null;
			// 遍历结果
			while (result.hasNext()) {
				// get("movie")和查询语句的return movie相匹配
				startNode = (Node) result.next().get("p");
				System.out.println(startNode.getId() + " : " + startNode.getProperty("name"));
			}
			
			IndexManager index = graphDB.index();
			boolean indexexits = index.existsForNodes("name");
			System.out.println("indexexits:"+indexexits);
			Index<Node> users = index.forNodes("USERS");
		//	users.add(startNode, "name", startNode.getProperty("name"));
			
			// 路劲
			for (Path position : graphDB.traversalDescription().depthFirst()
					.relationships(MyRelationshipTypes.IS_FRIEND_OF, Direction.OUTGOING)
					.relationships(MyRelationshipTypes.HAS_SEEN, Direction.OUTGOING).evaluator(Evaluators.fromDepth(1))
					.evaluator(Evaluators.toDepth(5)).traverse(startNode)) {
				System.out.println("path:" + position.toString());
			}

			// 节点
			for (Node node : graphDB.traversalDescription().depthFirst()
					.relationships(MyRelationshipTypes.IS_FRIEND_OF, Direction.OUTGOING)
					.relationships(MyRelationshipTypes.HAS_SEEN, Direction.OUTGOING).evaluator(Evaluators.fromDepth(1))
					.evaluator(Evaluators.toDepth(5)).traverse(startNode).nodes()) {
				System.out.println("name:" + node.getProperty("name") + " id:" + node.getId());
			}

			RelationshipIndex isFriendof =index.forRelationships("IS_FRIEND_OF");
			RelationshipIndex hasSeen =index.forRelationships("HAS_SEEN");
			IndexHits<Relationship> reIndexHits;
			// 节点关系
			for (Relationship relationship : graphDB.traversalDescription().depthFirst()
					.relationships(MyRelationshipTypes.IS_FRIEND_OF, Direction.OUTGOING)
					.relationships(MyRelationshipTypes.HAS_SEEN, Direction.OUTGOING).evaluator(Evaluators.fromDepth(1))
					.evaluator(Evaluators.toDepth(5)).traverse(startNode).relationships()) {
				String name = relationship.getType().name() + " id:" + relationship.getId();
				if ("HAS_SEEN".equals(relationship.getType().name())) {
					name += " stars:" + relationship.getProperty("stars");
				}
			//	relationship.get
				System.out.println("relationship:" + name);
			}
			
			for(Node user: users.query("name","*")) {
				System.out.println("query:"+user.getId()+"="+user.getProperty("name"));
			}
			
			tx.success();
			System.out.println("Done successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			graphDB.shutdown(); // 关闭数据库
		}
	}
}
