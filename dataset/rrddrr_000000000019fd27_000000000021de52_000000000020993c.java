import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

//    private static void handleIO() {
//        Scanner inputReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int numTestCases = Integer.parseInt(inputReader.nextLine());
//        for (int i = 0; i < numTestCases; ++i) {
//            String line = inputReader.nextLine();
//            String output = doStuff(line.trim());
//            System.out.println(String.format("Case #%d: %s\n", (i + 1), output));
//        }
//    }

    private static void handleList(Scanner scanner) {
        Scanner inputReader = scanner;
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            int numLines = Integer.parseInt(inputReader.nextLine());
            List<String> lines = new ArrayList<>();
            for (int j=0; j<numLines; ++j) {
                lines.add(inputReader.nextLine().trim());
            }
            int output = 0; //solve(lines);
            System.out.print(String.format("Case #%d: %d\n", (i + 1), output));
        }
    }

    public static void handleMatrix(Scanner inputReader) {
        int numTestCases = Integer.parseInt(inputReader.nextLine());
        for (int i = 0; i < numTestCases; ++i) {
            int numLines = Integer.parseInt(inputReader.nextLine());
            int[][] matrix = new int[numLines][numLines];
            for (int j=0; j<numLines; ++j) {
                matrix[j] = Arrays.stream(inputReader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            String output = solve(matrix);
            System.out.print(String.format("Case #%d: %s\n", (i + 1), output));
        }
    }

    public static void main(String[] args) {
        handleMatrix((new Scanner(new BufferedReader(new InputStreamReader(System.in)))));
        // testCases();
    }

    public static void testCases() {
        String input = "3\n" +
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
                "1 2 3";
        handleMatrix(new Scanner(input));
    }

    public static String solve(int[][] matrix) {
        Set<Integer> rowNums = new HashSet<>();
        Set<Integer> colNums = new HashSet<>();
        int r=0, c = 0;
        for (int i=0; i<matrix.length; ++i) {
            for (int j=0; j<matrix[i].length; ++j) {
                rowNums.add(matrix[i][j]);
                colNums.add(matrix[j][i]);
            }
            if (rowNums.size() != matrix.length) r++;
            if (colNums.size() != matrix.length) c++;
            rowNums.clear();
            colNums.clear();
        }
        int t = 0;
        for (int i=0; i<matrix.length; ++i)
            t+= matrix[i][i];
        return String.format("%d %d %d", t, r, c);
    }


}
