package exceptions;

/**
 * Exception that is thrown when the option entered is invalid.
 * Eg: This exception is thrown when the options valid are like 1 to 12 but the user eneters -1 or 13 or something like that.
 * @author sanjeev.rm
 *
 */
public class OptionInvalidException extends Exception
{
	public OptionInvalidException()
	{
		super("Invalid Option");
	}
}