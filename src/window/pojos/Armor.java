package window.pojos;

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

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{" + "name='" + name +
                '\'' + '}';
    }
}
