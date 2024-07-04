import java.util.*;
import java.io.*;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(nextToken());
        for (int t = 1; t <= testCases; t++) {
            String inputString = nextToken();
            StringBuilder output = new StringBuilder();
            boolean previousOne = false;

            for (int i = 0; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                if (currentChar == '1') {
                    if (!previousOne) {
                        output.append("(");
                    }
                    previousOne = true;
                } else {
                    if (previousOne) {
                        output.append(")");
                    }
                    previousOne = false;
                }
                output.append(currentChar);
            }

            if (previousOne) {
                output.append(")");
            }

            System.out.println("Case #" + t + ": " + output);
        }
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}