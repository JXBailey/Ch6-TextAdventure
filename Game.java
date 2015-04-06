/**
 *  This class is the main class of the "Amazement Park" application. 
 *  "Amazement Park" is a simple, text based adventure game. Users 
 *  can walk around some scenery. 
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Jordan Bailey
 * @version 2015.March
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room entrance, parkPlaza, carousel, parkTower;
        Room sapphireTunnel, giftShop, wavePool, lazyRiver;
        Room gardenGates, pettingZoo, hedgeMaze, train;
        Room deathsDoor, graveyard, houseOfMirrors, hauntedHouse;
        Room bigBangBridge, bumperCars, foodCourt,arcade; 
        Room playground, rollerCoaster, ferrisWheel, chairLift; 
        Room controlCenter;
      
        // create the rooms
        entrance = new Room("the AMAZEMENT Park entrance" +
                            "You walk up to the ticket window, but no one is inside." + 
                            "You pass through the turnstyle and see a clearing up ahead.");
        parkPlaza = new Room("a small picnic area with tables and benches");
        carousel = new Room("a cheesy carousel with annoying music" + 
                            "there's a sign: " + 
                            " " + "RIDE AND RECIEVE A PRIZE" + " ");
        parkTower = new Room("a giant tower that looms over the rest of the park");
         
        sapphireTunnel = new Room("a tunnel with water leaking from the walls" +
                                  "you hear a voice... " +
                                  " " + "Your prize is at the end of a long, dreary journey" + " ");
        giftShop = new Room("a small shop...that only sells swimming trunks" + 
                            "theres a sign: " + 
                            " " + "SWIMMING TRUNKS 3 COINS" + " ");
        wavePool = new Room("a pool filled with murky, blue water" + 
                            "there's a sign: " +
                            " " + "PATRONS MUST WEAR APPROPRIATE CLOTHING" + " ");
        lazyRiver = new Room("a slow moving river filled with murky, blue water" +
                             "there's a sign: " + 
                             " " + "PRESENT TICKET TO ENTER" + " ");
        
        gardenGates = new Room("a giant gate that's covered in flowers");
        pettingZoo = new Room("a petting zoo containing a lone sheep");
        hedgeMaze = new Room("a ridiculously simple hedge maze");
        train = new Room("a childish train that slowly moves along the tracks");
        
        deathsDoor = new Room("a creepy cemetary gate with a skull on it");
        graveyard = new Room("");
        houseOfMirrors = new Room("an empty house with mirrors along the walls");
        hauntedHouse = new Room("an " + "abandoned " + "house");
         
        bigBangBridge = new Room("a bridge that shoots fireworks from it's sides");
        bumperCars = new Room("an arena filled with bumper cars");
        foodCourt = new Room("a food court...with a limited selection");
        arcade = new Room("a broken down arcade with only a few games");
       
        playground = new Room("a tower which binoculars that let you see far away");
        rollerCoaster = new Room("a roller coaster with gaps in the tracks");
        ferrisWheel = new Room("a ferris wheel");
        chairLift  = new Room("a chair lift that seems to lead to a far corner of the park");
       
        controlCenter = new Room("a small room filled with monitors");
                
        // initialise room exits
        entrance.setExit("north", parkPlaza);

        parkPlaza.setExit("north", carousel);
        parkPlaza.setExit("south", entrance);
        
        carousel.setExit("north", parkTower);
        carousel.setExit("south", parkPlaza);
        carousel.setExit("east", sapphireTunnel);
        carousel.setExit("west", gardenGates);
        
        parkTower.setExit("south", carousel);
        
        sapphireTunnel.setExit("north", wavePool);
        sapphireTunnel.setExit("east", giftShop);
        sapphireTunnel.setExit("west", carousel);
        
        giftShop.setExit("north", lazyRiver);
        giftShop.setExit("east", sapphireTunnel);
                
        wavePool.setExit("south", sapphireTunnel);
                
        lazyRiver.setExit("south", giftShop);       
        lazyRiver.setExit("east", parkPlaza);
        
        gardenGates.setExit("north", deathsDoor);
        gardenGates.setExit("south", pettingZoo);
        gardenGates.setExit("east", carousel);
        gardenGates.setExit("west", train);
        
        pettingZoo.setExit("north", gardenGates);
        
        hedgeMaze.setExit("north", train);
        
        train.setExit("north", graveyard);
        train.setExit("south", hedgeMaze);        
        train.setExit("east", gardenGates);
        
        deathsDoor.setExit("north", houseOfMirrors);
        deathsDoor.setExit("south", gardenGates);
        
        graveyard.setExit("north", hauntedHouse);
        
        houseOfMirrors.setExit("south", deathsDoor);
        houseOfMirrors.setExit("east", bigBangBridge);
        houseOfMirrors.setExit("west", hauntedHouse);
        
        hauntedHouse.setExit("south", graveyard);
        hauntedHouse.setExit("west", houseOfMirrors);        
        
        bigBangBridge.setExit("south", foodCourt);
        bigBangBridge.setExit("east", arcade);
        bigBangBridge.setExit("west", houseOfMirrors);
        
        foodCourt.setExit("north", bigBangBridge);
        foodCourt.setExit("east", bumperCars);
        
        bumperCars.setExit("north", arcade);
        bumperCars.setExit("west", foodCourt);
        
        arcade.setExit("south", bumperCars);
        arcade.setExit("east", playground);
        arcade.setExit("west", bigBangBridge);
        
        playground.setExit("south", rollerCoaster);
        playground.setExit("east", ferrisWheel);
        playground.setExit("west", arcade);
        
        rollerCoaster.setExit("north", playground);
        
        ferrisWheel.setExit("east", chairLift);        
        ferrisWheel.setExit("west", playground);
        
        chairLift.setExit("south", controlCenter);
        chairLift.setExit("west", ferrisWheel);
        
        controlCenter.setExit("north", chairLift);     
        
        currentRoom = entrance;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Hope you enjoyed your time at Amazement Park! Hope so see you soon...");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the AMAZEMENT Park!");
        System.out.println("Amazement Park is a new, text adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need any help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some intro text, which is a short message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You wake up outside a mysterious gate...");
        System.out.println("Alone and comletely lost, you approach the gate...");
        System.out.println("A sign above the gate reads: WELCOME TO AMAZEMENT PARK...");
        System.out.println("As you get closer, the gate slowly creaks open...");
        System.out.println("You pass through the gate and find yourself inside the park's entrance...");
        System.out.println("With nowhere else to go, you begin to wander...");
        System.out.println("Out of nowhere, you hear a voice say: ");        
        System.out.println(" " + "Have fun...I'll be watching..." + " ");        
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Can't go that way!!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
