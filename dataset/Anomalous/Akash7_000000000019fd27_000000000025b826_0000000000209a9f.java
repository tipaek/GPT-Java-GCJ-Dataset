import java.io.*;
import java.util.*;

class Solution {

    static void makeNest(String s, int testNo) {
        StringBuilder sDash = new StringBuilder();
        int length = s.length();

        if (length == 1) {
            int num = s.charAt(0) - '0';
            sDash.append("(".repeat(num));
            sDash.append(s.charAt(0));
            sDash.append(")".repeat(num));
        } else {
            int prev = s.charAt(0) - '0';
            sDash.append("(".repeat(prev));
            sDash.append(s.charAt(0));

            for (int i = 1; i < length; i++) {
                int current = s.charAt(i) - '0';

                if (prev < current) {
                    sDash.append("(".repeat(current - prev));
                } else if (prev > current) {
                    sDash.append(")".repeat(prev - current));
                }

                sDash.append(s.charAt(i));
                prev = current;
            }

            sDash.append(")".repeat(prev));
        }

        PrintWriter writer = new PrintWriter(System.out);
        writer.write("Case #" + testNo + ": " + sDash + "\n");
        writer.flush();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 1; k <= t; k++) {
            String inp = br.readLine();
            makeNest(inp, k);
        }
    }
}