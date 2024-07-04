import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {


    private static int[][] matrix;
    private static int N;
    private static int K;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int c = 1; c <= t; ++c) {
                int[] line = lineToInt(in.nextLine(), " ");
            N = line[0];
            K = line[1];
            matrix = new int[N][N];

            if(backtrack(0,0, new BitSet(N+1))){
                System.out.println( String.format("Case #%d: %s", c,"POSSIBLE"));
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println( String.format("Case #%d: %s", c,"IMPOSSIBLE"));
            }
        }

    }

    private static boolean backtrack(int i, int j, BitSet currentRow){
        //if(j == 0)  // currentRow = new BitSet(N+1);
        if(trace() > K) return false;
        if(cols() != 0) return false;
        if(rows() != 0) return false;
        if(i >= N){
            return trace() == K;
        }

        int j2 = j+1;
        int i2 = i;
        if(j2 >= N){
            j2 = 0;
            i2++;
        }

        for (int k = 1; k <= N; k++) {
//            if(currentRow.get(k)) continue;
            matrix[i][j] = k;
//            currentRow.set(k);
            if(backtrack(i2,j2, currentRow)) return true;
//            currentRow.clear(k);
        }
        matrix[i][j] = 0;
        return false;

    }

    private static int trace() {
        return IntStream.range(0, N).map(i -> matrix[i][i]).sum();
    }

    private static int rows() {
        return IntStream.range(0, N).map(i -> isDuplicateRow(i) ? 1 : 0).sum();
    }

    private static int cols() {
        return IntStream.range(0, N).map(j -> isDuplicateCol(j) ? 1 : 0).sum();
    }

    private static boolean isDuplicateRow(int i){
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < N; j++) {
            int v = matrix[i][j];
            if(v == 0) continue;
            if(set.contains(v)) return true;
            set.add(v);
        }
        return false;
    }

    private static boolean isDuplicateCol(int j) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int v = matrix[i][j];
            if(v == 0) continue;
            if (set.contains(v)) return true;
            set.add(v);
        }
        return false;
    }


    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }
}