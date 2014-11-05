import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.impl.util.StringLogger;
import pojos.Boots;
import pojos.RpgCharacter;
import window.Window;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestDB {

    public static void characterSetup() {
        Transaction transaction = null;
        try {
            transaction = GraphDBController.getGDB().beginTx();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("data/characters.csv"));
                Node rpgchar;
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    String[] attr = line.split(",");
                    rpgchar = GraphDBController.getGDB().createNode(GraphDBController.ItemTypes.RpgCharacter);
                    rpgchar.setProperty(GraphDBController.RpgCharacter.NAME, attr[0]);
                    rpgchar.setProperty(GraphDBController.RpgCharacter.CLASS, attr[1]);
                    rpgchar.setProperty(GraphDBController.RpgCharacter.LEVEL, attr[2]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }

    public static void armorSetup(String filename, Label itemType) {
        Transaction transaction = null;
        try {
            transaction = GraphDBController.getGDB().beginTx();

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("data/" + filename));
                Node armorItem;
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    armorItem = GraphDBController.getGDB().createNode(itemType);
                    armorItem.setProperty(GraphDBController.Armor.NAME, line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }

    private static void createObjectsOnInitDB() {
        characterSetup();
        armorSetup("boots.csv", GraphDBController.ItemTypes.Boots);
        armorSetup("chests.csv", GraphDBController.ItemTypes.ChestPlate);
        armorSetup("helmets.csv", GraphDBController.ItemTypes.Helmet);
        armorSetup("leggings.csv", GraphDBController.ItemTypes.Leggings);
        armorSetup("pauldrons.csv", GraphDBController.ItemTypes.Pauldrons);
    }

    public static void main(String[] args) {
        createObjectsOnInitDB();
        new Window().setVisible(true);

        ExecutionEngine executionEngine = new ExecutionEngine(GraphDBController.getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e) RETURN e;");
        System.out.println(result.dumpToString());
    }

}
