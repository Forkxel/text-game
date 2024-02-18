import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Story {

    Scanner sc = new Scanner(System.in);

    public void narrator(Player player, HashMap<String, Command> commands){
        boolean repeat = true;
        while(repeat){
            String answer;
            switch (player.getLocation().getName()){
                case "Forest":
                    System.out.println();
                    System.out.println("After a several day travel through the forest you finally came to the gate of the castle.");
                    System.out.println("Next to you was tree full of apples will you take one? (yes) - (no)");
                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("yes")){
                            commands.get("pick up").command();
                            break;
                        } else if (answer.equalsIgnoreCase("no")){
                            System.out.println("You left the apple there just to never see it again.");
                            break;
                        } else {
                            System.out.println("Please speak English.");
                        }
                    }

                    System.out.println();

                    System.out.println("You can go to the " + ways(player));
                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("east") ){
                            break;
                        } else {
                            System.out.println("There is no way.");
                        }
                    }
                    commands.get(answer).command();
                    break;

                case "Gate":
                    System.out.println();
                    System.out.println("The gate was opened and there was one " + player.getLocation().getNpc().getName() + " you attacked him.");
                    commands.get("combat").command();
                    if (player.getCurrentHP() <= 0){
                        System.out.println("You lost and never known the real truth.");
                        System.exit(0);
                    }

                    System.out.println();
                    System.out.println("Do you want to heal yourself? (yes) - (no)");
                    answer = sc.next();
                    if (answer.equalsIgnoreCase("yes")){
                        commands.get("heal").command();
                        System.out.println("Your current HP: " + player.getCurrentHP());
                    } else {
                        System.out.println("No? Good luck I guess.");
                    }

                    System.out.println();
                    System.out.println("After you defeated Watchman you gone through the gate saw a hallway leading you deeper into the castle.");
                    System.out.println("When you entered the hallway gate suddenly closed behind you leaving you trapped inside castle.");
                    System.out.println();

                    System.out.println("You can go to the " + ways(player));
                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("east")){
                            break;
                        } else {
                            System.out.println("There is no way.");
                        }
                    }
                    commands.get(answer).command();
                    break;

                case "Hallway":
                    System.out.println();
                    System.out.println("When you were walking through the hallway you found a dagger will you take it? (yes) - (no)");
                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("yes")){
                            commands.get("pick up").command();
                            break;
                        } else if (answer.equalsIgnoreCase("no")){
                            System.out.println("You left the dagger there just to never see it again.");
                            break;
                        } else {
                            System.out.println("Its not that hard write yes or no.");
                        }
                    }

                    System.out.println();

                    System.out.println("You can continue your journey " + ways(player));

                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("east")){
                            break;
                        } else {
                            System.out.println("There is no way.");
                        }
                    }
                    commands.get(answer).command();
                    break;

                case "Guard":
                    System.out.println();
                    System.out.println("After you walked through the hallway and you wear attacked by " + player.getLocation().getNpc().getName());
                    commands.get("combat").command();
                    if (player.getCurrentHP() <= 0){
                        System.out.println("You lost and never know the real truth.");
                        System.exit(0);
                    }

                    System.out.println();

                    System.out.println("Do you want to heal yourself? (yes) - (no)");
                    answer = sc.next();
                    if (answer.equalsIgnoreCase("yes")){
                        commands.get("heal").command();
                        System.out.println("Your current HP: " + player.getCurrentHP());
                    } else {
                        System.out.println("You want this harder yeah?");
                    }

                    System.out.println();

                    System.out.println("After you have defeated a Royal guard you noticed that you can continue your journey to the " + ways(player));

                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("north")){
                            break;
                        } else {
                            System.out.println("There is no way.");
                        }
                    }
                    commands.get(answer).command();
                    break;

                case "Armory":
                    System.out.println();
                    System.out.println("You walked into the armory and you saw King´s sword will you take it? (yes) - (no)");

                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("yes")){
                            commands.get("pick up").command();
                            break;
                        } else if (answer.equalsIgnoreCase("no")){
                            System.out.println("You left the sword there just to never see it again.");
                            break;
                        } else {
                            System.out.println("I know yes is a hard word.");
                        }
                    }

                    System.out.println();

                    System.out.println("You looked on your compass and noticed you can continue to the " + ways(player));

                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("north")){
                            break;
                        } else {
                            System.out.println("There is no way.");
                        }
                    }
                    commands.get(answer).command();

                case "Dinning hall":
                    System.out.println();
                    System.out.println("When you walked to the glorious dinning hall of this castle you noticed a big cake on the table will you eat it? (yes) - (no)");

                    answer = sc.next();
                    if (answer.equalsIgnoreCase("yes")){
                        player.setCurrentHP(player.getMaxHP());
                        System.out.println("The cake filled your belly. This was the best decision of your life.");
                    } else if (answer.equalsIgnoreCase("no")){
                        System.out.println("This is the worst decision of your life. You will forever regret this.");
                    } else {
                        System.out.println("You just sold.");
                    }
                    System.out.println("Your current HP: " + player.getCurrentHP());

                    System.out.println();

                    System.out.println("After you did what you thought was best with the cake you noticed a door behind the table in the " + ways(player));

                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("east")){
                            break;
                        } else {
                            System.out.println("There is no way.");
                        }
                    }
                    commands.get(answer).command();
                    break;

                case "Crossroad":
                    System.out.println();
                    System.out.println("You walked to the Hallway of final decision there are two doors you feel that someone is behind south doors you saw Flashing lights through the window on the doors.");
                    System.out.println("Now you need to decide if you are ready to takeover this castle or to just Runaway.");
                    System.out.println();

                    System.out.println("Decision is yours " + ways(player));

                    while (true){
                        answer = sc.next();
                        if (answer.equalsIgnoreCase("south") || answer.equalsIgnoreCase("north")){
                            break;
                        } else {
                            System.out.println("There is no way.");
                        }
                    }
                    commands.get(answer).command();
                    break;

                case "Escape":
                    System.out.println();

                    System.out.println("You decided to escape from this castle you went to the north doors and when you opened then you saw the biggest treasure known to man.");
                    System.out.println("You filled your pockets to the brim and through the backdoor escaped this castle.");
                    System.out.println();
                    System.out.println("After you returned to your home you lived the most prestige life and lived happily ever after.");
                    repeat = false;
                    break;

                case "Boss":
                    System.out.println();

                    System.out.println("You decided to go to the doors with Flashing lights.");
                    System.out.println("You opened then and saw a King. He quickly turned took his sword and attacked.");
                    System.out.println();

                    commands.get("combat").command();
                    if (player.getCurrentHP() <= 0){
                        System.out.println("You lost so close to the finish.");
                        repeat = false;
                        break;
                    }
                    if (player.getCurrentHP() >= 0){
                        System.out.println();
                        System.out.println("You defeated the King his last words were. How could you be so Heartless....");
                        System.out.println();
                        System.out.println("You killed the King but you are not happy about it in fact you felt nothing like this was for nothing.");
                        System.out.println();
                        System.out.println("Eventually you became king but people didnt like you and long time allies of the kingdom declared war on your kingdom.");
                        System.out.println();
                        System.out.println("After the end of the war, you were captured and sentenced to be executed by hanging.");
                        System.out.println();
                        System.out.println("Your last words were: How could I be so Heartless....");

                        repeat = false;
                        break;
                    }
            }
        }
    }

    private ArrayList<String> ways(Player player){
        ArrayList<String> a = new ArrayList<>();
        if (player.getLocation().getWest() != 0){
            a.add("west");
        }
        if (player.getLocation().getNorth() != 0){
            a.add("north");
        }
        if (player.getLocation().getEast() != 0){
            a.add("east");
        }
        if (player.getLocation().getSouth() != 0){
            a.add("south");
        }
        return a;
    }
}
