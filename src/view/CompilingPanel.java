package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import controller.CompilerController;

public class CompilingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private CompilerController compilerController;
	
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JScrollPane scrollPane;
	
	public CompilingPanel(){
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		
		listModel=new DefaultListModel<>();
		listModel.addListDataListener(new ListDataListener() {
			@Override public void intervalRemoved(ListDataEvent e) {}
			@Override public void intervalAdded(ListDataEvent e) {
				JScrollBar scrollBar=scrollPane.getVerticalScrollBar();
				scrollBar.setValue(scrollBar.getMaximum());
			}
			@Override public void contentsChanged(ListDataEvent e) {}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 200, 390, 250);
		add(scrollPane);
		
		list = new JList<String>(listModel);
		scrollPane.setViewportView(list);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		
		//instruction string
		int compilingState=compilerController.getCompilingState();
		if(compilingState==2 || compilingState==3){
			int posX=200+(compilingState==3?400:400*compilerController.getStateProgress()/CompilerController.STATE_PROGRESS_TARGET);
			int posY=480;
			g2d.setColor(Color.BLACK);
			g2d.drawString(compilerController.getCurrentInstruction(), posX, posY);
		}
		
		//compiling machine
		Point offset=compilerController.getCompilingOffset();
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0+offset.x, 200+offset.y, 400, 400);
		g2d.setColor(Color.WHITE);
		g2d.drawString("COMPILER", 100+offset.x, 300+offset.y);
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void setCompilerController(CompilerController compilerController) {
		this.compilerController = compilerController;
	}
}
