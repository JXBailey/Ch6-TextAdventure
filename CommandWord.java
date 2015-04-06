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
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), LOOK("look"), EAT("eat"), 
    TAKE("take"), READ("read"), RIDE("ride"), BUY("buy"), WEAR("wear"), DIVE("dive"), 
    USE("use"), FILL("fill"), PLACE("place");
    
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
