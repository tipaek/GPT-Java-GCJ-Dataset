import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {

    private static final boolean DEBUG = false;

    public static String result(int X, int Y, String path) {
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                Y++;
            } else if (path.charAt(i) == 'S') {
                Y--;
            } else if (path.charAt(i) == 'W') {
                X++;
            } else {
                X--;
            }
            int result = Math.abs(X) + Math.abs(Y);
            int max = i + 1;
            if (result <= max) {
                return max + "";

            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("resources/input.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                String path = scanner.next();
                System.out.println("Case #" + testNumber + ": " + result(X, Y, path));
            }
        }
    }
}