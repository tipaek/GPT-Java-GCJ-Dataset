import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int n = sc.nextInt();
            out.println("Case #" + test + ": ");
            if (n <= 500) {
                for (int i = 0; i < n; i++) {
                    out.println((i + 1) + " 1");
                }
            } else {
                out.println("1 1");
                out.println("2 2");
                out.println("2 1");
                out.println("3 2");
                n -= 5;
                for (int i = 0; i < n; i++) {
                    out.println((i + 3) + " 1");
                }
            }
        }
        out.flush();
        out.close();
    }
}