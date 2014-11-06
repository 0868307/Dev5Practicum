package pojos;

import org.neo4j.graphdb.Node;

/**
 * Created by darryl on 3-11-14.
 */
public class Pauldrons extends Armor {
    public Pauldrons(String name) {
        super(name);
    }
    public Pauldrons(Node node) {
        super(node);
    }
}
