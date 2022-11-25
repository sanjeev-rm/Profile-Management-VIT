package validators.profileValidators;

import exceptions.personExceptions.MobileException;
import exceptions.personExceptions.EmailException;

/**
 * This class consists of methods that validate properties of a Person. 
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class PersonValidator
{
	/**
	 * This method validates mobile number.
	 * Throws an exception if the mobile number entered is invalid.
	 * @param mobile --> The mobile number in String format.
	 * @throws MobileException
	 */
	public static void validateMobile(String mobile) throws MobileException
	{
		if(mobile.length() < 7 || mobile.length() > 15)
		{
			throw new MobileException("Invalid Mobile Number");
		}
	}

	/**
	 * This method validates email.
	 * Throws an exception if the email entered is invalid.
	 * @param email --> The email in String format.
	 * @throws EmailException
	 */
	public static void validateEmail(String email) throws EmailException
	{
		if(!email.contains("@"))
			throw new EmailException("Invalid Email");
		
		// This makes sure that the first character is either an letter(a-zA-Z) or an number(0-9).
		if(!email.matches("^[a-zA-Z0-9].*"))
			throw new EmailException("Invalid Recipient Name [Valid : First character should be a letter(a-z) or a number(0-9)]");
		
		// This makes sure that the recipient name has only letters(a-zA-Z) and numbers(0-9) and periods(.).
		if(!email.matches("^[a-zA-Z0-9][a-zA-Z0-9.]+.*"))
			throw new EmailException("Invalid Recipient Name [Valid : Only letters(a-z), numbers(0-9), and periods(.) are allowed]");
		
		// This makes sure that the recipient name is of 6 to 30 characters long only.
		if(!email.matches("^[a-zA-Z0-9][a-zA-Z0-9.]{5,29}@.*"))
			throw new EmailException("Invalid Recipient Name [Valid : Must be 6 to 30 characters long]");
		
		// This makes sure that the domain name contains only letters(a-zA-Z) and dashes(-) and periods(.).
		if(!email.matches("^[a-zA-Z0-9][a-zA-Z0-9.]{5,29}@[a-zA-Z-.].*"))
			throw new EmailException("Invalid Domain Name [Valid : Only letters(a-z), numbers(0-9), dashes(-), and periods(.) are allowed]");
		
		// This makes sure that the length of domain name is at least 2 and at most 245.
		if(!email.matches("^[a-zA-Z0-9][a-zA-Z0-9.]{5,29}@[a-zA-Z-.]{2,254}\\..*"))
			throw new EmailException("Invalid Domain Name [Valid : Must be 2 to 254 characters long]");
		
		// This makes sure that the end of domain contains an .in or.cc or.com or something like that.
		if(!email.matches("^[a-zA-Z0-9][a-zA-Z0-9]{5,29}@[a-zA-Z-.]{2,254}\\.[a-zA-Z]{2,}"))
			throw new EmailException("Invalid Domain Name");
	}
}