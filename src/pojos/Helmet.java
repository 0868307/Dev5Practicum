package pojos;

import org.neo4j.graphdb.Node;

/**
 * Created by darryl on 3-11-14.
 */
public class Helmet extends Armor {
    public Helmet(String name) {
        super(name);
    }
    public Helmet(Node node) {
        super(node);
    }
}
