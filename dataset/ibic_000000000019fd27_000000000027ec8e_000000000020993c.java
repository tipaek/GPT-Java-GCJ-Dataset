import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static int getTrace(List<List<Integer>> matrix) {
        Integer r = 0;
        for (int i = 0; i < matrix.size(); i++) {
            r += matrix.get(i).get(i);
        }
        return r;
    }

    private static int getR(List<List<Integer>> matrix) {
        Integer r = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            Set<Integer> theSet = new HashSet<>(row);
            if (theSet.size() < row.size()) {
                r += 1;
            }
        }
        return r;
    }

    private static int getC(List<List<Integer>> matrix) {
        Integer r = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < matrix.size(); j++) {
                col.add(matrix.get(j).get(i));
            }
            Set<Integer> theSet = new HashSet<>(col);
            if (theSet.size() < col.size()) {
                r += 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int cases = scanner.nextInt();
        for (int ca = 0; ca < cases; ca++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<List<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                matrix.add(Arrays.stream(line.split("\\s+")).map(Integer::valueOf).collect(Collectors.toList()));
            }
            System.out.println(String.format("Case #%d: %d %d %d", ca + 1, getTrace(matrix), getR(matrix), getC(matrix)));
        }
        scanner.close();
    }
}
