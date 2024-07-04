import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            int trace = IntStream.range(0, n).map(q -> matrix[q][q]).sum();

            Set<Integer> repeatedRows = new HashSet<>();
            for (int j = 0; j < n; j++) {
                HashMap<Integer, List<Integer>> map = new HashMap<>();
                for (int k = 0; k < n && !repeatedRows.contains(k); k++) {
                    int key = matrix[k][j];
                    List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                    list.add(k);
                    map.put(key, list);
                }
                map.values().stream().filter(q -> q.size() > 1).forEach(repeatedRows::addAll);
            }

            Set<Integer> repeatedColumns = new HashSet<>();
            for (int j = 0; j < n; j++) {
                HashMap<Integer, List<Integer>> map = new HashMap<>();
                for (int k = 0; k < n && !repeatedColumns.contains(k); k++) {
                    int key = matrix[j][k];
                    List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                    list.add(k);
                    map.put(key, list);
                }
                map.values().stream().filter(q -> q.size() > 1).forEach(repeatedColumns::addAll);
            }

            System.out.println(String.format("Case #%d: %d %d %d", i + 1, trace, repeatedColumns.size(), repeatedRows.size()));
        }
    }
}
