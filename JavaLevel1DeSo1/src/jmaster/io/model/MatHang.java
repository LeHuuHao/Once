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
public class MatHang implements Serializable {

    private int maHang;//số nguyên có 4 chữ số, tự động tăng
    private String tenHang;
    private String nhomHang; //Hàng thời trang, Hàng tiêu dùng, Hàng điện máy, Hàng gia dụng
    private int giaBan;

    public MatHang() {
    }

    public MatHang(int maHang, String tenHang, String nhomHang, int giaBan) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.nhomHang = nhomHang;
        this.giaBan = giaBan;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getNhomHang() {
        return nhomHang;
    }

    public void setNhomHang(String nhomHang) {
        this.nhomHang = nhomHang;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

     ///su dung cho combo box 
    @Override
    public String toString() {
        return this.tenHang;
    }
}
