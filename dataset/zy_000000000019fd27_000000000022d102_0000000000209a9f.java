import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(bufferedReader);
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder result = new StringBuilder();
            String s = bufferedReader.readLine();
            int val = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                int num = c - '0';
                if (num == val) {
                    result.append(c);
                } else if (num > val) {
                    for (int z = 0; z < (num - val); z++) {
                        result.append('(');
                    }
                    val = num;
                    result.append(c);
                } else if (num < val) {
                    for (int z = 0; z < (val - num); z++) {
                        result.append(')');
                    }
                    val = num;
                    result.append(c);
                }
            }
            if (val > 0) {
                result.append(")".repeat(val));
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

}
