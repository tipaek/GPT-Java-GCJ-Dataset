import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0, length = 0;
        int cases = scan.nextInt();
        String skip =  scan.nextLine();
        for(int a = 1; a <= cases; a++) {
            length = scan.nextInt();
            skip = scan.nextLine();
            int[][] matrix = new int[length][length];
            for(int i=  0; i < length; i++) {
                for(int j = 0; j < length; j++) {
                    matrix[i][j] = scan.nextInt(); 
                }
                skip = scan.nextLine();
            }
        int l = 0, sum = 0;
        for(int i=  0; i < length; i++) {
                sum+= matrix[i][l];
                l++;
        }
        int[] column = new int[length];
        for(int i =  0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                for(int k = 0; k < length; k++) {
                    if(matrix[j][i] == matrix[k][i]) {
                        column[i]++;
                    }
                }
            }
        }
        int[] row = new int[length];
        for(int i =  0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                for(int k = 0; k < length; k++) {
                    if(matrix[i][j] == matrix[i][k]) {
                        row[i]++;
                    }
                }
            }
        }
        int columns = 0;
        for(int i = 0; i <column.length; i++) {
            if(column[i] > 0) {
                columns++;
            }
        }
        int rows = 0;
        for(int i = 0; i <row.length; i++) {
            if(row[i] > 0) {
                rows++;
            }
        }
        System.out.println("Case #" + a + ": " + sum + " " + rows + " " + columns);
        }
    }
}