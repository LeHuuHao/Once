/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmaster.io.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinhd
 */
public class IDGenerator {
    private static final String MA_KH_FILE = "MaKH.txt";
    private static final String MA_MH_FILE = "MaMH.txt";

    public static int getMHID() {
        int value = 1000;//4 chu so

        //doc ma kh tu file
        try {
            Object obj = FileIO.readOne(MA_MH_FILE);
            if (obj != null) {
                value = (int) obj;
            }
        } catch (Exception ex) {
            Logger.getLogger(IDGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        value++;//tu dong tang len 1

        //update lai file
        try {
            FileIO.writeOne(value, MA_MH_FILE);
        } catch (Exception ex) {
            Logger.getLogger(IDGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        //tra ve
        return value;
    }

    public static int getKHID() {
        int value = 10000;//5 chu so

        //doc ma kh tu file
        try {
            Object obj = FileIO.readOne(MA_KH_FILE);
            if (obj != null) {
                value = (int) obj;
            }
        } catch (Exception ex) {
        }

        value++;//tu dong tang len 1

        //update lai file
        try {
            FileIO.writeOne(value, MA_KH_FILE);
        } catch (Exception ex) {
        }

        //tra ve
        return value;
    }
}
