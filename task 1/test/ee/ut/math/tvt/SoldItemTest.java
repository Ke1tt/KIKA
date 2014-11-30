package ee.ut.math.tvt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {
	
	private StockItem item1;
	
	@Before
	public void setUp() {
		item1 = new StockItem((long) 1, "Porgand", "See on porgand", 2.30, 15);
	}
	
	@Test
	public void testGetSum() {
		SoldItem sold = new SoldItem(item1, 3);
		assertEquals(6.90,sold.getSum(),0.001);
	}
	
	@Test
	public void testGetSumWithZeroQuantity() {
		SoldItem sold = new SoldItem(item1, 0);
		assertEquals(0,sold.getSum(), 0.001);
	}

}
