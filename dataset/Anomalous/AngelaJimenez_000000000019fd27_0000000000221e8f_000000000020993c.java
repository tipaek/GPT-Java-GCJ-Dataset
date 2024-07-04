import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int numCases = Integer.parseInt(reader.readLine());
            
            for (int i = 0; i < numCases; i++) {
                int sumDiagonal = 0;
                int rowRepeats = 0;
                int colRepeats = 0;
                int n = Integer.parseInt(reader.readLine());
                
                int[][] matrix = new int[n][n];
                
                for (int j = 0; j < n; j++) {
                    String[] line = reader.readLine().split(" ");
                    System.out.println(line[0]);
                    
                    for (int h = 0; h < n; h++) {
                        matrix[j][h] = Integer.parseInt(line[h]);
                        
                        if (j == h) {
                            sumDiagonal += matrix[j][h];
                        }
                    }
                }

                for (int k = 0; k < n; k++) {
                    boolean hasRowRepeat = false;
                    boolean hasColRepeat = false;
                    
                    for (int z = 0; z < n && (!hasRowRepeat || !hasColRepeat); z++) {
                        for (int m = z + 1; m < n && (!hasRowRepeat || !hasColRepeat); m++) {
                            if (matrix[k][z] == matrix[k][m]) {
                                hasRowRepeat = true;
                            }
                            if (matrix[z][k] == matrix[m][k]) {
                                hasColRepeat = true;
                            }
                        }
                    }
                    
                    if (hasRowRepeat) {
                        rowRepeats++;
                    }
                    if (hasColRepeat) {
                        colRepeats++;
                    }
                }
                
                System.out.println("Case #" + (i + 1) + ": " + sumDiagonal + " " + rowRepeats + " " + colRepeats);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}