package pojos;

import org.neo4j.graphdb.Node;

/**
 * Created by darryl on 3-11-14.
 */
public class Leggings extends Armor {
    public Leggings(String name) {
        super(name);
    }
    public Leggings(Node node) {
        super(node);
    }
}
