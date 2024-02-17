public class East implements Command{

    Map map;
    Player player;

    public East(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    @Override
    public void command() {
        player.move(map, player.getLocation().getEast());
    }
}
