# Knight's Tour

This GitHub repository contains a Java program that solves the Knight's Tour problem on an empty chessboard. The
Knight's Tour is a puzzle where a knight piece starts from a specified position on the chessboard and must visit every
other field exactly once, following the legal moves of a knight.

The program utilizes an efficient algorithm to calculate the sequence of play turns required for the knight to complete
the tour. Starting from the top-left field (0,0), the program explores all possible moves, backtracking when necessary,
until it finds a valid tour or determines that no tour is possible.

## Getting Started:

1. Clone the repository to your local machine.
2. Make sure you have Java Development Kit (JDK) installed.
3. Compile the Java source files using your preferred Java compiler.
4. Run the program and wait for the result. (**Notice** on older PCs the calculation can take some time)

## Modify the program:

The program can be customized by modifying the properties in the Settings.java file.

| Property              | Description                                                                                                                                                                                                                                              |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| MAX_THREADS           | To specify the maximum number of threads for the program, set the value accordingly. If you want to run the program on a single thread, you can set the value to zero or any negative number.                                                            |
| FIELD_SIZE            | Specify the desired chessboard size for the program.                                                                                                                                                                                                     |
| ENABLE_PROCESS_OUTPUT | Enabling the program to output node states during the calculation significantly increases the calculation time due to the data output. Please note the warning that the program will take significantly longer to complete when this feature is enabled. |


## License:

The program is released under the MIT License. Feel free to modify and distribute it as per the license terms.

## Disclaimer:

This program aims to solve the Knight's Tour problem; however, it does not guarantee a solution for all board sizes. It
is important to note that when the board size is too large, the program may encounter issues such as running out of
memory or excessively long calculation times. Please be cautious when working with very large board sizes as it may lead
to program failure or impractical computation durations.