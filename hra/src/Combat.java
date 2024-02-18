import java.util.Random;

public class Combat implements Command{

    private Player player;
    Random rd = new Random();

    public Combat(Player player) {
        this.player = player;
    }

    @Override
    public void command() {
        while (player.getCurrentHP() > 0 && player.getLocation().getNpc().getCurrentHP() > 0){
            int playerDamage = 0;
            int a = rd.nextInt(100);
            switch (player.newWeapon().getName()){
                case "fists":
                    playerDamage = rd.nextInt(player.newWeapon().getDamage());
                    break;
                case "dagger":
                    if (a % 2 == 0){
                        playerDamage = 0;
                    } else {
                        playerDamage = rd.nextInt(player.newWeapon().getDamage())+3;
                    }
                    break;
                case "sword":
                    if (a %2 != 0){
                        playerDamage = 0;
                    } else {
                        playerDamage = rd.nextInt(player.newWeapon().getDamage())+5;
                    }
                    break;
            }

            player.getLocation().getNpc().setCurrentHP(player.getLocation().getNpc().getCurrentHP() - playerDamage);
            player.setCurrentHP(player.getCurrentHP() - player.getLocation().getNpc().getDamage() * rd.nextInt(2));
        }
        if (player.getCurrentHP() <= 0){
            System.out.println("You died");
            System.out.println("Enemy HP: " + player.getLocation().getNpc().getCurrentHP());
            System.out.println("Your HP: " + player.getCurrentHP());
        } else {
            System.out.println("You won");
            System.out.println("Enemy HP: " + player.getLocation().getNpc().getCurrentHP());
            System.out.println("Your HP: " + player.getCurrentHP());
        }
    }
}
