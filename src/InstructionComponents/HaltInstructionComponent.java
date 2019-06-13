package InstructionComponents;

import model.InstructionComponent;
import model.LocalizedStrings;

public class HaltInstructionComponent extends InstructionComponent {
	private static final long serialVersionUID = 1L;
	
	public HaltInstructionComponent(){
		setDisplayedText(LocalizedStrings.instructionHalt);
	}

	@Override
	public int getData() {
		return 0;
	}
}
