import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {

            int row = 0;
            int column = 0;

            int N = Integer.parseInt(reader.readLine());
            Vector<Vector<Integer>> matrix = new Vector<>(N, N);
            for (int a = 0; a < N; a++) {
                Vector<Integer> line = new Vector<>();
                Arrays.stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .forEach(line::add);
                matrix.add(line);
            }
            System.out.println("Case #" + i + ": " + calculateTrace(matrix, N) + " " + calculateRepeatedRow(matrix, N) + " " + calculateRepeatedColumn(matrix, N));
        }
    }

    private static int calculateRepeatedRow(Vector<Vector<Integer>> matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Vector<Integer> integers = matrix.get(i);
            Set<Integer> set = new HashSet<>(integers);
            if (integers.size() != set.size()) {
                sum++;
            }
        }
        return sum;
    }

    private static int calculateRepeatedColumn(Vector<Vector<Integer>> matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Vector<Integer> integers = new Vector<>();
            for (int j = 0; j < size; j++) {
                integers.add(matrix.get(j).get(i));
            }
            Set<Integer> set = new HashSet<>(integers);
            if (integers.size() != set.size()) {
                sum++;
            }
        }
        return sum;
    }

    private static int calculateTrace(Vector<Vector<Integer>> matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += matrix.get(i).get(i);
        return sum;
    }
}