/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmaster.io.model;

import java.io.Serializable;

/**
 *
 * @author dinhd
 */
public class DanhSachMuaHang implements Serializable {

    private KhachHang khachHang;
    private Oto oto;
    private int soLuong;

    public DanhSachMuaHang() {
    }

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Oto getOto() {
		return oto;
	}

	public void setOto(Oto oto) {
		this.oto = oto;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

   
  

}
