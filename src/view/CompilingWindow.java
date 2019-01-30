package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.CompilerController;

public class CompilingWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private CompilingPanel compilingPanel;
	
	public CompilingWindow(KUR2EditorFrame kur2EditorFrame) {
		setTitle("Compiler");
		
		compilingPanel=new CompilingPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(compilingPanel, BorderLayout.CENTER);
		
		CompilerController compilerController=new CompilerController(kur2EditorFrame, this);
		
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		if(compilerController.isAborted())
			dispose();
	}

	public CompilingPanel getCompilingPanel() {
		return compilingPanel;
	}
}
