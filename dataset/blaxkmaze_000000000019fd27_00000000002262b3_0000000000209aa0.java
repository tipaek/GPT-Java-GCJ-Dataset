import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String indicium(int N, int trace) {
        if (N == 0 || trace % N != 0 || trace > N*N) {
            return IMPOSSIBLE;
        }
        return POSSIBLE;
//
//        int[][] matrix = new int[N][N];
//        int traceNum = trace / N;
//        for (int i = 0; i < N; i++)
//            matrix[i][i] = traceNum;
//        
//        int[][] rowVisited = new int[N][N+1];
//        int[][] colVisited = new int[N][N+1];
//        for (int i = 0; i < )
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSize = Integer.valueOf(in.nextInt()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testSize; ++i) {
            int N = in.nextInt();
            int trace = in.nextInt();
            String output = indicium(N, trace);
            StringBuilder builder = new StringBuilder();
            builder.append("Case #" + i + ": ");
            builder.append(output);
            System.out.println(builder.toString().trim());
        }
    }
}