package bean;

import java.time.LocalDate;

public class Student {

	public String MaHocVien;
	public String TenHocVien;
	public LocalDate NgaySinh;
	public String GioiTinh;
	public float DTB;
	
	public Student()
	{

	}
	
	
	public Student(String maHocVien, String tenHocVien, LocalDate ngaySinh, String gioiTinh, float dTB) {
		super();
		MaHocVien = maHocVien;
		TenHocVien = tenHocVien;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DTB = dTB;
	}

	
	public String getMaHocVien() {
		return MaHocVien;
	}
	public void setMaHocVien(String maHocVien) {
		MaHocVien = maHocVien;
	}
	public String getTenHocVien() {
		return TenHocVien;
	}
	public void setTenHocVien(String tenHocVien) {
		TenHocVien = tenHocVien;
	}
	public LocalDate getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public float getDTB() {
		return DTB;
	}
	public void setDTB(Float dTB) {
		DTB = dTB;
	}

	@Override
	public String toString() {
		return "HocVien [MaHocVien=" + MaHocVien + ", TenHocVien=" + TenHocVien + ", NgaySinh=" + NgaySinh
				+ ", GioiTinh=" + GioiTinh + ", DTB=" + DTB + "]";
	}

}
