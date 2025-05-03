
/**
 * StaffHire Super-class to create and modify hired staff members.
 *
 * @author Anas Hmaimou
 * @version 01/05/2025
 */
public class StaffHire
{
    // StaffHire class- instance variables
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    /**
     * Constructor for objects of class StaffHire
     */
    public StaffHire(int vacancyNumber, String designation ,String jobType, String staffName,
    String joiningDate, String qualification,  String appointedBy, 
    boolean joined)
    {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }
    //GETTER AND SETTER METHODS FOR STAFFHIRE CLASS
    public int getVacancyNumber()
    {
        return vacancyNumber;
    }

    public void setVacancyNumber(int newNumber)
    {
        vacancyNumber = newNumber;
    }

    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String newDesignation)
    {
        designation = newDesignation;
    }

    public String getJobType()
    {
        return jobType;
    }

    public void setJobType(String newJobType)
    {
        jobType = newJobType;
    }

    public String getStaffName()
    {
        return staffName;
    }

    public void setStaffName(String newStaffName)
    {
        staffName = newStaffName;
    }

    public String getJoiningDate()
    {
        return joiningDate;
    }

    public void setJoiningDate(String newJoiningDate)
    {
        joiningDate = newJoiningDate;
    }

    public String getQualification()
    {
        return qualification;
    }

    public void setQualification(String newQualification)
    {
        qualification = newQualification;
    }

    public String getAppointedBy()
    {
        return appointedBy;
    }

    public void setAppointedBy(String newAppointedBy)
    {
        appointedBy = newAppointedBy;
    }

    public boolean getJoined()
    {
        return joined;
    }

    public void setJoined(boolean newJoined)
    {
        joined = newJoined;
    }

    public void display()
    {
        System.out.println();
        System.out.println();
        System.out.println("Vacancy number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job type: " + jobType);
        System.out.println("Staff name: " + staffName);
        System.out.println("Joining date: " + joiningDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed by: " + appointedBy);
        System.out.println("Has joined: " + (joined ? "Yes" : "No"));
    }
}
