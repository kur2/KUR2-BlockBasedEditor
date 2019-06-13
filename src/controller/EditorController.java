package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import InstructionComponents.StartInstructionComponent;
import model.InstructionComponent;
import model.InstructionComponentFactory;
import model.LocalizedStrings;
import view.EditorPanel;
import view.InstructionSelector;
import view.KUR2EditorFrame;

public class EditorController {
	private static final int LINKAGE_MAX_DISTANCE=25;
	
	private ArrayList<InstructionComponent> instructionComponents;
	private StartInstructionComponent startInstructionComponent;
	private EditorPanel editorPanel;
	private InstructionSelector instructionSelector;
	
	private Point draggingOffset;
	private InstructionComponent draggingStart;
	
	private Point mousePosition;
	
	public EditorController(KUR2EditorFrame kur2EditorFrame){
		instructionComponents=new ArrayList<InstructionComponent>();
		editorPanel=kur2EditorFrame.getEditorPanel();
		instructionSelector=kur2EditorFrame.getInstructionSelector();
		
		draggingOffset=new Point();
		mousePosition=new Point();
		
		startInstructionComponent=new StartInstructionComponent();
		insertComponent(startInstructionComponent);
		
		editorPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e){
				backgroundClicked(e);
			}
		});
		editorPanel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e){
				mousePosition.setLocation(e.getPoint());
			}
			@Override
			public void mouseDragged(MouseEvent e){
				mousePosition.setLocation(e.getPoint());
			}
		});
		
		editorPanel.setEditorController(this);
		
//		NoopInstructionComponent noc=new NoopInstructionComponent(false);
//		insertComponent(noc);
//		JumpInstructionComponent jic=new JumpInstructionComponent();
//		insertComponent(jic);
//		noc.setLinkedComponent(jic);
	}
	
	private void insertComponent(InstructionComponent ic){
		instructionComponents.add(ic);
		editorPanel.add(ic);
		ic.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e){
				componentDragged(e);
			}
		});
		ic.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				componentPressed(e);
			}
			@Override
			public void mouseReleased(MouseEvent e){
				componentReleased(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				componentEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e){
				componentExited(e);
			}
		});
	}
	
	private void removeComponent(InstructionComponent ic){
		if(ic instanceof StartInstructionComponent)
			return;
		
		editorPanel.remove(ic);
		instructionComponents.remove(ic);
		
		cutLinkage(ic);
		
		for(InstructionComponent parent:instructionComponents){
			if(parent.getPointingTarget() != null && parent.getPointingTarget().equals(ic)){
				parent.setPointingTarget(null);
				break;
			}
		}
		
		editorPanel.repaint();
	}
	
	private void componentPressed(MouseEvent e){
		if(e.getButton()==MouseEvent.BUTTON1){
			if((e.getModifiers() & 2) != 0){
				removeComponent((InstructionComponent)e.getSource());
			}else{
				draggingOffset.setLocation(e.getX(), e.getY());
			}
		}else if(e.getButton()==MouseEvent.BUTTON3 && InstructionComponentFactory.hasDraggablePointer((InstructionComponent)e.getSource())){
			draggingStart=(InstructionComponent)e.getSource();
		}
		
//		removeComponent((InstructionComponent)e.getSource());
	}
	
	private void componentEntered(MouseEvent e){
		if(draggingStart!=null){
			draggingStart.setPointingTarget((InstructionComponent)e.getSource());
		}
	}
	
	private void componentExited(MouseEvent e){
		if(draggingStart!=null){
			draggingStart.setPointingTarget(null);
		}
	}
	
	private void componentReleased(MouseEvent e){
		if(e.getButton()==MouseEvent.BUTTON3 && draggingStart!=null){
			int result=JOptionPane.showConfirmDialog(editorPanel, LocalizedStrings.editorUseInstructionCellPrompt, LocalizedStrings.editorUseInstructionCellHeadline, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(result==JOptionPane.YES_OPTION){
				draggingStart.setPointingToHiInt(true);
			}else{
				draggingStart.setPointingToHiInt(false);
			}
			
			draggingStart=null;
			editorPanel.repaint();
		}
	}
	
	public void reset(){
		while(instructionComponents.size()>1){
			removeComponent(instructionComponents.get(1));
		}
	}
	
	private void componentDragged(MouseEvent e){
		mousePosition.setLocation(SwingUtilities.convertPoint((Component)e.getSource(), e.getPoint(), editorPanel));
		if(SwingUtilities.isLeftMouseButton(e)){
			Component component=(Component)e.getSource();
			component.setLocation(component.getX()+e.getX()-draggingOffset.x, component.getY()+e.getY()-draggingOffset.y);
			
			checkLinkage((InstructionComponent)component);
			
			editorPanel.updateSize();
		}
		editorPanel.repaint();
	}
	
	private void cutLinkage(InstructionComponent ic){
		for(InstructionComponent parent:instructionComponents){
			if(parent.getLinkedComponent() != null && parent.getLinkedComponent().equals(ic)){
				parent.setLinkedComponent(null);
				break;
			}
		}
	}
	
	private void checkLinkage(InstructionComponent ic){
		if(ic instanceof StartInstructionComponent)
			return;
		
		//cut linkage
		cutLinkage(ic);
		
		//create linkage
		for(InstructionComponent parent:instructionComponents){
			if(parent.getLinkedComponent() != null || parent.equals(ic))
				continue;
			
			int dX=parent.getX()+parent.getWidth()-ic.getX();
			if(Math.abs(dX)>LINKAGE_MAX_DISTANCE)
				continue;
			
			int dY=parent.getY()-ic.getY();
			if(Math.abs(dY)>LINKAGE_MAX_DISTANCE)
				continue;
			
			parent.setLinkedComponent(ic);
			parent.updateLocation();
			break;
		}
	}
	
	private void backgroundClicked(MouseEvent e){
		if(e.getButton()==MouseEvent.BUTTON1){
			InstructionComponent selectedComponent=instructionSelector.getSelectedInstructionComponent();
			if(selectedComponent==null)
				return;
			
			InstructionComponent newComponent=InstructionComponentFactory.getInstructionComponent(selectedComponent);
			
			newComponent.setLocation(e.getX(), e.getY()-newComponent.getHeight()/2);
			insertComponent(newComponent);
			checkLinkage(newComponent);
		}
		
		editorPanel.repaint();
		instructionSelector.deselectAll();
		instructionSelector.repaint();
	}
	
	public int getInstructionNumber(InstructionComponent ic, boolean isPointingToHiInt){
		int number=0;
		InstructionComponent testComponent=startInstructionComponent.getLinkedComponent();
		
		while(testComponent!=null){
			if(testComponent.equals(ic)){
				number*=2;
				if(!isPointingToHiInt)number++;
				
				return number;
			}
			
			number++;
			testComponent=testComponent.getLinkedComponent();
		}
		
		return -1;
	}
	
	public void reinsertComponentsAfterCompiling(){
		InstructionComponent ic=startInstructionComponent.getLinkedComponent();
		while(ic!=null){
			editorPanel.add(ic);
			ic=ic.getLinkedComponent();
		}
	}
	
	public void updateComponents(){
		for(InstructionComponent ic:instructionComponents)
			ic.update(this);
	}

	public InstructionComponent getDraggingStart() {
		return draggingStart;
	}

	public Point getMousePosition() {
		return mousePosition;
	}

	public ArrayList<InstructionComponent> getInstructionComponents() {
		return instructionComponents;
	}

	public StartInstructionComponent getStartInstructionComponent() {
		return startInstructionComponent;
	}
}
