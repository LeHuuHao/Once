/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmaster.io.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author dinhd
 */
public class FileIO {

    //ghi 1 list xuong file
    public static void writeList(ArrayList data, String fileURI) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileURI);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
        outputStream.close();
    }

    //doc len 1 list
    public static ArrayList readList(String fileURI) throws IOException, ClassNotFoundException {
        File file = new File(fileURI);
        if (file.exists()) {
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Object obj = objectInputStream.readObject();
            if (obj != null) {
                return (ArrayList) obj; //ep kieu sang list
            }
        }
        return new ArrayList();//tra ve list trong
    }
    
     //ghi 1 doi tuong vao file
    public static void writeOne(Object obj, String fileURI) throws IOException, ClassNotFoundException {
        FileOutputStream outputStream = new FileOutputStream(fileURI);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        outputStream.close();
    }

    //doc len 1 list
    public static Object readOne(String fileURI) throws IOException, ClassNotFoundException {
        File file = new File(fileURI);
        if (file.exists()) {
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Object obj = objectInputStream.readObject();
            if (obj != null) {
                return obj; 
            }
        }
        return null;//tra ve null
    }
    
    //ghi them vao mang xuong file
    public static void addMoreToList(Object obj, String fileURI) throws IOException, ClassNotFoundException {
        ArrayList data = readList(fileURI);
        data.add(obj);
        writeList(data, fileURI);
    }

}
