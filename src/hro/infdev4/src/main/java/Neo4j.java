import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Neo4j {
	private static ExecutionEngine ee = null;
	private static GraphDatabaseService gdb = null;
	public static GraphDatabaseService getGDB() {
		if(gdb == null) {
			gdb = new GraphDatabaseFactory().newEmbeddedDatabase("C:/Users/EE/Documents/Neo4j/database1");
		}
		return gdb;
	}
	public static ExecutionEngine getEE() {
		if(ee == null) {
			ee = new ExecutionEngine(getGDB());
		}
		return ee;
	}
    private static enum RelTypes implements RelationshipType {
        KNOWS
    }
	public static void initDB() {
		GraphDatabaseService gdb = getGDB();
		ExecutionEngine ee = getEE();
		ee.execute("MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r");

        Node firstNode = gdb.createNode();
        firstNode.setProperty("Naam", "Thomas");
        firstNode.setProperty("Specialiteit", "Neo4j");

        Node secondNode = gdb.createNode();
        secondNode.setProperty("Naam", "Wim");
        secondNode.setProperty("Specialiteit", "Lezen");

        Node thirthNode = gdb.createNode();
        thirthNode.setProperty("Naam", "Wouter");
        thirthNode.setProperty("Specialiteit", "Koekjes bakken");

        Node fourthNode = gdb.createNode();
        fourthNode.setProperty("Naam", "Armindo");
        fourthNode.setProperty("Specialiteit", "Cool");

        firstNode.createRelationshipTo(secondNode, RelTypes.KNOWS);
        secondNode.createRelationshipTo(thirthNode, RelTypes.KNOWS);
        thirthNode.createRelationshipTo(fourthNode, RelTypes.KNOWS);
        fourthNode.createRelationshipTo(secondNode, RelTypes.KNOWS);
        firstNode.createRelationshipTo(thirthNode, RelTypes.KNOWS);
        firstNode.createRelationshipTo(fourthNode, RelTypes.KNOWS);
	}

	public static void createPerson(String naam) {
		System.out.println(naam);
		GraphDatabaseService gdb = getGDB();
		try(Transaction tx = gdb.beginTx()) {
	        Node n = gdb.createNode();
	        n.setProperty("Naam",naam);
			tx.success();
		}
	}
}
