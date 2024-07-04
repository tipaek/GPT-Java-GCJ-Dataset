import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            inputs.add(line);
        }

        if (inputs.size() == 0) {
            return;
        }

        int caseCnt = Integer.parseInt(inputs.get(0).trim());

        int index = 1;
        for (int i = 0; i < caseCnt; i++) {
            int n = Integer.parseInt(inputs.get(index).trim());
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                String str = inputs.get(index + j + 1);
                matrix[j] = Arrays.stream(str.split("\\s+")).mapToInt(s -> Integer.parseInt(s)).toArray();
            }

            Result result = vestigium(matrix, n);

            System.out.println(String.format("Case #%d: %d %d %d", i + 1, result.trace, result.rowCnt, result.colCnt));
            index += n + 1;
        }
    }

    private static Result vestigium(int[][] matrix, int n) {
        Result result = new Result(0, 0, 0);
        int trace = 0;

        int target = (n * (n + 1)) / 2;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            int colSum = 0;
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != target) {
                result.rowCnt++;
            }
            if (colSum != target) {
                result.colCnt++;
            }
        }
        result.trace = trace;
        return result;
    }

    private static class Result {
        int trace;
        int rowCnt;
        int colCnt;

        public Result(int trace, int rowCnt, int colCnt) {
            this.trace = trace;
            this.rowCnt = rowCnt;
            this.colCnt = colCnt;
        }
    }
}
