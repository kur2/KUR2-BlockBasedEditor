package InstructionComponents;

import java.awt.Dimension;

import model.InstructionComponent;
import model.LocalizedStrings;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import controller.EditorController;

public class JumpInstructionComponent extends InstructionComponent {
	private static final long serialVersionUID = 1L;

	JLabel label;
	
	public JumpInstructionComponent() {
		setDisplayedText(LocalizedStrings.instructionJump);
		setPreferredSize(new Dimension(150, 50));
		setLayout(null);
		
		label = new JLabel("0");
		label.setBounds(84, 23, 56, 16);
		label.setBorder(new EtchedBorder());
		add(label);
	}
	
	@Override
	public void update(EditorController editorController){
		if(getPointingTarget()==null){
			label.setText("0");
		}else{
			int target=editorController.getInstructionNumber(getPointingTarget(), isPointingToHiInt());
			label.setText(""+target);
		}
	}

	@Override
	public int getData() {
		return Integer.parseInt(label.getText());
	}
}
