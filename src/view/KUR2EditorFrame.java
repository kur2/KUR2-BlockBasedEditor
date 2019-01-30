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

public class KUR2EditorFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private EditorController editorController;
	
	private EditorPanel editorPanel;
	private InstructionSelector instructionSelector;
	
	public KUR2EditorFrame(){
		super();
		setTitle("Grafischer Editor für KUR2-Programme");
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
		
		JMenu file=new JMenu("Datei");
		menuBar.add(file);
		JMenuItem newProject=new JMenuItem(new AbstractAction("Neu"){
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
		JMenuItem exit=new JMenuItem(new AbstractAction("Beenden"){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		file.add(exit);
		
		
		JMenu compile=new JMenu("Übersetzen");
		menuBar.add(compile);
		JMenuItem graphicalCompile=new JMenuItem(new AbstractAction("Übersetzen"){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				new CompilingWindow(KUR2EditorFrame.this);
			}
		});
		compile.add(graphicalCompile);
		compile.addSeparator();
		JMenuItem quickCompile=new JMenuItem(new AbstractAction("Schnell übersetzen"){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				CompilerController.quickCompile(KUR2EditorFrame.this);
			}
		});
		compile.add(quickCompile);
		
		JMenu help=new JMenu("Hilfe");
		menuBar.add(help);
		JMenuItem delete=new JMenuItem(new AbstractAction("Befehl löschen"){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(KUR2EditorFrame.this, "Zum löschen eines Befehls die Strg-Taste gedrückt halten und den zu löschenden Befehl anklicken.", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		help.add(delete);
		JMenuItem adresses=new JMenuItem(new AbstractAction("Adressen bearbeiten"){
			private static final long serialVersionUID = 1L;
			@Override public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(KUR2EditorFrame.this, "Um die Ziele von Befehlen, die auf Adressen verweisen, zu ändern, muss vom zu ändernden Befehlen\n"
						+ "mit der rechten Maustaste eine Verbindung zum Ziel gezogen werden. Die erscheinende rote\n"
						+ "Verbindungslinie rastet auf dem Ziel ein, wenn dieses erkannt wurde. Zur besseren Zielerkennug\n"
						+ "beim Ziehen auf den Befehlstext vom Ziel zeigen.", "Info", JOptionPane.INFORMATION_MESSAGE);
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
