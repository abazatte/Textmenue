
public class Main {
    public Main(String[] args) {
        Menue menue = new Menue();
        menue.putMethode("a", Main::addieren, "addiert zwei Zahlen");
        help(args);
        menue.replaceHelp(Main::help);
        menue.exitMessage("Bis zum nächsten mal!");
        menue.putCommands();
    }

    private static void help(String[] args) {
        System.out.println("Functions: ");
        System.out.println("  (a) Addieren von zwei Werten");
        System.out.println("  (h) Hilfe. ");
        System.out.println("  (e) Exit. ");
    }

    private static void addieren(String[] strings) {
        int a = 2 + 3;
        System.out.println("2 + 3 = " + a);
    }

    public static void main(String[] args) {
        new Main(args);
    }
    
}
