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
public class WriteDatabaseTest {
    
    public WriteDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of writeDatabase method, of class WriteDatabase.
     */
    @Test
    public void testWriteDatabase() {
        System.out.println("writeDatabase");
        String s = "Scott Purcell,8016233388,2322 North 1500 West,,Pleasant Grove,84062";
        String t = "Patron";
        WriteDatabase.writeDatabase(s, t);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
