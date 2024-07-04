import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static  Scanner scanner;
    static  int tolLine = 1;

    public static void main(String[] args) {
            scanner = new Scanner(System.in);
            int line = scanner.nextInt();
            scanner.nextLine();
            while (line-- > 0){
                GetSolve();
            }

    }

    private static  void GetSolve(){
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int k  = 0;
        //generate matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    k += matrix[i][j];
                }
            }
        }
        int r = getRol(matrix);
        int c = getCol(matrix);
        System.out.println("Case #" + (tolLine++) + ": " + k + " " + r + " " + c);
    }

    private static int getRol(int[][] matrix){
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (set.contains(matrix[i][j])){
                    res++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        return res;
    }

    private static int getCol(int[][] matrix){
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (set.contains(matrix[j][i])){
                    res++;
                    break;
                }
                set.add(matrix[j][i]);
            }
        }
        return res;
    }
}
