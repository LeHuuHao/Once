/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmaster.io.utils;

import java.io.IOException;
import java.util.ArrayList;
import jmaster.io.model.DanhSachMuaHang;
import jmaster.io.service.DanhSachMuaHangService;

/**
 *
 * @author dinhd
 */
public class Validator {

    public static boolean isValidPhone(String phone) {
        //sdt khac null, do dai 10 va bat dau voi so 0
        return phone != null && phone.trim().length() == 10 && phone.trim().startsWith("0");
    }

    public static boolean isValidInteger(String number) {
        try {
            //ep kieu neu dc thi la so int, nguoc lai khong phai
            int no = Integer.parseInt(number);
            return no > 0;//phai la so duong
        } catch (NumberFormatException e) {
        }

        return false;
    }

    //khac null va do dai > 0
    public static boolean isRequiredString(String str) {
        return str != null && str.trim().length() > 0;
    }

    //Giả sử mỗi khách hàng không mua quá 10 loại mặt hàng
    //chú ý: cùng một khách hàng với một mặt hàng thì không thể xuất hiện 2 lần trong bảng này)
    public static boolean validateDSMH(DanhSachMuaHang dsmh) throws IOException, ClassNotFoundException {
        //1 tim dsmh cua khach hang
        DanhSachMuaHangService danhSachMuaHangService = new DanhSachMuaHangService();

        ArrayList<DanhSachMuaHang> danhSachMuaHangs = danhSachMuaHangService.findByKH(dsmh.getKhachHang().getMaKH());

        //Giả sử mỗi khách hàng không mua quá 10 loại mặt hàng
        if (danhSachMuaHangs.size() >= 10) {
            return false;//ket thuc
        }

        //TH nguoc lai
        //mot khach ko the mua 2 lan 1 mat hang
        //dung vong lap tim ma hang xem ton tai chua, so sanh voi dsmh moi nhap vao
        for (DanhSachMuaHang dsmhHienCo : danhSachMuaHangs) {
            if (dsmhHienCo.getOto().getMaOto() == dsmh.getOto().getMaOto()) {
                return false;//ket thuc
            }
        }

        //xuong day nghia la duoc phep them
        return true;
    }
}
