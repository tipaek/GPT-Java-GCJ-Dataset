import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
            Scanner inputValue = new Scanner(System.in);
            int vals2Loop = inputValue.nextInt();
            for (int caseVal = 1; caseVal <= vals2Loop; ++caseVal) {
                
                int n = inputValue.nextInt();
                int[][] matrix= new int[n][n];
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        matrix[i][j] = inputValue.nextInt();
                    }
                }
                //k - trace of the matrix
                //r - number of rows matrix
                //c - columns of the matrix
                int trace = 0  , rows = 0 , columns = 0;

                for (int i = 0 ; i < n ; i++) {
                    trace += matrix[i][i];
                    Set<Integer> tempHashSet = new HashSet<>();
                    for (int j = 0 ; j < n ; j++){
                        if (tempHashSet.contains(matrix[i][j])) {
                            rows++;
                            break;
                        }
                        tempHashSet.add(matrix[i][j]);
                    }
                    tempHashSet.clear();
                    for (int j = 0 ; j < n ; j++){
                        if (tempHashSet.contains(matrix[j][i])) {
                            columns++;
                            break;
                        }
                        tempHashSet.add(matrix[j][i]);
                    }
                }

                System.out.println("Case #"+caseVal+": "+trace+" "+rows+" "+columns);
            }

    }


}