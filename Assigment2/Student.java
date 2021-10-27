
/**
 * Student class represents student that is part of college and borrows books from the college library.
 *
 * @author 184510
 * @version 07/12/2018
 */
public class Student
{
    private String studentName;
    private Library collegeLibrary;
    private LibraryCard studentLibraryCard;
    private TextBook borrowedTextBook;

    /**
     * Constructs student by giving him name, issueing him library card and full allowance
     * 
     * @param name of the student
     * @param library in the college
     */
    public Student(String name, Library library)
    {
        studentName = name;
        collegeLibrary = library;
        studentLibraryCard = collegeLibrary.issueCard();
        borrowedTextBook = null;
    }

    /**
     * Checks if the student finished studies
     * 
     * @return positive if conditions have been met which means that student finnished studies
     */
    public boolean finishedStudies()
    {
        return ((borrowedTextBook == null) && (studentLibraryCard.expired() == true));
    }
    
    /**
     * Borrow book if none is held by student, 
     * otherwise read next chapter if book not finished 
     * or return book to library.
     */
    public void study()
    {
        if ((borrowedTextBook == null) && (finishedStudies() == false))
        {
            borrowedTextBook=collegeLibrary.borrowBook(studentLibraryCard);
        }
        else
        {
            if (borrowedTextBook.isFinished() == false)
            {
                borrowedTextBook.readNextChapter();
            }
            else
            {
                borrowedTextBook.closeBook();
                collegeLibrary.returnBook(borrowedTextBook);
                borrowedTextBook = null;
            }
        }
    }
    
    /**
     * Describes the student, his library card and his book depending on which ones he has
     */
    public void describe()
    {
        if (borrowedTextBook == null)
        {        
            System.out.println("Student " + studentName + " does not have a book and ");
            studentLibraryCard.describe();
            System.out.println("to borrow");
        }
        else if(borrowedTextBook.isFinished() == false)
        {
            System.out.println("Student " + studentName + " has a book ");
            borrowedTextBook.describe();
            System.out.println("The student is reading the book.");
        }
        else
        {
            System.out.println("Student " + studentName + " has a book ");
            borrowedTextBook.describe();
            System.out.println("The book is finished.");
        }
    }
}
