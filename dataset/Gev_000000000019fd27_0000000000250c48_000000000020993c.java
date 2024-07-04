import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            Integer[][] arr = new Integer[n][n];
            for (int j = 0; j < n; j++) {
                arr[j] = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList()).toArray(arr[j]);
            }
            int tr = trace(arr);
            int row = rows(arr);
            int col = cols(arr);
            System.out.println(String.format("Case #%d: %d %d %d", i, tr, row, col));
        }
    }

    private static int trace(Integer[][] arr) {
        int tr = 0;
        for (int i = 0; i < arr.length; i++)
            tr += arr[i][i];

        return tr;
    }

    private static int rows(Integer[][] arr) {
        int rows = 0;
        for (Integer[] integers : arr) {
            Set<Integer> set = new HashSet<>(Arrays.asList(integers));
            rows += set.size() != integers.length ? 1 : 0;
        }

        return rows;
    }

    private static int cols(Integer[][] arr) {
        int cols = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < arr.length; j++)
                set.add(arr[j][i]);
            cols += set.size() != arr.length ? 1 : 0;
        }

        return cols;
    }
}
