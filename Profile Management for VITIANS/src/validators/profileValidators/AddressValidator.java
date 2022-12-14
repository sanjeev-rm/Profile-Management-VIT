package validators.profileValidators;

import java.net.URL;

import exceptions.personExceptions.CityInvalidException;
import exceptions.personExceptions.CountryInvalidException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.io.IOException;

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
	 * This method validates city.
	 * throws an exception if the city entered is not valid.
	 * Network connectivity is required to run this method.
	 * @param city
	 * @throws CityInvalidException
	 * @disclaimer Network connection is required.
	 */
	/*
	 * This method reads an data-set in the form of tsv from the Internet. and checks if the city is present in the file.
	 * If yes then nothing happens program runs as usual else throws an custom exception.
	 */
	public static void validateCity(String city) throws CityInvalidException
	{
		try
		{
			URL url = new URL("https://raw.githubusercontent.com/adeckmyn/maps/master/data-raw/world.cities.new.tsv");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			bufferedReader.readLine();
			
			String line;
			while((line = bufferedReader.readLine()) != null)
			{
				String[] cityInfoArray = line.split("\t");
				if(city.equalsIgnoreCase(cityInfoArray[0].substring(1, (cityInfoArray[0].length() - 1))))
				{
					return;
				}
			}
			throw new CityInvalidException("Invalid City : %s".formatted(city));
		}
		catch(MalformedURLException mfue)
		{
			System.out.println("<%s>".formatted("Invalid URL for the cities dataset"));
		}
		catch(IOException ioe)
		{
			System.out.println("<Input/Output Exception [%s]>".formatted(ioe.getMessage()));
			System.out.println("<%s>".formatted("Please check your network connection"));
		}
	}
	
	/**
	 * This method validates country.
	 * Throws an exception if the country entered is not a valid country.
	 * Network connectivity is required to run this method.
	 * @param country --> String country to validate.
	 * @throws CountryInvalidException
	 * @disclaimer Network connection is required.
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
			throw new CountryInvalidException("Please check your network connection");
		}
	}
}