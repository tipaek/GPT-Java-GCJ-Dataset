import java.util.*;

public class Solution {

    public static String latin(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        int trace = 0;
        Set<Integer> rowDuplicates = new HashSet<>();
        Set<Integer> colDuplicates = new HashSet<>();

        // Check for row duplicates and calculate trace
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> rowMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int val = mat.get(i).get(j);
                rowMap.put(val, rowMap.getOrDefault(val, 0) + 1);
                if (i == j) {
                    trace += val;
                }
            }
            for (int key : rowMap.keySet()) {
                if (rowMap.get(key) > 1) {
                    rowDuplicates.add(i);
                    break;
                }
            }
        }

        // Check for column duplicates
        for (int j = 0; j < n; j++) {
            Map<Integer, Integer> colMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int val = mat.get(i).get(j);
                colMap.put(val, colMap.getOrDefault(val, 0) + 1);
            }
            for (int key : colMap.keySet()) {
                if (colMap.get(key) > 1) {
                    colDuplicates.add(j);
                    break;
                }
            }
        }

        return trace + " " + rowDuplicates.size() + " " + colDuplicates.size();
    }

    public static void print(ArrayList<ArrayList<Integer>> mat) {
        for (ArrayList<Integer> row : mat) {
            for (int val : row) {
                System.out.println(val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = s.nextInt();
            s.nextLine();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] line = s.nextLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for (String num : line) {
                    temp.add(Integer.parseInt(num));
                }
                arr.add(temp);
            }

            output.append("Case #").append(t + 1).append(": ").append(latin(arr));
            if (t != T - 1) {
                output.append("\n");
            }
        }

        System.out.println(output.toString());
    }
}