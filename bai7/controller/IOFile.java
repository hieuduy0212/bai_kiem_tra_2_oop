/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuDuy
 */
public class IOFile {

    public static <T> void ra(String fname, List<T> lst) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(lst);
            System.out.println("Luu file thanh cong");
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> vao(String fname) {
        ObjectInputStream ois = null;
        List<T> lst = null;
        FileInputStream fis = null;
        try {
            if (isEmptyFile(fname)) {
                System.out.println("File trong");
                ra(fname, lst);
            } else {
                fis = new FileInputStream(fname);
                ois = new ObjectInputStream(fis);
                lst = new ArrayList<>();
                lst = (List<T>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static boolean isEmptyFile(String fname) throws IOException {
        File f = new File(fname);
        return f.length() == 1;
    }
}
