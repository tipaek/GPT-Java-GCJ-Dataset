import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberTestCases = in.nextInt();
        for (int i = 0; i < numberTestCases; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            int rowsWithRepeatedElements = 0;
            HashSet<Integer> set;

            int trace = 0;
            // read input matrix
            for (int j = 0; j < n; j++) {
                set = new HashSet<>();
                boolean isCounted = false;
                for (int k = 0; k < n; k++) {
                    int next = in.nextInt();
                    matrix[j][k] = next;
                    if(!set.add(next) && !isCounted){
                        rowsWithRepeatedElements++;
                        isCounted = true;
                    }
                }
                trace += matrix[j][j];
            }

            //Check for repeated elements in columns
            int columnsWithRepeatedElements = 0;
            for (int j = 0; j < n; j++) {
                set = new HashSet<>();
                boolean isCounted = false;
                for (int k = 0; k < n; k++) {
                    int number = matrix[k][j];
                    if(!set.add(number) && !isCounted) {
                        columnsWithRepeatedElements++;
                        isCounted=true;
                    }
                }
            }

            System.out.println("Case #"+(i+1)+": "+trace+" "+rowsWithRepeatedElements+" "+columnsWithRepeatedElements);
        }
        
    }
}
