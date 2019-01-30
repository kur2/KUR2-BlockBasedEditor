package InstructionComponents;

import model.InstructionComponent;

public class HaltInstructionComponent extends InstructionComponent {
	private static final long serialVersionUID = 1L;
	
	public HaltInstructionComponent(){
		setDisplayedText("Halt");
	}

	@Override
	public int getData() {
		return 0;
	}
}
