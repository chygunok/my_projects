/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
//import java.io.*;

/**
 * @author Ivan
 */
public class Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int n = 0;     
        ArrayList myTriangleList = new ArrayList();
        int[] tall = new int[6];
        Scanner scanner = new Scanner(new File("Test.txt"));
        int j = 0, i = 0;
        String a;
        while (scanner.hasNextInt()) {
           a = scanner.nextLine();
           String Str = new String(a);
           String[] deep = Str.split(" ");
           for (i=0;i<6;i++)
                     tall[i]=  Integer.parseInt(deep[i]);
             n++; 
            Triangle triangle;

            try {
                triangle = new Triangle(tall[0],tall[1],tall[2],tall[3],tall[4],tall[5]);
                myTriangleList.add(triangle);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
      
        } 
         TriangleComparator myTriangleComparator = new TriangleComparator();
                  myTriangleList.sort((Comparator) myTriangleComparator); 
       

        //Запись в файл по неубыванию площадей
        FileWriter writer = new FileWriter("file1.txt");
        for (i = 0; i < myTriangleList.size(); i++) {
            writer.write(myTriangleList.get(i).toString());
            writer.write("\r\n");
        }
        writer.close();
        
    }
}


