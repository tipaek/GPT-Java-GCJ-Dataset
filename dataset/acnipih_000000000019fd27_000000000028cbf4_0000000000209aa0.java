import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(reader);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            found = false;
            solve(n, k, i);

//            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static void solve(int n, int k, int i) {
        List<List<Integer>> permutations = permute(n);
        List<List<Integer>> result = new ArrayList<>();
        generateMatrix(permutations, 0, n, new ArrayList<>(), k, result, 0);
        if (!found) {
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        } else {
            System.out.println("Case #" + i + ": " + "POSSIBLE");

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    System.out.print(result.get(j).get(l) + " ");
                }
                System.out.println();
            }
        }
    }

    private static void generateMatrix(List<List<Integer>> permutations, int row, int n, List<List<Integer>> current, int k,
                                       List<List<Integer>> result, int trace) {
        if (trace > k) return;
        if (found) return;
        if (row == n) {
            if (trace == k) {
                result.addAll(current);
                found = true;
            }
            return;
        }
        for (int i = 0; i < permutations.size(); i++) {
            if (found) return;
            List<Integer> list = permutations.get(i);
            if (list.isEmpty()) continue;
            current.add(list);

            permutations.set(i, Collections.emptyList());
            if (hasNoDuplicateRow(current, n))
                generateMatrix(permutations, row + 1, n, current, k, result, trace + list.get(row));
            permutations.set(i, list);
            current.remove(current.size() - 1);
        }

    }

    public static List<List<Integer>> permute(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;

    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> current,
                                  List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, current, result);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }

    }

    private static boolean hasNoDuplicateRow(List<List<Integer>> matrix, int n) {
        int cols = 0;
        for (int i = 0; i < n; i++) {
            boolean[] exist = new boolean[n];
            for (int j = 0; j < matrix.size(); j++) {
                if (exist[matrix.get(j).get(i) - 1]) {
                    cols++;
                    break;
                } else {
                    exist[matrix.get(j).get(i) - 1] = true;
                }
            }
        }
        return cols == 0;
    }
}
