import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();
        // Testcases loop
        for(int i = 0; i < testcases; i++){
            int usecase = i + 1;
            int trace = 0;
            int repRow = 0;
            int repCol = 0;

            // read matrix
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int j = 0; j < N; j++){
                HashSet<Integer> row = new HashSet<Integer>();
                Boolean rowDup = false;
                for(int k = 0; k < N; k++){
                    int entry = sc.nextInt();
                    matrix[j][k] = entry;

                    // Check if row has duplicates
                    if(row.contains(entry)){
                        rowDup = true;
                    } else {
                        row.add(entry);
                    }

                    // check if trace
                    if(j==k) trace+=entry;
                }
                if(rowDup) repRow++;

            }

            // For columns
            for(int j = 0; j < N; j++){
                HashSet<Integer> col = new HashSet<Integer>();
                Boolean colDup = false;
                for(int k = 0; k < N; k++){
                    int entry = matrix[k][j];

                    // Check if row has duplicates
                    if(col.contains(entry)){
                        colDup = true;
                    } else {
                        col.add(entry);
                    }
                }
                if(colDup) repCol++;

            }


            // output the line
            System.out.println("Case #" + usecase + ": " + trace + " " + repRow + " " + repCol);
        }

    }
}
 
 