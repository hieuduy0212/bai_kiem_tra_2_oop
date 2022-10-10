/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1.controller;

import bai1.model.IntlPhoneNumber;
import bai1.model.PhoneNumber;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuDuy
 */
public class PhoneBook {
    private List<PhoneNumber> listPN;
    private List<IntlPhoneNumber> listIPN;
    public PhoneBook(){
        listPN  = new ArrayList<>();
        listIPN  = new ArrayList<>();
    }
    
    
}
