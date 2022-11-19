package exceptions.studentExceptions;

/**
 * This is an  Exception for class Student.
 * This is the parent class Exception for all the exceptions related to Student class.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class StudentException extends Exception
{
	public StudentException(String message)
	{
		super(message);
	}
}