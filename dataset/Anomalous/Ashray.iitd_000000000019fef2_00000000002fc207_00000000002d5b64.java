import java.util.*;
import java.io.*;

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Solution {

    public static List<Pair> generatePairs(int r, int s) {
        List<Pair> pairs = new ArrayList<>();
        while (r > 1) {
            for (int i = 1; i < s; i++) {
                int t = r * s - r - i;
                pairs.add(new Pair(r, t));
            }
            r--;
        }
        return pairs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            if (t > 0) {
                System.out.println();
            }
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            List<Pair> pairs = generatePairs(r, s);
            System.out.print("Case #" + (t + 1) + ": " + pairs.size());
            for (Pair pair : pairs) {
                System.out.println();
                System.out.print(pair.a + " " + pair.b);
            }
        }
        scanner.close();
    }
}