package pojos;

import database.GraphDBController;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 * Created by darryl on 3-11-14.
 */
public class Boots extends Armor {
    public Boots(String name) {
        super(name);
    }
    public Boots(Node node) {
        super(node);
    }
}
