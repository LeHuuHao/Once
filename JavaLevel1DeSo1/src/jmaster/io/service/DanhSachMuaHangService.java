/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmaster.io.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import jmaster.io.model.DanhSachMuaHang;
import jmaster.io.utils.FileIO;

/**
 *
 * @author dinhd
 */
public class DanhSachMuaHangService {

    final String FILE_NAME = "QLBH.TXT";

    public void create(DanhSachMuaHang dsmh) throws IOException, ClassNotFoundException {
        FileIO.addMoreToList(dsmh, FILE_NAME);
    }

    public ArrayList<DanhSachMuaHang> findAll() throws IOException, ClassNotFoundException {
        return FileIO.readList(FILE_NAME);
    }

    //theo ten khach hang tang dan
    public ArrayList<DanhSachMuaHang> sortByTenKH() throws IOException, ClassNotFoundException {
        ArrayList<DanhSachMuaHang> mangHienCo = FileIO.readList(FILE_NAME);

        //dung anonymous class cho Comparator để so sánh cho sắp xếp list
        Collections.sort(mangHienCo, new Comparator<DanhSachMuaHang>() {
            @Override
            public int compare(DanhSachMuaHang o1, DanhSachMuaHang o2) {
                //theo ten tang dan
                return o1.getKhachHang().getHoTen().compareTo(o2.getKhachHang().getHoTen());
            }
        });

        return mangHienCo;
    }

    //theo ten Mat Hang tang dan
    public ArrayList<DanhSachMuaHang> sortByTenMH() throws IOException, ClassNotFoundException {
        ArrayList<DanhSachMuaHang> mangHienCo = FileIO.readList(FILE_NAME);

        //dung anonymous class cho Comparator để so sánh cho sắp xếp list
        Collections.sort(mangHienCo, new Comparator<DanhSachMuaHang>() {
            @Override
            public int compare(DanhSachMuaHang o1, DanhSachMuaHang o2) {
                //theo ten tang dan
                return o1.getOto().getKieuXe().compareTo(o2.getOto().getKieuXe());
            }
        });

        return mangHienCo;
    }

    //hoa don theo khach hang ma KH
    public ArrayList<DanhSachMuaHang> findByKH(int maKH) throws IOException, ClassNotFoundException {
        ArrayList<DanhSachMuaHang> mangTimDuoc = new ArrayList<DanhSachMuaHang>();

        ArrayList<DanhSachMuaHang> mangHienCo = FileIO.readList(FILE_NAME);

        for (DanhSachMuaHang dsmh : mangHienCo) {
            //chi giu lai danh sach mua hang co ma KH = maKH dang tim, them vao mang tim duoc
            if (dsmh.getKhachHang().getMaKH() == maKH) {
                mangTimDuoc.add(dsmh);
            }
        }

        return mangTimDuoc;
    }
}
