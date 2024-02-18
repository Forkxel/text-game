public class Heal extends Item{

    private int heal;

    public Heal(String name, int heal) {
        super(name);
        this.heal = heal;
    }

    public int getHeal() {
        return heal;
    }

    @Override
    public String toString() {
        return name + ": healing " + heal;
    }
}
