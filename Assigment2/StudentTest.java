

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentTest.
 *
 * @author 184510
 * @version 07/12/2018
 */
public class StudentTest
{
    private Library library1;
    private Student student1;

    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        library1 = new Library(100);
        student1 = new Student("Harry", library1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testNotFinnishedStudies()
    {
        assertEquals(false, student1.finishedStudies());
    }

    @Test
    public void testFinishedStudies()
    {
        for(int x = 0; x < 30; x++)
        {
            student1.study();
        }
        assertEquals(true, student1.finishedStudies());
    }

    @Test
    public void testDescribeNoBookBorrowed()
    {
        student1.describe();
    }

    @Test
    public void testDescribeBookBorrowedUsingStudy()
    {
        student1.study();
        student1.describe();
    }

    @Test
    public void testDescribeBookFinnishedUsingStudy()
    {
        for(int x = 0; x < 5; x++)
        {
            student1.study();
        }
        student1.describe();
    }
}








