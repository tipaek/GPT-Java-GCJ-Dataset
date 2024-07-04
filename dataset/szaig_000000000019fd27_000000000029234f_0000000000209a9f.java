
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String input = in.nextLine();
        for (int qdx = 1; qdx <= t; ++qdx) {
            int prev = 0;
            input = in.nextLine();
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                int a = input.charAt(i) - 48;
                if (prev < a) {
                    for (int j = 0; j < a - prev; j++) {
                        res.append("(");
                    }
                } else if (prev > a) {
                    for (int j = 0; j < prev - a; j++) {
                        res.append(")");
                    }
                }
                res.append(a);
                prev = a;
            }
            for (int j = 0; j < prev; j++) {
                res.append(")");
            }

            System.out.println("Case #" + qdx + ": " + res.toString());
        }
    }
}