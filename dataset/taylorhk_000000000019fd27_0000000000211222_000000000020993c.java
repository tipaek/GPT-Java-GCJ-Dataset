import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCnt = s.nextInt();
        System.out.println("caseCnt: " + caseCnt);
        for (int i = 0; i < caseCnt; i++) {
            int size = s.nextInt();
            System.out.println("size: " + size);
            int[][] matrix = new int[size][size];
            for (int j = 0; i < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[i][j] = s.nextInt();
                }
                System.out.println(Arrays.toString(matrix[i]));
            }
        }
        System.out.println("Yes");
    }
}
