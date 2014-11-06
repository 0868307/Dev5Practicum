package pojos;

import database.GraphDBController;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 * Created by darryl on 3-11-14.
 */
abstract public class Armor {
    private String name;

    protected Armor(String name) {
        this.name = name;
    }

    public String getName() {
        if(name==null)
        {
            return "none";
        }
        return name;
    }
    public Armor(Node node) {
        Transaction transaction = null;
        try {
            transaction = GraphDBController.getGDB().beginTx();
            this.name = (String)node.getProperty("name");
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    @Override
    public String toString() {
        return "pojos.Armor{" +
                "name='" + name + '\'' +
                '}';
    }*/
    public String toString(){
        return name;
    }
}
