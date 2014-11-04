import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * Created by darryl on 4-11-14.
 */
public class GraphDBController {
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
        public static final String LEVEL = "level";
    }

}
