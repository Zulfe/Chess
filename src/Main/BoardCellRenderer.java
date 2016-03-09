package Main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class BoardCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(SwingConstants.CENTER);
        
        if(row % 2 == 0 && column % 2 == 1)
        	setBackground(new Color(100, 100, 100));
        else if(row % 2 == 1 && column % 2 == 0)
        	setBackground(new Color(100, 100, 100));
        else
        	setBackground(Color.WHITE);
        
        
        if(hasFocus)
        	setBorder(new MatteBorder(2, 2, 2, 2, Color.RED));

        return this;
    }
}
