package ee.ut.math.tvt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseInfoTableModelTest {
	
	private StockItem item1;
	private StockItem item2;
	private SoldItem sold;
	private SoldItem sold2;
	
	@Before
	public void setUp() {
		item1 = new StockItem((long) 1, "Porgand", "See on porgand", 2.30, 15);
		item2 = new StockItem((long) 2, "Dipikaste", "See on porgandi jaoks", 3, 30);
		sold = new SoldItem(item1, 2);
		sold2 = new SoldItem(item2, 4);
	}

	@Test
	public void testGetColumnValue(){
		assertEquals((long)1,item1.getColumn(0));
		assertEquals("Porgand",item1.getColumn(1));
		assertEquals(2.30,item1.getColumn(2));
		assertEquals(15,item1.getColumn(3));
	}
	
	@Test
	public void testHasEnoughInStock() {
		PurchaseInfoTableModel model = new PurchaseInfoTableModel();
		assertTrue(model.checkQuantity(item1, 5));
		assertFalse(model.checkQuantity(item1, 25));
	}
	
	@Test
	public void testAddSoldItem() {
		PurchaseInfoTableModel model = new PurchaseInfoTableModel();
		model.addItem(sold);
		assertSame(model.getItemById(sold.getId()), sold);
	}
	
	@Test
	public void testGetSumWithNoItems() {
		PurchaseInfoTableModel model = new PurchaseInfoTableModel();
		assertEquals(model.totalSum(), 0, 0.001);
	}
	
	@Test
	public void testGetSumWithOneItem(){
		PurchaseInfoTableModel model = new PurchaseInfoTableModel();
		model.addItem(sold);
		assertEquals(model.totalSum(), 4.60, 0.001);
	}

	@Test
	public void testGetSumWithMultipleItems(){
		PurchaseInfoTableModel model = new PurchaseInfoTableModel();
		model.addItem(sold);
		model.addItem(sold2);
		assertEquals(model.totalSum(), 16.6, 0.001);
	}
	
	@Test
	public void testItemInShopingCart(){
		PurchaseInfoTableModel model = new PurchaseInfoTableModel();
		model.addItem(sold);
		assertEquals(model.itemInShoppingCart((long)1), sold);
	}
	
	@Test
	public void testItemNotInShopingCart(){
		PurchaseInfoTableModel model = new PurchaseInfoTableModel();
		model.addItem(sold);
		assertEquals(model.itemInShoppingCart((long)4), null);
	}
	
}
