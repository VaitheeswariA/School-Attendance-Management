package view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controller.StaffProcess;
import model.Staff;

public class StaffPage {
	StaffProcess staff_process=new StaffProcess();
	
	public void staff_homepage(Staff staff_detail)
	{
		Scanner staff_input=new Scanner(System.in);
		boolean staff_lets_start=true;
		do {
			System.out.println("**********************************Welcome Staff****************************************");
			System.out.println("Choose any service......\n1.	Add new Student  \n2.	Update Student detail \n3.	Delete Student \n4.	View Student detail  \n5.	View Student list \n6.	Add students Attendance  \n7.	Update Student Attendance \n8.	Delete Student Attendance \n9.	View Student Attendance \n10.	My students attendance \n11.	Notification \n12. Back");
			int admin_start_choice=staff_input.nextInt();
			
			switch(admin_start_choice)
			{
			case 1:
			{
				System.out.println("*******************Provide details**************************");
				staff_input.nextLine();
				System.out.print("Student name :");
				String stu_name=staff_input.nextLine();
				System.out.print("Email id :");
				String stu_email=staff_input.next();
				System.out.print("Staff incharge :");
				String staff_id=staff_input.next();
				System.out.print("Mobile number :");
				String stu_mobile=staff_input.next();
				System.out.print("Standard :");
				String stu_class=staff_input.next();
				System.out.print("Record live status:");
				boolean stu_record_status=staff_input.nextBoolean();
				staff_input.nextLine();
				System.out.print("Guardian Name :");
				String stu_guardian=staff_input.nextLine();
				System.out.print("Emergency contact :");
				String stu_emergency_contact=staff_input.nextLine();
				staff_process.add_new_student(stu_name, staff_id, stu_email, stu_mobile, stu_class, stu_record_status, stu_guardian, stu_emergency_contact);
				System.out.println("**************************************************************");
			}
			break;
			
			case 2:
			{
				System.out.println("*******************Provide details**************************");
				staff_input.nextLine();
				System.out.print("Student Id :");
				String student_id=staff_input.nextLine();
				System.out.print("Student name :");
				String stu_name=staff_input.nextLine();
				System.out.print("Email id :");
				String stu_email=staff_input.next();
				System.out.print("Staff incharge :");
				String staff_id=staff_input.next();
				System.out.print("Mobile number :");
				String stu_mobile=staff_input.next();
				System.out.print("Standard :");
				String stu_class=staff_input.next();
				System.out.print("Record live status:");
				boolean stu_record_status=staff_input.nextBoolean();
				staff_input.nextLine();
				System.out.print("Guardian Name :");
				String stu_guardian=staff_input.nextLine();
				System.out.print("Emergency contact :");
				String stu_emergency_contact=staff_input.nextLine();
				staff_process.update_student(student_id,stu_name, staff_id, stu_email, stu_mobile, stu_class, stu_record_status, stu_guardian, stu_emergency_contact);
				System.out.println("**************************************************************");
			}
			break;
			
			case 3:
			{
				System.out.print("Student Id:");
				String student_id=staff_input.next();
				System.out.print("Staff Id:");
				String staff_id=staff_input.next();
				staff_process.delete_student_detail(student_id,staff_id);
			}
			break;
			
			case 4:
			{
				System.out.print("Student Id:");
				String student_id=staff_input.next();
				System.out.print("Staff Id:");
				String staff_id=staff_input.next();
				staff_process.view_student_detail(student_id,staff_id);
			}
			break;
			
			case 5:
			{
				System.out.print("Staff Id:");
				String staff_id=staff_input.next();
				staff_process.view_student_detail(staff_id);
			}
			break;
			
			case 6:
			{
				System.out.print("Student Id :");
				String stu_id=staff_input.next();
				System.out.print("Attendance date (\"yyyy-mm--dd\"):");
				String stu_attendance_date=staff_input.next();
				staff_input.nextLine();
				System.out.print("Student standard :");
				String stu_grade=staff_input.nextLine();
				System.out.print("Staff id :");
				String staff_incharge_id=staff_input.next();
				System.out.print("Attendance Entry :");
				String attendance_entry=staff_input.next();
				staff_input.nextLine();
				System.out.println("Is holiday (yes or no):");
				boolean is_holiday=staff_input.nextLine().equalsIgnoreCase("yes") ? true :false;
				System.out.println("is absent(yes or no):");
				boolean is_absent=staff_input.nextLine().equalsIgnoreCase("yes") ? true :false;
				System.out.println("Has leave approval (yes or no):");
				boolean has_approval=staff_input.nextLine().equalsIgnoreCase("yes") ? true :false;
				System.out.println("Instruction :");
				String instruction=staff_input.nextLine();
				staff_process.add_student_attendance(stu_id, stu_attendance_date, stu_grade, staff_incharge_id, attendance_entry, is_holiday, is_absent, has_approval, instruction);	
			}
			break;
			
			case 7:
			{
				System.out.print("Student Id :");
				String stu_id=staff_input.next();
				System.out.print("Attendance date (\"yyyy-mm--dd\"):");
				String stu_attendance_date=staff_input.next();
				System.out.print("Student standard :");
				staff_input.nextLine();
				String stu_grade=staff_input.nextLine();
				System.out.print("Staff id :");
				String staff_incharge_id=staff_input.next();
				System.out.print("Attendance Entry :");
				String attendance_entry=staff_input.next();
				staff_input.nextLine();
				System.out.print("Is holiday (yes or no):");
				boolean is_holiday=staff_input.nextLine().equalsIgnoreCase("yes") ? true :false;
				System.out.print("is absent(yes or no):");
				boolean is_absent=staff_input.nextLine().equalsIgnoreCase("yes") ? true :false;
				System.out.print("Has leave approval (yes or no):");
				boolean has_approval=staff_input.nextLine().equalsIgnoreCase("yes") ? true :false;
				System.out.print("Instruction :");
				String instruction=staff_input.nextLine();
				staff_process.update_student_attendance(stu_id, stu_attendance_date, stu_grade, staff_incharge_id, attendance_entry, is_holiday, is_absent, has_approval, instruction);
			}
			break;
			
			case 8:
			{
				System.out.print("Student Id :");
				String stu_id=staff_input.next();
				staff_process.delete_student_attendance(stu_id,staff_detail.getStaff_id());
			}
			break;
			
			case 9:
			{
				System.out.println("***********************************Student's attendance Report********************************");
				System.out.print("Student Id :");
				String stu_id=staff_input.next();
				staff_process.view_student_attendance(stu_id);
			}
			break;
			
			case 10:
			{
				System.out.println("***********************************Grade students attendance Report********************************");
				staff_process.my_grade_student_attendance(staff_detail.getStaff_id());
			}
			break;
			/*
			case 11:
			{
				System.out.println("***********************************Weekly Report********************************");
				System.out.print("Student Id Id:");
				String student_id=staff_input.next();
				System.out.print("From date:");
				String from_date=staff_input.next();
				staff_process.weekly_report(student_id,staff_detail.getStaff_id(), from_date);//LocalDate.parse(from_date,DateTimeFormatter.ofPattern("yyyy-mm-dd")));
			}
			break;
			
			case 12:
			{
				System.out.println("***********************************Monthly Report********************************");
				System.out.print("Student Id Id:");
				String student_id=staff_input.next();
				System.out.print("From date:");
				String from_date=staff_input.next();
				//staff_process.monthly_report(student_id,staff_detail.getStaff_id(), ;
			//LocalDate.parse(from_date,DateTimeFormatter.ofPattern("yyyy-mm-dd"))
			}
			break;*/
			
			case 11:
			{
				staff_process.view_notification(staff_detail.getStaff_id());
			}
			break;
			
			case 12:
			{
				staff_lets_start=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing this service...Kindly try any of our mentioned service");
				System.out.println("****************************************************************************");
			}
			}
			
		}while(staff_lets_start);
	}
	
}
