public class Healing implements Command{

    Player player;
    Heal heal;

    public Healing(Player player) {
        this.player = player;
    }

    @Override
    public void command() {
        Heal healingItem = player.pickHeal();

        if (healingItem != null) {
            int newHP = player.getCurrentHP() + healingItem.getHeal();
            if (newHP > player.getMaxHP()){
                player.setCurrentHP(player.getMaxHP());
            } else {
                player.setCurrentHP(newHP);
            }

            for (int i = 0; i < player.getInventory().length;i++){
                if (player.getInventory()[i] instanceof Heal){
                    player.getInventory()[i] = null;
                    break;
                }
            }
            System.out.println(player.toString());
        }
    }
}
