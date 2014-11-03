package window;

import java.util.ArrayList;
import java.util.Iterator;

import hro.infdev4.neo4jpracticum.Neo4j;
import hro.infdev4.neo4jpracticum.Person;

import javax.swing.JList;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.helpers.collection.IteratorUtil;

public class PersonList extends JList<Person> {

    public PersonList() {
		super(getPeople());
	}

	public void updateList() {
		this.setListData(getPeople());
	}

	private static Person[] getPeople() {
		ArrayList<Person> out = new ArrayList<Person>();
		GraphDatabaseService gdb = Neo4j.getGDB();
		ExecutionEngine ee = Neo4j.getEE();
		try(Transaction tx = gdb.beginTx()) {
			//Neo4j.initDB();
			ExecutionResult res = ee.execute("MATCH (n) return n");
			Iterator<Node> it = res.columnAs("n");
			for(Node n : IteratorUtil.asIterable(it)) {
				out.add(new Person(n));
			}
			tx.success();
		}
		System.out.println(out.size());
		return out.toArray(new Person[out.size()]);
	}
}
