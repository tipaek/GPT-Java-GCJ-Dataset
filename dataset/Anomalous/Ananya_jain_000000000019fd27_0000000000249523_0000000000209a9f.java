import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        for (int test = 1; test <= t; test++) {
            out.print("Case #" + test + ": ");
            processTestCase();
        }
        out.flush();
        out.close();
        in.close();
    }

    private static void processTestCase() throws IOException {
        char[] digits = in.next().toCharArray();
        int currentDepth = 0;

        for (char digit : digits) {
            int targetDepth = digit - '0';
            if (targetDepth > currentDepth) {
                for (int i = currentDepth; i < targetDepth; i++) {
                    out.print('(');
                }
            } else if (targetDepth < currentDepth) {
                for (int i = currentDepth; i > targetDepth; i--) {
                    out.print(')');
                }
            }
            currentDepth = targetDepth;
            out.print(digit);
        }

        for (int i = 0; i < currentDepth; i++) {
            out.print(')');
        }
        out.println();
    }
}