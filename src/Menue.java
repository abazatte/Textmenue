import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * This Class is a simple text menu where you can put your methode.
 */
public class Menue {
    //one HashMap is for Commands, the other is for the description.
    private final HashMap<String, Consumer<String[]>> commands;
    private final HashMap<String, String> description;
    private String exitMsg = "";
    private boolean exitMsgSet = false;

    //default Constructor initialize both HashMaps and puts help and exit commands.
    public Menue() {
        commands = new HashMap<>();
        description = new HashMap<>();
        description.put("h", "help");
        description.put("e", "exit");
        commands.put("h", this::help);
        commands.put("e", this::exit);
    }

    //while true loop for input (must be at the end of your code)
    public void putCommands() {
        while (true) {
            input();
            System.out.println();
        }
    }

    //input Methode (used by only the class)
    private void input() {
        Scanner scan = new Scanner(System.in);
        System.out.print("$ ");
        String line = scan.nextLine();
        System.out.println("Input: " + line);

        String[] args = new String[0];

        if (commands.get(line) != null) {
            commands.get(line).accept(args);
        } else {
            System.err.println("INVALID INPUT");
        }
    }

    //default help methode
    public void help(String[] args) {
        System.out.println("default help, for better feeling implement the Methode. ");
        System.out.println("Commands: " + description);
    }

    //set exitMessage if u want
    public void exitMessage(String txt){
        exitMsg = txt;
        exitMsgSet = true;
    }

    //exit methode
    public void exit(String[] args) {
        if (exitMsgSet){
            System.out.println(exitMsg);
        }
        System.exit(0);
    }

    //for replacing the scuffed help Methode
    public void replaceHelp(Consumer<String[]> stringA) {
        commands.replace("h", stringA);
    }

    //Methode for putting your methode in the Menu
    public void putMethode(String string, Consumer<String[]> stringA, String text) {
        commands.put(string, stringA);
        description.put(string, text);
    }
}
