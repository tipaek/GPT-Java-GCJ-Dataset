
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String src = in.next();
            StringBuilder resultSB = new StringBuilder();
            int[] input = new int[src.length()];

            int idx = 0;
            for (char c : src.toCharArray()) {
                input[idx++] = c - '0';
            }
            int currentLevel = 0;

            for (int temp : input) {
                if (temp == currentLevel){
                    resultSB.append(temp);
                }else if (temp > currentLevel){
                    int diff = temp - currentLevel;
                    for (int j = 0; j < diff; j++) {
                         resultSB.append('(');
                    }
                    resultSB.append(temp);
                    currentLevel = temp;
                } else {
                    int diff = currentLevel - temp;
                    for (int j = 0; j < diff; j++) {
                        resultSB.append(')');
                    }
                    resultSB.append(temp);
                    currentLevel = temp;
                }
            }

            if (currentLevel > 0) {
                for (int j = 0; j < currentLevel; j++) {
                    resultSB.append(')');
                }
            }

            System.out.println(String.format("Case #%d: %s", i, resultSB.toString()));
        }


    }
}
