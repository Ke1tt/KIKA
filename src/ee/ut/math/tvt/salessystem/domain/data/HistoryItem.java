package ee.ut.math.tvt.salessystem.domain.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORY")
public class HistoryItem implements Cloneable, DisplayableItem {

	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "Price")
	private double price;
	@Column(name = "Date")
	private String date;
	@Column(name = "Time")
	private String time;
	@OneToMany(mappedBy = "historyItem")
	private List<SoldItem> soldItems;
	
	
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

	public List<SoldItem> getSoldItems() {
		return soldItems;
	}
	
	
	
}
