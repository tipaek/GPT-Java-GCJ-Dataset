import java.util.*;
import java.io.*;
public class Solution {


    

    public static String nestingDepth(int caseNum, String row) {
        StringBuilder result = new StringBuilder();
        char[] chars = row.toCharArray();
        int prev = 0;
        for (char c : chars) {
            int val = Character.getNumericValue(c);
            result.append(generateP(prev - val, false));
            result.append(generateP(val - prev, true));
            result.append(val);
            prev = val;
        }

        result.append(generateP(prev - 0, false));


        return "Case #" + caseNum + ": " + result.toString();
    }

    public static String generateP(int pNumber, boolean open) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pNumber; i++) {
            builder.append(open ? "(" : ")");
        }
        return builder.toString();
    }



    public static void main(String[] args) {



        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            System.out.println(nestingDepth(i, s));
        }
    }
}