package exceptions.personExceptions;

public class CityInvalidException extends AddressException
{
	public CityInvalidException(String message)
	{
		super(message);
	}
}