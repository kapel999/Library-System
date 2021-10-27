import java.util.Random;
import java.util.ArrayList;
/**
 * College class represents college that has library that students attend.
 *
 * @author 184510
 * @version 1.0, 07/12/2018
 */
public class College
{
    private ArrayList<Student> students;
    private Library library;
    private Random random;

    /**
     * Construstcs the college with a library and collection of students
     * 
     * @param numberOfStudents maximum number of students attending the college
     * @param textBookInTheLibrary maximum number of books in the library
     */
    public College(int numberOfStudents, int textBooksInTheLibrary)
    {
        library = new Library(textBooksInTheLibrary);
        students = new ArrayList<>(); 
        for (int x = 0; x < numberOfStudents; x++)
        {
            students.add(new Student("Student "+ (x+1), library));
        }
        random = new Random();
    }
    
    /**
     * Creates college that is parametrised by args or uses the default values
     * 
     * @param args array that can contain up to 3 numbers, representing students, books and times to run the simulation
     */
    public static void main(String[] args)
    {
        int students, books, times;
        if(args.length > 2)
        {
            times = Integer.parseInt(args[2]);
        }
        else
        {
            times = 100;
        }
        if(args.length > 1)
        {
            books = Integer.parseInt(args[1]);
        }
        else
        {
            books = 15;
        }
        if(args.length > 0)
        {
            students = Integer.parseInt(args[0]);
        }
        else
        {
            students = 10;
        }
        College college = new College(students, books);
        college.runCollege(times);
    }
    
    /**
     * Generates and prints the description of the college
     */
    public void describe()
    {
        System.out.println("The college currently has " + students.size() + " hard-working students");
        library.describe();
    }
    
    /**
     * Informs user that no students are left.
     * Otherwise pick random student, check if he finished studying, remove him or make him study
     */
    private void nextStep()
    {
        if (students.size() == 0)
        {
            System.out.println("Everything has gone quite");
        }
        else
        {
            int rand1 = random.nextInt(students.size());
            if (students.get(rand1).finishedStudies() == true)
            {
                students.remove(rand1);
                System.out.println("The student has graduated and left the college");
            }
            else 
            {
                students.get(rand1).study();
            }
        }
    }
    
    /**
     * runs simulation of college n times
     * 
     * @param nSteps how many times it should run
     */
    public void runCollege(int nSteps)
    {
        for( int stepNumber = 0; stepNumber < nSteps; stepNumber++)
        {
            System.out.println("Step " + stepNumber);
            describe();
            nextStep();
        }
    }
}
