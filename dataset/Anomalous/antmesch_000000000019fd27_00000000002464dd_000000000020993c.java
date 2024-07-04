import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int i = 1; i <= t; ++i) {
            String output = analyzeTest(in);
            System.out.println("Case #" + i + ": " + output);
        }
    }

    public static String analyzeTest(Scanner in) {
        int size = in.nextInt();
        int[][] square = new int[size][size];
        int k = 0, r = 0, c = 0;
        List<Set<Integer>> columns = new ArrayList<>(size);
        List<Set<Integer>> rows = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            columns.add(new HashSet<>());
            rows.add(new HashSet<>());
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int value = in.nextInt();
                square[x][y] = value;
                columns.get(y).add(value);
                rows.get(x).add(value);
            }
        }

        for (int i = 0; i < size; i++) {
            k += square[i][i];
        }

        for (Set<Integer> row : rows) {
            if (row.size() < size) {
                r++;
            }
        }

        for (Set<Integer> column : columns) {
            if (column.size() < size) {
                c++;
            }
        }

        return k + " " + r + " " + c;
    }
}