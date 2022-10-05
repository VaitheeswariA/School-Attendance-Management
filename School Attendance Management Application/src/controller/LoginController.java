package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Admin;
import model.Staff;
import model.Student;

public class LoginController {
	private Connection connect=null;
	private PreparedStatement prepared_statement=null;
	private ResultSet result_set=null;
	
	public LoginController()
	{
		try {
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/School_db", "root", "@Jjack007");
			System.out.println("login connected");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public boolean check_admin_login(String email_id,String password,Admin admin_detail)
	{
		try
		{
			prepared_statement=connect.prepareStatement("Select Name,Email_id,Password,Mobile_Number FROM Admin");
			result_set=prepared_statement.executeQuery();
			while(result_set.next())
			{
				admin_detail.setName(result_set.getNString(1));
				admin_detail.setEmail_id(result_set.getNString(2));
				admin_detail.setPassword(result_set.getNString(3));
				admin_detail.setMobile_number(result_set.getNString(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return admin_detail.getEmail_id().equals(email_id) && admin_detail.getPassword().equals(password);
	}
	
	public boolean check_staff_login(String email_id,String password,Staff staff_detail)
	{
		try {
			prepared_statement =connect.prepareStatement("SELECT staff_id,name,email_id,password,mobile_number,Standard_incharge,notification_id FROM Staff WHERE email_id=?");
			prepared_statement.setString(1,email_id);
			result_set=prepared_statement.executeQuery();
			while(result_set.next())
			{
				staff_detail.setStaff_id(result_set.getNString(1));
				staff_detail.setName(result_set.getNString(2));
				staff_detail.setEmail_id(result_set.getNString(3));
				staff_detail.setPassword(result_set.getNString(4));
				staff_detail.setMobile_number(result_set.getNString(5));
				staff_detail.setStandard_incharge(result_set.getNString(6));
				staff_detail.setNotification_id(result_set.getNString(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return staff_detail.getEmail_id().equals(email_id) && staff_detail.getPassword().equals(password);
	}
	
	public boolean check_student_login(String email_id,String password,Student student_detail)
	{
		try
		{
			prepared_statement=connect.prepareStatement("SELECT * FROM Student WHERE email_id=?");
			prepared_statement.setString(1, email_id);
			result_set=prepared_statement.executeQuery();
			while(result_set.next())
			{
				student_detail.setStudent_id(result_set.getNString(1));
				student_detail.setStaff_incharge_id(result_set.getNString(2));
				student_detail.setName(result_set.getNString(3));
				student_detail.setEmail_id(result_set.getNString(4));
				student_detail.setStudent_password(result_set.getNString(5));
				student_detail.setMobile_number(result_set.getNString(6));
				student_detail.setStandard(result_set.getNString(7));
				student_detail.setIs_live_data(result_set.getBoolean(8));
				student_detail.setGuardian_name(result_set.getNString(9));
				student_detail.setEmergency_contact(result_set.getNString(10));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return student_detail.getEmail_id().equals(email_id) && student_detail.getStudent_password().equals(password);
	}
	
	//validation
	public boolean validate_email_id(String email_id)
	{
		Pattern email_id_pattern =Pattern.compile("([a-z]{1,15})([@][a-z]{1,5}[.][a-z && (com)]{3})");
		Matcher email_id_matcher=email_id_pattern.matcher(email_id);
		if(email_id_matcher.find())
			return true;
		return false;
	}
}
