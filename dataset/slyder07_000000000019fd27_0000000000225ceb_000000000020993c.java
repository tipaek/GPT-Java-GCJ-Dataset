import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.*;

public class Solution {

    FastReader in = new FastReader();
    OutputStream out = System.out;

    public static void main(String[] args) throws IOException{
        new Solution().solveTests();
    }

    public void solveTests() throws IOException {
        int T = in.nextInt();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < T; i++){
            result.append(String.format("Case #%d: ", i + 1));
            result.append(solveTest());
            result.append("\n");
        }
        out.write(result.toString().getBytes());
        out.flush();
    }

    public String solveTest(){
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        Response response = getResponse(matrix);
        return response.sum + " " + response.rows + " " + response.columns;
    }

    private Response getResponse(int[][] matrix){
        int sum = 0;
        int columns = 0;
        int rows = 0;

        Set<Integer> column;
        Set<Integer> row;

        for(int i = 0; i < matrix.length; i++){
            column = new HashSet<>();
            row = new HashSet<>();
            sum+= matrix[i][i];
            for(int j = 0; j < matrix.length; j++){
                row.add(matrix[i][j]);
                column.add(matrix[j][i]);
            }
            if(column.size() != matrix.length){
                columns++;
            }
            if(row.size() != matrix.length){
                rows++;
            }
        }

        return new Response(sum, rows, columns);
    }

    private class Response{
        int sum;
        int rows;
        int columns;
        Response(int sum, int rows, int columns){
            this.sum = sum;
            this.rows = rows;
            this.columns = columns;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                InputStreamReader(System.in));
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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

}
