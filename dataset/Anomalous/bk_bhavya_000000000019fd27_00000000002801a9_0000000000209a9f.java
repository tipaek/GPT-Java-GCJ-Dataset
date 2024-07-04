import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = 1;
        
        while (t-- > 0) {
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            int targetDepth = s.charAt(0) - '0';
            
            // Adjust initial depth
            while (currentDepth < targetDepth) {
                result.append('(');
                currentDepth++;
            }
            result.append(s.charAt(0));
            
            for (int i = 1; i < s.length(); i++) {
                targetDepth = s.charAt(i) - '0';
                int previousDepth = s.charAt(i - 1) - '0';
                
                if (targetDepth > previousDepth) {
                    while (currentDepth < targetDepth) {
                        result.append('(');
                        currentDepth++;
                    }
                } else if (targetDepth < previousDepth) {
                    while (currentDepth > targetDepth) {
                        result.append(')');
                        currentDepth--;
                    }
                }
                result.append(s.charAt(i));
            }
            
            // Close remaining open parentheses
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}