
/**
 * Class LibraryCard represents a library card that Student will use to get TextBook.
 *
 * @author 184510
 * @version 1.0, 07/12/2018
 */
public class LibraryCard
{
    private int booksLimit;
    private int booksBorrowed;
    private String cardReference;
    
    /**
     * Constructs library card with unique id, given borrowing limit, and full allowance
     * 
     * @para limit of the books that can be borrowed
     * @para setReference unique number for cardID
     */
    public LibraryCard(int limit, int setReference)
    {
        booksLimit = limit;
        cardReference = "cardID " + setReference;
        booksBorrowed = 0;
    }
    
    /**
     * Increases the borrowed book count by one
     */
    public void swipe()
    {
        booksBorrowed = booksBorrowed + 1;
    }
    
    /**
     * @return true if library card is expired
     */
    public boolean expired()
    {
        return booksBorrowed >= booksLimit;
    }
    
    /**
     * @return the reference of the card
     */
    public String getCardRef()
    {
        return cardReference;
    }
    
    /**
     * Generates and prints the description of library card
     */
    public void describe()
    {
        System.out.println("Library card " + getCardRef() + " with " + (booksLimit - booksBorrowed) + " books left");
    }
}
