package vitians;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.OptionInvalidException;
import profile.Address;
import profile.Name;
import profile.Person;
import profile.Profilable;

/**
 * This class represents an profile of an Faculty of VIT.
 * @author sanjeev.rm
 */
public class Faculty extends Person implements Profilable<Faculty>
{
	private String facultyID;
	private String responsibility;
	private LocalDate dateOfJoining;
	private String school;
	private Integer yearsOfExperience;
	
	public Faculty(Name name, String gender, LocalDate dob, String email, String mobile, Address address, String facultyID, String responsibility, LocalDate dateOfJoining, String school, Integer yearsOfExperience)
	{
		super(name, gender, dob, email, mobile, address);
		this.facultyID = facultyID;
		this.responsibility = responsibility;
		this.dateOfJoining = dateOfJoining;
		this.school = school;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	public String getFacultyID() {
		return facultyID;
	}
	
	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
	
	/**
	 * this method is used to get the number of years the faculty has worked in VIT.
	 * @return Integer
	 */
	public Integer getYearsInVIT()
	{
		return Period.between(dateOfJoining, LocalDate.now()).getYears();
	}
	
	
	
	@Override
	public String toString()
	{
		return super.toString() + "%-30s : %s\n".formatted("7. FACULTY ID", this.facultyID)
								+ "%-30s : %s\n".formatted("8. RESPONSIBILITY", this.responsibility)
								+ "%-30s : %s\n".formatted("9. DATE OF JOINING", this.dateOfJoining.toString())
								+ "%-30s : %s\n".formatted("10. SCHOOL", this.school)
								+ "%-30s : %s\n".formatted("11. YEARS OF EXPERIENCE", this.yearsOfExperience);
	}
	
	
	
	/**
	 * This method inputs values for the properties of a Faculty.
	 * This method creates an object of Faculty class with the info inputed and returns it.
	 * This is an static method. So I can call this method by just the name of the class. No need to create an object.
	 * @return Faculty
	 */
    public static Faculty inputUserInfo()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	Person person = Person.inputUserInfo();
    	
    	System.out.printf("%-30s : ", "FACULTY ID");
    	String facultyID = sc.next();
    	sc.nextLine();
    	
    	System.out.printf("%-30s : ", "RESPONSIBILITY");
    	String responsibility = sc.nextLine();
    	
    	LocalDate dateOfJoining;
    	while(true)
    	{
    		try
        	{
        		System.out.println("DATE OF JOINING");
            	System.out.printf("%-30s : ", "JOINING YEAR");
            	Integer joiningYear = sc.nextInt();
            	System.out.printf("%-30s : ", "JOINING MONTH");
            	Integer joiningMonth = sc.nextInt();
            	System.out.printf("%-30s : ", "JOINING DAY");
            	Integer joiningDay = sc.nextInt();
        		dateOfJoining = LocalDate.of(joiningYear, joiningMonth, joiningDay);
        		break;
        	}
        	catch(InputMismatchException ime)
        	{
        		System.out.println("<Please enter only integers for date inputs>");
        	}
        	catch(DateTimeException dte)
        	{
        		System.out.println("<Please enter valid date inputs [month : 1 - 12] [day : 1 - 31]>");
        	}
    		finally
    		{
    			sc.nextLine();
    		}
    	}
    	
    	System.out.printf("%-30s : ", "SCHOOL");
    	String school = sc.nextLine();
    	
    	Integer yearsOfExperience;
    	while(true)
    	{
    		try
    		{
    			System.out.printf("%-30s : ", "YEARS OF EXPERIENCE");
    	    	yearsOfExperience = sc.nextInt();
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
    	
    	return new Faculty(person.getName(), person.getGender(), person.getDob(), person.getEmail(), person.getMobile(), person.getAddress(), facultyID, responsibility, dateOfJoining, school, yearsOfExperience);
    }
    
    
    
    /**
	 * This method checks if there is actually an profile in the array list with the id entered by the user.
	 * Returns profile object if profile is present, null if not.
	 * @param objArrayList --> This is the Array List in which we will search for the profile with id user entered.
	 * @param id --> This is the id which we will be searching in the array list.
	 * @return Faculty
	 */
    public static Faculty getProfileIfInArrayList(ArrayList<Faculty> objArrayList, String id)
    {
    	for(int index = 0; index < objArrayList.size(); index++)
    	{
    		if(id.equalsIgnoreCase(objArrayList.get(index).getFacultyID()))
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
				if(option < 1 || option > 11)
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
				System.out.println("<Please enter a number between 1 and 11>");
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
			System.out.printf("%-30s : ", "BIRTH YEAR");
			int year = sc.nextInt();
			System.out.printf("%-30s : ", "BIRTH MONTH");
			int month = sc.nextInt();
			System.out.printf("%-30s : ", "BIRTH DAY");
			int day = sc.nextInt();
			LocalDate dob = LocalDate.of(year, month, day);
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
			System.out.print("Enter updated Faculty ID : ");
			this.setFacultyID(sc.next());
			break;

		case 8 :
			System.out.print("Enter updated responsibility : ");
			this.setResponsibility(sc.next());
			break;

		case 9 :
			System.out.print("Enter updated date of joining");
	    	System.out.printf("%-30s : ", "JOINING YEAR");
	    	Integer joiningYear = sc.nextInt();
	    	System.out.printf("%-30s : ", "JOINING MONTH");
	    	Integer joiningMonth = sc.nextInt();
	    	System.out.printf("%-30s : ", "JOINING DAY");
	    	Integer joiningDay = sc.nextInt();
	    	LocalDate dateOfJoining = LocalDate.of(joiningYear, joiningMonth, joiningDay);
	    	this.setDateOfJoining(dateOfJoining);
			break;

		case 10 :
			System.out.print("Enter updated school : ");
			this.setSchool(sc.next());
			break;

		case 11 :
			System.out.print("Enter updated years of experience : ");
			this.setYearsOfExperience(sc.nextInt());
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