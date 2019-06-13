package view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
import InstructionComponents.StoreInstructionComponent;
import InstructionComponents.SubAddressInstructionComponent;
import InstructionComponents.SubConstantInstructionComponent;
import model.InstructionComponent;
import model.LocalizedStrings;

public class InstructionSelector extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<InstructionComponent> components;
	private InstructionComponent noopPanel,haltPanel;
	private InstructionComponent jumpPanel,jumpNullPanel,jumpNotNullPanel,jumpGreaterNullPanel,jumpLessNullPanel;
	private InstructionComponent nullPanel,loadConstantPanel,loadAddressPanel,storePanel;
	private InstructionComponent addConstantPanel,addAddressPanel;
	private InstructionComponent subConstantPanel,subAddressPanel;
	private InstructionComponent multConstantPanel,multAddressPanel;
	private InstructionComponent divConstantPanel,divAddressPanel;
	private InstructionComponent modConstantPanel,modAddressPanel;
	private InstructionComponent inputPanel,outputPanel;
	
	public InstructionSelector() {
		setPreferredSize(new Dimension(800, 150));
		components=new ArrayList<InstructionComponent>();
		
		//----------FLOW----------
		JPanel panelFlow = new JPanel();
		addTab(LocalizedStrings.guiTabFlow, null, panelFlow, null);
		
		noopPanel=new NoopInstructionComponent(true);
		noopPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(noopPanel);
			}
		});
		components.add(noopPanel);
		panelFlow.add(noopPanel);
		
		panelFlow.add(Box.createRigidArea(new Dimension(10, 0)));
		
		haltPanel=new HaltInstructionComponent();
		haltPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(haltPanel);
			}
		});
		components.add(haltPanel);
		panelFlow.add(haltPanel);
		
		
		
		//----------JUMP----------
		JPanel panelJump = new JPanel();
		addTab(LocalizedStrings.guiTabJumps, null, panelJump, null);
		
		jumpPanel=new JumpInstructionComponent();
		jumpPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(jumpPanel);
			}
		});
		components.add(jumpPanel);
		panelJump.add(jumpPanel);
		
		panelJump.add(Box.createRigidArea(new Dimension(10, 0)));
		
		jumpNullPanel=new JumpNullInstructionComponent();
		jumpNullPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(jumpNullPanel);
			}
		});
		components.add(jumpNullPanel);
		panelJump.add(jumpNullPanel);
		
		panelJump.add(Box.createRigidArea(new Dimension(10, 0)));
		
		jumpNotNullPanel=new JumpNotNullInstructionComponent();
		jumpNotNullPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(jumpNotNullPanel);
			}
		});
		components.add(jumpNotNullPanel);
		panelJump.add(jumpNotNullPanel);
		
		panelJump.add(Box.createRigidArea(new Dimension(10, 0)));
		
		jumpGreaterNullPanel=new JumpGreaterThanNullInstructionComponent();
		jumpGreaterNullPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(jumpGreaterNullPanel);
			}
		});
		components.add(jumpGreaterNullPanel);
		panelJump.add(jumpGreaterNullPanel);
		
		panelJump.add(Box.createRigidArea(new Dimension(10, 0)));
		
		jumpLessNullPanel=new JumpLessThanNullInstructionComponent();
		jumpLessNullPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(jumpLessNullPanel);
			}
		});
		components.add(jumpLessNullPanel);
		panelJump.add(jumpLessNullPanel);
		
		
		
		//----------DATA----------
		JPanel panelData = new JPanel();
		addTab(LocalizedStrings.guiTabData, null, panelData, null);
		
		nullPanel=new NullInstructionComponent();
		nullPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(nullPanel);
			}
		});
		components.add(nullPanel);
		panelData.add(nullPanel);
		
		panelData.add(Box.createRigidArea(new Dimension(10, 0)));
		
		loadConstantPanel=new LoadConstantInstructionComponent(true);
		loadConstantPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(loadConstantPanel);
			}
		});
		components.add(loadConstantPanel);
		panelData.add(loadConstantPanel);
		
		panelData.add(Box.createRigidArea(new Dimension(10, 0)));
		
		loadAddressPanel=new LoadAddressInstructionComponent();
		loadAddressPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(loadAddressPanel);
			}
		});
		components.add(loadAddressPanel);
		panelData.add(loadAddressPanel);
		
		panelData.add(Box.createRigidArea(new Dimension(10, 0)));
		
		storePanel=new StoreInstructionComponent();
		storePanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(storePanel);
			}
		});
		components.add(storePanel);
		panelData.add(storePanel);
		
		
		
		//----------ADD-----------
		JPanel panelAdd = new JPanel();
		addTab(LocalizedStrings.guiTabAdd, null, panelAdd, null);
		
		addConstantPanel=new AddConstantInstructionComponent(true);
		addConstantPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(addConstantPanel);
			}
		});
		components.add(addConstantPanel);
		panelAdd.add(addConstantPanel);
		
		panelAdd.add(Box.createRigidArea(new Dimension(10, 0)));
		
		addAddressPanel=new AddAddressInstructionComponent();
		addAddressPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(addAddressPanel);
			}
		});
		components.add(addAddressPanel);
		panelAdd.add(addAddressPanel);
		
		
		
		//----------SUB-----------
		JPanel panelSub = new JPanel();
		addTab(LocalizedStrings.guiTabSub, null, panelSub, null);
		
		subConstantPanel=new SubConstantInstructionComponent(true);
		subConstantPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(subConstantPanel);
			}
		});
		components.add(subConstantPanel);
		panelSub.add(subConstantPanel);
		
		panelSub.add(Box.createRigidArea(new Dimension(10, 0)));
		
		subAddressPanel=new SubAddressInstructionComponent();
		subAddressPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(subAddressPanel);
			}
		});
		components.add(subAddressPanel);
		panelSub.add(subAddressPanel);
		
		
		
		//----------MULT----------
		JPanel panelMul = new JPanel();
		addTab(LocalizedStrings.guiTabMult, null, panelMul, null);
		
		multConstantPanel=new MultConstantInstructionComponent(true);
		multConstantPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(multConstantPanel);
			}
		});
		components.add(multConstantPanel);
		panelMul.add(multConstantPanel);
		
		panelMul.add(Box.createRigidArea(new Dimension(10, 0)));
		
		multAddressPanel=new MultAddressInstructionComponent();
		multAddressPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(multAddressPanel);
			}
		});
		components.add(multAddressPanel);
		panelMul.add(multAddressPanel);
		
		
		
		//----------DIV-----------
		JPanel panelDiv = new JPanel();
		addTab(LocalizedStrings.guiTabDiv, null, panelDiv, null);
		
		divConstantPanel=new DivConstantInstructionComponent(true);
		divConstantPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(divConstantPanel);
			}
		});
		components.add(divConstantPanel);
		panelDiv.add(divConstantPanel);
		
		panelDiv.add(Box.createRigidArea(new Dimension(10, 0)));
		
		divAddressPanel=new DivAddressInstructionComponent();
		divAddressPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(divAddressPanel);
			}
		});
		components.add(divAddressPanel);
		panelDiv.add(divAddressPanel);
		
		
		
		//----------MOD-----------
		JPanel panelMod = new JPanel();
		addTab(LocalizedStrings.guiTabMod, null, panelMod, null);
		
		modConstantPanel=new ModCostantInstructionComponent(true);
		modConstantPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(modConstantPanel);
			}
		});
		components.add(modConstantPanel);
		panelMod.add(modConstantPanel);
		
		panelMod.add(Box.createRigidArea(new Dimension(10, 0)));
		
		modAddressPanel=new ModAddressInstructionComponent();
		modAddressPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(modAddressPanel);
			}
		});
		components.add(modAddressPanel);
		panelMod.add(modAddressPanel);
		
		
		
		//----------I/O-----------
		JPanel panelIO = new JPanel();
		addTab(LocalizedStrings.guiTabIO, null, panelIO, null);
		
		inputPanel=new InputInstructionComponent(true);
		inputPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(inputPanel);
			}
		});
		components.add(inputPanel);
		panelIO.add(inputPanel);
		
		panelIO.add(Box.createRigidArea(new Dimension(10, 0)));
		
		outputPanel=new OutputInstructionComponent(true);
		outputPanel.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e){
				selectOnly(outputPanel);
			}
		});
		components.add(outputPanel);
		panelIO.add(outputPanel);
	}
	
	public void deselectAll(){
		for(InstructionComponent ic:components)
			ic.setSelected(false);
	}
	
	private void selectOnly(InstructionComponent ic){
		deselectAll();
		ic.setSelected(true);
		repaint();
	}
	
	public InstructionComponent getSelectedInstructionComponent(){
		for(InstructionComponent ic:components)
			if(ic.isSelected())
				return ic;
		return null;
	}
}
