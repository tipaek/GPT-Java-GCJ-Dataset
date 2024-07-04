import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[]) {
        FastReader in = new FastReader();
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][];

            for (int j = 0; j < size; j++) {
                String row = in.nextLine();
                matrix[j] = convertRowToArray(row, size);
            }
            int traceValue = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateCols = countDuplicateCols(matrix);
            System.out.println("Case #" + (i + 1) + ": " + traceValue + " " + duplicateRows + " " + duplicateCols);
        }
    }

    public static int calculateTrace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countDuplicateRows(int[][] matrix) {
        int counter = 0;
        for (int[] row : matrix) {
            boolean hasDuplicate = false;
            for (int j = 0; j < row.length; j++) {
                for (int k = j + 1; k < row.length; k++) {
                    if (row[j] == row[k]) {
                        counter++;
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) break;
            }
        }
        return counter;
    }

    public static int countDuplicateCols(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < matrix.length; j++) {
                for (int k = j + 1; k < matrix.length; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        counter++;
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) break;
            }
        }
        return counter;
    }

    public static int[] convertRowToArray(String row, int size) {
        int[] arr = new int[size];
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(row);
        int index = 0;
        while (matcher.find() && index < size) {
            arr[index++] = Integer.parseInt(matcher.group());
        }
        return arr;
    }
}