package profile;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Scanner;
import exceptions.personExceptions.PersonException;
import validators.profileValidators.PersonValidator;

/**
 * This class contains the properties of an person.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class Person
{
	private Name name;
	private String gender;
	private CustomLocalDate dob;
	private String email;
	private String mobile;
	private Address address;
	
	public Person(Name name, String gender, CustomLocalDate dob, String email, String mobile, Address address) throws PersonException
	{
		PersonValidator.validateMobile(mobile);
		PersonValidator.validateEmail(email);
		
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CustomLocalDate getDob() {
		return dob;
	}

	public void setDob(CustomLocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter for email property of class Person.
	 * @param email
	 * @throws PersonException
	 */
	public void setEmail(String email) throws PersonException
	{
		PersonValidator.validateEmail(email);
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Setter for mobile property of class Person.
	 * @param mobile
	 * @throws PersonException
	 */
	public void setMobile(String mobile) throws PersonException
	{
		PersonValidator.validateMobile(mobile);
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}
	
	@Override
	public String toString()
	{
		return ("%-30s : %s\n".formatted("1. NAME", this.name.toString())
			  + "%-30s : %s\n".formatted("2. GENDER", this.gender)
			  + "%-30s : %s\n".formatted("3. DATE OF BIRTH", this.dob.toString())
			  + "%-30s : %s\n".formatted("4. EMAIL", this.email)
			  + "%-30s : %s\n".formatted("5. MOBILE", this.mobile)
			  + "%-30s : %s\n".formatted("6. ADDRESS", this.address.toString()));
	}
	
	/**
	 * This method returns the age of the person.
	 * @return Integer
	 */
	public Integer getAge()
	{
		Integer age = Period.between(this.dob.getLocalDate(), LocalDate.now()).getYears();
		return age;
	}
	
	/**
	 * This method inputs values for the properties of a Person.
	 * This method creates an object of Person class with the info inputed and returns it.
	 * This is an static method. So I can call this method by just the name of the class. No need to create an object.
	 * @return Person
	 */
	public static Person inputUserInfo()
	{
		Scanner sc = new Scanner(System.in);
		
		Name name = Name.inputUserInfo();
		
		System.out.printf("%-30s : ", "GENDER");
		String gender = sc.next();
		
		System.out.printf("%-30s\n", "DOB");
		CustomLocalDate dob = CustomLocalDate.inputDate();
		
		String email;
		while(true)
		{
			try
			{
				System.out.printf("%-30s : ", "EMAIL");
				email = sc.next();
				PersonValidator.validateEmail(email);
				break;
			}
			catch(PersonException pe)
			{
				System.out.println("<%s>".formatted(pe.getMessage()));
			}
			finally
			{
				sc.nextLine();
			}
		}
		
		String mobile;
		while(true)
		{
			try
			{
				System.out.printf("%-30s : ", "MOBILE");
				mobile = sc.next();
				PersonValidator.validateMobile(mobile);
				break;
			}
			catch(PersonException pe)
			{
				System.out.println("<%s>".formatted(pe.getMessage()));
			}
			finally
			{
				sc.nextLine();
			}
		}
		
		Address address = Address.inputUserInfo();
		
		try
		{
			return new Person(name, gender, dob, email, mobile, address);
		}
		catch(PersonException pe)
		{
		}
		return null;
	}
}