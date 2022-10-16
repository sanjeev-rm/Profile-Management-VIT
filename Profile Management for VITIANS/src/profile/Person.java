package profile;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the properties of an person.
 * @author sanjeev.rm
 */
public class Person
{
	private Name name;
	private String gender;
	private LocalDate dob;
	private String email;
	private String mobile;
	private Address address;
	
	public Person(Name name, String gender, LocalDate dob, String email, String mobile, Address address) {
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
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
		Integer age = Period.between(this.dob, LocalDate.now()).getYears();
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
		LocalDate dob = Date.inputDate();
		
		System.out.printf("%-30s : ", "EMAIL");
		String email = sc.next();
		
		System.out.printf("%-30s : ", "MOBILE");
		String mobile = sc.next();
		
		Address address = Address.inputUserInfo();
		
		return new Person(name, gender, dob, email, mobile, address);
	}
}