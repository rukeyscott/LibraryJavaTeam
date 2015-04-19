package libarypackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import patronpackage.Patron;
import check.Check;
import book.Book;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jenniferschofield
 */
public class Libary {
    ArrayList <Book> books;
    ArrayList <Patron> patrons;
    ArrayList <Check> checkeds;
    int lastbook;
    int lastpatron;
    LocalDate currentdate;
    File lib;
    public Libary() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
        checkeds=new ArrayList<>();
        lastbook=0;
        lastpatron=0;
        currentdate= LocalDate.of (2015,1,1);
        
        
    }
    public void addbook(Book b){
        b.addid(lastbook++);
        allbooks();
        books.add(b);
    }
    public void addPatron(Patron p){
        p.addcard(lastpatron++);
        System.out.print(p.toString());
        patrons.add(p);
    }
    public int checkout(int card, int item){
        for(Patron p : patrons){
            if (p.ispatron(card)){
                for (Book b: books){
                    if (b.isBook(item)){
                        int days=b.cancheckout(p.cancheckout());
                        if (days>0){
                            b.checkout();
                            p.checkout();
                            checkeds.add(new Check (card, item, days,currentdate));
                            return 1;
                        }
                        return 0;
                  }
                }
            }     
        }
        return 0;
    }
    public boolean checkin (int item){
        for (Check c: checkeds){
            if (c.ischeckedout(item)){
                int card=c.getpatroncard();
                for (Book b : books){
                    if (b.isBook(item)){
                        for (Patron p: patrons){
                            if (p.ispatron(card)){
                                p.checkIn();
                                b.checkin();
                                checkeds.remove(c);
                                return true;
                            }
                        }
                    }
                    
                }
                
            }
        }
        return false;
    }
    public boolean removebook (int item){
        for (Book b: books){
            if (b.isBook(item)){
                books.remove(b);
                return true;
            }
        }
        return false;
    }
    public boolean removepatron(int card){
        for (Patron p: patrons){
            if (p.ispatron(card)){
                patrons.remove(p);
                return true;
            }
        }
        return false;
        
    }
    
 
    public void open (File f) throws FileNotFoundException, IOException{
        lib=f;
        String line;
        try {
                    java.io.BufferedReader ip;
                    ip = new java.io.BufferedReader(new java.io.FileReader(lib));
                    lastbook =ip.read();
                    lastpatron=ip.read();
                    line =ip.readLine();
                    while (line !=null){
                        switch (line.charAt(0)){
                            case 'B':
                                books.add(new Book(line));
                                break;
                            case 'P':
                                patrons.add(new Patron(line));
                                break;
                            case 'C':
                                checkeds.add(new Check (line));
                                break;
                        } 
                    }
         } catch (FileNotFoundException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }
    public void save() throws FileNotFoundException{
        try {
            java.io.BufferedWriter outputstream;
            outputstream = new java.io.BufferedWriter(new
                java.io.OutputStreamWriter(new java.io.FileOutputStream(lib)));
            outputstream.write(lastbook);
            outputstream.write(lastpatron);
            for (Book b : books){
                outputstream.write(b.toString());
                outputstream.newLine();
            }
            for (Patron p: patrons){
                outputstream.write(p.toString());
                outputstream.newLine();
            }
            for (Check c : checkeds){
                outputstream.write(c.toString());
                outputstream.newLine();
            }
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Libary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateDate( LocalDate d){
        currentdate=d;
    }
    public String allbooks(){
        String list="";
        for(Book b : books){
            list=list+b.toString()+'\n';
        }
        System.out.print(list);
        return list;
    }
    public String patronbooks(int card){
        String list="";
        for (Check c: checkeds){
            if (c.ispatron(card)){
                int bid=c.getbookid();
                for (Book b: books){
                    if (b.isBook(bid)){            
                       list=list+b.toString()+'\n';
                    }
                }
            }
        }
        System.out.print(list);
        return list;
    }
        public String overduebooks(){
        String list="";
        for (Check c: checkeds){
            if (c.overdue(currentdate)){
                int bid=c.getbookid();
                for (Book b: books){
                    if (b.isBook(bid)){            
                       list=list+b.toString()+'\n';
                    }
                }
            }
        }
        System.out.print(list);
        return list;
    }
    
}
