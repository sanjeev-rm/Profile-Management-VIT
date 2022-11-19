package exceptions.personExceptions;

/**
 * This an Exception for properties of Person.
 * This is the parent class exception for all the exceptions related to Person class.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class PersonException extends Exception
{
	public PersonException(String message)
	{
		super(message);
	}
}