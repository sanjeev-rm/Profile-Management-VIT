package profile;

import java.time.LocalDate;
import java.util.Scanner;

public class Date
{
	public static LocalDate inputDate()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("%-30s : ", "YEAR");
		int year = sc.nextInt();
		
		System.out.printf("%-30s : ", "MONTH");
		int month = sc.nextInt();
		
		System.out.printf("%-30s : ", "DAY");
		int day = sc.nextInt();
		
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}
}