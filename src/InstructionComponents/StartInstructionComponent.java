package InstructionComponents;

import java.awt.Dimension;

import model.InstructionComponent;

public class StartInstructionComponent extends InstructionComponent {
	private static final long serialVersionUID=1L;
	
	public StartInstructionComponent(){
		setDisplayedText("Start");
		setLocation(50, 50);
		setPreferredSize(new Dimension(50, 50));
		setSize(new Dimension(50, 50));
	}

	@Override
	public int getData() {
		return 0;
	}
}
