import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static boolean solve(Scanner sc, int a, int b) {
        for (int i = -5; i <= 5; ++i) {
            for (int j = -5; j <= 5; ++j) {
                System.out.printf("%d %d%n", i, j);
                switch (sc.next().toUpperCase()) {
                    case "WRONG":
                        return false;
                    case "CENTER":
                        return true;
                    default:
                        break;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            if (!solve(sc, a, b)) {
                break;
            }
        }
    }
}
