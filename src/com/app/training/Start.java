package com.app.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to JDBC API");

		String sName = null;
		int sAge = 0;
		String sClass = null;
		String sLocation = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("Press 1 Add Student");

			System.out.println("Press 2 Delete Student");

			System.out.println("Press 3 Display Student Details by StudentId");

			System.out.println("Press 4 Display All Student Details");

			System.out.println("Press 5 Update Student");

			System.out.println("Press other Exit");

			int c = Integer.parseInt(br.readLine());

			switch (c) {
			case 1:
				System.out.println("Enter Student name");
				sName = br.readLine();

				System.out.println("Enter Student class");
				sClass = br.readLine();

				System.out.println("Enter Student age");
				sAge = Integer.parseInt(br.readLine());

				System.out.println("Enter Student Location");
				sLocation = br.readLine();

				Student s = new Student(sName, sClass, sAge, sLocation);

				Boolean result = StudentDAO.AddStudent(s);

				if (result) {
					System.out.println("Student data inserted successfully");
				} else {
					System.out.println("Insertion failed");
				}
				break;

			case 2:
				System.out.println("Enter Student id");
				int studentId = Integer.parseInt(br.readLine());

				Boolean result1 = StudentDAO.DeleteStudent(studentId);

				if (result1) {
					System.out.println("Student Deleted successfully");
				} else {
					System.out.println("Deletion failed");
				}
				break;

			case 3:
				System.out.println("Enter Student id");
				int sId = Integer.parseInt(br.readLine());

				Student rs = StudentDAO.DisplyStudentByStudentId(sId);

				if (rs != null) {
					System.out.println(rs.toString());
				} else {
					System.out.println("Display failed");
				}
				break;

			case 4:
				Student rs1 = StudentDAO.DisplayAllStudentInfo();

				if (rs1 != null) {
					//System.out.println(rs1.toString());
				} else {
					System.out.println("Display failed");
				}
				break;

			default:
				break;
			}

			if (c > 4)
				break;
		}

	}

}
