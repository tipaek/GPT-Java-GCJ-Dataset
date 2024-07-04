import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        PrintWriter out = new PrintWriter(System.out);
        
        while (t-- > 0) {
            int u = nextInt();
            int[] frequency = new int[26];
            boolean[] used = new boolean[26];
            
            for (int i = 0; i < 10000; i++) {
                nextInt();
                char[] arr = next().toCharArray();
                
                if (arr.length == u) {
                    frequency[arr[0] - 'A']++;
                }
                
                for (char c : arr) {
                    used[c - 'A'] = true;
                }
            }
            
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                int largest = 0;
                for (int i = 1; i < 26; i++) {
                    if (frequency[i] > frequency[largest]) {
                        largest = i;
                    }
                }
                used[largest] = false;
                frequency[largest] = 0;
                ans.append((char) (largest + 'A'));
            }
            
            for (int i = 0; i < 26; i++) {
                if (used[i]) {
                    ans.insert(0, (char) (i + 'A'));
                    break;
                }
            }
            
            out.println(ans.toString());
        }
        
        out.close();
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}