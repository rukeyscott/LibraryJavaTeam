/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check;

import java.util.Comparator;

/**
 *
 * @author jenniferscofield
 */
public class CheckSort implements Comparator<Check>{
     @Override
    public int compare(Check o1, Check o2) {
        if (o1.bookid<o2.bookid){
            return -1;
        }
            else if (o2.bookid==o1.bookid){
                return 0;
            }else return 1;
        
        
    }
    
}
