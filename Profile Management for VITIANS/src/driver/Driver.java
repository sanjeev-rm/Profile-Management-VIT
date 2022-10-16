package driver;

import java.util.ArrayList;
import java.util.InputMismatchException;

import vitians.Student;
import vitians.Faculty;
import vitians.Employee;
import vitians.Alumni;

// Instead of writing all the lines above to import classes of package vitians. As we are technically importing all the classes we can just write -->
import vitians.*;

import java.util.Scanner;

import exceptions.OptionInvalidException;
import profile.Person;
import profile.Profilable;

/**
 * Driver class of the whole project.
 * @author sanjeev.rm
 *
 * @since 1.0
 */
public class Driver
{
	public static void main(String[] args)
	{
		// ArrayLists to store students, faculties, employees, and alumni profiles.
		ArrayList<Student> studentsArrayList = new ArrayList<Student>();
		ArrayList<Faculty> facultiesArrayList = new ArrayList<Faculty>();
		ArrayList<Employee> employeesArrayList = new ArrayList<Employee>();
		ArrayList<Alumni> alumniArrayList = new ArrayList<Alumni>();
		
		// This is where it starts.
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO THE PROFILE MANAGEMENT SYSTEM FOR VITIANS");
		while(true)
		{
			displayVitiansOption();
			Integer vitianOption;
			try
			{
				vitianOption = sc.nextInt();
				if(vitianOption < 1 || vitianOption > 5)
				{
					throw new OptionInvalidException(); // Custom exception.
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("\n~~~~~~Please enter only integers~~~~~~");
				continue; // Continue would make the compiler go back to start of the loop.
			}
			catch(OptionInvalidException oie)
			{
				System.out.println("\n~~~~~~Please enter a number between 1 and 5~~~~~~");
				continue;
			}
			finally
			{
				sc.nextLine();
			}
			
			boolean wantToExit = false; // Variable becomes true if the user wants to exit.
			switch(vitianOption)
			{
			// Case 1 is for Student profile.
			case 1 :
				while(true)
				{
					// This is to display the options.
					// This is to get(input) the option to either create or edit profile.
					displayCreateOrEditOption();
					Integer createOrEditOption;
					try
					{
						createOrEditOption = sc.nextInt();
						if(createOrEditOption < 1 || createOrEditOption > 3)
						{
							throw new OptionInvalidException();
						}
					}
					catch(InputMismatchException ime)
					{
						System.out.println("\n~~~~~~Please eneter only integers~~~~~~");
						continue;
					}
					catch(OptionInvalidException oie)
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2 or 3~~~~~~");
						continue;
					}
					finally
					{
						sc.nextLine();
					}
					
					if(createOrEditOption == 1)
					{
						// This is for creating an profile.
						Student student = Student.inputUserInfo(); // Creating profile.
						studentsArrayList.add(student); // Adding the profile to the array list.
						student.displayProfile(); // Displays profile.
						System.out.println("<<<<<PROFILE CREATED>>>>>");
						break;
					}
					else if(createOrEditOption == 2)
					{
						// This is for editing an profile.
						
						// Getting the id from the user.
						System.out.print("Enter the registration number of profile to edit : ");
						String registrationNumber = sc.nextLine();
						
						// Checks if there's an profile like that.
						if(Student.getProfileIfInArrayList(studentsArrayList, registrationNumber) != null)
						{
							// We'll get that profile.
							Student student = Student.getProfileIfInArrayList(studentsArrayList, registrationNumber);
							
							// Then we show that profile and ask for which option to edit and then get the edit option.
							Integer optionToEdit = student.showProfileAndAskOptionToEdit();
							
							// Then we edit the profile by calling the editProfile(..) by passing in the option to edit.
							student.editProfile(optionToEdit);
							
							System.out.println("\n<<<<<PROFILE EDITED>>>>>");
							student.displayProfile();
							break;
						}
						else
						{
							System.out.println("\n~~~~~~No such profile present~~~~~~");
							break;
						}
					}
					else if(createOrEditOption == 3)
					{
						// This is for when the user wants to exit.
						wantToExit = true;
						break;
					}
				}
				break;
				
				
			// Case 2 is for Faculty profile.
			case 2 :
				while(true)
				{
					// This is to display the options.
					// This is to get the option to either create or edit profile.
					displayCreateOrEditOption();
					Integer createOrEditOption;
					try
					{
						createOrEditOption = sc.nextInt();
						if(createOrEditOption < 1 || createOrEditOption > 3)
						{
							throw new OptionInvalidException();
						}
					}
					catch(InputMismatchException ime)
					{
						System.out.println("\n~~~~~~Please eneter only integers~~~~~~");
						continue;
					}
					catch(OptionInvalidException oie)
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2 or 3~~~~~~");
						continue;
					}
					finally
					{
						sc.nextLine();
					}
					
					if(createOrEditOption == 1)
					{
						Faculty faculty = Faculty.inputUserInfo();
						facultiesArrayList.add(faculty);
						faculty.displayProfile();
						System.out.println("<<<<<PROFILE CREATED>>>>>");
						break;
					}
					else if(createOrEditOption == 2)
					{
						System.out.print("Enter the faculty ID of profile to edit : ");
						String facultyID = sc.nextLine();
						if(Faculty.getProfileIfInArrayList(facultiesArrayList, facultyID) != null)
						{
							Faculty faculty = Faculty.getProfileIfInArrayList(facultiesArrayList, facultyID);
							Integer optionToEdit = faculty.showProfileAndAskOptionToEdit();
							faculty.editProfile(optionToEdit);
							System.out.println("<<<<<PROFILE EDITED>>>>>");
							faculty.displayProfile();
							break;
						}
						else
						{
							System.out.println("\n~~~~~~No such profile present~~~~~~");
							break;
						}
					}
					else if(createOrEditOption == 3)
					{
						wantToExit = true;
						break;
					}
				}
				break;
				
			// Case 3 is for Employee profile.
			case 3 :
				while(true)
				{
					// This is to display the options.
					// This is to get the option to either create or edit profile.
					displayCreateOrEditOption();
					Integer createOrEditOption;
					try
					{
						createOrEditOption = sc.nextInt();
						if(createOrEditOption < 1 || createOrEditOption > 3)
						{
							throw new OptionInvalidException();
						}
					}
					catch(InputMismatchException ime)
					{
						System.out.println("\n~~~~~~Please eneter only integers~~~~~~");
						continue;
					}
					catch(OptionInvalidException oie)
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2 or 3~~~~~~");
						continue;
					}
					finally
					{
						sc.nextLine();
					}
					
					if(createOrEditOption == 1)
					{
						Employee employee = Employee.inputUserInfo();
						employeesArrayList.add(employee);
						employee.displayProfile();
						System.out.println("<<<<<PROFILE CREATED>>>>>");
						break;
					}
					else if(createOrEditOption == 2)
					{
						System.out.print("Enter the employee ID of profile to edit : ");
						String employeeID = sc.nextLine();
						if(Employee.getProfileIfInArrayList(employeesArrayList, employeeID) != null)
						{
							Employee employee = Employee.getProfileIfInArrayList(employeesArrayList, employeeID);
							Integer optionToEdit = employee.showProfileAndAskOptionToEdit();
							employee.editProfile(optionToEdit);
							System.out.println("<<<<<PROFILE EDITED>>>>>");
							employee.displayProfile();
							break;
						}
						else
						{
							System.out.println("\n~~~~~~No such profile present~~~~~~");
							break;
						}
					}
					else if(createOrEditOption == 3)
					{
						wantToExit = true;
						break;
					}
				}
				break;
				
			// Case 4 is for Alumni profile.
			case 4 :
				while(true)
				{
					// This is to display the options.
					// This is to get the option to either create or edit profile.
					displayCreateOrEditOption();
					Integer createOrEditOption;
					try
					{
						createOrEditOption = sc.nextInt();
						if(createOrEditOption < 1 || createOrEditOption > 3)
						{
							throw new OptionInvalidException();
						}
					}
					catch(InputMismatchException ime)
					{
						System.out.println("\n~~~~~~Please eneter only integers~~~~~~");
						continue;
					}
					catch(OptionInvalidException oie)
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2 or 3~~~~~~");
						continue;
					}
					finally
					{
						sc.nextLine();
					}
					
					if(createOrEditOption == 1)
					{
						Alumni alumni = Alumni.inputUserInfo();
						alumniArrayList.add(alumni);
						alumni.displayProfile();
						System.out.println("<<<<<PROFILE CREATED>>>>>");
						break;
					}
					else if(createOrEditOption == 2)
					{
						System.out.print("Enter the registration number of profile to edit : ");
						String alumniID = sc.nextLine();
						if(Alumni.getProfileIfInArrayList(alumniArrayList, alumniID) != null)
						{
							Alumni alumni = Alumni.getProfileIfInArrayList(alumniArrayList, alumniID);
							Integer optionToEdit = alumni.showProfileAndAskOptionToEdit();
							alumni.editProfile(optionToEdit);
							System.out.println("<<<<<PROFILE EDITED>>>>>");
							alumni.displayProfile();
							break;
						}
						else
						{
							System.out.println("\n~~~~~~No such profile present~~~~~~");
							break;
						}
					}
					else if(createOrEditOption == 3)
					{
						wantToExit = true;
						break;
					}
					else
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2~~~~~~");
					}
				}
				break;
				
			// Case 5 is for if the user wants to exit.
			case 5 :
				wantToExit = true;
				break;
			
			default :
				System.out.println("\n~~~~~~Please enter an valid option~~~~~~");
			}
			
			if(wantToExit)
			{
				break;
			}
		}
		
		System.out.println("*************************************************************\n" + "THANKS! FOR USING MY PROFILE MANAGEMENT SYSTEM\n" + "*************************************************************\n");
		
		System.out.println("\n*********************STUDENTS PROFILES*********************");
		displayProfiles(studentsArrayList);
		System.out.println("\n*********************FACULTIES PROFILES*********************");
		displayProfiles(facultiesArrayList);
		System.out.println("\n*********************EMPLOYEES PROFILES*********************");
		displayProfiles(employeesArrayList);
		System.out.println("\n*********************ALUMNI PROFILES*********************");
		displayProfiles(alumniArrayList);
	}
	
	/**
	 * Displays Vitians options.
	 */
	private static void displayVitiansOption()
	{
		System.out.println("\n***************************************VITIANS***************************************");
		System.out.println("1. Student");
		System.out.println("2. Faculty");
		System.out.println("3. Employee");
		System.out.println("4. Alumni");
		System.out.println("5. Exit");
		System.out.println("*************************************************************************************");
		System.out.print("Select profile (enter number between 1 and 4) or Enter 5 to exit : ");
	}
	
	/**
	 * Displays Create or Edit option.
	 */
	private static void displayCreateOrEditOption()
	{
		System.out.println("\n******************************");
		System.out.println("1. Create Profile");
		System.out.println("2. Edit Profile");
		System.out.println("3. Exit");
		System.out.println("******************************");
		System.out.print("Enter option (1 or 2 or 3) : ");
	}
	
	/**
	 * This method is used to display all the profiles in the array list.
	 * @param profilesArrayList
	 */
	private static void displayProfiles(ArrayList profilesArrayList)
	{
		if(profilesArrayList.size() == 0)
		{
			System.out.println("No profiles created yet.");
			return;
		}
		
		for(int index = 0; index < profilesArrayList.size(); index++)
		{
			System.out.println("\n-------------------------------------------------------------------------------------\n" + profilesArrayList.get(index) + "-------------------------------------------------------------------------------------\n");
			return;
		}
	}
}