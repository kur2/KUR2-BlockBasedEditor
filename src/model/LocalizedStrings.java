package model;

public class LocalizedStrings {
	public static String title="Grafischer Editor für KUR2-Programme";

	public static String menuFile="Datei";
	public static String menuFileNew="Neu";
	public static String menuFileExit="Beenden";
	public static String menuCompile="Übersetzen";
	public static String menuCompileCompile="Übersetzen";
	public static String menuCompileFast="Schnell übersetzen";
	public static String menuHelp="Hilfe";
	public static String menuHelpHeadline="Info";
	public static String menuHelpDelete="Befehl löschen";
	public static String menuHelpDeleteText="Zum löschen eines Befehls die Strg-Taste gedrückt halten und den zu löschenden Befehl anklicken.";
	public static String menuHelpEditAddress="Adressen bearbeiten";
	public static String menuHelpEditAddressText="Um die Ziele von Befehlen, die auf Adressen verweisen, zu ändern, muss vom zu ändernden Befehlen\n"
			+ "mit der rechten Maustaste eine Verbindung zum Ziel gezogen werden. Die erscheinende rote\n"
			+ "Verbindungslinie rastet auf dem Ziel ein, wenn dieses erkannt wurde. Zur besseren Zielerkennug\n"
			+ "beim Ziehen auf den Befehlstext vom Ziel zeigen.";
	
	public static String guiTabFlow="Fluss";
	public static String guiTabJumps="Sprünge";
	public static String guiTabData="Daten";
	public static String guiTabAdd="Addition";
	public static String guiTabSub="Subtraktion";
	public static String guiTabMult="Multiplikation";
	public static String guiTabDiv="Division";
	public static String guiTabMod="Modulo";
	public static String guiTabIO="Ein-/Ausgabe";
	
	public static String compilerErrorHeadline="Fehler";
	public static String compilerErrorNoProg="Kein Programm gefunden. Sind Befehle mit dem Startblock verbunden?";
	public static String compilerErrorNoHalt="Es wurde kein Haltebefehl gefunden! Übersetzen wirklich fortsetzen?";
	public static String compilerSuccess1="Übersetzen erfolgreich! Es wurden ";
	public static String compilerSuccess2=" Zeilen Code erzeugt.";
	public static String compilerSuccessHeadline="Übersetzen erfolgreich";
	public static String compilerWritingError1="Fehler beim schreiben in die Datei ";
	public static String compilerWritingError2=". Existieren die (Unter-)Ordner?";
	public static String compilerWritingErrorHeadline="Schreibfehler";
	
	public static String editorUseInstructionCellPrompt="Soll statt der Datenzelle die Instruktionszelle gewählt werden?";
	public static String editorUseInstructionCellHeadline="Speicherzelle wählen";
	
	public static String instructionAddA="Addiere Wert bei";
	public static String instructionAddC="Addiere Konstante";
	public static String instructionDivA="Teile durch Wert bei";
	public static String instructionDivC="Dividiere durch Konst.";
	public static String instructionHalt="Halt";
	public static String instructionInput="Hole Eingabe von Port";
	public static String instructionJumpGreater="Falls ACC>0 springe";
	public static String instructionJump="Springe nach";
	public static String instructionJumpLess="Falls ACC<0 springe";
	public static String instructionJumpNotNull="Falls ACC=/=0 springe";
	public static String instructionJumpNull="Falls ACC=0 springe";
	public static String instructionLoadA="Lade Wert bei";
	public static String instructionLoadC="Lade Konstante";
	public static String instructionModA="Nimm modulo Wert bei";
	public static String instructionModC="Nimm modulo Konst.";
	public static String instructionMultA="Multipliziere mit Wert bei";
	public static String instructionMultC="Multipliziere mit Konst.";
	public static String instructionNoop="Keine Operation";
	public static String instructionNull="Lade Konstante 0";
	public static String instructionOutput="Gib aus auf Port";
	public static String instructionStart="Start";
	public static String instructionStore="Speichere bei";
	public static String instructionSubA="Subtrahiere Wert bei";
	public static String instructionSubC="Subtrahiere Konstante";
}
