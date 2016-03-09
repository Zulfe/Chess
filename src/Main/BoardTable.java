package Main;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class BoardTable extends JTable {
	
	public BoardTable(){
		super(new DefaultTableModel(8, 8));
		super.setRowSelectionAllowed(false);
	}
}
