public class West implements Command{

    Map map;
    Player player;

    public West(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    @Override
    public void command() {
        player.move(map, player.getLocation().getWest());
    }
}
