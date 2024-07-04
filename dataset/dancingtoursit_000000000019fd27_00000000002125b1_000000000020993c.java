import java.io.*;
import java.util.*;
import java.util.function.BiFunction;

public class Solution {
    public static int[] solution(int[][] matrix){
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> columns = new HashMap<>();
        int total = 0;
        for(int i = 1; i <= matrix.length; i++){
            rows.put(i, new HashSet<>());
            total += matrix[i - 1][i - 1];
        }

        for(int i = 1; i <= matrix[0].length; i++){
            columns.put(i, new HashSet<>());
        }
        for(int i = 1; i <= matrix.length; i++){
            for(int j = 1; j<= matrix[i - 1].length; j++){
                Set<Integer> currentColumn = columns.get(j);
                currentColumn.add(matrix[i - 1][j - 1]);
                Set<Integer> currentRow = rows.get(i);
                currentRow.add(matrix[i - 1][j - 1]);
                rows.put(i, currentRow);
                columns.put(j, currentColumn);
            }
        }
        int rowsInvalid = 0;
        int columnsInvalid = 0;
        for(int i = 1; i <= matrix.length; i++){
            rowsInvalid += rows.get(i).size() != matrix.length ? 1 : 0;
            columnsInvalid += columns.get(i).size() != matrix[0].length ? 1 : 0;
        }
        return new int[]{total, rowsInvalid, columnsInvalid};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine().trim());
        StringTokenizer tokenizer = new StringTokenizer("");
        for(int test = 1; test <= T; test++){
            int N = Integer.parseInt(in.readLine().trim());
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++){
                String row = in.readLine().trim();
                tokenizer = new StringTokenizer(row);
                for(int j = 0; j < N; j++){
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            int[] ans = solution(matrix);
            out.write(String.format("Case #%d: %d %d %d\n", test, ans[0], ans[1], ans[2]));
            out.flush();
        }
        out.close();
    }
}