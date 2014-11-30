package ee.ut.math.tvt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {
	
	private StockItem item1;

	@Before
	public void setUp() {
		item1 = new StockItem((long) 1, "Porgand", "See on porgand", 2.30, 15);
	}
	
	@Test
	public void testClone() {
		assertNotSame(item1.clone(),item1);
	}
	
	@Test
	public void testGetColumn(){
		assertEquals((long)1,item1.getColumn(0));
		assertEquals("Porgand",item1.getColumn(1));
		assertEquals(2.30,item1.getColumn(2));
		assertEquals(15,item1.getColumn(3));
	}
	
}
