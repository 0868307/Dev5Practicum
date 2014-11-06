package pojos;

import org.neo4j.graphdb.Node;

/**
 * Created by darryl on 3-11-14.
 */
public class ChestPlate extends Armor {
    public ChestPlate(String name) {
        super(name);
    }
    public ChestPlate(Node node) {
        super(node);
    }
}
