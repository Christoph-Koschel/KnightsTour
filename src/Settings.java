public class Settings {

    /**
     * Specify the desired chessboard size for the program.
     */
    public static final int FIELD_SIZE = 8;

    /**
     * To specify the maximum number of threads for the program, set the value accordingly.
     * If you want to run the program on a single thread, you can set the value to zero or any negative number.
     */
    public static final int MAX_THREADS = 1024;

    /**
     * Enabling the program to output node states during the calculation significantly increases the calculation time due to the data output.
     * Please note the warning that the program will take significantly longer to complete when this feature is enabled.
     */
    public static boolean ENABLE_PROCESS_OUTPUT = true;
}
