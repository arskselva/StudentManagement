package com.app.training;

import java.sql.*;

public class StudentDAO {

	public static boolean AddStudent(Student student) {
		Boolean result = false;

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionProvider.CreateConnection();

			String query = "insert into student(name,class,sage,slocation) values (?,?,?,?)";

			ps = con.prepareStatement(query);

			ps.setString(1, student.getsName());
			ps.setString(2, student.getsClass());
			ps.setInt(3, student.getsAge());
			ps.setString(4, student.getsLocation());

			ps.executeUpdate();

			con.close();

			result = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public static boolean DeleteStudent(int studentId) {

		Boolean result = false;

		String query = "delete from student where studentId=?";
		try (Connection con = ConnectionProvider.CreateConnection();
				PreparedStatement ps = con.prepareStatement(query);) {

			ps.setInt(1, studentId);

			int s = ps.executeUpdate();

			con.close();

			if (s != 0)
				result = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static Student DisplyStudentByStudentId(int studentId) {

		int sId = 0;
		String sName = null;
		String sClass = null;
		int sAge = 0;
		String sLocation = null;
		Student st = new Student();

		String query = "select * from student where studentId=?";

		try (

				Connection con = ConnectionProvider.CreateConnection();
				PreparedStatement ps = con.prepareStatement(query);

		) {

			ps.setInt(1, studentId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				sId = rs.getInt("studentId");

				sName = rs.getString("name");

				sClass = rs.getString("class");

				sAge = rs.getInt("sAge");

				sLocation = rs.getString("sLocation");

				st.setStudentId(sId);

				st.setsName(sName);

				st.setsClass(sClass);

				st.setsAge(sAge);

				st.setsLocation(sLocation);

				// System.out.println(st.toString());

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return st;
	}

	public static Student DisplayAllStudentInfo() {
		int sId = 0;
		String sName = null;
		String sClass = null;
		int sAge = 0;
		String sLocation = null;
		Student st = new Student();

		String query = "select * from student";

		try (

				Connection con = ConnectionProvider.CreateConnection();
				Statement cr = con.createStatement();
				ResultSet rs = cr.executeQuery(query);

		) {

			while (rs.next()) {
				sId = rs.getInt("studentId");

				sName = rs.getString("name");

				sClass = rs.getString("class");

				sAge = rs.getInt("sAge");

				sLocation = rs.getString("sLocation");

				st.setStudentId(sId);

				st.setsName(sName);

				st.setsClass(sClass);

				st.setsAge(sAge);

				st.setsLocation(sLocation);

				System.out.println(st.toString());

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return st;
	}

	public static boolean UpdateStudent(int studentId, String sName, int sAge, String sClass, String sLocation) {
		Boolean result = false;
		try {
			Connection con = ConnectionProvider.CreateConnection();

			String query = "update student name=?,class=?,sage=?,sLocation=? where studentId=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, sName);
			
			ps.setString(2,  sClass);
			
			ps.setInt(3, sAge);
			
			ps.setString(4, sLocation);
			
			ps.setInt(5, studentId);

			int s = ps.executeUpdate();

			con.close();

			if (s != 0)
				result = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
