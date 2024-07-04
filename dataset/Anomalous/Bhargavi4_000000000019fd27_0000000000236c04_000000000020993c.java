import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tests = br.readLine();
        if (tests == null) return;

        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            String ele = br.readLine();
            if (ele == null) return;
            int n = Integer.parseInt(ele);
            int[][] arr = new int[n][n];
            for (int k = 0; k < n; k++) {
                String str = br.readLine();
                arr[k] = Stream.of(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int trace = calculateTrace(arr, n);
            int rows = calculateDupsInRows(arr, n);
            int columns = calculateDupsInColumns(arr, n);

            sb.append("case #").append(i).append(": ").append(trace).append(" ").append(rows).append(" ").append(columns).append("\n");
        }

        System.out.print(sb.toString().trim());
    }

    private static int calculateTrace(int[][] arr, int n) {
        int trace = 0;
        for (int k = 0; k < n; k++) {
            trace += arr[k][k];
        }
        return trace;
    }

    private static int calculateDupsInRows(int[][] arr, int n) {
        int rows = 0;
        for (int r = 0; r < n; r++) {
            Set<Integer> set = new HashSet<>();
            for (int c = 0; c < n; c++) {
                if (!set.add(arr[r][c])) {
                    rows++;
                    break;
                }
            }
        }
        return rows;
    }

    private static int calculateDupsInColumns(int[][] arr, int n) {
        int columns = 0;
        for (int c = 0; c < n; c++) {
            Set<Integer> set = new HashSet<>();
            for (int r = 0; r < n; r++) {
                if (!set.add(arr[r][c])) {
                    columns++;
                    break;
                }
            }
        }
        return columns;
    }
}