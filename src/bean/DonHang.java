package bean;

public class DonHang {
	private int id;
	private String TenMatHang;
	private Double SoTien;
	private String TenNguoiMua;
	public DonHang() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMatHang() {
		return TenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		TenMatHang = tenMatHang;
	}

	public Double getSoTien() {
		return SoTien;
	}

	public void setSoTien(Double soTien) {
		SoTien = soTien;
	}

	public String getTenNguoiMua() {
		return TenNguoiMua;
	}

	public void setTenNguoiMua(String tenNguoiMua) {
		TenNguoiMua = tenNguoiMua;
	}

	public DonHang(int id, String tenMatHang, Double soTien, String tenNguoiMua) {
		super();
		this.id = id;
		TenMatHang = tenMatHang;
		SoTien = soTien;
		TenNguoiMua = tenNguoiMua;
	}

	@Override
	public String toString() {
		return "DonHang [id=" + id + ", TenMatHang=" + TenMatHang + ", SoTien=" + SoTien + ", TenNguoiMua="
				+ TenNguoiMua + "]";
	}
	

	
	
	
}
