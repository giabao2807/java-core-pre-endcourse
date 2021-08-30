package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.DonHang;
import bean.Student;
import dao.StudentDao;

public class FileUtils {

	private FileUtils() {

	}

	public static List<DonHang> convertDH(List<String> lines){
		List<DonHang> rs = new ArrayList<>();
		int id=0;
		for (String line : lines) {
			String[] tmps = line.split(",");
			if (tmps.length == 3) {
				DonHang dh = new DonHang(++id, tmps[0], Double.valueOf(tmps[1]), tmps[2]);
				rs.add(dh);
			}
		}
		return rs;
	}
	public static List<Student> convert(List<String> lines) {
		List<Student> rs = new ArrayList<>();
		for (String line : lines) {
			List<String> tmps = new ArrayList<>();
			tmps.add(line.substring(0, 10));
			tmps.add(line.substring(10, 60));
			tmps.add(line.substring(60, 70));
			tmps.add(line.substring(70, 73));
			tmps.add(line.substring(73, 76));
			if (tmps.size() == 5) {;
				String mahv = tmps.get(0);
				String tenhv = line.substring(10, 60).trim();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dateofBirth = LocalDate.parse(line.substring(60, 70), dtf);
				String gt = line.substring(70, 73);
				float dtb = Float.parseFloat(line.substring(73, 76));
				Student h1 = new Student(mahv,tenhv,dateofBirth,gt,dtb);
				rs.add(h1);
			}
		}
		return rs;
	}
	
	public static List<Student> convertStudent(List<String> listst,File log){
		List<Student> rs = new ArrayList<>();
		List<String> fileErrorLog = new ArrayList<>();
		for (int i = 0; i < listst.size(); i++) {
			List<String> tmps = new ArrayList<>();
			tmps.add(listst.get(i).substring(0,10));
			tmps.add(listst.get(i).substring(10, 60));
			tmps.add(listst.get(i).substring(60, 70));
			tmps.add(listst.get(i).substring(70, 73));
			tmps.add(listst.get(i).substring(73, 76));
			boolean isValid = writelog(i, tmps.get(2), fileErrorLog);
			if(isValid) {
				continue;
			}
			if (tmps.size() == 5) {;
				String mahv = tmps.get(0);
				String tenhv = listst.get(i).substring(10, 60).trim();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dateofBirth = LocalDate.parse(listst.get(i).substring(60, 70), dtf);
				String gt = listst.get(i).substring(70, 73);
				float dtb = Float.parseFloat(listst.get(i).substring(73, 76));
				Student h1 = new Student(mahv,tenhv,dateofBirth,gt,dtb);
				rs.add(h1);
			}
		}
		try {
			Files.write(log.toPath(), fileErrorLog, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static boolean isDate(String s) 
	{
		try
		{
			String nam = null;
			String thang = null;
			String ngay=null;
			Pattern pattern = Pattern.compile("(?<day>\\d{1,3})/(?<month>\\d{1,3})/(?<year>\\d{3,5})");
			Matcher matcher = pattern.matcher(s);
			while(matcher.find())
			{
			nam = matcher.group("year").toString();
			thang = matcher.group("month").toString();
			ngay = matcher.group("day").toString();
			}
			int a = Integer.parseInt(nam);
			int b = Integer.parseInt(thang);
			int c = Integer.parseInt(ngay);
			if (!ktra(a,b,c))
			{
				return false;
			}
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	public static boolean ktra(int a, int b, int c)
	{
		if(a<0||a>2021||b<1||b>12||c<0||c>31)
		{
			return false;
		}
		else
			if (b ==2 &&c>29)
			{
				return false;
			}
		return true;
	}
	private static boolean writelog(int i, String dateofBirth, List<String> fileErrorLogs) {
		boolean error = false;
		List<String> logs = new ArrayList<>();

		if (!isDate(dateofBirth)) {
			error = true;
			logs.add("Lỗi định dạng ngày sinh!");
		}
		if (error == true) {
			String logError = String.join(", ", logs.toArray(String[]::new));
			String finallog = "Dong " + i + ": " + logError;
			fileErrorLogs.add(finallog);
		}
		return error;
	}
	public static List<String> readLines(File file){
			try {
				return Files.readAllLines(file.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return Collections.emptyList();
	}
	

}
