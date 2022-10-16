package vitians;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import profile.Address;
import profile.CustomLocalDate;
import profile.Name;
import profile.Person;
import profile.Profilable;
import exceptions.OptionInvalidException;

/**
 * This class represents an profile of an Alumni of VIT.
 * @author sanjeev.rm
 *
 * @since 1.0
 */
public class Alumni extends Person implements Profilable<Alumni>
{
    private String alumniID;
    private Integer yearOfGraduation;
    private String degree;
    private String currentResidingPlace;
    
    public Alumni(Name name, String gender, CustomLocalDate dob, String email, String mobile, Address address, String alumniID, Integer yearOfGraduation, String degree, String currentResidingPlace)
    {
		super(name, gender, dob, email, mobile, address);
		this.alumniID = alumniID;
		this.yearOfGraduation = yearOfGraduation;
		this.degree = degree;
		this.currentResidingPlace = currentResidingPlace;
	}
    
    public String getAlumniID() {
        return alumniID;
    }
    
    public void setAlumniID(String alumniID) {
        this.alumniID = alumniID;
    }
    
    public Integer getYearOfGraduation() {
        return yearOfGraduation;
    }
    
    public void setYearOfGraduation(Integer yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }
    
    public String getDegree() {
        return degree;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    public String getCurrentResidingPlace() {
        return currentResidingPlace;
    }
    
    public void setCurrentResidingPlace(String currentResidingPlace) {
        this.currentResidingPlace = currentResidingPlace;
    }
    
    @Override
    public String toString()
    {
    	return super.toString() + "%-30s : %s\n".formatted("7. ALUMNI ID", this.alumniID)
  			  					+ "%-30s : %s\n".formatted("8. YEAR OF GRADUATION", this.yearOfGraduation)
  			  					+ "%-30s : %s\n".formatted("9. DEGREE", this.degree)
  			  					+ "%-30s : %s\n".formatted("10. CURRENT RESIDING PLACE", this.currentResidingPlace);
    }
    
    
    
    /**
	 * This method inputs values for the properties of a Alumni.
	 * This method creates an object of Alumni class with the info inputed and returns it.
	 * This is an static method. So I can call this method by just the name of the class. No need to create an object.
	 * @return Alumni
	 */
    public static Alumni inputUserInfo()
    {
    	Scanner sc = new Scanner(System.in);
    	
    	Person person = Person.inputUserInfo();
    	
    	System.out.printf("%-30s : ", "ALUMNI ID");
    	String alumniId = sc.next();
    	
    	Integer yearOfGarduation;
    	while(true)
    	{
    		try
    		{
    			System.out.printf("%-30s : ", "YEAR OF GRADUATION");
            	yearOfGarduation = sc.nextInt();
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
    	
    	System.out.printf("%-30s : ", "DEGREE");
    	String degree = sc.nextLine();
    	
    	System.out.printf("%-30s : ", "CURRENT RESIDING PLACE");
    	String currentResidingPlace = sc.nextLine();
    	
    	return new Alumni(person.getName(), person.getGender(), person.getDob(), person.getEmail(), person.getMobile(), person.getAddress(), alumniId, yearOfGarduation, degree, currentResidingPlace);
    }
    
    
    
    /**
	 * This method checks if there is actually an profile in the array list with the id entered by the user.
	 * Returns the profile object if profile is present, null if not.
	 * @param objArrayList --> This is the Array List in which we will search for the profile with id user entered.
	 * @param id --> This is the id which we will be searching in the array list.
	 * @return Alumni
	 */
	public static Alumni getProfileIfInArrayList(ArrayList<Alumni> objArrayList, String id)
	{
		for(int index = 0; index < objArrayList.size(); index++)
		{
			if(id.equalsIgnoreCase(objArrayList.get(index).getAlumniID()))
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
					throw new OptionInvalidException(); // Custom exception created by me.
				}
				return option;
			}
			catch(InputMismatchException ime)
			{
				System.out.println("<Please enter an integer>");
			}
			catch(OptionInvalidException oie)
			{
				System.out.println("<Please enter a number between 1 and 10>");
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
			System.out.print("Enter updated Alumni ID : ");
			this.setAlumniID(sc.next());
			break;

		case 8 :
			System.out.print("Enter updated year of graduation : ");
			this.setYearOfGraduation(sc.nextInt());
			break;
			
		case 9 :
			System.out.print("Enter updated degree : ");
			this.setDegree(sc.next());
			break;

		case 10 :
			System.out.print("Enter updated current residing place : ");
			this.setCurrentResidingPlace(sc.next());
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