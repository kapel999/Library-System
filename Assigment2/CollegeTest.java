

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CollegeTest.
 *
 * @author 184510
 * @version 07/12/2018
 */
public class CollegeTest
{
    private College college1;

    /**
     * Default constructor for test class CollegeTest
     */
    public CollegeTest()
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
        college1 = new College(5, 10);
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
    public void testRunCollege1Step()
    {
        college1.runCollege(1);
    }

    @Test
    public void testRunCollege10steps()
    {
        college1.runCollege(10);
    }

    @Test
    public void testRunCollegeSomeStudentsFinished()
    {
        college1.runCollege(130);
    }

    @Test
    public void testRunCollegeAllStudentsFinished()
    {
        college1.runCollege(156);
    }
}




