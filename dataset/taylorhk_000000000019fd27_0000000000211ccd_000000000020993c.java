import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCnt = s.nextInt();
//        System.out.println("caseCnt: " + caseCnt);
        for (int i = 0; i < caseCnt; i++) {
            int size = s.nextInt();
//            System.out.println("size: " + size);
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = s.nextInt();
                }
//                System.out.println(Arrays.toString(matrix[i]));
            }
            int trace = 0;
            for (int j = 0; j < size; j++) trace += matrix[j][j];
            int repeatedRows = 0, repeatedColumns = 0;
            for (int j = 0; j < size; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (set.contains(matrix[j][k])) {
                        repeatedRows++;
                        break;
                    }
                    set.add(matrix[j][k]);
                }
            }

            for (int k = 0; k < size; k++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (set.contains(matrix[j][k])) {
                        repeatedColumns++;
                        break;
                    }
                    set.add(matrix[j][k]);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}
