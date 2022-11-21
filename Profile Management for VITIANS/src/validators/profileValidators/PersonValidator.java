package validators.profileValidators;

import exceptions.personExceptions.MobileException;

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
}