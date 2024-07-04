import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            HashMap<Integer, HashSet<Integer>> columns = new HashMap<>();

            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    int value = scanner.nextInt();
                    rowSet.add(value);

                    if (!columns.containsKey(j)) {
                        columns.put(j, new HashSet<>());
                    }
                    HashSet<Integer> columnSet = columns.get(j);
                    columnSet.add(value);

                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowSet.size() < N) {
                    rowDuplicates++;
                }
            }
            for (int i = 0; i < N; i++) {
                if (columns.get(i).size() < N) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}