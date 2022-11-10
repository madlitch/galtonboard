# GaltonBoard

## Project Description
- The project implements a Galton-Board Simulation using a defined number of balls that fall into a defined number of Bins through a tree like pattern of pegs.
- The balls fall through the tree in random directions. The position of the balls on the final level of the tree helps determine the bin they fall in.
- This randomly generated sample of data should follow the Central Limit Theorem(CLT). According to CLT, the final distribution of balls among bins should follow a normal distribution.

## Project Requirements
The requirements stated in the project outline include:
1. The program must have an option to simulate 6 different number of balls to be dropped
2. The program should implement and interactive Graphical User Interface that allows the user to enter the number of Bins and the number of Balls to be dropped.
3. The GUI should further create a Bar Graph showing the normal distribution that was created

## Classes Included
- GaltonBoard: This class uses recursive functions to find random bins for the balls and adds these values to the array.
- PinGraph: This class provides an array implementation of the graph of Pins that the balls fall through
- Node: Each Pin in the graph is an object of class Node. Each pin has a level, bin and left and right children associated with it.
- GaltonBoardGUI: Create an interactive interface and displays a bar chart based on the generated normal distribution.

## Usage
If Self Compiling:
1. Download the submitted .zip folder.
2. Extract all the files in the preferred local repository.
3. Open the source files in the required IDE (preferably Eclipse or IntelliJ).
4. The required classes can be found in the src folder.
5. Compile and run the main function in the GaltonBoardGUI class.
6. A Graphical user Interface will appear.
7. Enter the preferred values for the number of Balls and the number of Slots/Bins.
8. Click the Start button.
9. The generated bar chart will show a Normal Distribution.

If Running as a Standalone Program:
1. Download the submitted .zip folder.
2. Run the executable Galton Board.jar.
3. A Graphical user Interface will appear.
4. Enter the preferred values for the number of Balls and the number of Slots/Bins.
5. Click the Start button.
6. The generated bar chart will show a Normal Distribution.

- Depending on the specifications on your machine, it will take around 1000 seconds to compute 1 billion balls dropped with 20 slots.
- Legibility of the ball readout on each bar in the graph will be lost with over 80 slots.

## Credit
Created for SOFE2715U in 2020 by:
- Massimo Albanese - 100616057
- Clarissa Branje - 100716458
- Haider Sarmad - 100622306
- Tegveer Singh - 100730432