import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int matrixes = scanner.nextInt();
        for(int i = 0; i < matrixes; i++) {
            int k = 0;
            int r = 0;
            int c = 0;
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for(int j = 0; j < matrix.length; j++) {
                for(int l = 0; l < matrix[j].length; l++) {
                    matrix[j][l] = scanner.nextInt();
                }
            }
            for(int j = 0; j < matrix.length; j++) {
                k += matrix[j][j];
            }
            for(int j = 0; j < matrix.length; j++) {
                Set<Integer> alreadySeen = new HashSet<>();
                for(int l = 0; l < matrix[j].length; l++) {
                    if(alreadySeen.contains(matrix[j][l])) {
                        r++;
                        break;
                    }
                    alreadySeen.add(matrix[j][l]);
                }
            }
            for(int j = 0; j < matrix.length; j++) {
                Set<Integer> alreadySeen = new HashSet<>();
                for(int l = 0; l < matrix[j].length; l++) {
                    if(alreadySeen.contains(matrix[l][j])) {
                        c++;
                        break;
                    }
                    alreadySeen.add(matrix[l][j]);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}
