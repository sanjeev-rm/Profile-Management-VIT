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

public class Driver
{
	public static void main(String[] args)
	{
		ArrayList<Student> studentsArrayList = new ArrayList<Student>();
		ArrayList<Faculty> facultiesArrayList = new ArrayList<Faculty>();
		ArrayList<Employee> employeesArrayList = new ArrayList<Employee>();
		ArrayList<Alumni> alumniArrayList = new ArrayList<Alumni>();
		
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
					System.out.println("\n~~~~~~Please enter a number between 1 and 5~~~~~~");
					continue;
				}
			}
			catch(InputMismatchException ime)
			{
				System.out.println("\n~~~~~~Please enter only integers~~~~~~");
				continue;
			}
			finally
			{
				sc.nextLine();
			}
			
			boolean wantToExit = false;
			switch(vitianOption)
			{
			case 1 :
				while(true)
				{
					displayCreateOrEditOption();
					Integer createOrEditOption = sc.nextInt();
					sc.nextLine();
					if(createOrEditOption == 1)
					{
						Student student = Student.inputUserInfo();
						studentsArrayList.add(student);
						student.displayProfile();
						System.out.println("<<<<<PROFILE CREATED>>>>>");
						break;
					}
					else if(createOrEditOption == 2)
					{
						System.out.print("Enter the registration number of profile to edit : ");
						String registrationNumber = sc.nextLine();
						if(Student.getProfileIfInArrayList(studentsArrayList, registrationNumber) != null)
						{
							Student student = Student.getProfileIfInArrayList(studentsArrayList, registrationNumber);
							Integer optionToEdit = student.showProfileAndAskOptionToEdit();
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
						wantToExit = true;
						break;
					}
					else
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2 or 3~~~~~~");
					}
				}
				break;
			
			case 2 :
				while(true)
				{
					displayCreateOrEditOption();
					Integer createOrEditOption = sc.nextInt();
					sc.nextLine();
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
					else
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2 or 3~~~~~~");
					}
				}
				break;
			
			case 3 :
				while(true)
				{
					displayCreateOrEditOption();
					Integer createOrEditOption = sc.nextInt();
					sc.nextLine();
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
					else
					{
						System.out.println("\n~~~~~~Please enter either 1 or 2~~~~~~");
					}
				}
				break;
			
			case 4 :
				while(true)
				{
					displayCreateOrEditOption();
					Integer createOrEditOption = sc.nextInt();
					sc.nextLine();
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
		System.out.println("******************************");
		System.out.println("1. Create Profile");
		System.out.println("2. Edit Profile");
		System.out.println("3. Exit");
		System.out.println("******************************");
		System.out.print("Enter option (1 or 2 or 3) : ");
	}
}