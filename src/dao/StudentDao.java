package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DonHang;
import bean.Student;
import connection.ConnectionProvider;

public class StudentDao {
	private Connection connection;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;

	public StudentDao() {
		connection = ConnectionProvider.getConnection();
	}
	public int getStudent (String id) {
		String query ="select * from  HOCVIEN  where MaHocVien = ?";
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if(rs.next())
			{
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	private static int count(int[] rs)
	{
		int count =0;
		for(int i : rs)
		{
			count +=i;
		}
		return count;
	}
	
	public boolean save(List<DonHang> list) {
		String query = "Insert into DonHang(TenMatHang, SoTien,TenNguoiMua)"
				+ "values(?,?,?)";
		try {
			pst = connection.prepareStatement(query);
			for (DonHang mh : list) {
				pst.setString(1,mh.getTenMatHang());
				pst.setDouble(2, mh.getSoTien());
				pst.setString(3, mh.getTenNguoiMua());
				pst.addBatch();
			}
			int[] rs = pst.executeBatch();
			return count(rs)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<DonHang> getAllDH(){
		List<DonHang> dhs = new ArrayList<>();
		String query = "Select * from DonHang";
		try {
			st = connection.createStatement();
			rs = pst.executeQuery(query);
			while (rs.next()) {
				DonHang dh = new DonHang(rs.getInt("id"), rs.getString("TenMatHang"), rs.getDouble("SoTien"), rs.getString("TenNguoiMua"));
				dhs.add(dh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dhs;
		
	}



}
