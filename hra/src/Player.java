public class Player {

    private Location location;
    private int currentHP;
    private int maxHP;

    public Player(Location location) {
        this.location = location;
        this.maxHP = 20;
        this.currentHP = maxHP;
    }

    public void move(Map map, int numberOfLocation){
        location = map.hashMap.get(numberOfLocation);
    }

    public Location getLocation() {
        return location;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
}