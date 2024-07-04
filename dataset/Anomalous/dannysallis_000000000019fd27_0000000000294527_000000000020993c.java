import java.io.*;
import java.util.*;

class LatinSquares {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileReader("input_file.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output_file.txt"));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] square = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                for (int j = 0; j < size; j++) {
                    square[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < size; i++) {
                if (hasRepeatedElements(square[i])) {
                    repeatedRows++;
                }

                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = square[j][i];
                }
                if (hasRepeatedElements(column)) {
                    repeatedColumns++;
                }

                trace += square[i][i];
            }

            String result = String.format("Case #%d: %d %d %d", testCase, trace, repeatedRows, repeatedColumns);
            System.out.println(result);
            writer.println(result);
        }

        scanner.close();
        writer.close();
    }

    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}