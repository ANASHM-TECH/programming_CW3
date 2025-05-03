import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RecruitmentSystem
{
    private JFrame frame;

    private JLabel vacancyLabel;
    private JLabel jobTypeLabel;
    private JLabel staffNameLabel;
    private JLabel qualificationLabel;
    private JLabel weeklyHoursLabel;
    private JLabel wagesPerHourLabel;
    private JLabel displayNumberLabel;
    private JLabel designationLabel;
    private JLabel joiningDateLabel;
    private JLabel appointedByLabel;
    private JLabel salaryLabel;
    private JLabel workingHoursLabel;
    private JLabel shiftsLabel;

    private JTextField vacancyInput;
    private JTextField jobTypeInput;
    private JTextField staffNameInput;
    private JTextField qualificationInput;
    private JTextField weeklyHoursInput;
    private JTextField wagesPerHourInput;
    private JTextField displayNumberInput;
    private JTextField designationInput;
    private JTextField joiningDateInput;
    private JTextField appointedByInput;
    private JTextField salaryInput;
    private JTextField workingHoursInput;
    private JTextField shiftsInput;

    private JButton addFullTimeButton;
    private JButton addPartTimeButton;
    private JButton setSalaryButton; // Full-Time 
    private JButton setShiftsButton; // Part-time 
    private JButton terminatePartTimeButton;
    private JButton displayNumberButton;
    private JButton clearButton;
    private JButton joinedButton;

    private JCheckBox joinedCheckBox;
    private int frameWidth;
    private int frameHeight;

    private ArrayList<StaffHire> staffList;

    public static void main(String[] args)
    {
        RecruitmentSystem system = new RecruitmentSystem(800, 500);
        system.setUpGUI();
        system.setUpButtonListeners();
    }

    public RecruitmentSystem(int w, int h)
    {
        frame = new JFrame("Recruitment System");

        vacancyLabel = new JLabel("Vacancy Number:");
        jobTypeLabel = new JLabel("Job Type:");
        staffNameLabel = new JLabel("Staff Name:");
        qualificationLabel = new JLabel("Qualification:");
        weeklyHoursLabel = new JLabel("Weekly Hours:");
        wagesPerHourLabel = new JLabel("Wages Per Hour:");
        displayNumberLabel = new JLabel("Display:");
        designationLabel = new JLabel("Designation:");
        joiningDateLabel = new JLabel("Joining Date:");
        appointedByLabel = new JLabel("Appointed By:");
        salaryLabel = new JLabel("Salary:");
        workingHoursLabel = new JLabel("Working Hours:");
        shiftsLabel = new JLabel("Shifts:");

        vacancyInput = new JTextField();
        jobTypeInput = new JTextField();
        staffNameInput = new JTextField();
        qualificationInput = new JTextField();
        weeklyHoursInput = new JTextField();
        wagesPerHourInput = new JTextField();
        displayNumberInput = new JTextField();
        designationInput = new JTextField();
        joiningDateInput = new JTextField();
        appointedByInput = new JTextField();
        salaryInput = new JTextField();
        workingHoursInput = new JTextField();
        shiftsInput = new JTextField();

        addFullTimeButton = new JButton("Add Full Time Staff");
        addPartTimeButton = new JButton("Add Part Time Staff");
        setSalaryButton = new JButton("Set Salary"); // Full-Time 
        setShiftsButton = new JButton("Set Shifts"); // Part-Time
        terminatePartTimeButton = new JButton("Terminate");
        displayNumberButton = new JButton("Display");
        clearButton = new JButton("Clear");
        joinedButton = new JButton("Set Joined");

        joinedCheckBox = new JCheckBox();
        joinedCheckBox.setText("Joined:");
        joinedCheckBox.setFocusable(false);
        frameWidth = w;
        frameHeight = h;

        staffList = new ArrayList<StaffHire>();
    }

    public void setUpGUI()
    {
        Container cp = frame.getContentPane();
        GridLayout grid = new GridLayout(9, 5);
        cp.setLayout(grid);

        frame.setSize(frameWidth, frameHeight);
        frame.setTitle("Recruitment System GUI");

        cp.add(vacancyLabel);
        cp.add(vacancyInput);
        cp.add(designationLabel);
        cp.add(designationInput);
        cp.add(new JLabel(""));
        cp.add(jobTypeLabel);
        cp.add(jobTypeInput);
        cp.add(joiningDateLabel);
        cp.add(joiningDateInput);
        cp.add(new JLabel(""));
        cp.add(staffNameLabel);
        cp.add(staffNameInput);
        cp.add(appointedByLabel);
        cp.add(appointedByInput);
        cp.add(new JLabel(""));
        cp.add(qualificationLabel);
        cp.add(qualificationInput);
        cp.add(salaryLabel);
        cp.add(salaryInput);
        cp.add(setSalaryButton);
        cp.add(weeklyHoursLabel);
        cp.add(weeklyHoursInput);
        cp.add(workingHoursLabel);
        cp.add(workingHoursInput);
        cp.add(new JLabel(""));
        cp.add(wagesPerHourLabel);
        cp.add(wagesPerHourInput);
        cp.add(shiftsLabel);
        cp.add(shiftsInput);
        cp.add(setShiftsButton);
        cp.add(joinedCheckBox);
        cp.add(joinedButton);
        cp.add(new JLabel(""));
        cp.add(new JLabel(""));
        cp.add(new JLabel(""));
        cp.add(new JLabel(""));
        cp.add(addFullTimeButton);
        cp.add(addPartTimeButton);
        cp.add(new JLabel(""));
        cp.add(clearButton);
        cp.add(displayNumberButton);
        cp.add(displayNumberInput);
        cp.add(new JLabel(""));
        cp.add(new JLabel(""));
        cp.add(terminatePartTimeButton);

        // cp.add(TextArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void clearInputFields() 
    {
        vacancyInput.setText("");
        designationInput.setText("");
        jobTypeInput.setText("");
        staffNameInput.setText("");
        joiningDateInput.setText("");
        qualificationInput.setText("");
        appointedByInput.setText("");
        salaryInput.setText("");
        weeklyHoursInput.setText("");
        wagesPerHourInput.setText("");
        workingHoursInput.setText("");
        shiftsInput.setText("");
        displayNumberInput.setText("");
        joinedCheckBox.setSelected(false);
    }

    public int getIndex() 
    {

        int displayNumber = -1; // Initialize to -1

        try {
            // retrieve the input
            String input = displayNumberInput.getText().trim();

            // verify the input is not empty
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return displayNumber; // Return -1 if the input is empty
            }

            // Convert Input into an Integer
            displayNumber = Integer.parseInt(input);

            // verify the entered number is valid
            if (displayNumber < 0 || displayNumber >= staffList.size()) {
                JOptionPane.showMessageDialog(frame, "Invalid display number. Please enter a valid number between 0 and " + (staffList.size() - 1), "Invalid Range", JOptionPane.ERROR_MESSAGE);
                return -1; // Return -1 if out of range
            }
        } 
        catch (NumberFormatException e) 
        {
            // If input is not the valid integer: error
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Return -1 if the input is not a valid number
        }

        // Return valid index if everything is good
        return displayNumber;
    }

    public void displayStaffAtIndex() 
    {

        int index = getIndex(); // get Index

        if (index == -1) 
        {
            // Index is invalid
            return;
        }

        
        StaffHire staff = staffList.get(index);

        // Call display method
        staff.display();
    }

    public void setUpButtonListeners() 
    {
        // Add Full Time Staff button
        ActionListener buttonListener = new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    try {

                        // examine if any of the necessary fields are empty
                        if (vacancyInput.getText().trim().isEmpty() ||
                        designationInput.getText().trim().isEmpty() ||
                        jobTypeInput.getText().trim().isEmpty() ||
                        staffNameInput.getText().trim().isEmpty() ||
                        joiningDateInput.getText().trim().isEmpty() ||
                        qualificationInput.getText().trim().isEmpty() ||
                        appointedByInput.getText().trim().isEmpty() ||
                        salaryInput.getText().trim().isEmpty() ||
                        weeklyHoursInput.getText().trim().isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame, "Please fill in all required fields:\n- Vacancy Number\n- Designation\n- Job Type\n- Staff Name\n- Joining Date\n- Qualification\n- Appointed By\n- Salary\n- Weekly Hours",
                                "Missing Full Time Staff Information", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // retrieve input from input fields
                        int vacancyNumber = Integer.parseInt(vacancyInput.getText());
                        String designation = designationInput.getText();
                        String jobType = jobTypeInput.getText();
                        String staffName = staffNameInput.getText();
                        String joiningDate = joiningDateInput.getText();
                        String qualification = qualificationInput.getText();
                        String appointedBy = appointedByInput.getText();
                        boolean joined = joinedCheckBox.isSelected();
                        double salary = Double.parseDouble(salaryInput.getText());
                        int weeklyFractionalHours = Integer.parseInt(weeklyHoursInput.getText());

                        // Create FullTimeStaffHire obj
                        FullTimeStaffHire fullTimeStaff = new FullTimeStaffHire(
                                vacancyNumber, designation, jobType, staffName, joiningDate,
                                qualification, appointedBy, joined, salary, weeklyFractionalHours
                            );

                        // Add Staff to list
                        staffList.add(fullTimeStaff);

                        // Display Confirmation message
                        JOptionPane.showMessageDialog(frame, "Full Time Staff added successfully!");


                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "Please enter valid numbers for Vacancy Number, Salary, and Weekly Hours.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                }
            };

        // Add Part Time Staff button
        ActionListener buttonListenerTwo = new ActionListener() 
        {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    try 
                    {
                        // verify if any required fields are empty
                        if (vacancyInput.getText().trim().isEmpty() ||
                        designationInput.getText().trim().isEmpty() ||
                        jobTypeInput.getText().trim().isEmpty() ||
                        staffNameInput.getText().trim().isEmpty() ||
                        joiningDateInput.getText().trim().isEmpty() ||
                        qualificationInput.getText().trim().isEmpty() ||
                        appointedByInput.getText().trim().isEmpty() ||
                        workingHoursInput.getText().trim().isEmpty() ||
                        wagesPerHourInput.getText().trim().isEmpty() ||
                        shiftsInput.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please fill in all required fields:\n- Vacancy Number\n- Designation\n- Job Type\n- Staff Name\n- Joining Date\n- Qualification\n- Appointed By\n- Working Hours\n- Wages Per Hour\n- Shifts",
                                "Missing Part Time Staff Information", JOptionPane.WARNING_MESSAGE);
                            return; // Stop anymore further processing
                        }

                        // Parse the input values
                        int vacancyNumber = Integer.parseInt(vacancyInput.getText().trim());
                        String designation = designationInput.getText().trim();
                        String jobType = jobTypeInput.getText().trim();
                        String staffName = staffNameInput.getText().trim();
                        String joiningDate = joiningDateInput.getText().trim();
                        String qualification = qualificationInput.getText().trim();
                        String appointedBy = appointedByInput.getText().trim();
                        boolean joined = joinedCheckBox.isSelected();
                        int workingHours = Integer.parseInt(workingHoursInput.getText().trim());
                        double wagesPerHour = Double.parseDouble(wagesPerHourInput.getText().trim());
                        String shifts = shiftsInput.getText().trim();

                        // Create a new PartTimeStaffHire object
                        PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(
                                vacancyNumber, designation, jobType, staffName, joiningDate,
                                qualification, appointedBy, joined, workingHours, wagesPerHour, shifts);

                        // Add the Part-Time Staff object to the staff list
                        staffList.add(partTimeStaff);

                        // message of confirmation is displayed
                        JOptionPane.showMessageDialog(frame, "Part Time Staff added successfully!");


                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "Please enter valid numbers for Vacancy Number, Working Hours, and Wages Per Hour.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                }
            };

        // Set Salary Button
        ActionListener buttonListenerThree = new ActionListener() 
        {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    try {
                        // verify if vacancy number and staff name are entered
                        if (vacancyInput.getText().trim().isEmpty() || salaryInput.getText().trim().isEmpty() || staffNameInput.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter Vacancy Number, Staff Name and New Salary.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return; // Stop processing
                        }
                        // retrieve the input values
                        int vacancyNumber = Integer.parseInt(vacancyInput.getText().trim());
                        String staffName = staffNameInput.getText().trim();

                        // Find the FullTimeStaffHire object in the list based on the name and vacancy
                        boolean found = false;
                        for (StaffHire staff : staffList) {
                            if (staff instanceof FullTimeStaffHire) {
                                FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                                // examine if the staff name and vacancy number match
                                if (fullTimeStaff.getVacancyNumber() == vacancyNumber && fullTimeStaff.getStaffName().equalsIgnoreCase(staffName))
                                {
                                    if (!fullTimeStaff.getJoined())
                                    {
                                        JOptionPane.showMessageDialog(frame, "No modification possible: Staff has not joined !", "Staff not joined", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                    // Get salary from the salary input
                                    double newSalary = Double.parseDouble(salaryInput.getText().trim());
                                    // Set the new salary for the full-time staff member
                                    fullTimeStaff.setSalary(newSalary);
                                    JOptionPane.showMessageDialog(frame, "Salary updated successfully!");
                                    found = true;
                                    break;
                                }
                            }
                        }

                        // If no full-time staff match is found
                        if (!found) 
                        {
                            JOptionPane.showMessageDialog(frame, "No matching full-time staff found with the given vacancy number and staff name.", "Staff Not Found", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "Please enter valid numbers for Vacancy Number and Salary.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                }
            };

        // Clear button
        ActionListener buttonListenerFour = new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    clearInputFields();
                }
            };

        // Set Shifts Button
        ActionListener buttonListenerFive = new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    try
                    {
                        // examine if staffname and vacancy number are entered
                        if (vacancyInput.getText().trim().isEmpty() || 
                        staffNameInput.getText().trim().isEmpty() ||
                        shiftsInput.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter Vacancy Number, Staff Name, and new shifts.", "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return; // Stop processing
                        }

                        // retrieve the input values
                        int vacancyNumber = Integer.parseInt(vacancyInput.getText().trim());
                        String staffName = staffNameInput.getText().trim();

                        // search the PartTimeStaffHire object in list based on vacancy and name
                        boolean found = false;
                        for (StaffHire staff : staffList) {
                            if (staff instanceof PartTimeStaffHire) {
                                PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                                // examine if the staff name and vacancy number match
                                if (partTimeStaff.getVacancyNumber() == vacancyNumber && partTimeStaff.getStaffName().equalsIgnoreCase(staffName))
                                {
                                    if (!partTimeStaff.getJoined())
                                    {
                                        JOptionPane.showMessageDialog(frame, "No modification possible: Staff has not joined !", "Staff not joined", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                    // retrieve salary from salary input
                                    String newShifts = shiftsInput.getText().trim();
                                    // Set  new salary for full-time staff member
                                    partTimeStaff.setShifts(newShifts);
                                    JOptionPane.showMessageDialog(frame, "Shifts updated successfully!");
                                    clearInputFields();
                                    found = true;
                                    break;
                                }
                            }
                        }
                        // If no part-time staff match found
                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "No matching part-time staff found with the given vacancy number and staff name.", "Staff Not Found", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid number for Vacancy Number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                }
            };

        // Terminate Button
        ActionListener buttonListenerSix = new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    try
                    {
                        // examine if staff name and vacancy number are entered
                        if (vacancyInput.getText().trim().isEmpty()) 
                        {
                            JOptionPane.showMessageDialog(frame, "Please enter Vacancy Number", "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return; // Stop processing
                        }

                        // retrieve the input values
                        int vacancyNumber = Integer.parseInt(vacancyInput.getText().trim());

                        // Find the PartTimeStaffHire object in the list based on vacancy and name
                        boolean found = false;
                        for (StaffHire staff : staffList) {
                            if (staff instanceof PartTimeStaffHire) {
                                PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                                // examine if the staff name and vacancy number match
                                if (partTimeStaff.getVacancyNumber() == vacancyNumber)
                                {
                                    if (partTimeStaff.getTerminated())
                                    {
                                        JOptionPane.showMessageDialog(frame,"Staff already terminated !", "Termination Error", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    }
                                    partTimeStaff.setStaffName("");
                                    partTimeStaff.setJoiningDate("");
                                    partTimeStaff.setQualification("");
                                    partTimeStaff.setAppointedBy("");
                                    partTimeStaff.setJoined(false);
                                    partTimeStaff.setTerminated(true);
                                    found = true;
                                    JOptionPane.showMessageDialog(frame, "Staff successfully terminated !");
                                    break;
                                }
                            }
                        }
                        // If no part-time staff match found
                        if (!found) {
                            JOptionPane.showMessageDialog(frame, "No matching part-time staff found with the given vacancy number", "Staff Not Found", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter valid number for Vacancy Number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                }
            };

        // displayNumber Button
        ActionListener buttonListenerSeven = new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    displayStaffAtIndex();
                }
            };

        // Set joined
        ActionListener buttonListenerEight = new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    try
                    {
                        // examine if staff name and vacancy number are entered
                        if (vacancyInput.getText().trim().isEmpty() || staffNameInput.getText().trim().isEmpty()) 
                        {
                            JOptionPane.showMessageDialog(frame, "Please enter Vacancy Number and Staff Name", "Missing Information", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // retrieve the input values
                        boolean hasJoined = joinedCheckBox.isSelected();
                        String staffName = staffNameInput.getText().trim();
                        int vacancyNumber = Integer.parseInt(vacancyInput.getText().trim());

                        boolean found = false;
                        for (StaffHire staff : staffList) 
                        {
                            if (staff.getVacancyNumber() == vacancyNumber && staff.getStaffName().equalsIgnoreCase(staffName)) 
                            {
                                if (staff.getJoined() == hasJoined) 
                                {
                                    JOptionPane.showMessageDialog(frame, ("Staff Joined Status has already been updated to: " + hasJoined + " !"), "Joined Status Error" ,JOptionPane.WARNING_MESSAGE);
                                    return;
                                }

                                staff.setJoined(hasJoined);
                                JOptionPane.showMessageDialog(frame, "Staff Joined Status successfully updated to: " + hasJoined + " !");
                                clearInputFields();
                                found = true;
                                break;
                            }
                        }

                        if (!found) 
                        {
                            JOptionPane.showMessageDialog(frame, "No matching staff found with the given name and vacancy number", "Staff Not Found", JOptionPane.ERROR_MESSAGE);
                        }
                    } 
                    catch (NumberFormatException ex) 
                    {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number for Vacancy Number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                }
            };
        // Add listener to the addFullTime button
        addFullTimeButton.addActionListener(buttonListener);
        addPartTimeButton.addActionListener(buttonListenerTwo);
        setSalaryButton.addActionListener(buttonListenerThree);
        clearButton.addActionListener(buttonListenerFour);
        setShiftsButton.addActionListener(buttonListenerFive);
        terminatePartTimeButton.addActionListener(buttonListenerSix);
        displayNumberButton.addActionListener(buttonListenerSeven);
        joinedButton.addActionListener(buttonListenerEight);
    }
}
