package InstructionComponents;

import model.InstructionComponent;

public class NullInstructionComponent extends InstructionComponent {
	private static final long serialVersionUID = 1L;
	
	public NullInstructionComponent(){
		setDisplayedText("Lade Konstante 0");
	}

	@Override
	public int getData() {
		return 0;
	}
}
