package vitians;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.OptionInvalidException;
import profile.Address;
import profile.CustomLocalDate;
import profile.Name;
import profile.Person;
import profile.Profilable;

/**
 * This class represents an profile of an Student of VIT.
 * @author sanjeev.rm
 *
 * @since 1.0
 */
public class Student extends Person implements Profilable<Student>
{
	private String registrationNumber;
    private String program;
    private String branch;
    private String school;
    private Boolean isHosteller;
    private Integer expectedYearOfGraduation;
    
    public Student(Name name, String gender, CustomLocalDate dob, String email, String mobile, Address address, String registrationNumber, String program, String branch, String school, Boolean isHosteller, Integer expectedYearOfGraduation)
	{
		super(name, gender, dob, email, mobile, address);
		this.registrationNumber = registrationNumber;
		this.program = program;
		this.branch = branch;
		this.school = school;
		this.isHosteller = isHosteller;
		this.expectedYearOfGraduation = expectedYearOfGraduation;
	}
    
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Boolean getIsHosteller() {
		return isHosteller;
	}

	public void setIsHosteller(Boolean isHosteller) {
		this.isHosteller = isHosteller;
	}

	public Integer getExpectedYearOfGraduation() {
		return expectedYearOfGraduation;
	}

	public void setExpectedYearOfGraduation(Integer expectedYearOfGraduation) {
		this.expectedYearOfGraduation = expectedYearOfGraduation;
	}
	
	@Override
    public String toString()
    {
    	// This string is to store "yes" or "no" according to whether the student is an hosteller or dayscholar
    	String hostellerOrNot = "No";
    	if(isHosteller)
    	{
    		hostellerOrNot = "Yes";
    	}
    	
    	return super.toString() + "%-30s : %s\n".formatted("7. REGISTRATION NO.", this.registrationNumber)
								+ "%-30s : %s\n".formatted("8. PROGRAM", this.program)
								+ "%-30s : %s\n".formatted("9. BRANCH", this.branch.toString())
								+ "%-30s : %s\n".formatted("10. SCHOOL", this.school)
								+ "%-30s : %s\n".formatted("11. HOSTELLER", hostellerOrNot)
								+ "%-30s : %d\n".formatted("12. EXPECTED YEAR OF GRADUATION", this.expectedYearOfGraduation);
    }
	
	
	
	/**
	 * This method inputs values for the properties of a Student.
	 * This method creates an object of Student class with the info inputed and returns it.
	 * This is an static method. So I can call this method by just the name of the class. No need to create an object.
	 * @return Student
	 */
    public static Student inputUserInfo()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	Person person = Person.inputUserInfo();
    	
    	System.out.printf("%-30s : ", "REGISTRATION NUMBER");
    	String registrationNumber = sc.next();
    	sc.nextLine();
    	
    	System.out.printf("%-30s : ", "PROGRAM");
    	String program = sc.nextLine();
    	
    	System.out.printf("%-30s : ", "BRANCH");
    	String branch = sc.nextLine();
    	
    	System.out.printf("%-30s : ", "SCHOOL");
    	String school = sc.nextLine();
    	
    	System.out.printf("%-30s : ", "HOSTELLER (Y/N)");
    	String input = sc.next();
    	Boolean isHosteller;
    	if(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES"))
    	{
    		isHosteller = true;
    	}
    	else
    	{
    		isHosteller = false;
    	}
    	
    	Integer expectedYearOfGraduation;
    	while(true)
    	{
    		try
    		{
    			System.out.printf("%-30s : ", "EXPECTED YEAR OF GRADUATION");
    	    	expectedYearOfGraduation = sc.nextInt();
    	    	break;
    		}
    		catch(InputMismatchException ime)
    		{
    			System.out.println("<Please eneter an integer>");
    		}
    		finally
    		{
    			sc.nextLine();
    		}
    	}
    	
    	return new Student(person.getName(), person.getGender(), person.getDob(), person.getEmail(), person.getMobile(), person.getAddress(), registrationNumber, program, branch, school, isHosteller, expectedYearOfGraduation);
    }
    
    
    
    /**
	 * This method checks if there is actually an profile in the array list with the id entered by the user.
	 * Returns profile object if profile is present, null if not.
	 * @param objArrayList --> This is the Array List in which we will search for the profile with id user entered.
	 * @param id --> This is the id which we will be searching in the array list.
	 * @return Student
	 */
    public static Student getProfileIfInArrayList(ArrayList<Student> objArrayList, String id)
    {
    	for(int index = 0; index < objArrayList.size(); index++)
    	{
    		if(id.equalsIgnoreCase(objArrayList.get(index).getRegistrationNumber()))
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
				if(option < 1 || option > 12)
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
				System.out.println("<Please enter a number between 1 and 12>");
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
			CustomLocalDate dob = CustomLocalDate.inputDate();
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
			System.out.print("Enter updated Registration Number : ");
			this.setRegistrationNumber(sc.nextLine());
			break;

		case 8 :
			System.out.print("Enter updated program : ");
			this.setProgram(sc.next());
			break;
			
		case 9 :
			System.out.print("Enter updated branch : ");
			this.setBranch(sc.next());
			break;
			
		case 10 :
			System.out.print("Enter updated school : ");
			this.setSchool(sc.next());
			break;

		case 11 :
			System.out.print("Enter 'Y' if hosteller and 'N' if not : ");
			String input = sc.next();
			if(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES"))
	    	{
	    		this.setIsHosteller(true);
	    	}
	    	else
	    	{
	    		this.setIsHosteller(false);
	    	}
			break;
			
		case 12 :
			System.out.print("Enter updated year of graduation : ");
			this.setExpectedYearOfGraduation(sc.nextInt());
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