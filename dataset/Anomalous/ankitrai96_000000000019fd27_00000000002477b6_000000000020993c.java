import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte testCases = sc.nextByte();
        
        for (byte t = 0; t < testCases; t++) {
            byte N = sc.nextByte();
            byte[][] matrix = new byte[N][N];
            
            for (byte i = 0; i < N; i++) {
                for (byte j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextByte();
                }
            }
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Calculate trace
            for (byte i = 0; i < N; i++) {
                trace += matrix[i][i];
            }
            
            // Check for repeated elements in rows
            for (byte i = 0; i < N; i++) {
                Set<Byte> rowSet = new HashSet<>();
                for (byte j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < N) {
                    rowRepeats++;
                }
            }
            
            // Check for repeated elements in columns
            for (byte j = 0; j < N; j++) {
                Set<Byte> colSet = new HashSet<>();
                for (byte i = 0; i < N; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < N) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}