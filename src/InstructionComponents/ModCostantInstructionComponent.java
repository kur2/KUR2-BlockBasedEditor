package InstructionComponents;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

import model.InstructionComponent;
import model.LocalizedStrings;

public class ModCostantInstructionComponent extends InstructionComponent{
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	
	public ModCostantInstructionComponent(boolean isMenuItem){
		setDisplayedText(LocalizedStrings.instructionModC);
		
		setLayout(null);
		
		textField = new JTextField("0");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try{
					int i=Integer.parseInt(textField.getText());
					textField.setText(""+i);
				}catch(NumberFormatException e){
					textField.setText("0");
				}
			}
		});
		textField.setBounds(54, 22, 86, 20);
		add(textField);
		textField.setColumns(10);
		if(isMenuItem)
			textField.setEnabled(false);
	}

	@Override
	public int getData() {
		return Integer.parseInt(textField.getText());
	}
}
