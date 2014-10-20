package MIB13;

/**
 * Created by niiru on 17.10.14.
 * <p/>
 * Die Zeile, die der Spieler erraten soll.
 * Zum erzeugen MUSS ein Boolean übergeben werden, mit der Option, ob
 * Farben doppelt vorkommen dürfen.
 */
public class MasterLine extends Line {
	
	new Balls[] = new Int[3];

    public MasterLine(boolean multiColors) {

        if (!multiColors) {
            createSimpleLine();
        } else {
            createMultiLine();
        }
        lineNumber = -1; //Unnötig? Identifizierend für die Masterline (negative Zahl)
    }

    private void createMultiLine() {
        /**
         * Es sollen 4 zufällige Zahlen durch RNG berechnet werden.
         *
         * Wiederholungen sind ERLAUBT und gewünscht.
         *
         * Jede Zahl steht für eine Farbe.
         * Für jede Farbe soll eine neue Kugel erzeugt
         * und dem Balls[] hinzugefügt werden.
         */
    	
    	for (int i = 0; i <= 3; i++){
    		Balls[i] = randomNumberGenerator();
    	}

    }

    private void createSimpleLine() {
        /**
         * Es sollen 4 zufällige Zahlen durch RNG berechnet werden.
         *
         * Wiederholungen sind NICHT erlaubt.
         *
         * Jede Zahl steht für eine Farbe.
         * Für jede Farbe soll eine neue Kugel erzeugt
         * und dem Balls[] hinzugefügt werden.
         */
    	
    	int x = 0;
    	int y = 0;
    	
    	for (int i = 0; i <= 3; i++) {
    		do {
    			x = randomNumberGenerator();
    			for (int j = 0; j <= 3; j++) {
    				if (x == Balls[j]) {
    					y = 1;
    				}
    			}
    		} while (y == 1);
    		Balls[i] = x;
    	}

    }

    private int randomNumberGenerator() {
        /**
         * Es soll nur eine Zufällige Zahl generiert werden.
         * Zahlenraum 0 - n für n = Anzahl der Farben-1
         */
        int random = generator.nextInt(7);


        return random;
    }

}
