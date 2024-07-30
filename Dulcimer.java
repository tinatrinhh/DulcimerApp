import java.util.ArrayList;

/**
 * Class that models a dulcimer (included bass, treble 1, and treble 2 strings)
 * 
 * @author Tina Trinh
 * @version Sep. 19, 2023
 */
public class Dulcimer {
	/**
	 * Fields of bass, treble 1, and treble 2 strings.
	 */
	public ArrayList<DulcimerString> bassStrings;
	public ArrayList<DulcimerString> treble1Strings;
	public ArrayList<DulcimerString> treble2Strings;

	/**
	 * Constructs a Dulcimer with the specified bass strings, treble 1 strings, and
	 * treble 2 strings.
	 * 
	 * @param bassNotes    a String specifying the bass notes, from bottom to top
	 * @param treble1Notes a String specifying treble 1 notes, from bottom to top
	 * @param treble2Notes a String specifying treble 2 notes, from bottom to top
	 */
	public Dulcimer(String bassNotes, String treble1Notes, String treble2Notes) {
		this.bassStrings = new ArrayList<>();
		this.treble1Strings = new ArrayList<>();
		this.treble2Strings = new ArrayList<>();

		initializeStrings(this.bassStrings, bassNotes);
		initializeStrings(this.treble1Strings, treble1Notes);
		initializeStrings(this.treble2Strings, treble2Notes);
	}
	
	
	/**
	 * Helper method to initialize the string 
	 * @param strings
	 * @param notes
	 */
	

	private void initializeStrings(ArrayList<DulcimerString> strings, String notes) {
		for (String str : notes.split("\\s+")) {
			strings.add(new DulcimerString(str));
		}
	}

	/**
	 * Strikes the specified string in the bass and sets it to vibrating.
	 * 
	 * @param stringNum the string number of bass key notes (starting at the bottom
	 *                  with 0)
	 */
	public void hammerBass(int stringNum) {
		if (stringNum >= 0 && stringNum < this.bassStrings.size()) {
			this.bassStrings.get(stringNum).strike();
		}
	}

	/**
	 * Strikes specified string in the treble 1 and set it to vibrating
	 * 
	 * @param stringNum the string number of treble 1 key notes (starting at the
	 *                  bottom with 0)
	 */

	public void hammerTreble1(int stringNum) {
		if (stringNum >= 0 && stringNum < this.treble1Strings.size()) {
			this.treble1Strings.get(stringNum).strike();
		}
	}

	/**
	 * Strike specified string in treble 2 and set it to vibrating
	 * 
	 * @param stringNum the string number of treble 2 key notes (starting at the
	 *                  bottom with 0)
	 */
	public void hammerTreble2(int stringNum) {
		if (stringNum >= 0 && stringNum < this.treble2Strings.size()) {
			this.treble2Strings.get(stringNum).strike();
		}
	}

	/**
	 * Plays the sounds corresponding to all of the struck strings of bass, treble
	 * 1, and treble 2 strings.
	 * 
	 */
	public void play() {
		double combinedFrequenciesBass = 0.0;
		double combinedFrequenciesTreble1 = 0.0;
		double combinedFrequenciesTreble2 = 0.0;

		for (int i = 0; i < this.bassStrings.size(); i++) {
			combinedFrequenciesBass += this.bassStrings.get(i).sample();

		}

		for (int i = 0; i < this.treble1Strings.size(); i++) {
			combinedFrequenciesTreble1 += this.treble1Strings.get(i).sample();
		}

		for (int i = 0; i < this.treble2Strings.size(); i++) {
			combinedFrequenciesTreble2 += this.treble2Strings.get(i).sample();
		}

		StdAudio.play(combinedFrequenciesBass + combinedFrequenciesTreble1 + combinedFrequenciesTreble2);
	}
}