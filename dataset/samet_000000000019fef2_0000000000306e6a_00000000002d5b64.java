import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt(); // people
            int y = in.nextInt(); // grid size
            if (i < t)
                System.out.println("Case #" + i + ": " + findPath(x,y));
            else System.out.print("Case #" + i + ": " + findPath(x,y));
        }
    }

    private static String findPath(int r, int s) {

        String response = "";
        response += (r-1) * (s-1); // int
        int total = r*s;
        int found = 1;
        int round = 1;

        for (int i = 0; i < r-1; i++ ) {
            for (int j = 0; j < s-1; j++ ) {
                int b = r - round;
                int a = total - (b + found);
                response += "\n";
                response+= a + " " + b;
                found++;
            }
            round++;
            found++;

        }

        return response;

    }

}

