package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.ui.model.ConfirmOrderModel;
import ee.ut.math.tvt.salessystem.ui.model.HistoryInfoModel;
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
        panel.setLayout(new GridBagLayout());
      	  
        JTable table = new JTable(model.getHistoryTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        
        ListSelectionModel leftclick = table.getSelectionModel();
        
        leftclick.addListSelectionListener(new ListSelectionListener(){
    		public void valueChanged(ListSelectionEvent event){
    			if(event.getValueIsAdjusting())
    				return;
    			ListSelectionModel notempty = (ListSelectionModel) event.getSource();
    			if(!notempty.isSelectionEmpty()){
    				HistoryInfoModel historyInfoModel = new HistoryInfoModel();
    				historyInfoModel.setVisible(true);
    			}
    		}
    	});
        
        panel.add(scrollPane, getBacketScrollPaneConstraints());
        
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