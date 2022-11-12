package validators.profileValidators;

import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.io.IOException;
import exceptions.CountryInvalidException;

/**
 * This class consists of methods that validate properties of an Address.
 * @author sanjeev.rm
 *
 * @version 1.0
 * @since 1.0
 */
public class AddressValidator
{
	/**
	 * This method validates country.
	 * Throws an exception if the country entered is not a valid country.
	 * @param country --> String country to validate.
	 * @throws CountryInvalidException
	 */
	/*
	 * This method reads an data-set in the form of csv from the Internet. and checks if the country is present in the file.
	 * If yes then nothing happens program runs as usual else throws an custom exception.
	 */
	public static void validateCountry(String country) throws CountryInvalidException
	{
		try
		{
			URL url = new URL("https://pkgstore.datahub.io/core/country-list/data_csv/data/d7c9d7cfb42cb69f4422dec222dbbaa8/data_csv.csv");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			bufferedReader.readLine();
			
			String line;
			while((line = bufferedReader.readLine()) != null)
			{
				String[] stringArray = line.split(",");
				if(stringArray[0].charAt(0) == '"')
				{
					stringArray[0] = stringArray[0].substring(1);
				}
				
				if(country.equalsIgnoreCase(stringArray[0]))
				{
					return;
				}
			}
			throw new CountryInvalidException("Invalid Country : %s".formatted(country));
		}
		catch(MalformedURLException murle)
		{
			System.out.println("<Invalid URL for the countries dataset>");
		}
		catch(IOException ioe)
		{
			System.out.printf("<Input/Output Exception [%s]>\n", ioe.getMessage());
		}
	}
}