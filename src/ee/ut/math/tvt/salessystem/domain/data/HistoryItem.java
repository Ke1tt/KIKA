package ee.ut.math.tvt.salessystem.domain.data;


import java.util.ArrayList;
import java.util.Date;
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
	private Date soldTime;
	@OneToMany(mappedBy = "historyItem")
	private List<SoldItem> soldItems;
	
	
	public HistoryItem(Date soldTime, double price,
			ArrayList<SoldItem> soldItems) {
		super();
		this.price = price;
		this.soldTime = new Date();
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

	public Date getSoldTime() {
		return soldTime;
	}

	public List<SoldItem> getSoldItems() {
		return soldItems;
	}
	
}
