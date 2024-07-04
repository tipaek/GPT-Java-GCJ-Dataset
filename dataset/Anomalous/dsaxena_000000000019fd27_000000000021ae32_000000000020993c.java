import java.util.*;

public class Google {

    public static String latin(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int trace = 0;
        HashSet<Integer> rowViolations = new HashSet<>();
        HashSet<Integer> colViolations = new HashSet<>();

        for (int i = 0; i < n; i++) {
            HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                rowMap.computeIfAbsent(mat.get(i).get(j), k -> new HashSet<>()).add(j);
                if (i == j) trace += mat.get(i).get(i);
            }
            rowMap.values().stream().filter(set -> set.size() > 1).forEach(rowViolations::addAll);
        }

        for (int j = 0; j < n; j++) {
            HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                colMap.computeIfAbsent(mat.get(i).get(j), k -> new HashSet<>()).add(i);
            }
            colMap.values().stream().filter(set -> set.size() > 1).forEach(colViolations::addAll);
        }

        return trace + " " + rowViolations.size() + " " + colViolations.size();
    }

    public static void print(ArrayList<ArrayList<Integer>> mat) {
        for (ArrayList<Integer> row : mat) {
            for (Integer val : row) {
                System.out.println(val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine(); // Consume newline
        StringBuilder output = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = s.nextInt();
            s.nextLine(); // Consume newline
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] row = s.nextLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for (String num : row) {
                    temp.add(Integer.parseInt(num));
                }
                matrix.add(temp);
            }

            output.append("Case#").append(t + 1).append(": ").append(latin(matrix));
            if (t != T - 1) {
                output.append("\n");
            }
        }

        System.out.println(output.toString());
    }
}