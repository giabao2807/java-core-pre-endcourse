package view;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import bean.Student;
import connection.ConnectionProvider;
import dao.StudentDao;
import utils.FileUtils;


public class Ex02 {
	private static StudentDao dao = new StudentDao();

	public static void main(String[] args) {
		// Q2:connect datatbase
		System.out.println("===============Q2============");
		Connection connection = ConnectionProvider.getConnection();
		System.out.println(connection);
		
		
		// Q3 Q4:Read data from txt
		System.out.println("===============Q3============");
		File data1 = new File("input.txt1");
		List<String> lines1 = FileUtils.readLines(data1);
		show(lines1);
		
		
		System.out.println("===============Q4============");
//		List<Student> sts = FileUtils.convert(lines1);
//		dao.save(sts);
		
		
//		System.out.println("===============Q6============");
//		File log  = new File("Error.txt");
//		List<Student> sts2 = FileUtils.convertStudent(lines1, log);
//		dao.save(sts2);
		
		System.out.println("=======Done=========");
		
	}

	private static void show(List<String> data) {
		for (String line : data) {
			System.out.println(line);
		}
	}
}
