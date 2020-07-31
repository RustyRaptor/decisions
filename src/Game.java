import java.util.Scanner;

/**
 * This class creates an object that will contain the core variables and methods of the game.
 */

public class Game {
    private String playerName;

    public Game() {
        this.playerName = "Jeff"; // name defaults to jeff.
    }

    /**
     * This function is the entry point of the whole game.
     */


    public void start() {
        prntDlg("WELCOME TO DECISIONS"); // Welcome message
        playerName = usrInpt("Please enter your name:");

        prntDlg("Well hello, $N");
    }

    /**
     * PRINT DIALOG: Prints a dialog box to talk to the player.
     * Additionally, replaces all instances of $N with the playerName
     *
     * @param text the text you want to display.
     */
    public void prntDlg(String text) {
        text = text.replace("$N", playerName);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        System.out.println(text);
        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public String usrInpt(String text) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        prntDlg(text);

        return myObj.nextLine();
    }
}
