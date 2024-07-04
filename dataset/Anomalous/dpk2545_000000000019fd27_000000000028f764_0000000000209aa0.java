import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            for (int count = 1; count <= t; count++) {
                int n = in.nextInt();
                int k = in.nextInt();
                printLatinSquare(n, k, count);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void printLatinSquare(int n, int k, int count) {
        if (n * n < k) {
            System.out.print("Case #" + count + ": IMPOSSIBLE");
            return;
        }

        int x = -1;
        for (int i = 1; i <= n; i++) {
            if (n * i == k) {
                x = i;
                break;
            }
        }

        if (x == -1) {
            System.out.print("Case #" + count + ": IMPOSSIBLE");
            return;
        }

        System.out.print("Case #" + count + ": POSSIBLE");
        int y = x;
        for (int i = 0; i < n; i++) {
            System.out.println();
            y = (y == 0) ? n : y;
            x = y;
            for (int j = 0; j < n; j++) {
                System.out.print((x > n ? (x++ % n) : x++) + " ");
            }
            y--;
        }
    }
}