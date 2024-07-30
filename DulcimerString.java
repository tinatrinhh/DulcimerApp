import java.util.*;


/**
 * Class that models strings in dulcimer
 *
 * @author Tina Trinh
 * @version Sep. 19, 2023
 *
 */

public class DulcimerString {
	/**
	 * Fields
	 */
	public Queue<Double> queue;
	private String note;
	private int offsetFromMiddleC;

	/**
	 * Chromatic scale
	 */
	public static final List<String> chromatic = Arrays.asList("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#",
			"G", "G#");

	/**
	 * Constructor that takes the single input of note and initialize a queue
	 * containing N zeros
	 *
	 * @param note a string that represents the user input of the note
	 */
	public DulcimerString(String note) {
		this.note = note;
		offsetFromMiddleC = getOffsetFromMiddleC();
		this.queue = new LinkedList<>();

// Calculate N zeros
		double b = (22.0 - offsetFromMiddleC) / 12.0;
		double power = Math.pow(2, b);
		int N = (int) Math.round(StdAudio.SAMPLE_RATE * (power / 440));

// The for loop represents initial state of the queue
		for (int i = 0; i < N; i++) {
			queue.add(0.0);

		}

// Exception handling if queue is empty
		if (queue.isEmpty()) {
			throw new IndexOutOfBoundsException("Queue is empty.");
		}

	}

	/**
	 * this method returns the string that represents the note
	 * 
	 * @return string that represents the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * This method is used to calculate the offset from middle C
	 *
	 * @return the offset of the note from middle C
	 */
	public int getOffsetFromMiddleC() {
		

		String noteWithoutOctave = note.replaceAll("[+-]", ""); // Remove +/- characters in the note
		int index = chromatic.indexOf(noteWithoutOctave);
		if (index == -1) {
	        throw new IllegalArgumentException("Invalid note: " + note);
	    }

	    int offset = index - 3; // Adjust for C not being the first note

	    for (char c : note.toCharArray()) {
	        if (c == '+') {
	            offset += 12;
	        } else if (c == '-') {
	            offset -= 12;
	        }
	    }

	    return offset;
	}


	/**
	 * This method simulates striking the string with a hammer
	 */
	public void strike() {

		int queueSize = queue.size();

		Random random = new Random();
// clear the queue
		queue.clear();

		for (int i = 0; i < queueSize; i++) {
// Generate a random value between -0.5 and 0.5
			double randomValue = random.nextDouble() - 0.5;
// replace the values in the queue with random values
			queue.add(randomValue);
		}
	}

	/**
	 * This method returns the value currently stored at the front of the queue and
	 * updates contents of the queue so that a different sample is obtained each
	 * time the method is called.
	 *
	 * @return the front value of the the queue
	 */

	public double sample() {
// throw exception if queue size is less than 2
		if (queue.size() < 2) {
			throw new IllegalStateException("Queue must have at least 2 values for sampling.");
		}

// get the 2 front values
		double firstFrontValue = queue.peek();
		queue.remove();
		double secondFrontValue = queue.peek();

		/**
		 * adds a new value to the rear, which is the average of the two front values
		 * multiplied by a decay factor of 0.996
		 */
		double newValue = (firstFrontValue + secondFrontValue) / 2 * .996;

		queue.add(newValue);

		return firstFrontValue;
	}

}