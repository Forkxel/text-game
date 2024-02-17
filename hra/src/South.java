public class South implements Command{

    Map map;
    Player player;

    public South(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    @Override
    public void command() {
        player.move(map, player.getLocation().getSouth());
    }
}
