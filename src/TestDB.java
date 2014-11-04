import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class TestDB {
	private static GraphDatabaseFactory gdb = null;
    private static String DB ="data/rpg-inventory";
    private static String PROPERTIES = "neo4j.properties";

    public static GraphDatabaseService getGDB() {
		if(gdb == null) {
			gdb = new GraphDatabaseFactory();
            gdb.newEmbeddedDatabaseBuilder(DB)
                .loadPropertiesFromFile(PROPERTIES)
                .newGraphDatabase();
		}
		return (GraphDatabaseService) gdb;
	}

    public enum ItemTypes implements Label {
        Character,
        Boots,
        Bracers,
        BreastPlate,
        Greaves,
        Helmet
        
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

    public static class Character {
        public static final String NAME = "name";
        public static final String CLASS = "class";
        public static final String LEVEL = "0";
    }

    public static void setup() {
        Transaction transaction = null;
        try {
            transaction = getGDB().beginTx();

            Node char1 = getGDB().createNode(ItemTypes.Character);
            char1.setProperty(Character.NAME, "Arthas");
            char1.setProperty(Character.CLASS, "Death Knight");
            char1.setProperty(Character.LEVEL, "65");

            Node char2 = getGDB().createNode(ItemTypes.Character);
            char2.setProperty(Character.NAME, "Jaina Proudmoore");
            char2.setProperty(Character.CLASS, "Mage");
            char2.setProperty(Character.LEVEL, "50");

            Node char3 = getGDB().createNode(ItemTypes.Character);
            char3.setProperty(Character.NAME, "Muradin Bronzebeard");
            char3.setProperty(Character.CLASS, "Frost Dwarf");
            char3.setProperty(Character.LEVEL, "40");

            Node armor1 = getGDB().createNode(ItemTypes.Boots);
            armor1.setProperty(Armor.NAME, "");

            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }
}
