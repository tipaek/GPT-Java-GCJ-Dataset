/**
 *  Alex Tresselt
 *  Google Code Jam
 *  Qualification Round - Nesting Depth
 *  4/3/20
 */

import java.util.*;
import java.io.*;

class Solution {

    /**
     * Given a String of numbers, outputs it with nested parentheses
     * Ex. "312" --> "(((3))1(2))
     * @param string a string of only numbers
     */
    private static void nesting(String string) {
        int prev = 0; // Previous element

        for (int i = 0; i < string.length(); i++) {
            int curr = Character.getNumericValue(string.charAt(i)); // get value of number from string
            int diff = curr - prev; // find difference between current number and the previous

            // Determine the type of parentheses to use based on the difference
            char paren = (diff < 0) ? ')' : '(';

            // Print the parentheses p times, where p is the absolute value of the difference
            for (int p = 0; p < Math.abs(diff); p++) {
                System.out.print(paren);
            }

            // Print current number
            System.out.print(curr);

            // Set current to previous for next loop
            prev = curr;
        }

        // Print the remaining closing parentheses for the last number
        for (int p = 0; p < prev; p++) {
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        // Standard input from the FAQ
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Get number of cases
        int numCases = in.nextInt();
        in.nextLine(); // Consume the newline character

        // For each case, print out the results
        for (int i = 1; i <= numCases; i++) {
            System.out.print("Case #" + i + ": ");
            nesting(in.nextLine());
            System.out.println();
        }
    }
}