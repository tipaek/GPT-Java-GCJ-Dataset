import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            String line = in.nextLine();
            int currentLevel = 0;
            for (int j = 0; j < line.length(); j++) {
                Integer value = Character.getNumericValue(line.charAt(j));
                currentLevel = value - currentLevel;
                if (currentLevel > 0) {
                    for (int k = 0; k < currentLevel;k++) {
                        sb.append("(");
                    }
                } else {
                    currentLevel = (-1)*currentLevel;
                    for (int k = 0; k < currentLevel;k++) {
                        sb.append(")");
                    }
                }

                currentLevel = value;
                sb.append(value);
            }

            for (int j = 0; j < currentLevel; j++) {
                sb.append(")");
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}