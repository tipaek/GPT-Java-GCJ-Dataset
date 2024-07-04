import javax.swing.*;

public class Nesting_depths
{
    public static void main(String[] args) {

        // instance variables
        String s; // input string
        String output; // output string
        int i; // index counter

        int difference;
        int num;
        int previousNum;
        String hastag = "#";

        int tests = Integer.valueOf(JOptionPane.showInputDialog(null, "Enter number of tests you wish to run"));
        System.out.println("Input \t\tOutput");
        System.out.println();
        System.out.println(tests);

        for (int t = 1; t <= tests; t++) {
            // get the input from user
            s = JOptionPane.showInputDialog(null, "enter integer");

            // initialise variables
            num = 0;
            output = "";
            previousNum = 0;
            i=0;

            while (i < s.length()) {

                // save current character as an integer
                num = Integer.valueOf(String.valueOf(s.charAt(i)));

                // find the difference between current digit and previous digit
                difference = previousNum - num;

                // open the number of brackets required if previous digit was smaller
                if (difference < 0) {
                    for (int j = 0; j > difference; j--) {
                        output += "(";
                    }
                }
                // close the number of brackets required if previous digit was larger
                else if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        output += ")";
                    }
                }

                output += String.valueOf(num); // add in the digit
                i++; // iterate counter
                previousNum = num; // save current digit as the previous digit for next iteration of loop
            }

            // close remaining brackets after last digit
            for (i = 0; i < num; i++) {
                //d = String.valueOf(i);
                output += ")";
            }

            // print formatted output
            System.out.println(s + "\t\t" + "Case" + hastag + t + "\t" + output);
        }
    }
}