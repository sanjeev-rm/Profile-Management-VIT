package exceptions.personExceptions;

/**
 * This exception is thrown when the email is invalid.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class EmailException extends PersonException
{
	public EmailException(String message)
	{
		super(message);
	}
}