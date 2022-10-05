/*CREATE DATABASE School_db;*/
USE School_db;

/*CREATE TABLE Admin
(
Name varchar(25),
Email_id varchar(35),
Password varchar(10),
Mobile_number varchar(12)
);

INSERT INTO Admin VALUES
("Admin","admin@gmail.com","admin","9876543210");*/

/*DROP TABLE Staff;
/*CREATE TABLE IF NOT EXISTS Staff
(
Staff_id varchar(8) NOT NULL,
Name varchar(25),
Email_Id varchar(35),
Password varchar(10),
Mobile_number varchar(12),
Standard_incharge varchar(3),
Notification_Id varchar(5) NULL,
PRIMARY KEY(Staff_id)
);

INSERT INTO Staff VALUES
("EF202201","Hariharan","hariharan@gmail.com","efhari1","9898989898","1A",NULL),
("EF202202","Madhu","madhu@gmail.com","efmadhu2","9797979797","1B",NULL),
("EF202203","Nilan","nilan@gmail.com","efnilan3","9696969696","2A",NULL),
("EF202204","Dhivya","dhivya@gmail.com","efdhivya4","9595959595","2B",NULL);*/


	/*DROP TABLE Student;*/
    /*CREATE TABLE IF NOT EXISTS Student
    (
    Student_Id varchar(10) NOT NULL,
    Staff_Incharge_Id varchar(25) NOT NULL,
    Student_Name varchar(25) NOT NULL,
    Email_Id varchar(35) NOT NULL,
    Student_Password varchar(25) NOT NULL,
    Mobile_Number varchar(10) NOT NULL,
    Standard varchar(3) ,
    Is_live_data boolean,
    Guardian_Name varchar(25),
    Emergency_Contact varchar(10),
    PRIMARY KEY(Student_Id),
    FOREIGN KEY(Staff_Incharge_Id) REFERENCES Staff(Staff_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT student_uc UNIQUE(Email_Id,Mobile_Number)
    );
    
    INSERT INTO Student VALUES
    ("ST202201","EF202201","Uma","uma@gmail.com","stuma1","9090909090","1A",true,"Maheshwari","9191919191"),
    ("ST202202","EF202201","Ram","ram@gmail.com","stram2","9999999999","1A",true,"Magizhini","9098909890"),
    ("ST202203","EF202201","Somu","somu@gmail.com","stsomu3","8888888888","1A",true,"Nagesh","8989898989"),
    ("ST202204","EF202201","Krishna","krishna@gmail.com","stkrishna1","8080808080","1A",true,"Shivam","8098098098"),
    ("ST202205","EF202202","Shiva","shiva@gmail.com","stshiva5","8089808980","1B",true,"Maheshwari","9191919191"),
    ("ST202206","EF202202","Goutham","goutham@gmail.com","stgoutham6","7878787878","1B",true,"Maheshwaran","9191976544"),
    ("ST202207","EF202202","Arul","arul@gmail.com","starul7","9192939495","1B",true,"Kumaran","9292929292"),
    ("ST202208","EF202202","Arun","arun@gmail.com","starun8","7676767676","1B",true,"Shruthi","9695969596"),
    ("ST202209","EF202202","Latha","latha@gmail.com","stlatha9","8789878987","1B",true,"Mahesh","8980878690"),
    ("ST2022010","EF202202","kumar","kumar@gmail.com","stkumar10","7777777777","1B",true,"Dhinesh","7878989890");*/
    
   /* DROP TABLE StudentAttendance;*/
   Select * From StudentAttendance
  /*  CREATE TABLE IF NOT EXISTS StudentAttendance
    (
    Student_Id varchar(25) NOT NULL,
    Attendance_Date date NOT NULL,
    Staff_Incharge_Id varchar(25) NOT NULL,
    Student_Standard varchar(3) NOT NULL,
    Attendance_Record varchar(8) NOT NULL,
    Is_Holiday boolean ,
    Is_Absent boolean,
    Has_Approval boolean,
    Instruction varchar(40),
    PRIMARY KEY(Student_Id,Attendance_Date)
    );
    
    INSERT INTO StudentAttendance VALUES
    ("ST202201","2022-10-04","EF202201","1A","Present",false,false,false,NULL),
   ("ST202202","2022-10-04","EF202201","1A","Present",false,false,false,NULL),
   ("ST202203","2022-10-04","EF202201","1A","Leave",false,true,true,"approved leave"),
   ("ST202204","2022-10-04","EF202201","1A","Absent",false,false,false,"Need reason and proof");*/
   

    
    CREATE TABLE IF NOT EXISTS Leave_Notification
    (
    Notification_id varchar(10) NOT NULL,
    Notification_type varchar(35),
    Requested_Student_Id varchar(25),
    From_date date,
    To_date date,
    Approver_Staff_Id varchar(10),
    Request_reason varchar(35),
    Request_status varchar(15),
    is_live_request boolean,
    PRIMARY KEY(Notification_id)
    );
   
   INSERT INTO Leave_Notification VALUES
   ("L1","Leave request","ST202203","2022-10-04","2022-10-04","EF202201","Sick","Approved",false);
   SELECT * FROM Staff;

SELECT * FROM Student;