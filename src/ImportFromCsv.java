import daos.ArmorDAO;
import daos.CharacterDAO;
import window.pojos.Armor;
import window.pojos.ArmorFactory;
import window.pojos.RpgCharacter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportFromCsv {
    public static void characterSetup() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data/characters.csv"));
            RpgCharacter character;
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] attr = line.split(",");
                character = new RpgCharacter(attr[0], attr[1], attr[2]);
                CharacterDAO.createRPGChar(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void armorSetup(String filename) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data/" + filename));
            Armor item;
            String itemType = filename.split("\\.")[0];
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                item = ArmorFactory.create(itemType, line);
                ArmorDAO.createArmor(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createRelations() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data/inventory.csv"));
            RpgCharacter character;
            Armor item;
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] attr = line.split(";");
                character = new RpgCharacter();
                character.setName(attr[0]);
                item = ArmorFactory.create(attr[1], attr[2]);
                CharacterDAO.giveItemToChar(character, item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createObjects() {
        characterSetup();
        armorSetup("boots.csv");
        armorSetup("chestplate.csv");
        armorSetup("helmet.csv");
        armorSetup("leggings.csv");
        armorSetup("pauldrons.csv");
    }

    public static void main(String[] args) {
        createObjects();
        createRelations();
    }
}