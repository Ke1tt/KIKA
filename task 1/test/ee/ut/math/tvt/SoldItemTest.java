package ee.ut.math.tvt;

import static org.junit.Assert.*;

import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {
	
	@Before
	public void setUp() {
		stock1 = new StockItem(1, "Porgand", "See on porgand", 2.30, 15);
		item1 = new SoldItem(stock1, 3);
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
