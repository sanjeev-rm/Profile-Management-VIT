package profile;

import java.util.ArrayList;

/**
 * Interface Profilable.
 * This interface contains methods that are common to all the classes which could have a profile.
 * @author Sanjeev.rm
 * @param <T> --> This represents the type of the arguments of the abstract methods declared in the interface. I have not used any right now but I removed it due to some issues, but I might in the future..
 *
 * @since 1.0
 */
public interface Profilable<T>
{
	/**
	 * This method prints the profile.
	 */
	public void displayProfile();
	
	/**
	 * This method shows the user the whole profile which the user wants to edit and then asks which option(property) do you want to edit?
	 * Gets the option and returns it.
	 * No parameters as the object calling this method is profile we need to edit.
	 * @return Integer
	 */
	public Integer showProfileAndAskOptionToEdit();
	
	/**
	 * This method takes in the option to edit and then asks the user to input the value to update the property and then updates the property.
	 * @param option --> This is the option which is an integer this represents an property like indexing.
	 */
	public void editProfile(Integer option);
}