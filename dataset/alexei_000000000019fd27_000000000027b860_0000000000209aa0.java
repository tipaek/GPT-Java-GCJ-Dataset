import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static int n;
    static int k;
    static List<Set<Integer>> rows;
    static List<Set<Integer>> cols;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int c = 1; c <= t ; c++) {
            n = in.nextInt();
            k = in.nextInt();
            rows = new ArrayList<>();
            cols = new ArrayList<>();
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                rows.add(new HashSet<>());
                cols.add(new HashSet<>());
                for (int j = 1; j <= n; j++) {
                    rows.get(i).add(j);
                    cols.get(i).add(j);
                }
            }

            boolean success = generate(0, 0, 0);
            System.out.println(String.format("Case #%d: %s", c, success ? "POSSIBLE" : "IMPOSSIBLE"));
            if (success) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[i][j]);
                        if (j != n-1) System.out.print(' ');
                    }
                    System.out.println();
                }
            }
        }
    }

    public static boolean generate(int i, int j, int sum) {
        if (i == n-1 && j == n-1) {
            arr[i][j] = rows.get(n-1).iterator().next();
            sum += arr[i][j];
            if (sum == k) {
                return true;
            } else {
                return false;
            }
        }

        Set<Integer> intersection = new HashSet<>(rows.get(i));
        intersection.retainAll(cols.get(j));
        for(Integer num: intersection) {
            rows.get(i).remove(num);
            cols.get(j).remove(num);
            arr[i][j] = num;
            if (i == j) sum += num;

            boolean success;
            if (j == n-1) {
                success = generate(i+1, 0, sum);
            } else {
                success = generate(i, j+1, sum);
            }
            if (success) return true;

            if (i == j) sum -= num;
            rows.get(i).add(num);
            cols.get(j).add(num);
        }
        return false;
    }

}