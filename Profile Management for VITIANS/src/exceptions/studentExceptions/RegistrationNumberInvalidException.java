package exceptions.studentExceptions;

/**
 *This exception is thrown when the registration number is invalid.
 * @author sanjeev.rm
 *
 */
public class RegistrationNumberInvalidException extends StudentException
{
	public RegistrationNumberInvalidException(String message)
	{
		super(message);
	}
}