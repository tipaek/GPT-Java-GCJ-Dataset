import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            String str = in.next();
            StringBuilder result = new StringBuilder();
            int prev = 0;

            for (int i = 0; i < str.length(); i++) {
                int current = str.charAt(i) - '0';

                if (current > prev) {
                    for (int j = 0; j < current - prev; j++) {
                        result.append('(');
                    }
                } else if (current < prev) {
                    for (int j = 0; j < prev - current; j++) {
                        result.append(')');
                    }
                }

                result.append(str.charAt(i));
                prev = current;
            }

            for (int j = 0; j < prev; j++) {
                result.append(')');
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }
}