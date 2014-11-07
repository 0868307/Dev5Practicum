import consts.Consts;
import daos.ArmorDAO;
import daos.CharacterDAO;
import window.pojos.Armor;
import window.pojos.RpgCharacter;

import java.util.List;

/**
 * Created by darryl on 7-11-14.
 */
public class TestDB {
    public static void main(String[] args) {
        List<RpgCharacter> characters = CharacterDAO.getAllCharacters();
        for (RpgCharacter character : characters) {
            System.out.println(character);
            for (Armor armor : ArmorDAO.getAllItemsByCharacter(character)) {
                System.out.println(armor);
            }
        }
        System.out.println(Consts.BOOTS);
    }
}