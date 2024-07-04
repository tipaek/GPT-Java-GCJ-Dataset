import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        JoinTheRanks joinTheRanks = new JoinTheRanks();
        joinTheRanks.solve();
    }
}

class JoinTheRanks {

    private final int t;
    private final FScanner in;
    private final FPrinter out;

    JoinTheRanks() throws IOException {
        in = new FScanner();
        t = in.nextInt();
        out = new FPrinter();
    }

    void analyzeCase(int testCaseNumber) throws IOException {
        int r = in.nextInt();
        int s = in.nextInt();
        int answer = (r - 1) * (s - 1);
        out.printlnCase(testCaseNumber, answer);
        
        int sa = r * (s - 1);
        int sb = r - 1;
        
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < s - 1; j++) {
                out.printlnPair(sa, sb);
                sa--;
            }
            sb--;
        }
    }

    void solve() throws IOException {
        for (int testCaseNumber = 1; testCaseNumber <= t; testCaseNumber++) {
            analyzeCase(testCaseNumber);
        }
        out.close();
    }
}

class FScanner {

    private final StreamTokenizer tokenizer;

    FScanner() throws IOException {
        tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    int nextInt() throws IOException {
        tokenizer.nextToken();
        return (int) tokenizer.nval;
    }

    double nextDouble() throws IOException {
        tokenizer.nextToken();
        return tokenizer.nval;
    }

    String next() throws IOException {
        tokenizer.nextToken();
        return tokenizer.sval;
    }
}

class FPrinter {

    private final PrintWriter writer;

    FPrinter() {
        writer = new PrintWriter(System.out);
    }

    void printlnPair(long a, long b) {
        writer.print(a);
        writer.print(" ");
        writer.println(b);
    }

    void printlnCase(int testCaseNumber, long answer) {
        writer.print("Case #");
        writer.print(testCaseNumber);
        writer.print(": ");
        writer.println(answer);
    }

    void close() {
        writer.flush();
        writer.close();
    }
}