package window.pojos;

/**
 * Created by darryl on 6-11-14.
 */
public class ArmorFactory {
    public static Armor create(String type, String name) {
        Armor item;
        switch (type.toLowerCase()) {
            case "boots":
                item = new Boots(name);
                break;
            case "chestplate":
                item = new ChestPlate(name);
                break;
            case "helmet":
                item = new Helmet(name);
                break;
            case "leggings":
                item = new Leggings(name);
                break;
            case "pauldrons":
                item = new Pauldrons(name);
                break;
            default:
                item = null;
                break;
        }
        return item;
    }
}
