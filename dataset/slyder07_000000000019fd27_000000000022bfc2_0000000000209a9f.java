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
        String s = in.next();
        List<Character> chars = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            chars.add(s.charAt(i));
        }

        List<Integer> deltas = getDetlas(chars);

        int lastIndex = 0;

        for(int delta : deltas){
            if(delta == 0){
                lastIndex++;
                continue;
            }
            char c = delta > 0 ? '(' : ')';
            int n = Math.abs(delta);
            addCharAtIndex(n, c, lastIndex, chars);
            lastIndex = lastIndex + n + 1;
        }

        char[] res = new char[chars.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = chars.get(i);
        }

        return new String(res);
    }

    private List<Integer> getDetlas(List<Character> list){
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0) - 48);
        for(int i = 1; i < list.size(); i++){
            res.add(list.get(i) - list.get(i - 1));
        }
        res.add(48 - list.get(list.size() - 1));

        return res;
    }

    private void addCharAtIndex(int n, char c, int i, List<Character> list){
        for(int j = 0; j < n; j++){
            list.add(i, c);
        }
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
