import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<Pair> shuffles = calculateShuffles(n, m);
            System.out.println("Case #" + i + ": " + shuffles.size());
            for (Pair pair : shuffles) {
                System.out.println(pair.a + " " + pair.b);
            }
        }
    }

    private static List<Pair> calculateShuffles(int r, int s) {
        List<Pair> shuffles = new ArrayList<>();

        if (s == 1) {
            return shuffles;
        }

        int x = 0;
        for (int b = r * s - r - 1; x / (s - 1) < r - 1; b--) {
            int a = r - (x++ / (s - 1));
            shuffles.add(new Pair(a, b));
        }

        return shuffles;
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}