import java.util.*;
import java.io.*;
public class Solution {
    public static void solve(int t, int n){
        if (n <= 500){
            System.out.println("Case #" + t + ": ");
            for (int i = 1; i <= n; i++){
                System.out.println(i + " 1");
            }
            return;
        }
        if (n == 501){
            System.out.println("Case #" + t + ": ");

            System.out.println("1 1");

            System.out.println("2 1");

            System.out.println("2 2");
            for (int i = 3; i <= n; i++){

                System.out.println(i + " 1");
            }
            return;
        }


        //System.out.println("Case #" + t + ": " + resString);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            solve(i, n);
        }
    }
}
