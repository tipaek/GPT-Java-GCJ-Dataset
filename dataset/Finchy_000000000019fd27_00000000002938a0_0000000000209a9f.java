import java.util.*;
import java.io.*;
import java.lang.Math;

class nestingDepth {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String tString = in.nextLine();
        int t = Integer.parseInt(tString);
        for (int i = 1; i <= t; ++i) {
            String string = in.nextLine();
            char[] cArr = string.toCharArray();
            int depth = 0;
            String answer = "";

            for (char currentChar: cArr) {
                int intValue = Character.getNumericValue(currentChar);
                if (intValue > depth) {
                    while (intValue > depth) {
                        answer += "(";
                        depth++;
                    }
                    answer += Integer.toString(intValue);
                } else if (intValue == depth) {
                    answer += intValue;
                } else if (intValue < depth) {
                    while (intValue < depth) {
                        answer += ")";
                        depth--;
                    }
                    answer += Integer.toString(intValue);
                }
            }

            while (depth > 0) {
                answer += ")";
                depth--;
            }
            System.out.println("Case #" + i + ": " + answer);
        }
    }
}