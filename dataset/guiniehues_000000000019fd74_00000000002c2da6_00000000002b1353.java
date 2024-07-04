import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static String solve() {
        int n = scanner.nextInt();

        LinkedList<int[]> position = new LinkedList<>();

        position.add(new int[] {1, 1});
        n -= 1;

        if (n > 0) {
            position.add(new int[] {2, 1});
            n -= 1;
        }

        if (n == 1) {
            position.add(new int[] {3, 1});
            n -= 1;
        }

        if (n > 0) {
            position.add(new int[] {3, 2});
            n -= 2;
        }

        while (n > 0) {
            int[] last = position.getLast();

            int lastR = last[0];
            int lastK = last[1];

            if (lastK == 2) {
                if (n - lastR >= 0) {
                    position.add(new int[] {lastR + 1, 2});
                    n -= lastR;
                } else {
                    position.add(new int[] {lastR, 1});
                    n -= 1;
                }
            } else {
                position.add(new int[] {lastR + 1, 1});
                n -= 1;
            }
        }

        return position.stream()
                .map(ints -> "\n" + ints[0] + " " + ints[1])
                .collect(Collectors.joining());
    }

}
