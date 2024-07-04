import java.io.*;
import java.util.*;

public class Solution {
    public void solve() {
        Scanner scanner = new Scanner(System.in);

        int ntest = scanner.nextInt();
        int n = scanner.nextInt();

        for (int t = 0; t < ntest; t++) {
            boolean ok = ask(n);
            if (!ok) return;
        }
    }

    private boolean ask(int n) {
        StringBuilder sb = new StringBuilder();

        for (int p = 1; p <= n; p++) {
            writer.println(p);
            writer.flush();

            String answer = reader.next();
            if (answer.equals("N")) return false;

            sb.append(answer);
        }

        writer.println(sb.toString());
        writer.flush();

        String answer = reader.next();
        return answer.equals("Y");
    }

    private Scanner reader;
    private PrintWriter writer;

    public Solution() {
        reader = new Scanner(System.in);
        writer = new PrintWriter(System.out);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}