import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PersonList extends JList<Person> {

    public PersonList() {
		super(getPeople());
	}

	public void updateList() {
		this.setListData(getPeople());
	}

	private static Person[] getPeople() {
		ArrayList<Person> out = new ArrayList<>();
		GraphDatabaseService gdb = Neo4j.getGDB();
		ExecutionEngine ee = Neo4j.getEE();
        Transaction tx = gdb.beginTx();
        //Neo4j.initDB();
        ExecutionResult res = ee.execute("MATCH (n) return n");
        Iterator<Node> it = res.columnAs("n");
        for (Node n : IteratorUtil.asIterable(it)) {
            out.add(new Person(n));
        }
        tx.success();

        System.out.println(out.size());
		return out.toArray(new Person[out.size()]);
	}
}
