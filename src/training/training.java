package training;

//package com.hcl.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class training {
    //creates a dnyamic array;stores the duplicate elements of different data types, maintains insertion order
    //non synchronized
    
    public static void main(String[] args) {
        //Generics ->making sure that its type safety
         
        List<Double> list2=new ArrayList<>();//run time polymorphism
         
        
        list2.add(90.89);
        list2.add(32.78);
        list2.add(45.20);
        
    
        Iterator<Double> itr=list2.iterator();
        double total = 0; 
        while(itr.hasNext()) {
            total += itr.next();
        }
        System.out.print(total);
        
    }
}


