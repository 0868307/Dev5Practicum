package pojos;

/**
 * Created by darryl on 3-11-14.
 */
public class Character {
    private Helmet helmet;
    private ChestPlate chestPlate;
    private Pauldrons pauldrons;
    private Leggings leggings;
    private Boots boots;

    public Character(Helmet helmet, ChestPlate chestPlate, Pauldrons pauldrons, Leggings leggings, Boots boots) {
        this.helmet = helmet;
        this.chestPlate = chestPlate;
        this.pauldrons = pauldrons;
        this.leggings = leggings;
        this.boots = boots;
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
}
