public class North implements Command{

    Map map;
    Player player;

    public North(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    @Override
    public void command() {
        player.move(map, player.getLocation().getNorth());
    }
}
