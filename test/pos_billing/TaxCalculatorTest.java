/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atanu
 */
public class TaxCalculatorTest {
    
    public TaxCalculatorTest() {
    }
    
    static DummyDAO dao;
    
    @BeforeClass
    public static void setUpClass() {
        dao = new DummyDAO();
    }
    
    @AfterClass
    public static void tearDownClass() {
        dao=null;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    private String generateRandomID(){
        return dao.generateRandomID();
    }

    /**
     * Test of calculateTax method, of class TaxCalculator.
     */
    @Test
    public void testCalculateTax_WithItemTypeBook_NotImported() {
        System.out.println("calculateTax with item type book - not imported");
        Item item = new Item(generateRandomID(), Item.Type.BOOK, new BigDecimal("12.49"), "Harry Potter", "book", false);
        TaxCalculator instance = new TaxCalculator();
        BigDecimal expResult = new BigDecimal("0.00");
        BigDecimal result = instance.calculateTax(item);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of calculateTax method, of class TaxCalculator.
     */
    @Test
    public void testCalculateTax_WithItemTypeBook_Imported() {
        System.out.println("calculateTax with item type book - imported");
        Item item = new Item(generateRandomID(), Item.Type.BOOK, new BigDecimal("12.49"), "Harry Potter", "book", true);
        TaxCalculator instance = new TaxCalculator();
        BigDecimal expResult = new BigDecimal("0.63");
        BigDecimal result = instance.calculateTax(item);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of calculateTax method, of class TaxCalculator.
     */
    @Test
    public void testCalculateTax_WithItemTypeOthers_NotImported() {
        System.out.println("calculateTax with item type other - not imported");
        Item item = new Item(generateRandomID(), Item.Type.OTHERS, new BigDecimal("12.49"), "Perfume", "perfume local", false);
        TaxCalculator instance = new TaxCalculator();
        BigDecimal expResult = new BigDecimal("1.25");
        BigDecimal result = instance.calculateTax(item);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of calculateTax method, of class TaxCalculator.
     */
    @Test
    public void testCalculateTax_WithItemTypeOthers_Imported() {
        System.out.println("calculateTax with item type other - imported");
        Item item = new Item(generateRandomID(), Item.Type.OTHERS, new BigDecimal("12.49"), "Perfume", "perfume local", true);
        TaxCalculator instance = new TaxCalculator();
        BigDecimal expResult = new BigDecimal("1.88");
        BigDecimal result = instance.calculateTax(item);
        assertEquals(expResult, result);
        
    }
    
}
