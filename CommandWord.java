/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Jordan Bailey
 * @version 2015.March
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    ACTIVATE("activate"), BUY("buy"), CHECK("check"), DIVE("dive"), 
    EAT("eat"), ENTER("enter"), FILL("fill"), GO("go"), HELP("help"), 
    OPEN("open"), PLACE("place"),  REMOVE("remove"), RIDE("ride"), 
    TAKE("take"), SHOW("show"), UNKNOWN("?"), USE("use"),WEAR("wear"), 
    QUIT("quit");
      
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
