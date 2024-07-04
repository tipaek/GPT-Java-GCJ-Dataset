import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int i = 0; i < t; ++i) {
            String input = scan.next();
            StringBuilder output = new StringBuilder();
            int currentLevel = 0;

            for (int j = 0; j < input.length(); ++j) {
                int digit = Character.getNumericValue(input.charAt(j));

                while (currentLevel < digit) {
                    output.append("(");
                    currentLevel++;
                }

                while (currentLevel > digit) {
                    output.append(")");
                    currentLevel--;
                }

                output.append(digit);
            }

            while (currentLevel > 0) {
                output.append(")");
                currentLevel--;
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}