package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import InstructionComponents.AddAddressInstructionComponent;
import InstructionComponents.AddConstantInstructionComponent;
import InstructionComponents.DivAddressInstructionComponent;
import InstructionComponents.DivConstantInstructionComponent;
import InstructionComponents.HaltInstructionComponent;
import InstructionComponents.InputInstructionComponent;
import InstructionComponents.JumpGreaterThanNullInstructionComponent;
import InstructionComponents.JumpInstructionComponent;
import InstructionComponents.JumpLessThanNullInstructionComponent;
import InstructionComponents.JumpNotNullInstructionComponent;
import InstructionComponents.JumpNullInstructionComponent;
import InstructionComponents.LoadAddressInstructionComponent;
import InstructionComponents.LoadConstantInstructionComponent;
import InstructionComponents.ModAddressInstructionComponent;
import InstructionComponents.ModCostantInstructionComponent;
import InstructionComponents.MultAddressInstructionComponent;
import InstructionComponents.MultConstantInstructionComponent;
import InstructionComponents.NoopInstructionComponent;
import InstructionComponents.NullInstructionComponent;
import InstructionComponents.OutputInstructionComponent;
import InstructionComponents.StartInstructionComponent;
import InstructionComponents.StoreInstructionComponent;
import InstructionComponents.SubAddressInstructionComponent;
import InstructionComponents.SubConstantInstructionComponent;
import model.InstructionComponent;
import view.CompilingPanel;
import view.CompilingWindow;
import view.KUR2EditorFrame;

public class CompilerController implements ActionListener{
	private static final int INSTRUCTION_MOVEMENT_SPEED=3;
	private static final String outputFilePath="res/progs/testProgram.txt";
	
	private KUR2EditorFrame kur2EditorFrame;
	private CompilingWindow compilingWindow;
	private CompilingPanel compilingPanel;
	
	private ArrayList<InstructionComponent> instructionComponents;
	private InstructionComponent currentInstructionComponent;
	private String currentInstruction;
	
	private ClockGenerator clockGenerator;
	
	private int compilingState;
	private int stateProgress;
	public static final int STATE_PROGRESS_TARGET=40;
	
	private Point compilingOffset;
	private Random random;
	
	private boolean aborted;
	
	public CompilerController(KUR2EditorFrame kur2EditorFrame, CompilingWindow compilingWindow){
		if(kur2EditorFrame.getEditorController().getStartInstructionComponent().getLinkedComponent()==null){
			JOptionPane.showMessageDialog(kur2EditorFrame, "Kein Programm gefunden. Sind Befehle mit dem Startblock verbunden?", "Fehler", JOptionPane.ERROR_MESSAGE);
			aborted=true;
			return;
		}
		
		this.kur2EditorFrame=kur2EditorFrame;
		this.compilingWindow=compilingWindow;
		this.compilingPanel=compilingWindow.getCompilingPanel();
		
		compilingPanel.setCompilerController(this);
		
		boolean haltFound=hasHalt(kur2EditorFrame.getEditorController().getStartInstructionComponent());
		if(!haltFound){
			int result=JOptionPane.showConfirmDialog(kur2EditorFrame, "Es wurde kein Haltebefehl gefunden! Übersetzen wirklich fortsetzen?", "Fehler", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(result!=JOptionPane.YES_OPTION){
				aborted=true;
				return;
			}
		}
		
		instructionComponents=new ArrayList<>();
		InstructionComponent ic=kur2EditorFrame.getEditorController().getStartInstructionComponent().getLinkedComponent();
		int counter=0;
		while(ic!=null){
			instructionComponents.add(ic);
			compilingPanel.add(ic);
			ic.forceLocation(counter*160+100, 80);
			counter++;
			ic=ic.getLinkedComponent();
		}
		
		compilingOffset=new Point();
		random=new Random();
		
		initializeState(0);
		
		clockGenerator=new ClockGenerator(1000/30, this);
		clockGenerator.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		stateProgress++;
		if(stateProgress==STATE_PROGRESS_TARGET){
			stateProgress=0;
			compilingState++;
			if(compilingState>3)compilingState=0;
			initializeState(compilingState);
		}
		
		if(currentInstructionComponent.getY()<400)
			moveInstructionComponent(currentInstructionComponent, 0, INSTRUCTION_MOVEMENT_SPEED);
		
		if(instructionComponents.size()>0 && instructionComponents.get(0).getX()>100)
			for(InstructionComponent ic:instructionComponents)
				moveInstructionComponent(ic, -INSTRUCTION_MOVEMENT_SPEED, 0);
		
		if(compilingState==1){
			//rattle
			compilingOffset.setLocation(random.nextInt(5)-2, random.nextInt(5)-2);
		}else{
			compilingOffset.setLocation(0, 0);
		}
		
		compilingPanel.repaint();
	}
	
	private void moveInstructionComponent(InstructionComponent ic, int dX, int dY){
		ic.forceLocation(ic.getX()+dX, ic.getY()+dY);
	}
	
	private void initializeState(int i){
		switch(i){
		case 0://get next graphical instruction
			if(instructionComponents.size()==0){
				if(clockGenerator!=null)
					clockGenerator.shutDown();
				compilingWindow.dispose();
				kur2EditorFrame.getEditorController().reinsertComponentsAfterCompiling();
				kur2EditorFrame.getEditorController().getStartInstructionComponent().updateLocation();
				quickCompile(kur2EditorFrame);
				return;
			}
			currentInstructionComponent=instructionComponents.remove(0);
			break;
		case 1://compile
			compilingPanel.remove(currentInstructionComponent);
			break;
		case 2://output text instruction
			currentInstruction=getCodeForInstructionComponent(currentInstructionComponent);
			break;
		case 3://wait
			compilingPanel.getListModel().addElement(currentInstruction);
		}
	}
	
	public boolean isAborted() {
		return aborted;
	}

	public String getCurrentInstruction() {
		return currentInstruction;
	}

	public Point getCompilingOffset() {
		return compilingOffset;
	}

	public int getCompilingState() {
		return compilingState;
	}

	public int getStateProgress() {
		return stateProgress;
	}

	public static void quickCompile(KUR2EditorFrame kur2EditorFrame){
		StartInstructionComponent startInstructionComponent=kur2EditorFrame.getEditorController().getStartInstructionComponent();
		if(kur2EditorFrame.getEditorController().getStartInstructionComponent().getLinkedComponent()==null){
			JOptionPane.showMessageDialog(kur2EditorFrame, "Kein Programm gefunden. Sind Befehle mit dem Startblock verbunden?", "Fehler", JOptionPane.ERROR_MESSAGE);
			return;
		}
		boolean haltFound=hasHalt(startInstructionComponent);
		if(!haltFound){
			int result=JOptionPane.showConfirmDialog(kur2EditorFrame, "Es wurde kein Haltebefehl gefunden! Übersetzen wirklich fortsetzen?", "Fehler", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(result!=JOptionPane.YES_OPTION){
				return;
			}
		}
		
		//compile
		try{
			PrintWriter out=new PrintWriter(outputFilePath);
			
			int counter=0;
			InstructionComponent ic=startInstructionComponent.getLinkedComponent();
			while(ic!=null){
				out.println(getCodeForInstructionComponent(ic));
				counter++;
				ic=ic.getLinkedComponent();
			}
			
			out.close();
			
			JOptionPane.showMessageDialog(kur2EditorFrame, "Übersetzen erfolgreich! Es wurden "+counter+" Zeilen Code erzeugt.", "Übersetzen erfolgreich", JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e){
			JOptionPane.showMessageDialog(kur2EditorFrame, "Fehler beim schreiben in die Datei "+outputFilePath+". Existieren die (Unter-)Ordner?", "Schreibfehler", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private static boolean hasHalt(StartInstructionComponent startInstructionComponent){
		boolean haltFound=false;
		InstructionComponent ic=startInstructionComponent.getLinkedComponent();
		while(ic!=null){
			if(ic instanceof HaltInstructionComponent){
				haltFound=true;
				break;
			}
			ic=ic.getLinkedComponent();
		}
		return haltFound;
	}
	
	private static String getCodeForInstructionComponent(InstructionComponent ic){
		String instruction="";
		
		//instruction int
		if(ic instanceof NoopInstructionComponent){
			instruction+="0 ";
		}else if(ic instanceof HaltInstructionComponent){
			instruction+="1 ";
		}else if(ic instanceof JumpInstructionComponent){
			instruction+="10 ";
		}else if(ic instanceof JumpNullInstructionComponent){
			instruction+="11 ";
		}else if(ic instanceof JumpNotNullInstructionComponent){
			instruction+="12 ";
		}else if(ic instanceof JumpGreaterThanNullInstructionComponent){
			instruction+="13 ";
		}else if(ic instanceof JumpLessThanNullInstructionComponent){
			instruction+="14 ";
		}else if(ic instanceof NullInstructionComponent){
			instruction+="20 ";
		}else if(ic instanceof LoadConstantInstructionComponent){
			instruction+="21 ";
		}else if(ic instanceof LoadAddressInstructionComponent){
			instruction+="22 ";
		}else if(ic instanceof StoreInstructionComponent){
			instruction+="23 ";
		}else if(ic instanceof AddConstantInstructionComponent){
			instruction+="30 ";
		}else if(ic instanceof AddAddressInstructionComponent){
			instruction+="31 ";
		}else if(ic instanceof SubConstantInstructionComponent){
			instruction+="40 ";
		}else if(ic instanceof SubAddressInstructionComponent){
			instruction+="41 ";
		}else if(ic instanceof MultConstantInstructionComponent){
			instruction+="50 ";
		}else if(ic instanceof MultAddressInstructionComponent){
			instruction+="51 ";
		}else if(ic instanceof DivConstantInstructionComponent){
			instruction+="60 ";
		}else if(ic instanceof DivAddressInstructionComponent){
			instruction+="61 ";
		}else if(ic instanceof ModCostantInstructionComponent){
			instruction+="70 ";
		}else if(ic instanceof ModAddressInstructionComponent){
			instruction+="71 ";
		}else if(ic instanceof InputInstructionComponent){
			instruction+="80 ";
		}else if(ic instanceof OutputInstructionComponent){
			instruction+="81 ";
		}
		
		instruction+=ic.getData();
		
		return instruction;
	}
}
