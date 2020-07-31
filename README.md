# decisions
A text base decision making game engine.
Allows the creation of text based decision story games by writing a simple text file. 


## How it works
The program will read a script from the scripts folder.
The script will describe how the story works and where decisions will take you.

The program will also ask you for information like your name so it can personalize the dialog for you.


## How to make a script.

An example script exists in the scripts folder.

Here is an explanation of how it works. 

```
WELCOME:  // Words that end with a colon : are tags and indicate the start of a story branch.
// The first line of any story script MUST BE A TAG
// If it is not a tag the story will end immediately. 

// Lines that start with DLG are dialog lines and will print dialog to the screen.
DLG Hi, welcome to the game. Are you ready to begin? 

// Lines that start with OPT are option lines and will append an option to be compiled and shown to the user.
OPT YES -> BEGIN   
OPT NO  -> BEGINANYWAY // THe arrow symbol in the middle points to which tag this option will take you to. 
OPT IDK -> BEGINANYWAY 

// If a line starts with FIN it will compile the options and let the user choose one
FIN 
// then it will take the reader to the branch that their option takes them to.


BEGIN:
DLG Okidokey, lets get started 
// Tags don't need to have OPT and they don't need to end in FIN.
// Just know that if that's the case it will just keep reading on to the next line. 

BEGINANYWAY:

// you can have as many dialogue and options as you want in a single branch. 
DLG Well too bad we are starting anyway.
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

***IMPORTANT*** DO NOT USE THIS CODE IN A SCRIPT PLEASE USE THE RAW FILE UNDER THE /scripts FOLDER. THIS CODE WILL BREAK
```
