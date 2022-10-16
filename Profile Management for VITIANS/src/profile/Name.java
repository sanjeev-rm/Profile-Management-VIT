package profile;

import java.util.Scanner;

/**
 * This class contains the properties of a name.
 * @author sanjeev.rm
 *
 * @since 1.0
 */
public class Name
{
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Name(String firstName, String middleName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString()
	{
		return "%s %s %s".formatted(this.firstName, this.middleName, this.lastName);
	}
	
	/**
	 * This method inputs values for the properties of a Name.
	 * This method creates an object of Name class with the info inputed and returns it.
	 * This is an static method. So I can call this method by just the name of the class. No need to create an object.
	 * @return Name
	 */
	public static Name inputUserInfo()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("%-30s\n", "NAME");
		
		System.out.printf("%-30s : ", "FIRST NAME");
		String firstName = sc.nextLine();
		
		System.out.printf("%-30s : ", "MIDDLE NAME");
		String middleName = sc.nextLine();
		
		System.out.printf("%-30s : ", "LAST NAME");
		String lastName = sc.nextLine();
		
		return new Name(firstName, middleName, lastName);
	}
}