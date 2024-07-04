import java.util.*;

public class Google {

    public static String latin(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int trace = 0;
        HashSet<Integer> rowDuplicates = new HashSet<>();
        HashSet<Integer> colDuplicates = new HashSet<>();

        for (int i = 0; i < n; i++) {
            HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                // Row processing
                rowMap.computeIfAbsent(mat.get(i).get(j), k -> new HashSet<>()).add(j);
                // Column processing
                colMap.computeIfAbsent(mat.get(j).get(i), k -> new HashSet<>()).add(j);

                if (i == j) {
                    trace += mat.get(i).get(j);
                }
            }

            for (int value : rowMap.keySet()) {
                if (rowMap.get(value).size() > 1) {
                    rowDuplicates.addAll(rowMap.get(value));
                }
            }

            for (int value : colMap.keySet()) {
                if (colMap.get(value).size() > 1) {
                    colDuplicates.addAll(colMap.get(value));
                }
            }
        }

        return trace + " " + rowDuplicates.size() + " " + colDuplicates.size();
    }

    public static void print(ArrayList<ArrayList<Integer>> mat) {
        for (ArrayList<Integer> row : mat) {
            for (Integer value : row) {
                System.out.println(value);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        StringBuilder output = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] row = scanner.nextLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for (String num : row) {
                    temp.add(Integer.parseInt(num));
                }
                matrix.add(temp);
            }

            output.append("Case#").append(t + 1).append(": ").append(latin(matrix));
            if (t < T - 1) {
                output.append("\n");
            }
        }

        System.out.println(output);
    }
}