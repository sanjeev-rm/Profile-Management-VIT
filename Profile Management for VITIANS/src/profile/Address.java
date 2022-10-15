package profile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the properties of an address.
 * @author sanjeev.rm
 */
public class Address
{
	private String houseNo;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	public Address(String houseNo, String area, String city, String state, String country, String pincode)
	{
		this.houseNo = houseNo;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString()
	{
		return "%s, %s, %s, %s, %s, %s".formatted(this.houseNo, this.area, this.city, this.state, this.country, this.pincode);
	}
	
	/**
	 * This method inputs values for the properties of an Address.
	 * This method creates an object of Address class with the info inputed and returns it.
	 * This is an static method. So I can call this method by just the name of the class. No need to create an object.
	 * @return Address
	 */
	public static Address inputUserInfo()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("%-30s\n", "ADDRESS");
		
		System.out.printf("%-30s : ", "HOUSE NO");
		String houseNo = sc.next();
		sc.nextLine();
		
		System.out.printf("%-30s : ", "AREA");
		String area = sc.nextLine();
		
		System.out.printf("%-30s : ", "CITY");
		String city = sc.nextLine();
		
		System.out.printf("%-30s : ", "STATE");
		String state = sc.nextLine();
		
		System.out.printf("%-30s : ", "COUNTRY");
		String country = sc.nextLine();
		
		System.out.printf("%-30s : ", "PINCODE");
		String pincode = sc.next();
		sc.nextLine();
		
		return new Address(houseNo, area, city, state, country, pincode);
	}
}