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
    
    private Room entrance, parkPlaza, carousel, parkTower;
    private Room sapphireTunnel, giftShop, wavePool, lazyRiver;
    private Room gardenGates, pettingZoo, hedgeMaze, train;
    private Room deathsDoor, graveyard, houseOfMirrors, hauntedHouse;
    private Room bigBangBridge, bumperCars, foodCourt,arcade; 
    private Room playground, rollerCoaster, ferrisWheel, chairLift; 
    private Room controlCenter;
    
    private boolean hasNote = false;
    private boolean hasBathingSuit = false;
    private boolean hasBluePass = false;
    private boolean hasBlueOrb = false;
    private boolean hasWateringCan = false;
    private boolean hasHammer = false; 
    private boolean hasRedPass = false;    
    private boolean hasSalad = false;
    private boolean hasScissors = false;
    private boolean hasGreenOrb = false;      
    private boolean hasArcadePass = false;    
    private boolean hasRedOrb = false;    
    private boolean hasYellowKey = false;
    private boolean hasLiftKey = false;    
    private boolean hasSilverOrb = false;    
    private boolean hasHouseKey = false;    
    private boolean hasBook = false;    
    private boolean hasSkullKey = false;    
    private boolean hasBlackOrb = false; 

    private boolean inWater = false;    
    private boolean wearingBathingSuit = false;    
    private boolean riverLocked = true;
    private boolean inRiver = false;

    private boolean gateLocked = true;
    private boolean fullCan = false;    
    private boolean goatMoved = false;    
    private boolean mazeBlocked = true;
    private boolean endMaze = false;  

    private boolean bridgeLocked = true;
    private boolean arcadeLocked = true;
    private boolean inArcade = false;
    private boolean gameBeaten = false;
    
    private boolean coasterOff = true;
    private boolean liftOff = true;

    private boolean mausoleumLocked = true;
    private boolean inMausoleum = false;
    private boolean houseLocked = true;
    private boolean inLibrary = false;
    private boolean bookPlaced = false;
    private boolean inMirrors = false;
    private boolean mirrorSmashed = false;
    
    private int coinCount = 0;
    private int orbCount = 0;
   
    Command command;
    private String secondWord;
    
    /**
     * Create the game and initialise it's internal map.
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
        entrance = new Room("ENTRANCE: the AMAZEMENT Park entrance." + "\n" +
                            "\n" +
                            "You walk up to the ticket window, but no one is inside." + "\n" +
                            "You pass through the turnstyle and see a clearing up ahead." + "\n");
        parkPlaza = new Room("PARK PLAZA: a small picnic area with tables and benches." + "\n" +
                                 "\n" +
                                 "Letters suddenly appear in the sky and they read:" + "\n" +
                                 "''" + "Th_ p_rt_l _s _n th_ P_rk T_w_r..." + "''." + "\n");
        
        carousel = new Room("CAROUSEL: a cheesy carousel with annoying music." + "\n" +
                            "\n" +
                            "In front of the carousel, there's a sign:" + "\n" +
                            "''" + "RIDE AND RECIEVE A PRIZE" + "''." + "\n");
        parkTower = new Room("PARK TOWER: a giant tower that looms over the rest of the park." + "\n" +
                             "\n" +
                             "You walk towards the tower, but there's a locked gate in front of it." + "\n" +
                             "The gate has five small holes in it..." + "\n");
               
                             
        sapphireTunnel = new Room("SAPPHIRE TUNNEL: a tunnel with water leaking from the walls:" + "\n" +
                                  "\n" +
                                  "As you walk through the tunnel, you hear a voice..." + "\n" +
                                  "''" + "Your prize is at the end of a long, dreary journey" + "''." + "\n");
        giftShop = new Room("GIFT SHOP: a small shop...that only sells bathing suits." + "\n" +
                            "\n" +
                            "After walking through the store, you reach a register." + "\n" +
                            "There's a sign:" + "\n" +
                            "''" + "BATHING SUITS 3 COINS" + "''." + "\n");
        wavePool = new Room("WAVE POOL: a pool filled with murky, blue water." + "\n" +
                            "\n" +
                            "You walk pass rows and rows of empty chairs and umbrellas" + "\n" +
                            "until you reach the edge of the pool." + "\n"); 
        lazyRiver = new Room("LAZY RIVER: a slow moving river filled with murky, blue water." + "\n" +
                             "\n" +
                             "You walk to the gate and there's a sign:" + "\n" +
                             "''" + "PRESENT PASS TO ENTER" + "''." + "\n");
        
        gardenGates = new Room("GARDEN GATES: a giant gate that's covered in flowers." + "\n");                     
        pettingZoo = new Room("PETTING ZOO: a petting zoo containing a lone sheep." + "\n" +
                              "\n" +    
                              "As you walk around, you notice that there aren't any animals around." + "\n" +
                              "You eventually reach a lone goat with gleaming red eyes." + "\n" +
                              "It looks as if it's sitting on something." + "\n" +
                              "The goat then opens it's mouth and in a childlike voice says:" + "\n" +
                              "''" + "H...hu..ng...ry..." + "''." + "\n");                                                      
        hedgeMaze = new Room("You board the train and head south towards the hedge maze." + "\n" +
                             "HEGDE MAZE: a simple hedge maze." + "\n" +
                             "\n" +
                             "You approach the entrance and see that it is covered in thorns." + "\n");
        train = new Room("TRAIN: a childish train that slowly moves along the tracks." + "\n"); 

        
        deathsDoor = new Room("DEATH'" + "S DOOR: a creepy pathway lined with skulls." + "\n" +
                              "\n" +
                              "You slowly walk along the pathway and hear a voice..." + "\n" +
                              "''" + "What you seek lies among the dead" + "''." + "\n");
        graveyard = new Room("You board the train and head north towards the graveyard." + "\n" +
                             "GRAVEYARD: a graveyard filled with tombstones." + "\n" +
                             "\n" +
                             "You walk among the tombstones and reach a mausoleum." + "\n");
        houseOfMirrors = new Room("HOUSE OF MIRRORS: an empty house with mirrors along the walls." + "\n");
        hauntedHouse = new Room("HAUNTED HOUSE: an " + "''" + "abandoned" + "''" + " house." + "\n");

          
        bigBangBridge = new Room("BIG BANG BRIDGE: a bridge that shoots fireworks from it's sides." + "\n");
        bumperCars = new Room("BUMPER CARS: an arena filled with bumper cars..." + "\n");
        foodCourt = new Room("FOOD COURT: a food court...with a limited selection." + "\n" +
                             "\n" +                
                             "You walk up to one of the registers and see a sign:" + "\n" +
                             "''" + "SALAD 3 COINS" + "''." + "\n");
        arcade = new Room("ARCADE: a broken down arcade with only a few games." + "\n");

        
        playground = new Room("PLAYGROUND: a children's playground that's...fun." + "\n");
        rollerCoaster = new Room("ROLLER COASTER: a old roller coaster with with yellow cars." + "\n");
        ferrisWheel = new Room("FERRIS WHEEL: a slow moving ferris wheel." + "\n");
        chairLift  = new Room("CHAIR LIFT: a chair lift that seems to lead to a far corner of the park." + "\n");
        
        controlCenter = new Room("CONTROL CENTER: a small room filled with monitors." + "\n" +
                                 "You look around the room and see that it is filled with monitors" + "\n" +
                                 "that show different parts of the park. There's a book on the desk." + "\n");
                
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
        giftShop.setExit("west", sapphireTunnel);
                
        wavePool.setExit("south", sapphireTunnel);
        wavePool.setExit("east", lazyRiver);
                
        lazyRiver.setExit("south", giftShop);
        lazyRiver.setExit("west", wavePool);
           
        gardenGates.setExit("east", carousel);
        
        pettingZoo.setExit("north", gardenGates);
        
        train.setExit("north", graveyard);
        train.setExit("south", hedgeMaze);
        train.setExit("east", gardenGates);
        
        hedgeMaze.setExit("north", train);        
        
        deathsDoor.setExit("north", houseOfMirrors);
        deathsDoor.setExit("south", gardenGates);
        
        graveyard.setExit("north", hauntedHouse);
        
        houseOfMirrors.setExit("south", deathsDoor);
        houseOfMirrors.setExit("west", hauntedHouse);
        
        hauntedHouse.setExit("south", graveyard);
        hauntedHouse.setExit("east", houseOfMirrors);              
       
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
        
        chairLift.setExit("west", ferrisWheel);
        chairLift.setExit("east", controlCenter);
        
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
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Hope you enjoyed your time at Amazement Park! Hope so see you soon..." + "\n");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the AMAZEMENT Park!");
        System.out.println("Amazement Park is a new, text adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need any help." + "\n");
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

        switch (commandWord) 
        {
            case ACTIVATE:
                 activateCoaster();
                 activateLift();
                 break;
                 
            case BUY:
                 buyGiftShop();
                 buyFoodCourt();
                 break;
                
            case CHECK:
                 checkItem();
                 break;                 
                 
            case DIVE:
                 poolDive();
                 break;                
                
            case EAT:
                 eatSalad();
                 break;

            case ENTER:
                 enterWavePool();
                 enterH_House();
                 enterM_House();
                 enterRiver();
                 enterMaze();
                 enterMausoleum();
                 enterArcade();
                 break;
                 
            case FILL:
                 fillWateringCan();
                 break;
                 
            case GO:
                 goRoom(command);
                 break;                 
                 
            case HELP:
                 printHelp();
                 break;                  
              
            case OPEN:
                 openParkTower();
                 break;
            
            case PLACE:
                 placeBook();
                 break;
                
            case REMOVE:
                 removeSuit();
                 break;                
                               
            case RIDE:
                 rideCarousel();
                 rideF_Wheel();
                 break;                

            case SHOW:
                 showSalad();
                 break;
                 
            case TAKE:
                 takeItem();
                 break;
                
            case UNKNOWN:
                 System.out.println("I don't know what you mean..." + "\n");
                 break;

            case USE:
                 useWateringCan();
                 useHammer();
                 useScissors();
                 break;
                 
            case WEAR:
                 wearSuit();
                 break;                
                
            case QUIT:
                 wantToQuit = quit(command);
                 break;    
        }
        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Activate the roller coaster.
     */
    private void activateCoaster()
    {
        if(currentRoom == rollerCoaster && hasYellowKey == true && coasterOff == true)
        {
            System.out.println("You step up to the coaster's control panel and use the key" + "\n" +
                               "to turn on the ride. The cars start moving and rush towards" + "\n" +
                               "the first loop. When the cars are upside down, you notice something" + "\n" +
                               "fall from one of them. It's a lift key." + "\n");
            coasterOff = false;
        }
        if(currentRoom == rollerCoaster && hasYellowKey == true && coasterOff == false)
        {
            System.out.println("The coaster is already running." + "\n");
            coasterOff = false;
        }
        
        if(currentRoom == rollerCoaster && hasYellowKey == false)
        {
            System.out.println("It looks like to need a key to activate the coaster." + "\n");
            coasterOff = true;
        }
    }
    
    /**
     * Activate the chair lift.
     */
    private void activateLift()
    {
        if(currentRoom == chairLift && hasLiftKey == true && liftOff == true)
        {
            System.out.println("You step up to the control panel and turn on the chair lift." + "\n" +
                               "The chairs start moving to a far side of the park..." + "\n" +
                               "You can now travel via the chair lift." + "\n");
            liftOff = false;
        }
        if(currentRoom == chairLift && hasLiftKey == true && liftOff == false)
        {
            System.out.println("The chair lift is already running." + "\n");
            liftOff = false;
        }
        
        if(currentRoom == chairLift && hasLiftKey == false)
        {
            System.out.println("It looks like to need a key to activate the chair lift." + "\n");
            liftOff = true;
        }
    }    
    
    /** 
     * Buy something from the gift shop.
     */
    private void buyGiftShop() 
    {
        if(currentRoom == giftShop && coinCount >= 3)
        {
            System.out.println("You place three coins on the counter." + "\n" +
                               "A bathing suit materializes in front of you and you take it." + "\n");
            coinCount = coinCount - 3;
            hasBathingSuit = true;
        }
        
        if(currentRoom == giftShop && coinCount < 3)
        {
            System.out.println("You don't have enough coins to buy this." + "\n" +
                               "You have " + coinCount + " coins." + "\n");
        }
    }  
    
    /** 
     * Buy something from the food court.
     */
    private void buyFoodCourt() 
    {
        if(currentRoom == foodCourt && coinCount >= 3)
        {
            System.out.println("You place four coins on the counter." + "\n" +
                               "A salad materializes in front of you and you take it." + "\n");
            coinCount = coinCount - 3;
            hasSalad = true;
        }
        
        if(currentRoom == foodCourt && coinCount < 3)
        {
            System.out.println("You don't have enough coins to buy this." + "\n" +
                               "You have " + coinCount + " coins." + "\n");
        }
    }     
    
    /** 
     * Get details on one of your items.
     */
    private void checkItem() 
    {         
            if(hasBathingSuit == true && secondWord == "bathing suit")
        {
            System.out.println("a bathing suit that you bought at the gift shop." + "\n");
        }        
        
        if(hasBluePass == true &&  secondWord == "blue pass")
        {
            System.out.println("a blue colored pass that is used to ride the Last River." + "\n");
        }

        if(hasBlueOrb == true && secondWord == "blue orb")
        {
            System.out.println("a light blue orb that's filled with water." + "\n");
        }

        if(hasWateringCan == true && secondWord == "watering can")
        {
            System.out.println("a small green watering can with a flower on it." + "\n");
        }

        if(hasHammer == true && secondWord == "hammer")
        {
            System.out.println("a small hammer with" + "\n" +
                               "''" + "RORRIM " + "''" + "\n" +
                               "written on it." + "\n");
        }

        if(hasRedPass == true && secondWord == "red pass")
        {
            System.out.println("a red colored pass that grants access to Big Bang Bridge." + "\n");
        }

        if(hasSalad == true && secondWord == "salad")
        {
            System.out.println("a salad...with no dressing." + "\n");
        }

        if(hasScissors == true && secondWord == "giant scissors")
        {
            System.out.println("...giant scissors." + "\n");
        }

        if(hasGreenOrb == true && secondWord == "green orb")
        {
            System.out.println("a light green orb that smells like spring." + "\n");
        }

        if(hasArcadePass == true && secondWord == "arcade pass")
        {
            System.out.println("a pass that grants access to the arcade." + "\n");
        }

        if(hasRedOrb == true && secondWord == "red orb")
        {
            System.out.println("a red orb that's warm to the touch." + "\n");
        }

        if(hasYellowKey == true && secondWord == "yellow key")
        {
            System.out.println("a small yellow key that turns on the roller coaster." + "\n");
        }

        if(hasLiftKey == true && secondWord == "lift key")
        {
            System.out.println("a small key that activates the chair lift." + "\n");
        }

        if(hasSilverOrb == true && secondWord == "silver orb")
        {
            System.out.println("a silver orb that sparkles and shines." + "\n");
        }

        if(hasBook == true && secondWord == "book")
        {
            System.out.println("a book titled:" +
                               "''" + "Life In a Haunted House" + "''" + "\n");
        }

        if(hasHouseKey == true && secondWord == "house key")
        {
            System.out.println("a small house key with an" + "\n" +
                               "''" + "H" + "''" + "\n" +
                               "on it." + "\n");
        }

        if(hasSkullKey == true && secondWord == "skull key")
        {
            System.out.println("a key with a skull on it." + "\n");
        }

        if(hasBlackOrb == true && secondWord == "black orb")
        {
            System.out.println("a black orb filled with murky darkness." + "\n");
        }         
    }     
    
    /** 
     * Dive into the deep end of the wave pool.
     */
    private void poolDive() 
    {
        if(inWater == true && hasBluePass == false)
        {
            System.out.println("You dive into the deep end of the wave pool." + "\n" +
                               "You see some sort of card resting on the bottom." + "\n" +
                               "You pick it up and see that it's a pass for the Lazy River." + "\n" +
                               "You then resurface and leave the water." + "\n");
            hasBluePass = true;
            inWater = false;
        }
               
        if(inWater == true && hasBluePass == true)
        {
            System.out.println("You dive into the deep end of the wave pool." + "\n" +
                               "You get bored and resurface and leave the water." + "\n");
            inWater = false;
        }
    }     
    
    /** 
     * Eat the salad that you bought.
     */
    private void eatSalad() 
    {
        if(hasSalad == true)
        {
            System.out.println("You eat the salad." + "\n" +
                               "Without any dressing on it, it is completely dry" + "\n" +
                               "and way to crunchy for your taste." + "\n");
            hasSalad = false;
        }
        
        if(hasSalad == false)
        {
            System.out.println("You don't have anything to eat." + "\n");
        }
    }      
    
    /** 
     * Get in the wave pool.
     */
    private void enterWavePool() 
    {
        if(currentRoom == wavePool && wearingBathingSuit == true)
        {
            System.out.println("Even though the water looks sketchy, you jump into the pool." + "\n" +
                               "The water looks pretty deep... you could probably dive to the bottom." + "\n");
            inWater = true;
        }
      
        if(currentRoom == wavePool && wearingBathingSuit == false)
        {
            System.out.println("There's a sign:" + "\n" +
                               "''" + "PATRONS MUST WEAR APPROPRIATE CLOTHING" + "''" + "\n" +
                               "It looks like you can't enter unless you're wearing a bathing suit." + "\n");
        }
    }     
    
    /** 
     * Enter the haunted house.
     */
    private void enterH_House() 
    {
        if(currentRoom == hauntedHouse && hasHouseKey == true)
        {
            System.out.println("You enter the house and hear and eerie voice say:" + "\n" +
                               "''" + "Library...." + "''" + "\n" +
                               "You then make your way to the library and find a bookshelf" + "\n" +
                               "with a book missing." + "\n");
            inLibrary = true;
        }
        
        if(currentRoom == hauntedHouse && hasHouseKey == false)
        {
            System.out.println("The door is locked...you need a house key." + "\n");
        }
    }         

    /** 
     * Enter the haunted house.
     */
    private void enterM_House() 
    {
        if(currentRoom == houseOfMirrors && mirrorSmashed == false)
        {
            System.out.println("You enter the house of mirrors and notice arrows on the ground." + "\n" +
                               "You follow the arrows and end up in a room with a giant mirror in it." + "\n");
            inMirrors = true;
        }
        
        if(currentRoom == houseOfMirrors && mirrorSmashed == true)
        {
            System.out.println("You enter the house of mirrors and notice arrows on the ground." + "\n" +
                               "You follow the arrows and end up in the room with the broken mirror in it." + "\n" +
                               "Since the mirror is smashed, you turn around and leave." + "\n");
            inMirrors = false;
        }
    }     
    
    /** 
     * Enter the mausoleum.
     */
    private void enterMausoleum() 
    {
        if(currentRoom == graveyard && hasSkullKey == true)
        {
            System.out.println("You open the door to the mausoleum and dust pours out of the entrance." + "\n" +
                               "You walk to the back wall, and see a black orb." + "\n");
            mausoleumLocked = false;
            inMausoleum = true;
        }
        
        if(currentRoom == graveyard && hasSkullKey == false)
        {
            System.out.println("You try to open the door but it won't budge." + "\n" +
                               "You need the skull key." + "\n");
        }
    }     
    
    /** 
     * Enter the lazy river.
     */
    private void enterRiver() 
    {
        if(currentRoom == lazyRiver && hasBluePass == true && hasBlueOrb == false)
        {
            System.out.println("You pick up a tube and walk to the river's entrance and jump in" + "\n" +
                               "After floating for what seems like forever," + "\n" +
                               "you reach the end and arrive at a gate...suddenly, a small" + "\n" +
                               "blue orb materializes in front of you. You take the orb and pass" + "\n" +
                               "through the gate, which quickly closes and locks behind you." + "\n" +
                               "You take a look around and realize you are in the park plaza." + "\n");
            riverLocked = false;
            inRiver = true;
            hasBlueOrb = true;
            orbCount = orbCount++;
            currentRoom = parkPlaza;
        }
        
        if(currentRoom == lazyRiver && hasBluePass == false)
        {
            System.out.println("There's a sign:" + "\n" +
                               "''" + "PRESENT PASS TO ENTER" + "''." + "\n" +
                               "It looks like you can't proceed." + "\n");
        }
        
        if(currentRoom == lazyRiver && hasBlueOrb == true)
        {
            System.out.println("You pick up a tube and walk to the river's entrance and jump in" + "\n" +
                               "After floating for what seems like forever," + "\n" +
                               "you reach the end and arrive at a gate..." + "\n" +
                               "You pass through the gate, which quickly closes and locks behind you." + "\n");
            inRiver = true;
            hasBlueOrb = true;
            currentRoom = parkPlaza;
        }   
    }         
    
    /** 
     * Enter the arcade.
     */
    private void enterArcade() 
    {
        if(currentRoom == arcade && hasArcadePass == true && hasRedOrb == false)
        {
            System.out.println("You enter the arcade." + "\n" +
                               "After awhile you realize that all of the gamnes have" + "\n" +
                               "''" + "OUT OF ORDER" + "''" + "signs on them." + "\n" +
                               "You keep looking around and find a game that still works." + "\n" +
                               "It looks like an old school platformer and you decide to play for awhile." + "\n" +
                               "Pretty soon you're facing the final boss and after you beat him, the game shuts off." + "\n" +
                               "A small red orb then materializes in front of you." + "\n");
            arcadeLocked = false;
            inArcade = true;
            gameBeaten = true;
        }
        
        if(currentRoom == arcade && hasArcadePass == true && hasRedOrb == true)
        {
            System.out.println("You enter the arcade." + "\n" +
                               "You make your way to the back where the only working game is." + "\n" +
                               "You play a few rounds and get bored." + "\n" +
                               "You then step out of the arcade." + "\n");
            arcadeLocked = false;
            inArcade = false;
        } 
        
        if(currentRoom == arcade && hasArcadePass == false)
        {
            System.out.println("There's a sign:" + "\n" +
                               "''" + "NO NOOBS ALLOWED" + "''." + "\n" +
                               "It looks like you can't proceed." + "\n");
        }        
    }    
    
    /** 
     * Enter the hedge maze.
     */
    private void enterMaze() 
    {
        if(currentRoom == hedgeMaze && mazeBlocked == false)
        {
            System.out.println("You enter the hedge maze and wander around." + "\n" +
                               "You eventually reach the end where you see" + "\n" +
                               "an orb on a pedestal." + "\n");
            endMaze = true;
        }
        if(currentRoom == hedgeMaze && mazeBlocked == true)
        {
            System.out.println("You can't go any farther because of the vines." + "\n");
        }
    }     
    
    /** 
     * Fill up the watering can.
     */
    private void fillWateringCan() 
    {
        if(inWater == true && hasWateringCan == true)
        {
            System.out.println("You dip the watering can into the pool and fill it up." + "\n");
            fullCan = true;
        }
        if(inWater == false)
        {
            System.out.println("Cant't do that here." + "\n");
        }
    }    
    
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?" + "\n");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if(nextRoom == null) 
        {
            System.out.println("Can't go that way!!" + "\n");
        }
        else 
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
               
        //create the glowing in the bumper car
        if(nextRoom == bumperCars && hasArcadePass == false)
        {
            System.out.println("You see a faint red glow coming from one of the cars." + "\n" +
                               "You walk over to the car and see an arcade pass on the seat." + "\n");
        }
        if(nextRoom == bumperCars && hasArcadePass == true)
        {
            System.out.println("You walk into the middle of the arena...then step out of it." + "\n");
        }
              
        if(nextRoom == gardenGates && gateLocked == true && hasWateringCan == false)
        {
            System.out.println("A watering can lies on the ground." + "\n"); 
        }                      
        
        if(nextRoom == train && hasHammer == false)
        {
            System.out.println("There's a small hammer lying on the ground." + "\n");
        }
        
        if(nextRoom == deathsDoor &&  hasHouseKey == false)
        {
            System.out.println("There's a small key on the ground." + "\n"); 
        }
        
        if(nextRoom == playground && hasYellowKey == false)
        {
            System.out.println("It looks like someone dropped a yellow key on the ground." + "\n");
        }
    }    
    
    /**
     * Print out some help information.
     * Here we print some intro text, which is a short message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You wake up outside a mysterious gate..." + "\n" +
                           "Alone and comletely lost, you approach the gate..." + "\n" +
                           "A sign above the gate reads: WELCOME TO AMAZEMENT PARK..." + "\n" +
                           "As you get closer, the gate slowly creaks open..." + "\n" +
                           "You pass through the gate and find yourself inside the park's entrance..." + "\n" +
                           "With nowhere else to go, you begin to wander..." + "\n" +
                           "Out of nowhere, you hear a voice say:" + "\n" +
                           "''" + "Have fun...I'll be watching..." + "''" + "\n" +
                           "\n" +
                           "Your command words are: ");
        parser.showCommands();
    }    
    
    /** 
     * Try to go in the Park Tower. Check to see if the player has the 
     * five orbs.
     */
    private void openParkTower() 
    {
        if(currentRoom == parkTower && orbCount == 5) 
        {
            System.out.println("You place the five orbs on the door and it slowly creaks open." + "\n" +
                               "You enter the tower and see a long spiral staircase." + "\n" +
                               "After climbing a seemingly endlees staircase, you reach the top floor." + "\n" +
                               "You look around the room and see a portal floating on the other side of the room." + "\n" +
                               "You walk through the protal and are blinded by an immense light." + "\n" +
                               "You wake up in your room...you feel something in your pocket." + "\n" +
                               "You reach into your pocket and find a ticket stub for Amazement Park." + "\n" +
                               "You then hear a voice:" + "\n" +
                               "''" + "Hope you had fun...come back soon..." + "''");                 
        }
        if(currentRoom == parkTower && orbCount < 5) 
        {
            System.out.println("You hear a voice:" +
                               "''" + "Only those with all five treasures may proceed." + "''" + "\n");
        }
    }  
    
    /**
     * Place the book in the bookshelf.
     */
    private boolean placeBook()
    {
        if(inLibrary == true && hasBook == true)
        {
            System.out.println("You place the book in the empty spot." + "\n" +
                               "Suddenly, a small skull key pops out of the book's spine" + "\n" +
                               "and falls onto the ground." + "\n");
            return bookPlaced = true;
        }
        
        if(inLibrary == true && hasSkullKey == true)
        {
            System.out.println("...there's nothing to do here." + "\n" +
                               "You leave the haunted house." + "\n");
            hasSkullKey = true;
            return inLibrary = false;
        }
        return bookPlaced = true;
    }            
    
    /** 
     * Change out of the bathing suit.
     */
    private void removeSuit() 
    {
        if(wearingBathingSuit == true)
        {
            System.out.println("You change out of the bathing suit suit and put on your regular clothes." + "\n");
        }
        if(wearingBathingSuit == false)
        {
            System.out.println("You're not wearing the bathing suit." + "\n");
        }
    }     
    
    /** 
     * Ride the carousel and get a coin.
     * Add a coin to the player's coin coint.
     */
    private void rideCarousel() 
    {
        if(currentRoom == carousel)
        {
            System.out.println("You rode the carousel." + "\n" +
                               "As soon as you get off, a coin materializes in front of you." + "\n" +
                               "You take the coin and put it in your pocket." + "\n");
            coinCount++;
        }
    }     
    
    /** 
     * Ride the ferris wheel.
     */
    private void rideF_Wheel() 
    {
        if(currentRoom == ferrisWheel && hasSilverOrb == false)
        {
            System.out.println("You step into the car and it starts moving as soon as you sit down." + "\n" +
                               "The car you're in slowly moves up towards the top and then stops." + "\n" +
                               "For awhile you get a nice view of the park. After a few minutes, you start miving again." + "\n" +
                               "Soon, you're on the ground and you step out of the car." + "\n" +
                               "A small silver orb then materializes in front of you." + "\n");
        }
        
        if(currentRoom == ferrisWheel && hasSilverOrb == true)
        {
            System.out.println("You step into the car and it starts moving as soon as you sit down." + "\n" +
                               "The car you're in slowly moves up towards the top and then stops." + "\n" +
                               "For awhile you get a nice view of the park. After a few minutes, you start miving again." + "\n" +
                               "Soon, you're on the ground and you step out of the car." + "\n");
        }        
    }    
    
    /** 
     *  Show the goat the salad.
     */
    private void showSalad() 
    {
        if(currentRoom == pettingZoo && hasSalad == true && goatMoved == false)
        {
            System.out.println("The goat starts sniffing around and turns to you." + "\n" +
                               "The goat smells the salad and charges at you." + "\n" +
                               "You drop the salad and the goat starts eating it." + "\n" +
                               "You walk over to where the goat was sitting and find a giant pair of scissors." + "\n");
            goatMoved =  true;
        }
        if(currentRoom == pettingZoo && goatMoved == true)
        {
            System.out.println("The goat turns to you and simply stares." + "\n");
            goatMoved = true;
        }
    }    
    
    /**
     * Pick up an item.
     */
    private void takeItem()
    {       
        if(currentRoom == gardenGates && hasWateringCan == false)
        {
            System.out.println("You picked up the watering can." + "\n");
            hasWateringCan = true;
        }            
       
        if(currentRoom == pettingZoo && goatMoved == true && hasScissors == false)
        {
            System.out.println("You picked up the giant scissors." + "\n");
            hasScissors = true;
        }       
             
        if(currentRoom == hedgeMaze && endMaze == true && hasGreenOrb == false)
        {
            System.out.println("You picked up the green orb." + "\n" +
                               "and go back to the maze's entrance." + "\n");
            hasGreenOrb = true;
            endMaze = false;
            orbCount = orbCount++;
        }          
        
        if(currentRoom == train && hasHammer == false)
        {
            System.out.println("You picked up the hammer." + "\n");
            hasHammer = true;
        }
        
        if(currentRoom == deathsDoor && hasHouseKey == false)
        {
            System.out.println("You picked up the house key." + "\n");
            hasHouseKey = true;
        }
        
        if(currentRoom == graveyard && mausoleumLocked == false && hasBlackOrb == false)
        {
            System.out.println("You picked up the black orb." + "\n");
            hasBlackOrb = true;
            orbCount = orbCount++;
        }             
        
        if(currentRoom == hauntedHouse && bookPlaced == true && hasSkullKey == false)
        {
            System.out.println("You picked up the skull key." + "\n");
            hasSkullKey = true;
        }                  
        
        if(currentRoom == houseOfMirrors && mirrorSmashed == true && hasRedPass == false)
        {
            System.out.println("You picked up the red pass." + "\n" +
                               "You then leave the house of mirrors." + "\n");
            hasRedPass = true;
            inMirrors = false;
            bridgeLocked = false;
            houseOfMirrors.setExit("east", bigBangBridge);
        }                 
        
        if(inArcade == true && gameBeaten == true && hasRedOrb == false)
        {
            System.out.println("You picked up the red orb." + "\n" +
                               "With nothing left to do, you step outside of the arcade." + "\n");
            hasRedOrb = true;
            orbCount = orbCount++;
            inArcade = false;
        }                 
        
        if(currentRoom == bumperCars && hasArcadePass == false)
        {
            System.out.println("You picked up the arcade pass." + "\n");
            hasArcadePass = true;
            arcadeLocked = false;
        }               
        
        if(currentRoom == playground && hasYellowKey == false)
        {
            System.out.println("You picked up the yellow key." + "\n");
            hasYellowKey = true;
        }                 
        
        if(currentRoom == rollerCoaster && coasterOff == false && hasLiftKey == false)
        {
            System.out.println("You picked up the lift key." + "\n");
            hasLiftKey = true;
        }                     
        
        if(currentRoom == controlCenter && hasBook == false)
        {
            System.out.println("You picked up the book." + "\n");
            hasBook = true;
        }                         
        
        if(currentRoom == ferrisWheel && hasSilverOrb == false)
        {
            System.out.println("You picked up the silver orb." + "\n");
            hasSilverOrb = true;
            orbCount = orbCount++;
        }                      
    }
    
    /** 
     * Use the watering can.
     */
    private void useWateringCan() 
    {
        if(currentRoom == gardenGates && fullCan == true)
        {
            System.out.println("You water the mysterious seed and it grows into a beautiful flower!" + "\n" +
                               "the gate then creaks open." + "\n" +
                               "There are exits in all directions." + "\n");
            gateLocked = false;
            gardenGates.setExit("north", deathsDoor);
            gardenGates.setExit("south", pettingZoo);
            gardenGates.setExit("west", train);            
        }
    }    
   
    /** 
     * Use the hammer.
     */
    private void useHammer() 
    {
        if(inMirrors == true && hasHammer == true)
        {
            System.out.println("You take the hammer and smash the giant mirror and shards of glass fly everywhere." + "\n" +
                               "You look down and see a red pass on the ground." + "\n");
            mirrorSmashed = true;
            inMirrors = false;
        }
    }      
    
    /** 
     * Use the giant scissors.
     */
    private void useScissors() 
    {
        if(currentRoom.equals(hedgeMaze) && hasScissors == true)
        {
            System.out.println("You start cutting the vines and after a few minutes they're all gone." + "\n" +
                               "You are now able to enter the hedge maze." + "\n");
            mazeBlocked = false;
        } 
    }    
    
    /** 
     * Change into the bathing suit.
     */
    private void wearSuit() 
    {
        if(hasBathingSuit == true)
        {
            System.out.println("You change out of your regular clothes and put on the bathing suit." + "\n"); 
            wearingBathingSuit = true;
        }
        
        if(hasBathingSuit == false)
        {
            System.out.println("You don't have a bathing suit." + "\n");
        }
        
        if(wearingBathingSuit == true)
        {
            System.out.println("You're wearing the bathing suit." + "\n");
        }
    }       
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?" + "\n");
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
}
