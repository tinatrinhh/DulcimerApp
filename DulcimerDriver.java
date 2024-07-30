import java.awt.Font;

/**
 * Driver class for the keyboard-based virtual dulcimer.
 * Currently has the bass, treble 1, and treble 2 keys 
 * 
 * @author Tina Trinh
 * @version Sep. 19, 2023
 */
public class DulcimerDriver {
	public static void main(String[] args) {
		/**
		 * Show the list of keys in the bass, treble 1 and treble 2 strings.
		 */
		String bassKeys = "a   s   d   f   g   h   j   k   l   ;   '";
		String treble1Keys = "1   2   3   4   5   6   7   8   9   0   -   = ";
		String treble2Keys = "q   w   e   r   t   y   u   i   o   p   [   ] ";

		/**
		 * Since the bass string only has 11 keys, therefore it'll have their own dashes
		 * to fit their keys
		 */
		String dashesBass = "--- --- --- --- --- --- --- --- --- --- ---";
		String trebleDashes = "--- --- --- --- --- --- --- --- --- --- --- ---";

		/**
		 * Keys on the bass, treble 1, and treble 2 strings
		 */
		String bassNotes = "G-  A   B   C   D   E   F   G   A+ A#+  C+";
		String treble1Notes = "G# A+  B+  C#+  D+  E+ F#+  G+ A++ B++ C++ D++";
		String treble2Notes = "C#  D   E  F#   G   A+  B+  C+  D+  E+  F#+ G+";

		/**
		 * Draw dulcimer mapping Draw the environment of each keys and notes of bass,
		 * treble 1, and treble 2 strings
		 */
		StdDraw.setFont(new Font("Monospaced", Font.PLAIN, 12));
		StdDraw.textLeft(0.00, 1.00, "DULCIMER KEY MAPPINGS");

		// Bass environment
		StdDraw.textLeft(0.00, 0.90, "        keys:  " + bassKeys);
		StdDraw.textLeft(0.00, 0.87, "BASS          " + dashesBass);
		StdDraw.textLeft(0.00, 0.84, "       notes:  " + bassNotes);

		// Treble 1
		StdDraw.textLeft(0.00, 0.70, "        keys:  " + treble1Keys);
		StdDraw.textLeft(0.00, 0.67, "Treble 1      " + trebleDashes);
		StdDraw.textLeft(0.00, 0.64, "       notes:  " + treble1Notes);

		// Treble 2
		StdDraw.textLeft(0.00, 0.50, "        keys:  " + treble2Keys);
		StdDraw.textLeft(0.00, 0.47, "Treble 2      " + trebleDashes);
		StdDraw.textLeft(0.00, 0.44, "       notes:  " + treble2Notes);

		/**
		 * remove all the spaces in the strings of bass keys, treble 1 keys, and treble
		 * 2 keys.
		 */
		String keyBass = bassKeys.replace(" ", "");
		String keyTreble1 = treble1Keys.replace(" ", "");
		String keyTreble2 = treble2Keys.replace(" ", "");

		Dulcimer dulc = new Dulcimer(bassNotes, treble1Notes, treble2Notes);
		while (true) {
			if (StdDraw.hasNextKeyTyped()) {

				/**
				 * ensure that the char typed is not case sensitive by convert the character to
				 * lower case
				 */

				char typed = Character.toLowerCase(StdDraw.nextKeyTyped());
				int typedIndex;

				// Play bass notes on bass strings if hit a bass key
				if (keyBass.indexOf(typed) != -1) {
					typedIndex = keyBass.indexOf(typed);
					dulc.hammerBass(typedIndex);

					// Play treble 1 notes on treble 1 string if hit a treble 1 key
				} else if (keyTreble1.indexOf(typed) != -1) {
					typedIndex = keyTreble1.indexOf(typed);
					dulc.hammerTreble1(typedIndex);

					// Play treble 2 notes on treble 2 string if hit a treble 2 key
				} else if (keyTreble2.indexOf(typed) != -1) {
					typedIndex = keyTreble2.indexOf(typed);
					dulc.hammerTreble2(typedIndex);
				}
			}
			dulc.play();
		}
	}
}
