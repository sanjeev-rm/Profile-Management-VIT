package exceptions.personExceptions;

/**
 * This exception is thrown when the mobile is invalid.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class MobileException extends PersonException
{
	public MobileException(String message)
	{
		super(message);
	}
}