/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileWriterReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Scott Purcell
 */
public class ReadDatabase {

  
   public static void readDatabase(String t) throws FileNotFoundException, IOException {//string t is the database you want to read ie: Patron, Book,Check
    BufferedReader br = new BufferedReader(new FileReader(t+".txt"));
    String line = null;

    if(t == "Patron"){
    while ((line = br.readLine()) != null) {
      String[] values = line.split(",");
      for (String str : values) {
        System.out.print(str+",");// need to send to correct class and insert in array
        
        }
      }
    }
    if(t == "Book"){
    while ((line = br.readLine()) != null) {
      String[] values = line.split(",");
      for (String str : values) {
        System.out.print(str+",");// need to send to correct class and insert in array
        
        }
      }
    }
    if(t == "C"){
    while ((line = br.readLine()) != null) {
      String[] values = line.split(",");
      for (String str : values) {
        System.out.print(str+",");// need to send to correct class and insert in array
        
        }
      }
    }
    br.close();
    
  }
}