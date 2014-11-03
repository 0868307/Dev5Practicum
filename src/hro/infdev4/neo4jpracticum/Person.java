import org.neo4j.graphdb.Node;

public class Person {
	private String naam;

	public Person(String name) {
		naam = name;
	}

	public Person(Node n) {
		naam = (String)n.getProperty("Naam");
	}

	public String toString() {
		return naam;
	}
}
