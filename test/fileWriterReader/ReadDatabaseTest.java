/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileWriterReader;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author office
 */
public class ReadDatabaseTest {
    
    public ReadDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readDatabase method, of class ReadDatabase.
     */
    @Test
    public void testReadDatabase() throws Exception {
        String t = "Patron";
        System.out.println("reading the Database: "+ t);
        ReadDatabase.readDatabase(t);
    
 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
