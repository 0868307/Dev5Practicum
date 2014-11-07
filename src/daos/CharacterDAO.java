package daos;

import daos.pojos.RpgCharacter;
import org.neo4j.cypher.CypherException;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;
import window.pojos.Armor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by darryl on 6-11-14.
 */
public class CharacterDAO extends DatabaseAccessObject {
    public static window.pojos.RpgCharacter getCharacterByName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("inputName", name);
        Transaction transaction = null;
        final window.pojos.RpgCharacter rpgCharacter = new window.pojos.RpgCharacter();
        try {
            transaction = getGraphDB().beginTx();
            ExecutionResult result = getEngine().execute(
                    "MATCH (n:RpgCharacter {name: {inputName}}) RETURN n", params);
            ResourceIterator<Node> nodes = result.columnAs("n");
            for (Node node : IteratorUtil.asIterable(nodes)) {
                rpgCharacter.setName((String) node.getProperty("name"));
                rpgCharacter.setClassName((String) node.getProperty("class"));
                rpgCharacter.setLevel((String) node.getProperty("level"));
            }
            transaction.success();
        } catch (CypherException e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
        return rpgCharacter;
    }

    public static List getAllCharacterNames() {
        List<String> names = new ArrayList<String>();
        ExecutionResult result = getEngine().execute("MATCH (n:RpgCharacter) RETURN n.name");
        ResourceIterator<Node> nodes = result.columnAs("n.name");
        while (nodes.hasNext()) {
            names.add(String.valueOf(nodes.next()));
        }
        return names;
    }

    public static List getAllCharacters() {
        List<String> names = getAllCharacterNames();
        List<window.pojos.RpgCharacter> characterList = new ArrayList<window.pojos.RpgCharacter>();
        for (String name : names) {
            characterList.add(getCharacterByName(name));
        }
        return characterList;
    }

    public static void createRPGChar(window.pojos.RpgCharacter character) {
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
                Node rpgchar;
                rpgchar = getGraphDB().createNode(ItemTypes.RpgCharacter);
                rpgchar.setProperty(RpgCharacter.NAME, character.getName());
                rpgchar.setProperty(RpgCharacter.CLASS, character.getClassName());
                rpgchar.setProperty(RpgCharacter.LEVEL, character.getLevel());
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }

    public static void giveItemToChar(window.pojos.RpgCharacter character, Armor item) {
        Map<String, Object> charParams = new HashMap<String, Object>();
        charParams.put("charName", character.getName());
        charParams.put("itemName", item.getName());
        charParams.put("itemClass", item.getClassName());
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            getEngine().execute(
                    "MATCH (char:RpgCharacter {name: {charName}})" +
                    "MATCH (armor:Armor {name: {itemName}})" +
                    "CREATE UNIQUE (armor)-[:WORN_BY {type: {itemClass}}]->(char)", charParams);
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }

    public static void removeArmorFromCharByType(window.pojos.RpgCharacter character, String type) {
        Map<String, Object> charParams = new HashMap<String, Object>();
        charParams.put("charName", character.getName());
        charParams.put("itemName", type);
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            getEngine().execute(
                    "MATCH (n:Armor {name: {itemName}})-[r]->(e:RpgCharacter {name: {charName}}) DELETE r", charParams
            );
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }

    public static void deleteCharByName(String name) {
        Map<String, Object> charParams = new HashMap<String, Object>();
        charParams.put("charname", name);
        Transaction transaction = null;
        try {
            transaction = getGraphDB().beginTx();
            getEngine().execute(
                    "MATCH (n:RpgCharacter {name: {charName}})-[r]-() DELETE n, r", charParams
            );
            transaction.success();
        } finally {
            if (transaction != null) {
                transaction.close();
            }
        }
    }
}