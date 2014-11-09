package ee.ut.math.tvt.salessystem.ui.model;


import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

public class HistoryInfoModel extends SalesSystemTableModel<SoldItem>{
	private static final long serialVersionUID = -1427369210939461637L;

	public HistoryInfoModel() {
		super(new String[] {"Name", "Price", "Quantity", "Sum"});
	}

	@Override
	protected Object getColumnValue(SoldItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getName();
		case 1:
			return item.getPrice();
		case 2:
			return item.getQuantity();
		case 3:
			return item.getSum();
		}
		throw new IllegalArgumentException("Column index out of range");
		
	}
	
	public void addItem(final SoldItem item){
		rows.add(item);
		fireTableDataChanged();
	}
}
