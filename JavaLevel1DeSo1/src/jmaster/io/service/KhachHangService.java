/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmaster.io.service;

import java.io.IOException;
import java.util.ArrayList;
import jmaster.io.model.KhachHang;
import jmaster.io.utils.FileIO;

/**
 *
 * @author dinhd
 */
public class KhachHangService {

    final String FILE_NAME = "KH.TXT";

    public void create(KhachHang khachHang) throws IOException, ClassNotFoundException {
        FileIO.addMoreToList(khachHang, FILE_NAME);
    }

    public ArrayList<KhachHang> findAll() throws IOException, ClassNotFoundException {
        return FileIO.readList(FILE_NAME);
    }

    public void delete(int maKH) throws IOException, ClassNotFoundException {
        ArrayList<KhachHang> mangSauXoa = new ArrayList<KhachHang>();

        ArrayList<KhachHang> mangHienCo = FileIO.readList(FILE_NAME);

        for (KhachHang khachHang : mangHienCo) {
            //chi giu lai mat hang ko co ma hang trung ma hang cần xoa, luu vao list sau xoa
            if (khachHang.getMaKH() != maKH) {
                mangSauXoa.add(khachHang);
            }
        }

        FileIO.writeList(mangSauXoa, FILE_NAME);
    }
}
