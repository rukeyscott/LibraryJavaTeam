/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileWriterReader;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Scott Purcell
 */
public class WriteDatabase{
    public static void writeDatabase(String s,String t) {
        
        //t = filename and s= string being written- may need to make this the corresponding array that is passed in then printed into the file
      BufferedWriter bw = null;
      try {
	 String mycontent = s;
         //Specify the file name and path here
	 File file = new File(t+".txt");

	 /* This logic will make sure that the file 
	  * gets created if it is not present at the
	  * specified location*/
	  if (!file.exists()) {
	     file.createNewFile();
	  }

	  FileWriter fw = new FileWriter(file,true);
	  bw = new BufferedWriter(fw);
	  bw.write(mycontent);
          bw.newLine();
          System.out.println("File written Successfully");

      } catch (IOException ioe) {
	   ioe.printStackTrace();
	}
	finally
	{ 
	   try{
	      if(bw!=null)
		 bw.close();
	   }catch(Exception ex){
	       System.out.println("Error in closing the BufferedWriter"+ex);
	    }
	}
   }
}
