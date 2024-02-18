import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Map map = null;

        try {
            map = new Map();
        } catch (IOException e){
            System.out.println("File was not found");
        }

        Player player = new Player(map.hashMap.get(1));
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("west", new West(map, player));
        commands.put("north", new North(map, player));
        commands.put("east", new East(map, player));
        commands.put("south", new South(map, player));
        commands.put("combat", new Combat(player));
        commands.put("heal", new Healing(player));
        commands.put("pick up", new PickUp(player));

        Story story = new Story();

        System.out.println();
        System.out.println("The year is 1496 in the kingdom of Kamino. You are a villager dreaming of better life as a king.");
        System.out.println("One night you decided to attack the royal castle.");

        story.narrator(player, commands);
    }
}