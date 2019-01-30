package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controller.EditorController;

public abstract class InstructionComponent extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private String displayedText="none";
	private boolean selected;
	
	private boolean pointingToHiInt;
	private InstructionComponent pointingTarget;
	
	private InstructionComponent linkedComponent;
	
	public InstructionComponent(){
		setPreferredSize(new Dimension(150, 50));
		setSize(new Dimension(150, 50));
		setBorder(new EtchedBorder());
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		
		g2d.setColor(Color.BLACK);
		g2d.drawString(displayedText, 10, 15);
		
		drawSelectionFrame(g2d);
	}
	
	protected void drawSelectionFrame(Graphics2D g2d){
		if(!selected)
			return;
		
		g2d.setColor(Color.RED);
		
		for(int i=0; i<4; i++)
			g2d.drawRect(i, i, getWidth()-2*i-1, getHeight()-i*2-1);
	}
	
	@Override
	public void setLocation(int x, int y){
		super.setLocation(x, y);
		
		if(linkedComponent!=null)
			linkedComponent.setLocation(getWidth()+x+5, y);
	}
	
	public void forceLocation(int x, int y){
		super.setLocation(x, y);
	}
	
	public void update(EditorController editorController){
		
	}
	
	public abstract int getData();
	
	public void updateLocation(){
		setLocation(getLocation());
	}
	
	public String getDisplayedText() {
		return displayedText;
	}

	public void setDisplayedText(String displayedText) {
		this.displayedText = displayedText;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public InstructionComponent getLinkedComponent() {
		return linkedComponent;
	}

	public void setLinkedComponent(InstructionComponent linkedComponent) {
		this.linkedComponent = linkedComponent;
	}

	public boolean isPointingToHiInt() {
		return pointingToHiInt;
	}

	public void setPointingToHiInt(boolean pointingToHiInt) {
		this.pointingToHiInt = pointingToHiInt;
	}

	public InstructionComponent getPointingTarget() {
		return pointingTarget;
	}

	public void setPointingTarget(InstructionComponent pointingTarget) {
		this.pointingTarget = pointingTarget;
	}
}
