/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_billing;

import java.math.BigDecimal;
import java.util.ArrayList;
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
public class BillHandlerTest {
    
    public BillHandlerTest() {
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
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithSingleItem() {
        System.out.println("addItemToBill");
        Item item = new Item(generateRandomID(), Item.Type.BOOK, new BigDecimal("12.49"), "Harry Potter", "book", false);
        int quantity = 1;
        BigDecimal expTotalBasePrice = new BigDecimal("12.49");
        BigDecimal expTotalSalesTax = new BigDecimal("0.00");
        BillHandler instance = new BillHandler();
        instance.addItemToBill(item, quantity);
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithMultipleItems() {
        System.out.println("addItemToBill");
        ArrayList<Item> items = dao.queryOne();
        int quantity = 1;
        BigDecimal expTotalBasePrice = new BigDecimal("28.33");
        BigDecimal expTotalSalesTax = new BigDecimal("1.50");
        BillHandler instance = new BillHandler();
        items.forEach( item -> instance.addItemToBill(item, quantity));
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
}
