
/**
 * sub-class PartTimeStaffHire of super class Staffhire.
 *
 * @author (Anas Hmaimou)
 * @version (01/05/2025)
 */
public class PartTimeStaffHire extends StaffHire
{
    // instance variable additions for this sub-class
    private int workingHours;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    /**
     * Constructor for objects of class PartTimeStaffHire
     */
    public PartTimeStaffHire(int vacancyNumber, String designation ,String jobType, 
    String staffName, String joiningDate, String qualification, 
    String appointedBy, boolean joined, int workingHours, 
    double wagesPerHour, String shifts)

    {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, 
            appointedBy, joined);
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        terminated = false;
    }

    public int getWorkingHours()
    {
        return workingHours;
    }

    public void setWorkingHours(int newWorkingHours)
    {
        workingHours = newWorkingHours;
    }

    public double getWagesPerHour()
    {
        return wagesPerHour;
    }

    public void setWagesPerHour(double newWages)
    {
        wagesPerHour = newWages;
    }

    public String getShifts()
    {
        return shifts;
    }

    public void setShifts(String newShifts)
    {
        shifts = newShifts;
    }

    public boolean getTerminated()
    {
        return terminated;
    }

    public void setTerminated(boolean isTerminated)
    {
        terminated = isTerminated;
    }

    public void terminateStaff()
    {
        if (terminated == true)
        {
            System.out.println("Staff already terminated !");
        }
        else
        {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            setTerminated(true);
        }
    }

    public void display()
    {
        super.display();
        if (getWorkingHours() != 0)
        {
            System.out.println("Wages per hour: " + wagesPerHour);
            System.out.println("Working hours: " + workingHours);
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + (terminated ? "Yes" : "No"));
            System.out.println("Income per day: £" + (workingHours * wagesPerHour));            
        }
    }

}
