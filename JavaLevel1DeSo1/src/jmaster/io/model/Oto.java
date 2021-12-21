package jmaster.io.model;

import java.io.Serializable;

public class Oto implements Serializable{
	private int maOto;
    private String kieuXe;
    private int soTienThue; 
    private int soXe;
	public Oto() {
		
	}
	public Oto(int maOto, String kieuXe, int soTienThue, int soXe) {
		super();
		this.maOto = maOto;
		this.kieuXe = kieuXe;
		this.soTienThue = soTienThue;
		this.soXe = soXe;
	}
	public int getMaOto() {
		return maOto;
	}
	public void setMaOto(int maOto) {
		this.maOto = maOto;
	}
	public String getKieuXe() {
		return kieuXe;
	}
	public void setKieuXe(String kieuXe) {
		this.kieuXe = kieuXe;
	}
	public int getSoTienThue() {
		return soTienThue;
	}
	public void setSoTienThue(int soTienThue) {
		this.soTienThue = soTienThue;
	}
	public int getSoXe() {
		return soXe;
	}
	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.kieuXe;
	}

}
