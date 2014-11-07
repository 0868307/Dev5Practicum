import daos.ArmorDAO;
import window.pojos.Armor;

import java.util.List;

/**
 * Created by darryl on 7-11-14.
 */
public class TestDB {
    public static void main(String[] args) {
//        List<RpgCharacter> characters = CharacterDAO.getAllCharacters();
//        for (RpgCharacter character : characters) {
//            System.out.println(character);
//            for (Armor armor : ArmorDAO.getAllItemsByCharacter(character)) {
//                System.out.println(armor);
//            }
//        }
        List<Armor> boots = ArmorDAO.getAllItemsByType(ArmorDAO.BOOTS);
        System.out.println(boots.size());
        for (Armor armor : boots) {
            System.out.println(armor);
        }
    }
}

