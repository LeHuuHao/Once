/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmaster.io.service;

import java.io.IOException;
import java.util.ArrayList;
import jmaster.io.model.MatHang;
import jmaster.io.model.Oto;
import jmaster.io.utils.FileIO;

/**
 *
 * @author dinhd
 */
public class MatHangService {

    final String FILE_NAME = "MH.TXT";

    public void create(	Oto matHang) throws IOException, ClassNotFoundException {
        FileIO.addMoreToList(matHang, FILE_NAME);
    }

    public ArrayList<Oto> findAll() throws IOException, ClassNotFoundException {
        return FileIO.readList(FILE_NAME);
    }

    public void delete(int maHang) throws IOException, ClassNotFoundException {
        ArrayList<Oto> matHangSauXoa = new ArrayList<Oto>();

        ArrayList<Oto> matHangHienCo = FileIO.readList(FILE_NAME);

        for (Oto matHang : matHangHienCo) {
            //chi giu lai mat hang ko co ma hang trung ma hang cần xoa, luu vao list sau xoa
            if (matHang.getMaOto() != maHang) {
                matHangSauXoa.add(matHang);
            }
        }

        FileIO.writeList(matHangSauXoa, FILE_NAME);
    }
}
