package ee.ut.math.tvt;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {
	
	private StockItem item1;
	private StockItem item2;

	@Before
	public void setUp() {
		item1 = new StockItem((long) 1, "Porgand", "See on porgand", 2.30, 15);
		item2 = new StockItem((long) 1, "Dipikaste", "See voib olla porgand", 3.0, 3);
	}
	
	@Test (expected = VerificationFailedException.class)
	public void testValidateNameUniqueness()  throws VerificationFailedException {
		StockTableModel model = new StockTableModel();
		model.addItem(item1);
		model.addItem(item2);
	}
	
	//testHasEnoughInStock() is in PurchaseInfoTableModelTest because the method is in that class

	@Test
	public void testGetItemByIdWhenItemExists() throws VerificationFailedException {
		StockTableModel model = new StockTableModel();
		model.addItem(item1);
		assertSame(model.getItemById(item1.getId()), item1);
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException() throws VerificationFailedException {
		StockTableModel model = new StockTableModel();
		model.addItem(item1);
		model.getItemById(9999);
	}
	
	@Test
	public void testGetColumnValue(){
		assertEquals((long)1,item1.getColumn(0));
		assertEquals("Porgand",item1.getColumn(1));
		assertEquals(2.30,item1.getColumn(2));
		assertEquals(15,item1.getColumn(3));
	}
}
