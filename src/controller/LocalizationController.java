package controller;

import model.LocalizedStrings;

public class LocalizationController {
	public enum Language{
		GERMAN,
		ENGLISH
	}
	
	public static void setLanguage(Language language) {
		switch(language) {
		case GERMAN:
			setLanguageToGerman();
			break;
		case ENGLISH:
			setLanguageToEnglish();
			break;
		}
	}
	
	private static void setLanguageToGerman() {
		LocalizedStrings.title="Grafischer Editor für KUR2-Programme";

		LocalizedStrings.menuFile="Datei";
		LocalizedStrings.menuFileNew="Neu";
		LocalizedStrings.menuFileExit="Beenden";
		LocalizedStrings.menuCompile="Übersetzen";
		LocalizedStrings.menuCompileCompile="Übersetzen";
		LocalizedStrings.menuCompileFast="Schnell übersetzen";
		LocalizedStrings.menuHelp="Hilfe";
		LocalizedStrings.menuHelpHeadline="Info";
		LocalizedStrings.menuHelpDelete="Befehl löschen";
		LocalizedStrings.menuHelpDeleteText="Zum löschen eines Befehls die Strg-Taste gedrückt halten und den zu löschenden Befehl anklicken.";
		LocalizedStrings.menuHelpEditAddress="Adressen bearbeiten";
		LocalizedStrings.menuHelpEditAddressText="Um die Ziele von Befehlen, die auf Adressen verweisen, zu ändern, muss vom zu ändernden Befehlen\n"
				+ "mit der rechten Maustaste eine Verbindung zum Ziel gezogen werden. Die erscheinende rote\n"
				+ "Verbindungslinie rastet auf dem Ziel ein, wenn dieses erkannt wurde. Zur besseren Zielerkennug\n"
				+ "beim Ziehen auf den Befehlstext vom Ziel zeigen.";
		
		LocalizedStrings.guiTabFlow="Fluss";
		LocalizedStrings.guiTabJumps="Sprünge";
		LocalizedStrings.guiTabData="Daten";
		LocalizedStrings.guiTabAdd="Addition";
		LocalizedStrings.guiTabSub="Subtraktion";
		LocalizedStrings.guiTabMult="Multiplikation";
		LocalizedStrings.guiTabDiv="Division";
		LocalizedStrings.guiTabMod="Modulo";
		LocalizedStrings.guiTabIO="Ein-/Ausgabe";
		
		LocalizedStrings.compilerErrorHeadline="Fehler";
		LocalizedStrings.compilerErrorNoProg="Kein Programm gefunden. Sind Befehle mit dem Startblock verbunden?";
		LocalizedStrings.compilerErrorNoHalt="Es wurde kein Haltebefehl gefunden! Übersetzen wirklich fortsetzen?";
		LocalizedStrings.compilerSuccess1="Übersetzen erfolgreich! Es wurden ";
		LocalizedStrings.compilerSuccess2=" Zeilen Code erzeugt.";
		LocalizedStrings.compilerSuccessHeadline="Übersetzen erfolgreich";
		LocalizedStrings.compilerWritingError1="Fehler beim schreiben in die Datei ";
		LocalizedStrings.compilerWritingError2=". Existieren die (Unter-)Ordner?";
		LocalizedStrings.compilerWritingErrorHeadline="Schreibfehler";
		
		LocalizedStrings.editorUseInstructionCellPrompt="Soll statt der Datenzelle die Instruktionszelle gewählt werden?";
		LocalizedStrings.editorUseInstructionCellHeadline="Speicherzelle wählen";
		
		LocalizedStrings.instructionAddA="Addiere Wert bei";
		LocalizedStrings.instructionAddC="Addiere Konstante";
		LocalizedStrings.instructionDivA="Teile durch Wert bei";
		LocalizedStrings.instructionDivC="Dividiere durch Konst.";
		LocalizedStrings.instructionHalt="Halt";
		LocalizedStrings.instructionInput="Hole Eingabe von Port";
		LocalizedStrings.instructionJumpGreater="Falls ACC>0 springe";
		LocalizedStrings.instructionJump="Springe nach";
		LocalizedStrings.instructionJumpLess="Falls ACC<0 springe";
		LocalizedStrings.instructionJumpNotNull="Falls ACC=/=0 springe";
		LocalizedStrings.instructionJumpNull="Falls ACC=0 springe";
		LocalizedStrings.instructionLoadA="Lade Wert bei";
		LocalizedStrings.instructionLoadC="Lade Konstante";
		LocalizedStrings.instructionModA="Nimm modulo Wert bei";
		LocalizedStrings.instructionModC="Nimm modulo Konst.";
		LocalizedStrings.instructionMultA="Multipliziere mit Wert bei";
		LocalizedStrings.instructionMultC="Multipliziere mit Konst.";
		LocalizedStrings.instructionNoop="Keine Operation";
		LocalizedStrings.instructionNull="Lade Konstante 0";
		LocalizedStrings.instructionOutput="Gib aus auf Port";
		LocalizedStrings.instructionStart="Start";
		LocalizedStrings.instructionStore="Speichere bei";
		LocalizedStrings.instructionSubA="Subtrahiere Wert bei";
		LocalizedStrings.instructionSubC="Subtrahiere Konstante";
	}
	
	private static void setLanguageToEnglish() {
		LocalizedStrings.title="Block-based editor für KUR2-Programs";

		LocalizedStrings.menuFile="File";
		LocalizedStrings.menuFileNew="New";
		LocalizedStrings.menuFileExit="Exit";
		LocalizedStrings.menuCompile="Compile";
		LocalizedStrings.menuCompileCompile="Compile";
		LocalizedStrings.menuCompileFast="Fast compile";
		LocalizedStrings.menuHelp="Help";
		LocalizedStrings.menuHelpHeadline="Info";
		LocalizedStrings.menuHelpDelete="Delete instruction";
		LocalizedStrings.menuHelpDeleteText="In order to delete an instruction, hold down the Ctrl-Key and click the instruction.";
		LocalizedStrings.menuHelpEditAddress="Edit address fields";
		LocalizedStrings.menuHelpEditAddressText=""
				+ "In order to set an instructions adress field, you need to drag a connection to the target\n"
				+ "while holding down the right mouse button. The then appearing red line will lock onto the target\n"
				+ "if it has been identified correctly. Position the cursor above the targets instruction text to\n"
				+ "make targeting more precise.";
		
		LocalizedStrings.guiTabFlow="Flow";
		LocalizedStrings.guiTabJumps="Jumps";
		LocalizedStrings.guiTabData="Data";
		LocalizedStrings.guiTabAdd="Addition";
		LocalizedStrings.guiTabSub="Subtraction";
		LocalizedStrings.guiTabMult="Multiplication";
		LocalizedStrings.guiTabDiv="Division";
		LocalizedStrings.guiTabMod="Modulo";
		LocalizedStrings.guiTabIO="Input/Output";
		
		LocalizedStrings.compilerErrorHeadline="Error";
		LocalizedStrings.compilerErrorNoProg="No program found. Are the instructions connected to the start block?";
		LocalizedStrings.compilerErrorNoHalt="No halting instruction found! Continue compilation?";
		LocalizedStrings.compilerSuccess1="Compilation successful! ";
		LocalizedStrings.compilerSuccess2=" lines of code produced.";
		LocalizedStrings.compilerSuccessHeadline="Compilation successful";
		LocalizedStrings.compilerWritingError1="Error writing to file ";
		LocalizedStrings.compilerWritingError2=". Do (sub-)folders exist?";
		LocalizedStrings.compilerWritingErrorHeadline="Writing error";
		
		LocalizedStrings.editorUseInstructionCellPrompt="Select instruction cell instead of data cell?";
		LocalizedStrings.editorUseInstructionCellHeadline="Select memory cell";
		
		LocalizedStrings.instructionAddA="Add value at";
		LocalizedStrings.instructionAddC="Add constant";
		LocalizedStrings.instructionDivA="Divide by value at";
		LocalizedStrings.instructionDivC="Dividy by constant";
		LocalizedStrings.instructionHalt="Halt";
		LocalizedStrings.instructionInput="Get input from port";
		LocalizedStrings.instructionJumpGreater="If ACC>0 jump to";
		LocalizedStrings.instructionJump="Jump to";
		LocalizedStrings.instructionJumpLess="If ACC<0 jump to";
		LocalizedStrings.instructionJumpNotNull="If ACC=/=0 jump to";
		LocalizedStrings.instructionJumpNull="If ACC=0 jump to";
		LocalizedStrings.instructionLoadA="Load value at";
		LocalizedStrings.instructionLoadC="Load constant";
		LocalizedStrings.instructionModA="Modulo value at";
		LocalizedStrings.instructionModC="Modulo constant";
		LocalizedStrings.instructionMultA="Multiply ba value at";
		LocalizedStrings.instructionMultC="Multiply by constant";
		LocalizedStrings.instructionNoop="No operation";
		LocalizedStrings.instructionNull="Load constant 0";
		LocalizedStrings.instructionOutput="Output on port";
		LocalizedStrings.instructionStart="Start";
		LocalizedStrings.instructionStore="Store at";
		LocalizedStrings.instructionSubA="Subtract value at";
		LocalizedStrings.instructionSubC="Subtract constant";
	}
}
