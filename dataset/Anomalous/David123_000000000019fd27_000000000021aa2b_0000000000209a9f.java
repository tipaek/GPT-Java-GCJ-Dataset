import java.util.*;
import java.io.*;

public class Solution {

    public static String findSolution(String s) {
        StringBuilder sol = new StringBuilder();
        int lastVal = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = Character.getNumericValue(s.charAt(i));
            int diff = val - lastVal;

            if (diff > 0) {
                sol.append("(".repeat(diff));
            } else if (diff < 0) {
                sol.append(")".repeat(-diff));
            }

            sol.append(s.charAt(i));
            lastVal = val;
        }

        sol.append(")".repeat(lastVal));
        return sol.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();

        for (int i = 1; i <= numTestCase; i++) {
            String s = in.next();
            String solution = findSolution(s);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}