package view;

import java.util.Scanner;

import controller.LoginController;
import model.Admin;
import model.Staff;
import model.Student;

public class Login {
	
	public static void main(String[] args)
	{
		Login login=new Login();
		login.begin(login);
	}
	
	public void begin(Login login)
	{
		Scanner user_input=new Scanner(System.in);
		LoginController login_process=new LoginController();
		AdminPage admin_page=new AdminPage();
		StaffPage staff_page=new StaffPage();
		StudentPage student_page=new StudentPage();
		Admin admin_detail=new Admin();
		Staff staff_detail=new Staff();
		Student student_detail=new Student();
		
		System.out.println("*************School Attendance Application*******************");
		boolean lets_start=true;
		
		do {
			System.out.println("Choose any option to get in to application...\n1.	Admin Login \n2.	Staff Login \n3.	Student Login \n4.	Exit");
			int login_choice=user_input.nextInt();
			
			switch(login_choice)
			{
			case 1:
			{
				boolean isValid_email=false;
				String email_id;
				String password;
				user_input.nextLine();
				do {
					System.out.print("Email id:");
					email_id=user_input.nextLine();
					isValid_email=login_process.validate_email_id(email_id);
					if(!isValid_email)
							System.out.println("Invalid mail Id....enter valid email");
				}while(!isValid_email);
				
				System.out.print("Password :");
				password=user_input.nextLine();
				if(login_process.check_admin_login(email_id, password,admin_detail))
					{
						System.out.println("Logged in successfully!..............");
						admin_page.admin_homepage();
					}
				else
					System.out.println("Incorrect email id or password");
					
			}
			break;
			
			case 2:
			{
				boolean isValid_email=false;
				String email_id;
				String password;
				user_input.nextLine();
				do {
					System.out.print("Email id:");
					email_id=user_input.nextLine();
					isValid_email=login_process.validate_email_id(email_id);
					if(!isValid_email)
							System.out.println("Invalid mail Id....enter valid email");
				}while(!isValid_email);
				
				System.out.print("Password :");
				password=user_input.nextLine();
				if(login_process.check_staff_login(email_id, password,staff_detail))
					staff_page.staff_homepage(staff_detail);
				else
					System.out.println("Incorrect email id or password");
					
			}
			break;
			
			case 3:
			{
				boolean isValid_email=false;
				String email_id;
				String password;
				user_input.nextLine();
				do {
					System.out.print("Email id:");
					email_id=user_input.nextLine();
					isValid_email=login_process.validate_email_id(email_id);
					if(!isValid_email)
							System.out.println("Invalid mail Id....enter valid email");
				}while(!isValid_email);
				
				System.out.print("Password :");
				password=user_input.nextLine();
				if(login_process.check_student_login(email_id, password,student_detail))
					student_page.student_homepage(student_detail);
				else
					System.out.println("Incorrect email id or password");
			}
			break;
			
			case 4:
			{
				lets_start=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing this service...Kindly try any of our mentioned service");
				System.out.println("****************************************************************************");
			}
			}
			
		}while(lets_start);
		
	}
}
