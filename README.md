# decisions
A completely normal decision making game.


## How it works
The program will read a script from the scripts folder.
The script will describe how the story works and where decisions will take you.

The program will also ask you for information like your name so it can personalize the dialog for you.


## How to make a script.

An example script exists in the scripts folder.

Here is an explanation of how it works. 

```
WELCOME:  // Words that end with a colon : are tags and indicate the start of a story branch.
DLG Hi, welcome to the game. Are you ready to begin? // Lines that start with DLG are dialog lines and will print dialog to the screen.
OPT YES -> BEGIN   // Lines that start with OPT are option lines and will append an option to be compiled and shown to the user at the end of the branch.
OPT NO  -> BEGINANYWAY // THe arrow symbol in the middle points to which tag this option will take you to. 
OPT IDK -> BEGINANYWAY 
FIN // If a line starts with FIN it will compile the options and let the user choose one
// then it will take the reader to the branch that their option takes them to.


BEGIN:
DLG Okidokey, lets get started 
// Tags don't need to have option and they don't need to end in FIN.
// Just know that if that's the case it will just keep reading on to the next line. 

BEGINANYWAY:
DLG Well too bad we are starting anyway. // you can have as many dialogue and options as you want in a single branch. 
DLG Now pick a class.
OPT ROGUE -> ROGUE
OPT WARRIOR -> WARRIOR
OPT MAGE -> MAGE
FIN

ROGUE:
DLG AH the rogue. Agile and clever
HALT // The HALT command will end the story immediately. 

// It's important to understand that unless you guide the story to a specific branch it will just keep reading on.

WARRIOR:
DLG Warrior powerful and brave
HALT // If this HALT is removed it will keep reading into the MAGE: tag.

MAGE:
DLG You are a mage, Master of the Arcana.
HALT
```
