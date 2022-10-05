package view;

import java.util.Scanner;

import controller.StudentProcess;
import model.Student;

public class StudentPage {
	StudentProcess student_process=new StudentProcess();
	
	public void student_homepage(Student student_detail)
	{
		Scanner student_input=new Scanner(System.in);
		System.out.println("**************************Welcome Student************************");
		boolean student_lets_start=true;
		do {
			System.out.println("Choose any service to explore.....\n1.	My details \n2.	My attendance details \n3.	Apply Leave \n4.	Notification \n5.	Back");
			int student_start_choice=student_input.nextInt();
			
			switch(student_start_choice)
			{
			case 1:
			{
				student_process.view_my_details(student_detail.getStudent_id());
			}
			break;
			
			case 2:
			{
				student_process.view_my_attendance_details(student_detail.getStudent_id());
			}
			break;
			
			case 3:
			{
				student_input.nextLine();
				System.out.println("Student Id :");
				String student_id=student_input.nextLine();
				System.out.println("From date(\"yyyy-mm-dd\") :");
				String from_date=student_input.nextLine();
				System.out.println("To date (\\\"yyyy-mm-dd\\\"):");
				String to_date=student_input.nextLine();
				System.out.println("Leave reason :");
				String reason=student_input.nextLine();
				student_process.apply_leave(student_id, from_date, to_date, reason,student_detail);
			}
			break;
			
			case 4:
			{
				student_input.nextLine();
				System.out.println("Student Id :");
				String student_id=student_input.nextLine();
				student_process.view_notification(student_id);
			}
			break;
			
			case 5:
			{
				student_lets_start=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing this service...Kindly try any of our mentioned service");
				System.out.println("****************************************************************************");
			}
			break;
			}
		}while(student_lets_start);
	}
}
