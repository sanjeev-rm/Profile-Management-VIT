package profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.DateTimeException;

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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		return localDate.format(dtf);
	}

	public static CustomLocalDate inputDate()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			
			try
			{
				System.out.printf("%-30s : ", "YEAR");
				int year = sc.nextInt();
				
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
				System.out.println("<Please enter valid date inputs [month : 1 - 12] [day : 1 - 31]>");
			}
			finally
			{
				sc.nextLine();
			}
		}
	}
}