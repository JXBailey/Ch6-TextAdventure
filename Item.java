import java.util.Set;
import java.util.HashMap;

/**
 * Class Item - an item in an adventure game.
 *
 * This class is part of the "Amazement Park" application. 
 * "Amazement Park" is a very simple, text based adventure game.  
 *
 * An "Item" represents a usable object within the game. Each item is 
 * able to be taken and used for a specific purpose.  
 * 
 * @author  Jordan Bailey
 * @version 2015.March
 */
public class Item
{
    // instance variables - replace the example below with your own
    private HashMap<String, Item> itemList;
    private String itemName;
    private String itemDescription;

    /**
     * Creates an item object.
     * @param itemName        the name of an item
     * @param itemDescription the description of an item
     */
    public Item(String itemName, String itemDescription)
    {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        itemList = new HashMap<String, Item>();
    }

    /**
     * Add items to the game.
     */
    public void addItems()
    {
        itemList.put("note", new Item("note", "a note you found on the ground."));
        itemList.put("coin", new Item("coin", "a token that can be used to buy things."));
        itemList.put("bathing suit", new Item("bathing suit", "a bathing suit for you to wear."));
        itemList.put("blue ticket", new Item("blue ticket", "a ticket used to ride the Lazy River."));
        itemList.put("blue orb", new Item("blue orb", "an orb filled with water."));
        itemList.put("watering can", new Item("watering can", "a small watering can."));
        itemList.put("hammer", new Item("hammer", "a small hammer with " + 
                                        " " + "RORRIM" + " " + 
                                        "written on it."));     
        itemList.put("red pass", new Item("red pass", "a pass that grants access to BigBang Bridge."));
        itemList.put("salad", new Item("salad", "a salad...with no dressing."));
        itemList.put("giant scissors", new Item("giant scissors", "...giant scissors."));
        itemList.put("green orb", new Item("green orb", "an orb that smells like spring."));
        itemList.put("arcade pass", new Item("arcade pass", "a pass for the arcade."));
        itemList.put("red orb", new Item("red orb", "a red orb that's warm to the touch."));
        itemList.put("yellow key", new Item("yellow key", "a key to unlock the gate to the rollercaster."));
        itemList.put("lift key", new Item("lift key", "a key that activates the charilift."));
        itemList.put("silver orb", new Item("silver orb", "a silver orb that sparkles and shines."));    
        itemList.put("book", new Item("book", "a book titled: " +
                                      " " + "Life In a Haunted House" + " ")); 
        itemList.put("house key", new Item("house key", "a key with an " +
                                           " " + "H" + " " +
                                           "on it."));
        itemList.put("skull key", new Item("skull key", "a key with a skull on it."));
        itemList.put("black orb", new Item("black orb", "a black orb filled with a murky darkness."));             
    }
    
    /**
     * Return the item's name.
     */
    public String getItemName()
    {
        return itemName;
    }
    
    /**
     * Return the item's description.
     */
    public String getItemdescription()
    {
        return itemDescription;
    }

}
