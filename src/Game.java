import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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


    public void start() throws IOException {
        prntDlg("WELCOME TO DECISIONS"); // Welcome message
        playerName = usrInpt("Please enter your name:");

        prntDlg("Well hello, $N");

        readStory("scripts/scripta");
    }

    /**
     * PRINT DIALOG: Prints a dialog box to talk to the player.
     * Additionally, replaces all instances of $N with the playerName
     *
     * @param text the text you want to display.
     */

    // TODO: Make this more readable.
    public void prntDlg(String text) {
        text = text.replace("$N", playerName);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(text);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * USER INPUT: it gets user input and returns it for use.
     *
     * @param text The text you want to prompt them with.
     * @return The text the user entered.
     */
    public String usrInpt(String text) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        prntDlg(text);

        return myObj.nextLine();
    }

    /**
     * This function will interpret a story file you created.
     * <p>
     * The story file must follow a fairly strict syntax.
     * This is documented separately.
     * This function determines how our story files will be read.
     * It's VERY IMPORTANT to understand this function
     *
     * @param storyName the name of the story file you have stored.
     * @throws IOException if something goes wrong.
     */
    public void readStory(String storyName) throws IOException {
        // This is the name of the next branch to read.
        // It is updated in the FIN command.
        String nextBranch;


        // This is an array of options to be compiled for the player to choose from.
        // They are updated using the OPT command.
        // They are compiled in the FIN then cleared afterwards for the next branch.
        ArrayList<String> options = new ArrayList<>();


        // Initialize a buffered reader to read the file line by line without using too much memory.
        File file = new File(storyName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        // This is the string that will store the current line for interpretation.
        String st;

        // read the first line of the file and make sure it ends with a colon
        st = br.readLine();
        if (!st.endsWith(":")) {
            return;
        }

        // Now let's begin the story reading it line by line.
        while ((st = br.readLine()) != null) {


            // HALT: will end the story immediately
            if (st.startsWith("HALT")) {
                break;
            }

            // DLG: will display some dialogue using the prntDlg function
            if (st.startsWith("DLG")) {
                prntDlg(st.replace("DLG", ""));
            }

            // OPT: Will create an option and the -> will point to the tag it should take you to.
            else if (st.startsWith("OPT")) {
                st = st.replaceAll("OPT", "");
                st = st.replaceAll(" ", "");
                options.add(st);
            }


            // FIN will compile the options and prompt the user to pick one.
            // it will then take the interpreter to that option.
            else if (st.startsWith("FIN")) {
                if (options.isEmpty()) {
                    continue;
                }

                // compiles the decision into a readable dialogue.
                // TODO: make this more readable.
                StringBuilder optionList = new StringBuilder("Pick One:\n");
                for (int i = 0; i < options.size(); i++) {
                    optionList.append(i).append(" : ");
                    optionList.append(options.get(i).split("->")[0]);
                    optionList.append("\n");
                }

                // print out the compiled options.
                prntDlg(optionList.toString());

                // get the users decision
                String decision = usrInpt("enter the number for your decision");

                // set the next branch based on the user option.
                nextBranch = options.get(Integer.parseInt(decision)).split("->")[1];

                // take our reader to the next branch.
                while ((st = br.readLine()) != null) {
                    if (st.endsWith(":") && st.replace(":", "").equals(nextBranch)) {
                        break;
                    }
                }

                options = new ArrayList<>(); // clear the options for next branch.
            }
        }

    }
}
