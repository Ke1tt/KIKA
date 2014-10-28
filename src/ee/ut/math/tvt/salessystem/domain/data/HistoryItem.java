package ee.ut.math.tvt.salessystem.domain.data;

import java.util.ArrayList;

public class HistoryItem implements Cloneable, DisplayableItem {

	private double price;
	private String date;
	private String time;
	private ArrayList<SoldItem> soldItems;
	
	
	public HistoryItem(String date, String time, double price,
			ArrayList<SoldItem> soldItems) {
		super();
		this.price = price;
		this.date = date;
		this.time = time;
		this.soldItems = soldItems;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public ArrayList<SoldItem> getSoldItems() {
		return soldItems;
	}
	
	
	
}
