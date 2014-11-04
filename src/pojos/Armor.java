package pojos;

/**
 * Created by darryl on 3-11-14.
 */
abstract public class Armor {
    private String name;

    protected Armor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "pojos.Armor{" +
                "name='" + name + '\'' +
                '}';
    }
}
