import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    // Discuss this round on Codeforces: https://codeforces.com/blog/entry/71545

    static void solve() throws Exception {
        String inputString = readString();
        int currentDepth = 0;
        printCase();
        
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            int nextDepth = currentChar - '0';
            
            while (currentDepth < nextDepth) {
                out.print('(');
                currentDepth++;
            }
            while (currentDepth > nextDepth) {
                out.print(')');
                currentDepth--;
            }
            out.print(currentChar);
        }
        
        while (currentDepth > 0) {
            out.print(')');
            currentDepth--;
        }
        out.println();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    static long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    static String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static void printCase() {
        out.print("Case #" + testNumber + ": ");
    }

    static void printlnCase() {
        out.println("Case #" + testNumber + ":");
    }

    static BufferedReader reader;
    static PrintWriter out;
    static StringTokenizer tokenizer;
    static int testNumber;

    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int numberOfTests = readInt();
            
            for (testNumber = 1; testNumber <= numberOfTests; testNumber++) {
                solve();
            }
            
            reader.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}