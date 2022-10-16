package vitians;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.OptionInvalidException;
import profile.Address;
import profile.Date;
import profile.Name;
import profile.Person;
import profile.Profilable;

/**
 * This class represents an profile of an Employee of VIT.
 * @author sanjeev.rm
 */
public class Employee extends Person implements Profilable<Employee>
{
    private String employeeID;
    private String qualification;
    private String responsibility;
    private LocalDate dateOfJoining;
    
    public Employee(Name name, String gender, LocalDate dob, String email, String mobile, Address adress, String employeeID, String qualification, String responsiblity, LocalDate dateOfJoining)
    {
		super(name, gender, dob, email, mobile, adress);
		this.employeeID = employeeID;
		this.qualification = qualification;
		this.responsibility = responsiblity;
		this.dateOfJoining = dateOfJoining;
	}
    
    public String getEmployeeID() {
        return employeeID;
    }
    
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    
    public String getQualification() {
        return qualification;
    }
    
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    public String getResponsiblity() {
        return responsibility;
    }
    
    public void setResponsiblity(String responsiblity) {
        this.responsibility = responsiblity;
    }
    
    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }
    
    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    
    @Override
    public String toString()
    {
    	return super.toString() + "%-30s : %s\n".formatted("7. EMPLOYEE ID", this.employeeID)
								+ "%-30s : %s\n".formatted("8. QUALIFICATION", this.qualification)
								+ "%-30s : %s\n".formatted("9. RESPONSIBILITY", this.responsibility)
								+ "%-30s : %s\n".formatted("10. DATE OF JOINING", this.dateOfJoining.toString());
    }
    
    
    
    /**
	 * This method inputs values for the properties of a Employee.
	 * This method creates an object of Employee class with the info inputed and returns it.
	 * This is an static method. So I can call this method by just the name of the class. No need to create an object.
	 * @return Employee
	 */
    public static Employee inputUserInfo()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	Person person = Person.inputUserInfo();
    	
    	System.out.printf("%-30s : ", "EMPLOYEE ID");
    	String employeeID = sc.next();
    	sc.nextLine();
    	
    	System.out.printf("%-30s : ", "QUALIFICATION");
    	String qualification = sc.nextLine();
    	
    	System.out.printf("%-30s : ", "RESPONSIBILITY");
    	String responsibility = sc.nextLine();
    	
    	System.out.println("DATE OF JOINING");
    	LocalDate dateOfJoining = Date.inputDate();
    	
    	return new Employee(person.getName(), person.getGender(), person.getDob(), person.getEmail(), person.getMobile(), person.getAddress(), employeeID, qualification, responsibility, dateOfJoining);
    }
    
    
    
    /**
	 * This method checks if there is actually an profile in the array list with the id entered by the user.
	 * Returns profile object if profile is present, null if not.
	 * @param objArrayList --> This is the Array List in which we will search for the profile with id user entered.
	 * @param id --> This is the id which we will be searching in the array list.
	 * @return Employee
	 */
	public static Employee getProfileIfInArrayList(ArrayList<Employee> objArrayList, String id)
	{
		for(int index = 0; index < objArrayList.size(); index++)
		{
			if(id.equalsIgnoreCase(objArrayList.get(index).getEmployeeID()))
			{
				return objArrayList.get(index);
			}
		}
		return null;
	}
	
	
	
	@Override
	public Integer showProfileAndAskOptionToEdit()
	{
		this.displayProfile();
		
		Scanner sc = new Scanner(System.in);
		
		Integer option;
		while(true)
		{
			try
			{
				System.out.print("Enter the option to edit : ");
				option = sc.nextInt();
				// Throws an exception if the option entered is not valid. So that the loop runs until the user enters an valid input.
				if(option < 1 || option > 10)
				{
					throw new OptionInvalidException();
				}
				return option;
			}
			catch(InputMismatchException ime)
			{
				System.out.println("<Please enter an integer>");
			}
			catch(OptionInvalidException oie)
			{
				System.out.println("<Please enter an number between 1 and 10>");
			}
			finally
			{
				sc.nextLine();
			}
		}
	}
	
	
	
	@Override
	public void editProfile(Integer option)
	{
		Scanner sc = new Scanner(System.in);
		
		switch(option)
		{
		case 1 :
			System.out.println("Enter updated name : ");
			Name newName = Name.inputUserInfo();
			this.setName(newName);
			break;

		case 2 :
			System.out.print("Enter new Gender : ");
			this.setGender(sc.next());
			break;

		case 3 :
			System.out.print("Enter new DOB");
			LocalDate dob = Date.inputDate();
			this.setDob(dob);
			break;

		case 4 :
			System.out.print("Enter updated Email : ");
			this.setEmail(sc.next());
			break;

		case 5 :
			System.out.print("Enter updated mobile number : ");
			this.setMobile(sc.next());
			break;

		case 6 :
			System.out.println("Enter updated Address");
			Address address = Address.inputUserInfo();
			this.setAddress(address);
			break;

		case 7 :
			System.out.print("Enter updated Employee ID : ");
			this.setEmployeeID(sc.next());
			break;

		case 8 :
			System.out.print("Enter updated qualification : ");
			this.setQualification(sc.next());
			break;

		case 9 :
			System.out.print("Enter updated responsibility : ");
			this.setResponsiblity(sc.next());
			break;

		case 10 :
			System.out.print("Enter updated date of joining");
	    	LocalDate dateOfJoining = Date.inputDate();
	    	this.setDateOfJoining(dateOfJoining);
			break;

		default :
			System.out.print("WHAAAT???");
		}
	}

	@Override
	public void displayProfile()
	{
		System.out.println("\n-------------------------------------------------------------------------------------\n" + this + "-------------------------------------------------------------------------------------\n");
	}
}