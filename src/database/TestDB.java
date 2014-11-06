package database;


import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.helpers.collection.IteratorUtil;
import org.neo4j.kernel.impl.util.StringLogger;
import pojos.Armor;
import pojos.Helmet;
import pojos.RpgCharacter;
import scala.collection.Iterator;
import scala.collection.immutable.List;
import window.Window;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        new Window().setVisible(true);

    }
    public static ExecutionResult getRpgCharacters()
    {

        ExecutionEngine executionEngine = new ExecutionEngine(GraphDBController.getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e:RpgCharacter) RETURN e;");
        return result;
    }
    public static ExecutionResult getAllChestPlate()
    {

        ExecutionEngine executionEngine = new ExecutionEngine(GraphDBController.getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e:ChestPlate) RETURN e;");
        return result;
    }
    public static ExecutionResult getAllHelmet()
    {

        ExecutionEngine executionEngine = new ExecutionEngine(GraphDBController.getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e:Helmet) RETURN e;");
        return result;
    }
    public static ExecutionResult getAllLeggings()
    {

        ExecutionEngine executionEngine = new ExecutionEngine(GraphDBController.getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e:Leggings) RETURN e;");
        return result;
    }
    public static ExecutionResult getAllBoots()
    {

        ExecutionEngine executionEngine = new ExecutionEngine(GraphDBController.getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e:Boots) RETURN e;");
        return result;
    }
    public static Node getSingleItem(String name)
    {
        ExecutionEngine executionEngine = new ExecutionEngine(GraphDBController.getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e) RETURN e;");
        Iterator<Node> it = result.columnAs("e");

        Node node = it.next();
        return node;
    }
    public static void setRelationship(String name, RpgCharacter rpg) {
            getSingleItem(name).createRelationshipTo(rpg.getNode(), GraphDBController.RelTypes.BELONGS_TO);

    }
    public static void initRpgCharacter(RpgCharacter rpg, Node node)
    {
        rpg.setName((String)node.getProperty("name"));
        rpg.setClassName((String)node.getProperty("class"));
        rpg.setLevel((String)node.getProperty("level"));

    }
}
