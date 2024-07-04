
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve(int b) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<b;i++) {
            out.println(i);
            sb.append(sc.nextInt());
        }
        out.println(sb.toString());
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve(b);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
