import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private static final String RESULT_PATTERN = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int testCasesNumber = Integer.parseInt(tokenizer.nextToken());
            for (int t = 1; t <= testCasesNumber; ++t) {
                tokenizer = new StringTokenizer(reader.readLine());
                int n = Integer.parseInt(tokenizer.nextToken());
                List<List<Integer>> matrix = new ArrayList<List<Integer>>(n);
                for (int i = 0; i < n; ++i) {
                    tokenizer = new StringTokenizer(reader.readLine());
                    List<Integer> row = new ArrayList<Integer>();
                    for (int j = 0; j < n; ++j) {
                        row.add(Integer.parseInt(tokenizer.nextToken()));
                    }
                    matrix.add(row);
                }
                solve(t, matrix);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void solve(int testCaseId, List<List<Integer>> matrix) {
        int n = matrix.size();
        int trace = 0;
        int repeatedRowsCnt = 0;
        int repeatedColsCnt = 0;
        for (int i = 0; i < n; ++i) {
            trace += matrix.get(i).get(i);
            repeatedRowsCnt += isRowRepeated(matrix, i);
            repeatedColsCnt += isColRepeated(matrix, i);
        }
        System.out.println(String.format(RESULT_PATTERN, testCaseId, trace, repeatedRowsCnt, repeatedColsCnt));
    }

    private static int isColRepeated(List<List<Integer>> matrix, int col) {
        Set<Integer> values = new HashSet<Integer>();
        for (int i = 0; i < matrix.size(); ++i) {
            if (!values.add(matrix.get(i).get(col))) {
                return 1;
            }
        }
        return 0;
    }

    private static int isRowRepeated(List<List<Integer>> matrix, int rowId) {
        Set<Integer> values = new HashSet<Integer>();
        for (int i = 0; i < matrix.size(); ++i) {
            if (!values.add(matrix.get(rowId).get(i))) {
                return 1;
            }
        }
        return 0;
    }
}
