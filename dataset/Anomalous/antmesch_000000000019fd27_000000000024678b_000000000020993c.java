import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            String result = analyzeTest(scanner);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String analyzeTest(Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        List<List<Integer>> rows = new ArrayList<>();
        List<List<Integer>> columns = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            rows.add(new ArrayList<>());
            columns.add(new ArrayList<>());
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = scanner.nextInt();
                matrix[i][j] = value;
                rows.get(i).add(value);
                columns.get(j).add(value);
            }
        }

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        duplicateRows = countDuplicates(rows);
        duplicateColumns = countDuplicates(columns);

        return trace + " " + duplicateRows + " " + duplicateColumns;
    }

    private static int countDuplicates(List<List<Integer>> lists) {
        int duplicates = 0;

        for (List<Integer> list : lists) {
            Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            if (counts.values().stream().anyMatch(count -> count > 1)) {
                duplicates++;
            }
        }

        return duplicates;
    }
}