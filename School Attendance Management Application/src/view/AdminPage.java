package view;

import java.util.Scanner;

import controller.AdminProcess;
import model.Staff;

public class AdminPage {
	AdminProcess admin_process=new AdminProcess();
	
	public void admin_homepage()
	{
		Scanner admin_input=new Scanner(System.in);
		boolean admin_lets_start=true;
		do {
			System.out.println("**************************Welcome Admin************************");
			System.out.println("Choose any service......\n1.Add new Staff  \n2.Update staff detail \n3.Delete staff detail \n4.View Student details \n5.View students Attendance \n6.Back");
			int admin_start_choice=admin_input.nextInt();
			
			switch(admin_start_choice)
			{
			case 1:
			{
				System.out.print("Staff name :");
				String staff_name=admin_input.next();
				System.out.print("Email id :");
				String staff_email=admin_input.next();
				System.out.print("Mobile number :");
				String staff_mobile=admin_input.next();
				System.out.println("standard_incharge :");
				String staff_class=admin_input.next();
				admin_process.add_new_staff(staff_name, staff_email, staff_mobile, staff_class, null);
			}
			break;
			
			case 2:
			{
				boolean admin_update=true;
				do {
					System.out.println("**************************Updating details***********************************");
					System.out.println("Choose field to update...\n1.Email id \n2.Mobile number \n3.Standard \n4.back");
					int admin_update_choice=admin_input.nextInt();
					switch(admin_update_choice)
					{
					case 1:
					{
						System.out.print("Staff id :");
						String staff_id=admin_input.next();
						System.out.print("Email id :");
						String staff_email=admin_input.next();
						admin_process.update_email(staff_id, staff_email);
					}
					break;
					
					case 2:
					{
						System.out.print("Staff id :");
						String staff_id=admin_input.next();
						System.out.print("Mobile number :");
						String staff_mobile=admin_input.next();
						admin_process.update_mobile_number(staff_id, staff_mobile);
					}
					break;
					
					case 3:
					{
						System.out.print("Staff id :");
						String staff_id=admin_input.next();
						System.out.print("Standard :");
						String staff_grade=admin_input.next();
						admin_process.update_grade(staff_id, staff_grade);
					}
					break;
					
					case 4:
					{
						admin_update=false;
					}
					
					default:
					{
						System.out.println("We are not providing this service...Kindly try any of our mentioned service");
						System.out.println("****************************************************************************");
					}
					}
					
				}while(admin_update);
				
			}
			break;
			
			case 3:
			{
				System.out.print("Staff id :");
				String staff_id=admin_input.next();
				admin_process.delete_staff(staff_id);
			}
			break;
			
			case 4:
			{
				System.out.print("Student id :");
				String student_id=admin_input.next();
				admin_process.view_student_detail(student_id);
				
			}
			break;
			
			case 5:
			{
				System.out.print("Student id :");
				String student_id=admin_input.next();
				admin_process.view_student_attendance_detail(student_id);
			}
			break;
			
			case 6:
			{
				admin_lets_start=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing this service...Kindly try any of our mentioned service");
				System.out.println("****************************************************************************");
			}
			}
			
		}while(admin_lets_start);
	}
}
