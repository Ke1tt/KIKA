package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
    	
	  //private static final Logger log = Logger.getLogger(PurchaseTab.class);

	  private SalesSystemModel model;
	  
	  public HistoryTab(SalesSystemModel model) {
		    this.model = model;
		  }
	  
    public Component draw() {
        JPanel panel = new JPanel();
        
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(new GridLayout(2,1));
      	  
        JTable table = new JTable(model.getHistoryTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        
        ListSelectionModel leftclick = table.getSelectionModel();
        
        leftclick.addListSelectionListener(new ListSelectionListener(){
    		public void valueChanged(ListSelectionEvent event){
    			if(event.getValueIsAdjusting())
    				return;
    			ListSelectionModel notempty = (ListSelectionModel) event.getSource();
    			if(!notempty.isSelectionEmpty()){
    				
    				//Find item that was clicked
    				model.getHistoryInfoModel().clear();
    				HistoryItem item = model.getHistoryTableModel().getRow(notempty.getMinSelectionIndex());
    				List<SoldItem> items = item.getSoldItems();
    				for(SoldItem sold: items){
    					model.getHistoryInfoModel().addItem(sold);
    				}
    			}
    		}
    	});
        
        JTable table2 = new JTable(model.getHistoryInfoModel());
        JScrollPane scrollPane2 = new JScrollPane(table2);
        
        panel.add(scrollPane, getBacketScrollPaneConstraints());
        panel.add(scrollPane2, getBacketScrollPaneConstraints());
        
        return panel;
    }

    private GridBagConstraints getBacketScrollPaneConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;

        return gc;
    }
    
}