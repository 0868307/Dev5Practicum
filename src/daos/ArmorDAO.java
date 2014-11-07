package daos;

import daos.pojos.Items;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;
import window.pojos.Armor;
import window.pojos.ArmorFactory;
import window.pojos.RpgCharacter;

import java.util.*;

/**
 * Created by darryl on 6-11-14.
 */
public class ArmorDAO extends DatabaseAccessObject {
    public static void createArmor(Armor armor) {
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            String clsName = armor.getClass().getSimpleName();
            Node item = getGraphDB().createNode(ItemTypes.Armor);
            item.setProperty(Items.NAME, armor.getName());
            item.setProperty(Items.TYPE, clsName);
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }

    public static List<Armor> getAllItemsByCharacter(RpgCharacter character) {
        Transaction transaction = null;
        List<Armor> items = new ArrayList<>();
        try {
            transaction = getGraphDB().beginTx();
            Map<String, Object> params = new HashMap<>();
            params.put("inputName", character.getName());
            ExecutionResult result = getEngine().execute(
                    "MATCH (e:Armor)-[WORN_BY]->(c:RpgCharacter {name: {inputName}}) RETURN e", params);
            Armor item;
            Iterator<Node> columns = result.columnAs("e");
            for (Node node : IteratorUtil.asIterable(columns)) {
                String strName = (String) node.getProperty("name");
                String strType = (String) node.getProperty("type");
                item = ArmorFactory.create(strType, strName);
                items.add(item);
            }
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
        return items;
    }
}