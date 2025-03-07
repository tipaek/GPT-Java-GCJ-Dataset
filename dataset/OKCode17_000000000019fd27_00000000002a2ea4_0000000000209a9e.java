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
        for(int i=1;i<=b;i++) {
            out.println(i);
            sb.append(sc.nextInt());
        }
        out.println(sb.toString());
        String response = sc.next();
        if(response.equalsIgnoreCase("N")){
            System.exit(1);
        }
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int b = sc.nextInt();
            solve(b);
        }
        sc.close();
        out.close();
        System.exit(0);
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
