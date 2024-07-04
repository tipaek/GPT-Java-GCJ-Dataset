import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            List<List<Integer>> moves = new ArrayList<>();

            while (r > 1) {
                for (int lower = 0; lower < s - 1; lower++) {
                    List<Integer> move = new ArrayList<>();
                    move.add(r * (s - 1) - lower);
                    move.add(r - 1);
                    moves.add(move);
                }
                r--;
            }

            System.out.println("Case #" + testCase + ": " + moves.size());
            for (List<Integer> move : moves) {
                System.out.println(move.get(0) + " " + move.get(1));
            }
        }

        scanner.close();
    }
}