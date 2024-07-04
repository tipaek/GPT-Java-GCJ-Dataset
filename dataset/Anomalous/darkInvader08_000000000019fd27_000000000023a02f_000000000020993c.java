import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] M = new int[N][N];
            
            // Reading the matrix
            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    M[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += M[i][i];
            }
            
            // Check for row repeats
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(M[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }
            
            // Check for column repeats
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(M[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}