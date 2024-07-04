import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        long testCases = reader.nextLong();

        for (long t = 1; t <= testCases; t++) {
            String input = reader.nextLine();
            StringBuilder result = new StringBuilder();

            int previousDepth = 0;
            for (char ch : input.toCharArray()) {
                int currentDepth = Character.getNumericValue(ch);
                while (previousDepth < currentDepth) {
                    result.append('(');
                    previousDepth++;
                }
                while (previousDepth > currentDepth) {
                    result.append(')');
                    previousDepth--;
                }
                result.append(ch);
            }
            while (previousDepth > 0) {
                result.append(')');
                previousDepth--;
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}