# Dulcimer Simulator 
**Description**: A virtual dulcimer for playing and experimentation.

## About 
This project is a digital simulation of a dulcimer. It aims to provide a virtual instrument for learning, practicing, and experimenting with dulcimer music. Users can interact with the simulated dulcimer to play notes, chords, and melodies.

This project employs a queue data structure to model the behavior of a dulcimer string. To represent the string's initial state, the queue is populated with random values uniformly distributed between -0.5 and 0.5. Simulating a plucked string involves a wave-like propagation of displacement. The Karplus-Strong algorithm is used to achieve this effect. The algorithm iteratively appends the average of the queue's first two elements, scaled by a decay factor of 0.996, to the queue's end while simultaneously removing the first element. This simple algorithm provides an effective model of the string vibration due to two features: the queue feedback mechanism and the averaging operation.
1. **The queue feedback mechanism**: The queue models the medium (a string fixed at both ends) in which the energy travels back and forth. The length of the queue determines the fundamental frequency of the resulting sound. Sonically, the feedback mechanism reinforces only the fundamental frequency and its harmonics (frequencies at integer multiples of the fundamental). The energy decay factor (.996 in this case) models the slight dissipation in energy as the wave makes a roundtrip through the string.
2. **The averaging operation**: The averaging operation serves as a gentle low pass filter (which removes higher frequencies while allowing lower frequencies to pass). Because it is in the path of the feedback, this has the effect of gradually attenuating the higher harmonics while keeping the lower ones, which corresponds closely with how a struck wire actually sounds.

**Key features**
* Interactive dulcimer interface
* Basic sound generation and playback
* Potential for customization (e.g., tuning, string types)


## Getting started 
### Prerequisites
* Java Runtime Environment (JRE) installed
* A preferred IDE (e.g., Eclipse)

### Cloning the code from Github and run it 
1. **Open Eclipse**: Launch the Eclipse IDE
2. **Import the project from GitHub**:
   * Click on Import -> Projects from Git (with smart import), then click **Next**
   * Choose Clone URI, then click **Next**
   * Copy the URI from Git then paste it in Eclipse
     *  git clone: git@github.com:tinatrinhh/DulcimerApp.git
3. Right click on the DulcimerDriver -> Run as -> Java Application


# Acknowledgements 
This project is inspired by an assignment introduced by Kevin Wayne (Princeton University) and refined by Stuart Reges (University of Washington). The code has been significantly expanded and improved upon. 
