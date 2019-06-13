package InstructionComponents;

import model.InstructionComponent;
import model.LocalizedStrings;

public class NullInstructionComponent extends InstructionComponent {
	private static final long serialVersionUID = 1L;
	
	public NullInstructionComponent(){
		setDisplayedText(LocalizedStrings.instructionNull);
	}

	@Override
	public int getData() {
		return 0;
	}
}
