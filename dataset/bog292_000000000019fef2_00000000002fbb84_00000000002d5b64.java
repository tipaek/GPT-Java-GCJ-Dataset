import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/jointheranks/input.txt"))));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int nr = 1; nr <= t; ++nr) {
            int x = in.nextInt();
            int y = in.nextInt();
            
            solve(nr, x, y);
        }
    }

    private static void solve(int nr, int x, int y) {
        System.out.println("Case #" + nr + ": " + (x - 1) * (y - 1));
        for (int i = x; i > 1; i--) {
            printSolution(i, y);
        }
    }

    private static void printSolution(int x, int y) {
        int k = x * (y - 1);
        for (int i = 0; i < y - 1; i++) {
            System.out.println((k - i) + " " + (x - 1));
        }
    }
}