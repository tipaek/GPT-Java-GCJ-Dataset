import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void solve(Scanner scanner, int tc) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (k % n != 0) {
            System.out.println(String.format("Case #%d: IMPOSSIBLE", tc));
            return;
        } else {
            System.out.print(String.format("Case #%d: POSSIBLE", tc));
        }

        List<List<Integer>> array = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            row.add(i + 1);
        }

        for (int i = 0; i < n; i++) {
            array.add(new ArrayList<>(row));
            row.add(0, row.remove(n - 1));
        }

        array.add(array.remove(n - k / n));

        for (List<Integer> r : array) {
            boolean blank = false;
            for (int c : r) {
                if (blank)
                    System.out.print(" ");
                System.out.print(c);
                blank = true;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            solve(scanner, i + 1);
        }
    }
}