import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        int numberOfCases = Integer.parseInt(args[0]);
        if (args.length == 1) return;
        int cursor = 1;
        for (int i = 1; i <= numberOfCases; ++i) {
            System.out.println("Case #" + i + ": " + evaluateMatrix(args, cursor));
            cursor += Integer.parseInt(args[cursor]) + 1;
        }
    }

    private static String evaluateMatrix(String[] args, int cursor) {
        int matrixSize = Integer.parseInt(args[cursor]);
        int repeatedRow = 0;
        int repeatedColumn = 0;
        int traceSum = 0;

        ArrayList<String[]> matrix = new ArrayList<>();
        for (int i = 0; i < matrixSize; ++i)
            matrix.add(args[cursor + i + 1].split(" "));

        for (int i = 0; i < matrixSize; ++i)
            traceSum += Integer.parseInt(matrix.get(i)[i]);

        HashMap<String, String> map;

        for (int i = 0; i < matrixSize; i++) {
            map = new HashMap<>();
            for (int j = 0; j < matrixSize; j++) {
                if (map.containsKey(matrix.get(i)[j])) {
                    repeatedRow++;
                    break;
                }
                map.put(matrix.get(i)[j], matrix.get(i)[j]);
            }
        }

        for (int j = 0; j < matrixSize; j++) {
            map = new HashMap<>();
            for (int i = 0; i < matrixSize; i++) {
                if (map.containsKey(matrix.get(i)[j])) {
                    repeatedColumn++;
                    break;
                }
                map.put(matrix.get(i)[j], matrix.get(i)[j]);
            }
        }
        return traceSum + " " + repeatedRow + " " + repeatedColumn;
    }
}
