import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CodeJam1 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            
            for (int t = 0; t < testCases; t++) {
                int N = Integer.parseInt(br.readLine());
                int[][] matrix = new int[N][N];
                
                for (int i = 0; i < N; i++) {
                    String[] lineArray = br.readLine().split(" ");
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = Integer.parseInt(lineArray[j]);
                    }
                }
                
                int trace = 0;
                for (int i = 0; i < N; i++) {
                    trace += matrix[i][i];
                }
                
                int rowRepeats = 0;
                int colRepeats = 0;
                
                for (int i = 0; i < N; i++) {
                    if (hasDuplicates(matrix[i])) {
                        rowRepeats++;
                    }
                    
                    int[] column = new int[N];
                    for (int j = 0; j < N; j++) {
                        column[j] = matrix[j][i];
                    }
                    if (hasDuplicates(column)) {
                        colRepeats++;
                    }
                }
                
                System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}