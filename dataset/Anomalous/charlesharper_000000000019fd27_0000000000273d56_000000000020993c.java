import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] matrix = new int[l][l];
            
            for (int row = 0; row < l; row++) {
                String[] inputLine = br.readLine().split(" ");
                for (int col = 0; col < l; col++) {
                    matrix[row][col] = Integer.parseInt(inputLine[col]);
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int index = 0; index < l; index++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < l; j++) {
                    rowSet.add(matrix[index][j]);
                    colSet.add(matrix[j][index]);
                }

                if (rowSet.size() < l) {
                    duplicateRows++;
                }
                if (colSet.size() < l) {
                    duplicateCols++;
                }

                trace += matrix[index][index];
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}