import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        public final int n1;
        public final int n2;

        Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + (i + 1) + ":");

            if (n == 1) {
                System.out.println("1 1");
                continue;
            }

            int half = (n + 1) / 2;
            ArrayList<Pair> pairs = new ArrayList<>();

            for (int j = 1; j <= half; j++) {
                pairs.add(new Pair(j, 1));
            }

            if (n % 2 == 1) {
                pairs.add(new Pair(half, 2));
            } else {
                pairs.add(new Pair(half + 1, 2));
            }

            for (Pair pair : pairs) {
                System.out.println(pair.n1 + " " + pair.n2);
            }
        }
    }
}