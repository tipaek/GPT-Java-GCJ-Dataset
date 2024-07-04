import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        final String POSSIBLE = "POSSIBLE";
        final String IMPOSSIBLE = "IMPOSSIBLE";
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int center = k / n;
            if (k % n == 0) {
                List<List<Integer>> matrix = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    List<Integer> row = new ArrayList<>(n);
                    for (int j = 0; j < n; j++) {
                        int value = ((n - i + j) % n) + center;
                        if (value > n) {
                            value -= n;
                        }
                        row.add(value);
                    }
                    matrix.add(row);
                }

                System.out.println("Case #" + caseNum + ": " + POSSIBLE);
                matrix.forEach(row -> System.out.println(row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))));
            } else {
                System.out.println("Case #" + caseNum + ": " + IMPOSSIBLE);
            }
        }
    }
}