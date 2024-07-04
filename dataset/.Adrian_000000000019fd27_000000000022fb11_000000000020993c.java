import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            List<List<Integer>> matrix = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String line = scanner.nextLine();
                matrix.add(stringToIntegerList(line, n));
            }

            solve(i, n, matrix);
        }
    }

    private static void solve(int test, int n, List<List<Integer>> matrix) {
        int k = 0, r = 0,c = 0;

        for (int i = 0; i < n; i++) {
            k += matrix.get(i).get(i);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> numbers = new HashSet<>();

            List<Integer> row = matrix.get(i);

            for (int j = 0; j < n; j++) {
                if (!numbers.add(row.get(j))) {
                    r ++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> numbers = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (!numbers.add(matrix.get(j).get(i))) {
                    c ++;
                    break;
                }
            }
        }

        System.out.println("Case #" + (test + 1) + ": " + k + " " + r + " " + c);
    }

    private static List<Integer> stringToIntegerList(String line, int n) {
        String[] parts = line.split(" ", n);
        return Arrays.stream(parts).map(Integer::parseInt).collect(Collectors.toList());
    }
}
