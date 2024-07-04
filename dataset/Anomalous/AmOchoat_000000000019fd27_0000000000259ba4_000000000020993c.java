import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int cases = Integer.parseInt(bf.readLine().trim());
            
            for (int i = 0; i < cases; i++) {
                int n = Integer.parseInt(bf.readLine().trim());
                if (n < 2) continue;
                
                int[][] table = new int[n][n];
                
                for (int x = 0; x < n; x++) {
                    String[] row = bf.readLine().trim().split(" ");
                    for (int c = 0; c < n; c++) {
                        table[x][c] = Integer.parseInt(row[c]);
                    }
                }

                int diagonalSum = 0;
                for (int z = 0; z < n; z++) {
                    diagonalSum += table[z][z];
                }

                int duplicateRows = 0;
                for (int a = 0; a < n; a++) {
                    boolean hasDuplicate = false;
                    for (int b = 0; b < n && !hasDuplicate; b++) {
                        for (int e = b + 1; e < n && !hasDuplicate; e++) {
                            if (table[a][b] == table[a][e]) {
                                duplicateRows++;
                                hasDuplicate = true;
                            }
                        }
                    }
                }

                int duplicateColumns = 0;
                for (int a = 0; a < n; a++) {
                    boolean hasDuplicate = false;
                    for (int b = 0; b < n && !hasDuplicate; b++) {
                        for (int e = b + 1; e < n && !hasDuplicate; e++) {
                            if (table[b][a] == table[e][a]) {
                                duplicateColumns++;
                                hasDuplicate = true;
                            }
                        }
                    }
                }

                result.append("Case #").append(i + 1).append(": ").append(diagonalSum)
                      .append(" ").append(duplicateColumns).append(" ").append(duplicateRows).append("\n");
            }
            
            System.out.print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}