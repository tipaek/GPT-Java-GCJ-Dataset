import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++){
            int n = scanner.nextInt();
            int[][] mat = new int[n][n];


            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;

            for(int i = 0; i < n; i++){

                trace += mat[i][i];

            }


            int totalRow = 0;
            int totalColumn = 0;

            for(int i = 0; i < n; i++){
                boolean[] rows = new boolean[n+1];
                boolean[] columns = new boolean[n+1];
                boolean foundRow = false;
                boolean foundColumn = false;
                for(int j = 0; j < n; j++){
                    if (rows[mat[i][j]])
                        foundRow = true;
                    if (columns[mat[j][i]])
                        foundColumn = true;
                    rows[mat[i][j]] = true;
                    columns[mat[j][i]] = true;

                }
                if (foundRow)
                    totalRow++;
                if(foundColumn)
                    totalColumn++;

            }

            System.out.println("Case #" + t + ": " + trace + " " + totalRow + " " + totalColumn);


        }
    }
}