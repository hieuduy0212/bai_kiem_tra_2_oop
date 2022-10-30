/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanLySach.controller;

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

    public static <T> List<T> doc(String filename) {
        List<T> lst = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            lst = (List<T>)ois.readObject();
            ois.close();
        }catch(IOException |ClassNotFoundException e){
            e.printStackTrace();
        }
        return lst;
    }
    public static <T> void viet(String filename, List<T> lst){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(lst);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
