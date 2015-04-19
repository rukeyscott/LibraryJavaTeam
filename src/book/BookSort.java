package book;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jenniferschofield
 */

import java.util.Comparator;
public class BookSort implements Comparator<Book>{
     @Override
    public int compare(Book o1, Book o2) {
        if (o1.id<o2.id){
            return -1;
        }
            else if (o1.id==o2.id){
                return 0;
            }else return 1;
        
        
    }
    
}
