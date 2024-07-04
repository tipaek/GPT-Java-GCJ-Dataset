import java.util.*;
import java.io.*;

class Ground {

    public static void main(String[] args) {
        solve();
    }
    
    public static void solve(){
        int t = readInt();
        for(int testCase = 1; testCase <= t; testCase++){
            int n = readInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];
            
            for(int i = 0; i < n; i++){
                Set<Integer> rowSet = new HashSet<>();
                for(int j = 0; j < n; j++){
                    matrix[i][j] = readInt();
                    if(i == j) trace += matrix[i][j];
                    rowSet.add(matrix[i][j]);
                }
                if(rowSet.size() != n) rowRepeats++;
            }
            for(int j = 0; j < n; j++){
                Set<Integer> colSet = new HashSet<>();
                for(int i = 0; i < n; i++){
                    colSet.add(matrix[i][j]);
                }
                if(colSet.size() != n) colRepeats++;
            }
            
            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, rowRepeats, colRepeats);
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int readInt() {
        return Integer.parseInt(next());
    }

    static long readLong() {
        return Long.parseLong(next());
    }

    static double readDouble() {
        return Double.parseDouble(next());
    }

    static String readLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}