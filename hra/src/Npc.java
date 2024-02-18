public class Npc {

    private String name;
    private int currentHP;
    private int damage;

    public Npc(String name, int currentHP, int damage) {
        this.name = name;
        this.currentHP = currentHP;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Npc{" +
                "name='" + name + '\'' +
                ", currentHP=" + currentHP +
                ", damage=" + damage +
                '}';
    }
}
