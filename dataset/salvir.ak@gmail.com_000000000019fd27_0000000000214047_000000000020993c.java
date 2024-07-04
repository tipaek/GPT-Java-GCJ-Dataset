import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =0; i<t; i++) {
            int trace = 0;
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for(int row = 0; row<n; row++) {
                for(int column = 0; column<n; column++) {
                    matrix[row][column]=sc.nextInt();
                    if(row==column) trace+=matrix[row][column];
                }
            }
            System.out.print("Case #"+(i+1)+": " + trace+" ");
            vestigium(matrix);
        }
    }

    public static void vestigium (int[][] matrix) {
        int rows= 0;
        int columns = 0;
        for(int i =0; i<matrix.length; i++) {
            HashSet<Integer> row = new HashSet<>();
            for(int j = 0; j<matrix[i].length; j++) {
                if(!row.contains(matrix[i][j])) row.add(matrix[i][j]);
                else {rows++; break;}
            }
        }

        for(int i =0; i<matrix.length; i++) {
            HashSet<Integer> column = new HashSet<>();
            for(int j = 0; j<matrix[i].length; j++) {
                if(!column.contains(matrix[j][i])) column.add(matrix[j][i]);
                else {columns++; break;}
            }
        }

        System.out.println(rows+" "+ columns);
    }

}
