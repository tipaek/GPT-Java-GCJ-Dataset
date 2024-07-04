import java.util.*;
import java.io.*;

// 321232
// (((3)2)1(2(3)2))

/**
 Timo Hromadka
 - add opening paranthesis as needed and add closing paranthesis when encountered with a successive number that is smaller
 - equal digits may be grouped together whenever they are right next to eachother
 */
class Solution2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int count = in.nextInt();
        // System.out.println("count: " + count);
        for (int i = 1; i <= count; i++) {
            String finalString = "";
            String input = in.next();

            int[] intInput = new int[input.length()];
            char[] charInput = input.toCharArray();

            for (int j = 0; j < charInput.length; j++) {
                intInput[j] = Character.getNumericValue(charInput[j]); // convert to int array from char array
            }

            for (int j = 0; j < intInput.length; j++) { // main string building loop
                if (j==0) { // first element in the array used to construct the initial paranthesis
                    for (int amt = 0; amt < intInput[j]; amt++) finalString += "(";
                }
                else if (intInput[j] > intInput[j-1]) {
                    for (int amt = 0; amt < (intInput[j]-intInput[j-1]); amt++) finalString += "(";

                }
                else if (intInput[j] < intInput[j-1]) {
                    for (int amt = 0; amt < (intInput[j-1]-intInput[j]); amt++) finalString += ")";
                }
                else { // the numbers are the same
                    // do nothing!
                }
                finalString += intInput[j];
            }
            for (int amt = 0; amt < intInput[intInput.length-1]; amt++) finalString += ")"; // close off all paranthesis

            System.out.println("Case #" + count + ": " + finalString);

        }
    }
}