import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {


    private static int[][] matrix;
    private static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            N = Integer.parseInt(in.nextLine());
            matrix = new int[N][];

            for (int j = 0; j < N; j++) {
                matrix[j] = lineToInt(in.nextLine(), " ");
            }

            System.out.println( String.format("Case #%d = %d %d %d", i, trace(), rows(), cols()));
        }

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
            if(set.contains(v)) return true;
            set.add(v);
        }
        return false;
    }

    private static boolean isDuplicateCol(int j) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int v = matrix[i][j];
            if (set.contains(v)) return true;
            set.add(v);
        }
        return false;
    }


    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }
}