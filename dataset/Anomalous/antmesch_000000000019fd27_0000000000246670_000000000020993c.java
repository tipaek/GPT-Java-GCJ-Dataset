import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {
        String inputString = "3\n" +
                             "4\n" +
                             "1 2 3 4\n" +
                             "2 1 4 3\n" +
                             "3 4 1 2\n" +
                             "4 3 2 1\n" +
                             "4\n" +
                             "2 2 2 2\n" +
                             "2 3 2 3\n" +
                             "2 2 2 3\n" +
                             "2 2 2 2\n" +
                             "3\n" +
                             "2 1 3\n" +
                             "1 3 2\n" +
                             "1 2 3\n";

        InputStream testInput = new ByteArrayInputStream(inputString.getBytes("UTF-8"));
        System.setIn(testInput);
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String result = analyzeTest(scanner);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String analyzeTest(Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;
        List<List<Integer>> columns = new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            columns.add(new ArrayList<>());
            rows.add(new ArrayList<>());
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                columns.get(j).add(matrix[i][j]);
                rows.get(i).add(matrix[i][j]);
            }
        }

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        colRepeats = countRepeats(columns);
        rowRepeats = countRepeats(rows);

        return trace + " " + rowRepeats + " " + colRepeats;
    }

    private static int countRepeats(List<List<Integer>> lists) {
        int repeats = 0;
        for (List<Integer> list : lists) {
            Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            for (Long count : counts.values()) {
                if (count > 1) {
                    repeats++;
                    break;
                }
            }
        }
        return repeats;
    }
}