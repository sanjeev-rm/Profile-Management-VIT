package validators;

import exceptions.studentExceptions.RegistrationNumberInvalidException;

/**
 * This class consists of methods that validate properties of an Student.
 * @author sanjeev.rm
 *
 */
public class StudentValidator
{
	/**
	 * This method validates an registration number.
	 * Throws an exception if the entered registration number is invalid.
	 * @param registrationNumber
	 * @throws RegistrationNumberInvalidException
	 */
	/*
	 * This method checks the format of the string entered.
	 * Checks if it matches the format of an registration number.
	 * Example : Valid --> "21BCE0430".
	 */
	public static void validateRegistrationNumber(String registrationNumber) throws RegistrationNumberInvalidException
	{
		if(!registrationNumber.matches("[0-9]{2}[a-zA-Z]{3}[0-9]{4}"))
		{
			throw new RegistrationNumberInvalidException("Invalid Registration Number : %s".formatted(registrationNumber));
		}
	}
}