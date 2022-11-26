package exceptions.personExceptions;

/**
 * This exception is thrown when the country is invalid.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class CountryInvalidException extends AddressException
{
	public CountryInvalidException(String message)
	{
		super(message);
	}
}