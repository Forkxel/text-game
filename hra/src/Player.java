import java.util.Arrays;
import java.util.Scanner;

public class Player {

    private Location location;
    private int currentHP;
    private int maxHP;
    private Weapon weapon;
    private Item[] inventory;

    public Player(Location location) {
        this.location = location;
        this.maxHP = 20;
        this.inventory = new Item[3];
        this.currentHP = maxHP;
    }

    public Heal pickHeal() {
        Scanner sc = new Scanner(System.in);

        boolean inventoryEmpty = true;
        for (Item item : inventory) {
            if (item != null) {
                inventoryEmpty = false;
                break;
            }
        }

        int emptySlots = 0;
        for (Item item : inventory) {
            if (item == null) {
                emptySlots++;
            }
        }

        if (inventoryEmpty) {
            System.out.println("Your inventory is empty.");
            return null;
        }

        if (emptySlots == 0) {
            System.out.println("Your inventory is full.");
            return null;
        }

        while (true) {
            System.out.println("What heal item do you want to use?");
            System.out.println("Your inventory: " + Arrays.toString(inventory));
            String temp = sc.next();
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] instanceof Heal && inventory[i] != null && temp.equals(inventory[i].getName())) {
                    return (Heal) inventory[i];
                } else if (inventory[i] instanceof Weapon) {
                    System.out.println("This is not a food item.");
                    break;
                }
            }
            break;
        }
        return null;
    }

    public Weapon newWeapon(){
        Weapon bestWeapon = new Weapon("fists", 2);
        for (Item item : inventory) {
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                if (weapon.getDamage() > bestWeapon.getDamage()) {
                    bestWeapon = weapon;
                }
            }
        }
        return bestWeapon;
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

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public Item[] getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Your inventory: " + Arrays.toString(inventory);
    }
}