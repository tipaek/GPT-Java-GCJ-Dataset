import java.util.Scanner;
import java.util.HashMap;
public class Solution {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        //System.out.println("t: "+ t);
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rows = 0;
            int cols = 0;
            //System.out.println("n: "+ n);
            for(int j=0; j<n; j++) {
                String[] tempArray = scanner.nextLine().split(" ");
                for(int k=0;k<n;k++) {
                    matrix[j][k] = Integer.parseInt(tempArray[k]);
                    if(j==k) {
                        trace += matrix[j][k];
                    }
                }
            }
            for(int j=0; j<n; j++) {
                int increment = containDuplicatesInRow(matrix, j) ? 1 : 0;
                rows += increment;
                increment = containDuplicatesInColumn(matrix, j) ? 1 : 0;
                cols += increment;
            }
            System.out.println("Case #"+(i+1)+": " + trace+ " " + rows+ " " + cols);
        }
    }

    public static boolean containDuplicatesInRow(int[][] matrix, int row) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i=0; i<matrix.length; i++) {
            if(hashMap.containsKey(matrix[row][i])) {
                return true;
            } else {
                hashMap.put(matrix[row][i], 1);
            }
        }
        return false;
    }

    public static boolean containDuplicatesInColumn(int[][] matrix, int column) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i=0; i<matrix.length; i++) {
            if(hashMap.containsKey(matrix[i][column])) {
                return true;
            } else {
                hashMap.put(matrix[i][column], 1);
            }
        }
        return false;
    }
}
