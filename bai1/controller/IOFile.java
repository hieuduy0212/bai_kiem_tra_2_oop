/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    public static <T> void viet(String fname, List<T> list) {
        try {
            try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fname))) {
                ous.writeObject(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> doc(String fname) throws ClassNotFoundException {
        List<T> list = new ArrayList<>();
        try {
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname))) {
                list = (List<T>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
