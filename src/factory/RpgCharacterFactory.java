package factory;

import database.GraphDBController;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.io.IOException;

/**
 * Created by Wouter on 11/5/2014.
 */
public class RpgCharacterFactory {
    public RpgCharacterFactory()
    {

    }
    public static void createRpgCharacter(String name, String cls, String level) {
        Transaction transaction = null;
        try {
            transaction = GraphDBController.getGDB().beginTx();

            Node rpgchar;
            rpgchar = GraphDBController.getGDB().createNode(GraphDBController.ItemTypes.RpgCharacter);
            rpgchar.setProperty(GraphDBController.RpgCharacter.NAME, name);
            rpgchar.setProperty(GraphDBController.RpgCharacter.CLASS, cls);
            rpgchar.setProperty(GraphDBController.RpgCharacter.LEVEL, level);

            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }

    }
}
