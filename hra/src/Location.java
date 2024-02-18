public class Location {

    private int west, north, east, south;
    private String name;
    private Npc npc;
    private Item item;

    public Location(int west, int north, int east, int south, String name) {
        this.west = west;
        this.north = north;
        this.east = east;
        this.south = south;
        this.name = name;
    }

    public int getWest() {
        return west;
    }

    public int getNorth() {
        return north;
    }

    public int getEast() {
        return east;
    }

    public int getSouth() {
        return south;
    }

    public String getName() {
        return name;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}