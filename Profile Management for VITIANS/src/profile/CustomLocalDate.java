package profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.DateTimeException;

/**
 * This class is a customized version of LocalDate.
 * This class consist of only one property which is a LocalDate.
 * This class is specially created for this project only.
 * This was created to have a special toString() for LocalDate and a common input method for all dates in all classes.
 * This was created to reduce repetitiveness in code.
 * @author sanjeev.rm
 *
 * @since 1.0
 */
// First I thought of extending LocalDate class but that's not possible as LocalDate is an final class.
public class CustomLocalDate
{
	private LocalDate localDate;
	
	public CustomLocalDate(LocalDate date)
	{
		this.localDate = date;
	}
	
	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate date) {
		this.localDate = date;
	}
	
	@Override
	public String toString()
	{
		// This is used to format the date i.e. the way we want to show the date.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		return localDate.format(dtf);
	}
	
	/**
	 * This method is used to input date component values such as YEAR, MONTH, and DAY.
	 * This method uses scanner and inputs these data from the user and returns to you CustomLocalDate object.
	 * @return CustomLocalDate
	 */
	public static CustomLocalDate inputDate()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			
			try
			{
				System.out.printf("%-30s : ", "YEAR");
				int year = sc.nextInt();
				int currentYear = LocalDate.now().getYear();
				// If year inputed by user is greater than current year then throws exception as properties like dob can't be in the future.
				if((year > currentYear) || ((currentYear - year) > 100))
				{
					throw new DateTimeException("Enter valid year input");
				}
				
				System.out.printf("%-30s : ", "MONTH");
				int month = sc.nextInt();
				
				System.out.printf("%-30s : ", "DAY");
				int day = sc.nextInt();
				
				CustomLocalDate date = new CustomLocalDate(LocalDate.of(year, month, day));
				return date;
			}
			catch(InputMismatchException ime)
			{
				System.out.println("<Please enter only integers for date inputs>");
			}
			catch(DateTimeException dte)
			{
				System.out.println("<Please enter valid date inputs [year : valid year] [month : 1 - 12] [day : 1 - 31]>");
				System.out.printf("<%s>\n", dte.getMessage());
			}
			finally
			{
				sc.nextLine();
			}
		}
	}
}