import java.util.*;
import java.io.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt();
        for (int i = 0; i < t; i++) {
            if (b == 10) {
                solve_simple();
            } else {
                solve(b);
            }
            String c = in.next();
        }
    }

    private static void solve(int b) {

    }


    private static void solve_simple() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            int x = in.nextInt();
            sb.append(x);
        }
        System.out.println(sb.toString());
    }
}