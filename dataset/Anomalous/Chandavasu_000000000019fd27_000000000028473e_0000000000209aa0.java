import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTests = scanner.nextInt();

        for (int i = 0; i < numOfTests; i++) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();
            new Solution().createMatrix(i + 1, n, trace);
        }
    }

    public void createMatrix(int test, int n, int trace) {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> traces = new ArrayList<>();
        boolean impossible = false;

        if (trace < n) {
            impossible = true;
        } else if (trace % n == 0) {
            int d = trace / n;
            for (int i = 0; i < n; i++) {
                traces.add(d);
            }
        } else {
            int sum = 0;
            for (int i = 1; sum < trace; i++) {
                sum += i;
                traces.add(i);
                if (sum == trace) {
                    break;
                }
            }

            if (traces.size() < n) {
                int diff = n - traces.size();
                for (int i = diff; i >= 0; i--) {
                    int val = traces.remove(i);
                    traces.add(val / 2);
                    traces.add(val / 2);
                }
            } else if (traces.size() > n) {
                int diff = traces.size() - n;
                for (int i = 0; i <= n; i += 2) {
                    int val1 = traces.remove(i);
                    int val2 = traces.remove(i + 1);
                    traces.add(val1 + val2);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        if (impossible) {
            result.append("Case #").append(test).append(": IMPOSSIBLE\n");
        } else {
            result.append("Case #").append(test).append(": POSSIBLE\n");
            for (int i = 1; i <= n; i++) {
                values.add(i);
            }

            int[][] matrix = new int[n][n];
            int traceIndex = 0;

            for (int i = 0; i < n; i++) {
                int index = 0;
                int d = traces.get(traceIndex);
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        matrix[i][j] = d;
                        traceIndex++;
                    } else {
                        int ip = values.get(index);
                        if (ip == d) {
                            index++;
                            ip = values.get(index);
                        }
                        matrix[i][j] = ip;
                        index++;
                    }
                    result.append(matrix[i][j]).append(" ");
                }

                int r = values.remove(0);
                if ((traceIndex < traces.size()) && (r == traces.get(traceIndex))) {
                    values.add(r);
                    r = values.remove(0);
                }
                values.add(r);
                result.append("\n");
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    set.add(matrix[j][i]);
                }
                if (set.size() != n) {
                    result.setLength(0);
                    result.append("Case #").append(test).append(": IMPOSSIBLE");
                    break;
                }
            }
        }
        System.out.println(result.toString());
    }
}