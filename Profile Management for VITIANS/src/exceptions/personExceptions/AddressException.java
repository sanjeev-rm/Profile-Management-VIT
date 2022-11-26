package exceptions.personExceptions;

/**
 * This exception will be thrown when the Address is invalid.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class AddressException extends PersonException
{
	public AddressException(String message)
	{
		super(message);
	}
}