import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        int counter = 1;

        while(testCases-- > 0) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                    if( i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for(int[] rows : matrix) {
                Set<Integer> set = new HashSet<Integer>();
                for(int i = 0; i < rows.length; i++) {
                    if(set.contains(rows[i])) {
                        rowCount += 1;
                        break;
                    }
                    set.add(rows[i]);
                }
            }

            for(int i = 0; i < size; i++) {
                Set<Integer> set = new HashSet<Integer>();
                for(int j = 0; j < size; j++) {
                    int tmpValue = matrix[j][i];
                    if(set.contains(tmpValue)) {
                        colCount += 1;
                        break;
                    }
                    set.add(tmpValue);
                }
            }
            System.out.println("Case #"+counter+": "+trace+" "+rowCount+" "+colCount);
            counter++;
        }
    }
}