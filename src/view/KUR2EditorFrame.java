package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controller.CompilerController;
import controller.EditorController;
import controller.LocalizationController;
import controller.LocalizationController.Language;
import model.LocalizedStrings;

public class KUR2EditorFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private EditorController editorController;
	
	private EditorPanel editorPanel;
	private InstructionSelector instructionSelector;
	
	public KUR2EditorFrame(){
		super();
		LocalizationController.setLanguage(Language.GERMAN);
		
		setTitle(LocalizedStrings.title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		getContentPane().add(constructMenuBar(), BorderLayout.NORTH);
		
		editorPanel=new EditorPanel();
		JScrollPane scrollPane=new JScrollPane(editorPanel);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		instructionSelector=new InstructionSelector();
		getContentPane().add(instructionSelector, BorderLayout.SOUTH);
		
		editorController=new EditorController(this);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private JMenuBar constructMenuBar(){
		JMenuBar menuBar=new JMenuBar();
		
		JMenu file=new JMenu(LocalizedStrings.menuFile);
		menuBar.add(file);
		JMenuItem newProject=new JMenuItem(new AbstractAction(LocalizedStrings.menuFileNew){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				editorController.reset();
			}
		});
		file.add(newProject);
//		JMenuItem open=new JMenuItem(new AbstractAction("Öffnen"){
//			private static final long serialVersionUID = 1L;
//			@Override public void actionPerformed(ActionEvent e) {
//				//datei laden
//			}
//		});
//		file.add(open);
		file.addSeparator();
		JMenuItem exit=new JMenuItem(new AbstractAction(LocalizedStrings.menuFileExit){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		file.add(exit);
		
		
		JMenu compile=new JMenu(LocalizedStrings.menuCompile);
		menuBar.add(compile);
		JMenuItem graphicalCompile=new JMenuItem(new AbstractAction(LocalizedStrings.menuCompileCompile){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				new CompilingWindow(KUR2EditorFrame.this);
			}
		});
		compile.add(graphicalCompile);
		compile.addSeparator();
		JMenuItem quickCompile=new JMenuItem(new AbstractAction(LocalizedStrings.menuCompileFast){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				CompilerController.quickCompile(KUR2EditorFrame.this);
			}
		});
		compile.add(quickCompile);
		
		JMenu help=new JMenu(LocalizedStrings.menuHelp);
		menuBar.add(help);
		JMenuItem delete=new JMenuItem(new AbstractAction(LocalizedStrings.menuHelpDelete){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(KUR2EditorFrame.this, LocalizedStrings.menuHelpDeleteText, LocalizedStrings.menuHelpHeadline, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		help.add(delete);
		JMenuItem adresses=new JMenuItem(new AbstractAction(LocalizedStrings.menuHelpEditAddress){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(KUR2EditorFrame.this, LocalizedStrings.menuHelpEditAddressText, LocalizedStrings.menuHelpHeadline, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		help.add(adresses);
		
		return menuBar;
	}
	
	public static void main(String[] args){
		new KUR2EditorFrame();
	}

	public EditorPanel getEditorPanel() {
		return editorPanel;
	}

	public InstructionSelector getInstructionSelector() {
		return instructionSelector;
	}

	public EditorController getEditorController() {
		return editorController;
	}
}
