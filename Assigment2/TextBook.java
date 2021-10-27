
/**
 * Class TextBook represents a book to be read by a Student.
 *
 * @author 184510
 * @version 1.0, 07/12/2018
 */
public class TextBook
{
    private String textBookTitle;
    private int chapterNumber;
    private int chaptersRead;
    
    /**
     * Constructs a book with given title and length, that hasn't been read.
     * 
     * @param title for the book
     * @param length of the book in chapters
     */
    public TextBook(String title, int length)
    {
        textBookTitle = title;
        chapterNumber = length;
        chaptersRead = 0;
    }
    
    /**
     * @return the book title
     */
    public String getTitle()
    {
        return textBookTitle;
    }
    
    /**
     * Attempts to read the book's chapter, if any left
     */
    public void readNextChapter()
    {
        if (!isFinished())
        {
            chaptersRead = chaptersRead + 1;
        }
        
        else
        {
            System.out.println("Book has been read!");
        }
    }
    
    /**
     * Checks if the book has been read fully
     * 
     * @return true if book finished
     */
    public boolean isFinished()
    {
        return chaptersRead == chapterNumber;
    }
    
    /**
     * Reset book to initial state
     */
    public void closeBook()
    {
        chaptersRead = 0;
    }
    
    /**
     * Generates and prints description for the book
     */
    public void describe()
    {
        System.out.println(textBookTitle + " with " + (chapterNumber-chaptersRead) + " chapters left to read");
    }
}
