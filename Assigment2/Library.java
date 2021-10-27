
/**
 * Class Library represents a College library from which books can be borrowed
 *
 * @author 184510
 * @version 1.0, 07/12/2018
 */
public class Library
{
    private TextBook[] bookShelf;
    private int nextBook;
    private int borrowersNumber;

    /**
     * Constructs library with a book shelf array
     * 
     * @param maxNumTextBook number of books that can be stored 
     */
    public Library(int maxNumTextBook)
    {
        borrowersNumber = 0;
        
        bookShelf = new TextBook[maxNumTextBook]; 
        
        for (int x = 0; x < maxNumTextBook; x++)
        {
            bookShelf[x] = new TextBook("text book "+ (x+1), 4);
        }
    }
    
    /**
     * Issues a library card, keeping track of how many there are
     * 
     * @return new library card with an allowment of 5 books
     */
    public LibraryCard issueCard()
    {
        borrowersNumber = borrowersNumber + 1;
        return new LibraryCard(5, borrowersNumber - 1);
    }
    
    /**
     * Get a book off the book shelf if the card is not expired and there is any more to be borrowed.
     * Records the transaction on the library card if succesful
     * 
     * @param card that will track the borrowed book
     * 
     * @return a new book or null if conditions are not met
     */
    public TextBook borrowBook(LibraryCard card)
    {
        if((!card.expired()) && (nextBook < bookShelf.length))
        {
            TextBook book = bookShelf[nextBook];
            bookShelf[nextBook] = null;
            nextBook = nextBook + 1;
            card.swipe();
            return book;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Puts the book back on the book shelf
     * 
     * @param book to return on the shelf
     */
    public void returnBook(TextBook book)
    {
        bookShelf[nextBook - 1] = book;
        nextBook = nextBook - 1;
    }
    
    /**
     * Generates and prints the description of the Library
     */
    public void describe()
    {
        System.out.println("The library has " + (bookShelf.length - nextBook) + " books left on the shelf and has issued "  + borrowersNumber + " library cards");
    }
}
