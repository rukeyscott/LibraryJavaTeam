package patronpackage;


import java.util.Comparator;



/**
 *
 * @author jenniferschofield
 */
public class PatronSort implements Comparator<Patron>{//this class compares patrons to eachother then sorts and returns
     @Override
    public int compare(Patron o1, Patron o2) {
        if (o1.card<o2.card){//if card id is lower then return -1
            return -1;
        }
            else if (o1.card==o2.card){//if card id is the same return o(nothing)
                return 0;
            }else return 1;
        
        
    }
    
}
