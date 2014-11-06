package pojos;


import database.GraphDBController;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 * Created by darryl on 3-11-14.
 */
public class RpgCharacter {
    private String name;
    private String className;
    private String level;

    private Boots boots;
    private ChestPlate chestPlate;
    private Helmet helmet;
    private Leggings leggings;
    private Pauldrons pauldrons;

    public RpgCharacter(String name, String className, String level) {
        this.name = name;
        this.className = className;
        this.level = level;
        System.out.println(name);
    }

    public RpgCharacter(Node node) {
        Transaction transaction = null;
        try {
            transaction = GraphDBController.getGDB().beginTx();

            this.name = (String)node.getProperty("name");
            this.className = (String)node.getProperty("class");
            this.level = (String)node.getProperty("level");

            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boots getBoots() {
        return boots;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public ChestPlate getChestPlate() {
        return chestPlate;
    }

    public void setChestPlate(ChestPlate chestPlate) {
        this.chestPlate = chestPlate;
    }

    public Pauldrons getPauldrons() {
        return pauldrons;
    }

    public void setPauldrons(Pauldrons pauldrons) {
        this.pauldrons = pauldrons;
    }

    public Leggings getLeggings() {
        return leggings;
    }

    public void setLeggings(Leggings leggings) {
        this.leggings = leggings;
    }

    @Override
    public String toString() {
        /*return "RpgCharacter{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", level='" + level + '\'' +
                '}';
                */
        return name;
    }

}
