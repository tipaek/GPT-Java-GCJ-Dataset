import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = in.nextInt();
        for (int t = 1; t <= tc; ++t) {
            int n = in.nextInt();
            int s = in.nextInt();

            List<List<Integer>> options = gen(s, n);

            int[][] mat = new int[n][];
            for (int i = 0; i < n; i++) {
                int[] arr = new int[n];
                int curr = 1;
                for (int j = i; j < n; j++) {
                    arr[j] = curr;
                    curr += 1;
                    if (curr > n) {
                        curr = 1;
                    }
                }
                for (int j = 0; j < i; j++) {
                    arr[j] = curr;
                    curr += 1;
                    if (curr > n) {
                        curr = 1;
                    }
                }
                mat[i] = arr;
            }

            boolean flag = false;
            boolean oflag = false;
            List<Integer> finalorder = new ArrayList<>();

            for (List<Integer> arr: options) {
                Set<Integer> used = new HashSet<>();
                List<Integer> order = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (mat[j][i] == arr.get(i) && !used.contains(j)) {
                            used.add(j);
                            order.add(j);
                            break;
                        }
                    }
                }
                Set<Integer> used2 = new HashSet<>();
                List<Integer> order2 = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (mat[i][j] == arr.get(i) && !used2.contains(j)) {
                            used2.add(j);
                            order2.add(j);
                            break;
                        }
                    }
                }

                if (used.size() == n) {
                    flag = true;
                    finalorder = order;
                    break;
                }
                if (used2.size() == n) {
                    flag = true;
                    finalorder = order2;
                    oflag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println(String.format("Case #%s: %s", t, "POSSIBLE"));
                if (!oflag) {
                    for (Integer i : finalorder) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < n; j++) {
                            sb.append(mat[i][j]).append(" ");
                        }
                        System.out.println(sb.toString());
                    }
                } else {
                    for (Integer i : finalorder) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < n; j++) {
                            sb.append(mat[j][i]).append(" ");
                        }
                        System.out.println(sb.toString());
                    }
                }
            } else {
                System.out.println(String.format("Case #%s: %s", t, "IMPOSSIBLE"));
            }
        }
    }

    public static List<List<Integer>> gen(int target, int n) {
        List<List<Integer>> result = new ArrayList<>();
        gen(target, n, new ArrayList<>(), result);
        return result;
    }

    public static void gen(int target, int n, List<Integer> curr, List<List<Integer>> arr) {
        if (n == curr.size() && target == 0) {
            arr.add(curr);
        } else if (n > curr.size() && target > 0) {
            for (int i = 1; i <= n; i++) {
                if (i <= target) {
                    List<Integer> next = new ArrayList<>();
                    next.addAll(curr);
                    next.add(i);
                    gen(target - i, n, next, arr);
                }
            }
        }
    }

}
