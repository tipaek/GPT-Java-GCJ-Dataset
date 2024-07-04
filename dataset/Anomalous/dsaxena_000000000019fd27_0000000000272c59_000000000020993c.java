import java.util.*;

public class Solution {

    public static String latin(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int trace = 0;
        int num_row = 0;
        int num_col = 0;

        // Calculate trace
        for (int i = 0; i < n; i++) {
            trace += mat.get(i).get(i);
        }

        // Check for duplicate values in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(mat.get(i).get(j))) {
                    num_row++;
                    break;
                }
            }
        }

        // Check for duplicate values in columns
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(mat.get(i).get(j))) {
                    num_col++;
                    break;
                }
            }
        }

        return trace + " " + num_row + " " + num_col;
    }

    public static void print(ArrayList<ArrayList<Integer>> mat) {
        for (ArrayList<Integer> row : mat) {
            for (Integer val : row) {
                System.out.println(val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        StringBuilder output = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] line = scanner.nextLine().split(" ");
                ArrayList<Integer> row = new ArrayList<>();
                for (String num : line) {
                    row.add(Integer.parseInt(num));
                }
                matrix.add(row);
            }

            if (t != 0) {
                output.append("\n");
            }
            output.append("Case #").append(t + 1).append(": ").append(latin(matrix));
        }

        System.out.println(output.toString());
    }
}