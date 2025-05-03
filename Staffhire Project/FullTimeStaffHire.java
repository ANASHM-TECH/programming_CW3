
/**
 * sub-class FullTimeStaffHire of super class Staffhire.
 *
 * @author Anas Hmaimou
 * @version 01/05/2025
 */
public class FullTimeStaffHire extends StaffHire
{
    // instance variable additions for this sub-class
    private double salary;
    private int weeklyFractionalHours;

    /**
     * Constructor for objects of class FullTimeStaffHire
     */
    public FullTimeStaffHire(int vacancyNumber, String designation ,String jobType, 
    String staffName, String joiningDate, String qualification, 
    String appointedBy, boolean joined, double salary, 
    int weeklyFractionalHours)
    {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, 
            appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double newSalary)
    {
        salary = newSalary;
    }

    public int getWeeklyFractionalHours()
    {
        return weeklyFractionalHours;
    }

    public void setWeeklyFractionalHours(int newHours)
    {
        weeklyFractionalHours = newHours;
    }

    public void display()
    {
        super.display();
        if (salary != 0)
        {
            System.out.println("Salary: " + salary);
            System.out.println("Weekly fractional hours: " + weeklyFractionalHours);
        }
    }
}

