import java.util.*;

public class Solution {

    static int[][] matrix;
    static int n;

    static Map<String, Boolean> check;
    static Map<String, ArrayList<Integer>> map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int temp = t;

        while (t-- > 0) {
            check = new HashMap<>();
            map = new HashMap<>();
            int r = 0, c = 0;

            n = scanner.nextInt();
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check.get("R" + i)) {
                        ArrayList<Integer> rowList = map.get("R" + i);
                        int freq = Collections.frequency(rowList, matrix[i][j]);
                        if (freq > 1) {
                            r++;
                            check.put("R" + i, true);
                        }
                    }
                    if (!check.get("C" + j)) {
                        ArrayList<Integer> colList = map.get("C" + j);
                        int freq = Collections.frequency(colList, matrix[i][j]);
                        if (freq > 1) {
                            c++;
                            check.put("C" + j, true);
                        }
                    }
                }
            }

            System.out.println("Case #" + (temp - t) + ": " + trace + " " + r + " " + c);
        }
    }

    static int calculateTrace() {
        int trace = 0;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                check.put("R" + i, false);
                check.put("C" + j, false);

                if (i == j) {
                    trace += matrix[i][j];
                }
                rowList.add(matrix[i][j]);

                ArrayList<Integer> colList = map.getOrDefault("C" + j, new ArrayList<>());
                colList.add(matrix[i][j]);
                map.put("C" + j, colList);
            }
            map.put("R" + i, rowList);
        }

        return trace;
    }
}