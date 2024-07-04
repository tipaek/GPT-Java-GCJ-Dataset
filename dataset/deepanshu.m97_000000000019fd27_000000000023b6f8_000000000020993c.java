import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0;
            int repRow = 0;
            int repCol = 0;

            List<List<Integer>> matrix = new ArrayList<>();
            for (int j = 0 ; j < n ; j++)
                matrix.add(Arrays.stream(br.readLine().split(" ")).map(num -> new Integer(num)).collect(Collectors.toList()));

            for (int j = 0  ; j < n ; j++) {
                trace = trace + matrix.get(j).get(j);
            }

            for (int j = 0  ; j < n ; j++) {
                if (rowRepeated(matrix, n, j)) {
                    repRow++;
                }
            }

            for (int j = 0  ; j < n ; j++) {
                if (colRepeated(matrix, n, j)) {
                    repCol++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + repRow + " " + repCol);
        }
    }

    private static boolean colRepeated(List<List<Integer>> matrix, int n, int idx) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            if (set.contains(matrix.get(i).get(idx))) {
                return true;
            }

            set.add(matrix.get(i).get(idx));
        }

        return false;
    }

    private static boolean rowRepeated(List<List<Integer>> matrix, int n, int idx) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            if (set.contains(matrix.get(idx).get(i))) {
                return true;
            }

            set.add(matrix.get(idx).get(i));
        }

        return false;
    }
}