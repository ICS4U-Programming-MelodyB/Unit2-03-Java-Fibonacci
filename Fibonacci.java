import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program uses recursion to calculate
 * the Fibonacci.
 *
 * @author  Melody Berhane
 * @version 1.0
 *
 * @since 2023-04-24.
 */

public final class Fibonacci {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String line = sc.nextLine();
                try {
                    // Parse the input into a double.
                    final int newLine = Integer.parseInt(line);

                    // Declare variable.
                    final int aStr = newLine;

                    // If aStr is greater than 0
                    // call the function.
                    if (aStr >= 0) {
                        final int fibNum = funcFibonacci(aStr);
                        // Write to console.
                        write.print("The fibonacci sequence of " + aStr);
                        write.println(" is " + fibNum);
                    }

                } catch (NumberFormatException error) {
                    // Displays error to user if input is not a valid int.
                    write.println("Error: Invalid, \""
                            + line + "\" is not a valid number.");
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * calculate Fibonacci.
    *
    * @param num passed
    * @return funcFibonacci.
    */

    public static int funcFibonacci(int num) {
        // Calculates factorial.
        if (num == 0) {
            // Returns 0 because it is one of the base cases
            return 0;
        } else if (num == 1) {
            // Returns 1 because it is one of the base cases
            return 1;
        } else {
            // Calls function recursively.
            return funcFibonacci(num - 1) + funcFibonacci(num - 2);
        }
    }
}
