/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.Question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author 22816
 */
public class Dictionary {
    ArrayList<String> list = new ArrayList<String>();
    public void readFile(String address){
        String s=null;
        try {
            File file = new File(address);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
            s = sc.nextLine();
            if(!s.isEmpty() && !s.equals(" ") && s.length()>4)
            list.add(s);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
         
    }
    
    public void ShuffleList(){
     Collections.shuffle(list);
    }
    
    
    public static void main(String[] args){
    Dictionary D = new Dictionary();
    BinarySearchTree BST = new BinarySearchTree();
    D.readFile("Dictionary.txt");
    D.ShuffleList();
    Iterator i = D.list.iterator();
    while (i.hasNext()) {
    String string =(String)i.next();
    String[] parts = string.split("  ");
    if(parts.length==2)
    BST.insert(parts[0],parts[1]); //save it too binary tree
    
 
    }
    System.out.println(BST.find("Afraid"));
    System.out.println(BST.find("Blacklist"));
    
   // BST.LNR(BST.root); //print binary tree
}
}

