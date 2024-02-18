public class PickUp implements Command{

    Player player;

    public PickUp(Player player) {
        this.player = player;
    }

    @Override
    public void command() {
        for (int i = 0; i < player.getInventory().length;i++){
            if (player.getInventory()[i] == null){
                player.getInventory()[i] = player.getLocation().getItem();
                System.out.println(player.toString());
                break;
            }
        }
    }
}