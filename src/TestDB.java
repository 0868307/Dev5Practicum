import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.StringLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestDB {
    private static GraphDatabaseService graphDatabaseService;
    private static String DB ="data/rpg-inventory";
    private static String PROPERTIES = "neo4j.properties";

    public static GraphDatabaseService getGDB() {
		if(graphDatabaseService == null) {
			GraphDatabaseFactory graphDatabaseFactory = new GraphDatabaseFactory();
            graphDatabaseService = graphDatabaseFactory
                    .newEmbeddedDatabaseBuilder(DB)
                    .loadPropertiesFromFile(PROPERTIES)
                    .newGraphDatabase();

        }
        return graphDatabaseService;
	}

    public enum ItemTypes implements Label {
        RpgCharacter,
        Boots,
        ChestPlate,
        Helmet,
        Leggings,
        Pauldrons
    }

    public enum RelTypes implements RelationshipType {
        BELONGS_TO;
        public static final String FROM = "from";
    }

    abstract public static class Armor {
        public static final String NAME = "name";
    }

    public static class Boots extends Armor {}
    public static class ChestPlate extends Armor {}
    public static class Helmet extends Armor {}
    public static class Leggings extends Armor {}
    public static class Pauldrons extends Armor {}

    public static class RpgCharacter {
        public static final String NAME = "name";
        public static final String CLASS = "class";
        public static final String LEVEL = "0";
    }

    public static void characterSetup() {
        Transaction transaction = null;
        try {
            transaction = getGDB().beginTx();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("data/characters.csv"));
                Node rpgchar;
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    String[] attr = line.split(",");
                    rpgchar = getGDB().createNode(ItemTypes.RpgCharacter);
                    rpgchar.setProperty(RpgCharacter.NAME, attr[0]);
                    rpgchar.setProperty(RpgCharacter.CLASS, attr[1]);
                    rpgchar.setProperty(RpgCharacter.LEVEL, attr[2]);
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
            transaction = getGDB().beginTx();

            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("data/" + filename));
                Node armorItem;
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    armorItem = getGDB().createNode(itemType);
                    armorItem.setProperty(Armor.NAME, line);
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
        armorSetup("boots.csv", ItemTypes.Boots);
        armorSetup("chests.csv", ItemTypes.ChestPlate);
        armorSetup("helmets.csv", ItemTypes.Helmet);
        armorSetup("leggings.csv", ItemTypes.Leggings);
        armorSetup("pauldrons.csv", ItemTypes.Pauldrons);
    }

    public static void main(String[] args) {
        createObjectsOnInitDB();
        ExecutionEngine executionEngine = new ExecutionEngine(getGDB(),
                StringLogger.logger(new File("logs/logdb.txt")));
        ExecutionResult result = executionEngine.execute("MATCH (e:RpgCharacter) RETURN e;");
        System.out.println(result.dumpToString());
    }
}
