package view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.EditorController;
import model.InstructionComponent;

public class EditorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int HORIZONTAL_EXTRA_SPACE=75;
	private static final int VERTICAL_EXTRA_SPACE=75;
	
	private EditorController editorController;
	
	private AlphaComposite alphaFull=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
	private AlphaComposite alphaLow=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f);
	
	public EditorPanel(){
		setPreferredSize(new Dimension(800, 600));
		
		setLayout(null);
	}
	
	@Override
	public void paint(Graphics g){
		if(editorController!=null)
			editorController.updateComponents();
		
		super.paint(g);
//		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		
		
		for(Component c:getComponents()){
//			c.repaint();
			
			InstructionComponent ic=(InstructionComponent)c;
			g2d.setColor(Color.DARK_GRAY);
			g2d.fillOval(ic.getX()+ic.getWidth()-6, ic.getY()+ic.getHeight()/2-6, 12, 12);
			g2d.setColor(ic.getLinkedComponent()==null?Color.RED:Color.BLUE);
			g2d.fillOval(ic.getX()+ic.getWidth()-5, ic.getY()+ic.getHeight()/2-5, 10, 10);
		}
		
		if(editorController.getDraggingStart()!=null){
			InstructionComponent startComponent=editorController.getDraggingStart();
			int startX=startComponent.getX()+startComponent.getWidth()/2;
			int startY=startComponent.getY()+startComponent.getHeight()/2;
			int endX=editorController.getMousePosition().x;
			int endY=editorController.getMousePosition().y;
			
			if(startComponent.getPointingTarget()!=null){
				endX=startComponent.getPointingTarget().getX()+startComponent.getPointingTarget().getWidth()/2;
				endY=startComponent.getPointingTarget().getY()+startComponent.getPointingTarget().getHeight()/2;
			}
			
			g2d.setColor(Color.RED);
			g2d.setStroke(new BasicStroke(5));
			g2d.setComposite(alphaLow);
			g2d.drawLine(startX, startY, endX, endY);
			g2d.setStroke(new BasicStroke(1));
			g2d.setComposite(alphaFull);
		}
	}
	
	public void updateSize(){
		//push components into view
		for(Component c:getComponents()){
			if(c.getLocation().x<0)c.setLocation(0, c.getLocation().y);
			if(c.getLocation().y<0)c.setLocation(c.getLocation().x, 0);
		}
		
		//find max x and y of components
		int width=getParent().getSize().width;
		int height=getParent().getSize().height;
		
		for(Component c:getComponents()){
			int x=c.getX()+c.getWidth()+HORIZONTAL_EXTRA_SPACE;
			int y=c.getY()+c.getHeight()+VERTICAL_EXTRA_SPACE;
			
			if(x>width)width=x;
			if(y>height)height=y;
		}
		
		setSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
	}

	public void setEditorController(EditorController editorController) {
		this.editorController = editorController;
	}
}
