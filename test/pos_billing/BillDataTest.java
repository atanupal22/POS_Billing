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
public class BillDataTest {
    
    public BillDataTest() {
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
    
    
    ArrayList<Item> items;
    int quantity;
    BillData instance;
    Item item;
    @Before
    public void setUp() {
        items = dao.queryOne();
        item = items.get(0);
        quantity = quantity = (int)(Math.random()*100+1);
        instance = new BillData();    }
    
    @After
    public void tearDown() {
        items.clear();
        item = null;
        quantity = 0;
        instance = null;
    }
    
    private void sysOutPrint(String text){
        System.out.println("Class :: " + instance.getClass().getName() + ", " + text);
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithSingleItem() {
        quantity = 1;
        
        BigDecimal expTotalBasePrice = new BigDecimal("12.49");
        BigDecimal expTotalSalesTax = new BigDecimal("0.00");
        
        sysOutPrint("Method : addItemToBill single item & " + quantity + " quantity");
        
        instance.addItemToBill(item, quantity);
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithSingleItemAndRandomQuantity() {
        BigDecimal expTotalBasePrice = new BigDecimal("12.49").multiply(new BigDecimal(quantity));
        BigDecimal expTotalSalesTax = new BigDecimal("0.00").multiply(new BigDecimal(quantity));
        
        sysOutPrint("Method : addItemToBill single item & " + quantity + " quantity");
        
        instance.addItemToBill(item, quantity);
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithMultipleLocalItems() {
        quantity = 1;
        
        BigDecimal expTotalBasePrice = new BigDecimal("28.33");
        BigDecimal expTotalSalesTax = new BigDecimal("1.50");
        
        sysOutPrint("Method : addItemToBill multiple local items & " + quantity + " quantity");
        
        items.forEach( item -> instance.addItemToBill(item, quantity));
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithMultipleLocalItemsAndDoubleQuantity() {
        BigDecimal expTotalBasePrice = new BigDecimal("28.33").multiply(new BigDecimal(quantity));
        BigDecimal expTotalSalesTax = new BigDecimal("1.50").multiply(new BigDecimal(quantity));
        
        sysOutPrint("Method : addItemToBill multiple local items & " + quantity + " quantity");
        
        items.forEach( item -> instance.addItemToBill(item, quantity));
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithMultipleImportedItems() {
        quantity = 1;
        items = dao.queryTwo();
        
        BigDecimal expTotalBasePrice = new BigDecimal("57.50");
        BigDecimal expTotalSalesTax = new BigDecimal("7.63");
        
        sysOutPrint("Method : addItemToBill multiple imported items & " + quantity + " quantity");
        
        items.forEach( item -> instance.addItemToBill(item, quantity));
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithMultipleImportedItemsAndDoubleQuantity() {
        items = dao.queryTwo();
        
        BigDecimal expTotalBasePrice = new BigDecimal("57.50").multiply(new BigDecimal(quantity));
        BigDecimal expTotalSalesTax = new BigDecimal("7.63").multiply(new BigDecimal(quantity));
        
        sysOutPrint("Method : addItemToBill multiple imported items & " + quantity + " quantity");
        
        items.forEach( item -> instance.addItemToBill(item, quantity));
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithMultipleMixedItems() {
        quantity = 1;
        items = dao.queryThree();
        
        BigDecimal expTotalBasePrice = new BigDecimal("67.98");
        BigDecimal expTotalSalesTax = new BigDecimal("6.67");
        
        sysOutPrint("Method : addItemToBill multiple mixed(local+imported) items & " + quantity + " quantity");
        
        items.forEach( item -> instance.addItemToBill(item, quantity));
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
    
    /**
     * Test of addItemToBill method, of class BillHandler.
     */
    @Test
    public void testAddItemToBill_WithMultipleMixedItemsAndDoubleQuantity() {
        items = dao.queryThree();
        
        BigDecimal expTotalBasePrice = new BigDecimal("67.98").multiply(new BigDecimal(quantity));
        BigDecimal expTotalSalesTax = new BigDecimal("6.67").multiply(new BigDecimal(quantity));
        
        sysOutPrint("Method : addItemToBill multiple mixed(local+imported) items & " + quantity + " quantity");
        
        items.forEach( item -> instance.addItemToBill(item, quantity));
        assertEquals(expTotalBasePrice, instance.getTotalBasePrice());
        assertEquals(expTotalSalesTax, instance.getTotalSalesTax());
    }
}
