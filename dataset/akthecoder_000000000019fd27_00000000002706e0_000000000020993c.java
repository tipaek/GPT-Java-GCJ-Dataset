import java.util.Scanner;
import java.util.Vector;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int i = 0; i < testCases; i++) {
            int N = scan.nextInt();
            int matrix[][] = new int[N][N];
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    matrix[r][c] = scan.nextInt();
                }
            }
            System.out.println(calculateDiagonalSum(matrix, N, 0) + " " + calculateDuplicate(matrix, N, true) + " " + calculateDuplicate(matrix, N, false));
        }
        scan.close();
    }

    public static int calculateDuplicate(int[][] matrix, int N, boolean rows) {
        Vector<Integer> vec = new Vector<>();
        boolean duplicate = false;
        int duplicates = 0;
        for(int i = 0; i < N; i++) {
            duplicate = false;
            vec.removeAllElements();
            for(int j = 0; j < N; j++) {
                if(rows) {
                    if(vec.contains(matrix[i][j])) {
                        duplicate = true;
                    }
                    else {
                        vec.add(matrix[i][j]);
                    }
                }
                else {
                    if(vec.contains(matrix[j][i])) {
                        duplicate = true;
                    }
                    else {
                        vec.add(matrix[j][i]);
                    }
                }
            }
            if(duplicate) {
                duplicates++;
            }
        }
        return duplicates;
    }
        
    public static int calculateDiagonalSum(int[][] matrix, int N, int curr) {
        if(curr >= N) return 0;
        return matrix[curr][curr] + calculateDiagonalSum(matrix, N, curr + 1);
    }
}