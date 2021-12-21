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
public class KhachHang implements Serializable {
    
    private int maKH;//mã KH là một số nguyên có 5 chữ số, tự động tăng
    private String hoTen;
    private String loaiXeThue;
    private int soXeThue;

    public KhachHang() {
    }


    public KhachHang(int maKH, String hoTen, String loaiXeThue, int soXeThue) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.loaiXeThue = loaiXeThue;
		this.soXeThue = soXeThue;
	}


	public int getMaKH() {
		return maKH;
	}


	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getLoaiXeThue() {
		return loaiXeThue;
	}


	public void setLoaiXeThue(String loaiXeThue) {
		this.loaiXeThue = loaiXeThue;
	}


	public int getSoXeThue() {
		return soXeThue;
	}


	public void setSoXeThue(int soXeThue) {
		this.soXeThue = soXeThue;
	}


	///su dung cho combo box 
    @Override
    public String toString() {
        return this.hoTen;
    }

}
