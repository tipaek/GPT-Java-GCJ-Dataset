import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        int[] trace = new int[T];
        int[] rowRepeats = new int[T];
        int[] colRepeats = new int[T];
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            
            // Reading matrix values
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // Calculate trace
            trace[t] = 0;
            for (int i = 0; i < N; i++) {
                trace[t] += matrix[i][i];
            }
            
            // Calculate row repeats
            rowRepeats[t] = 0;
            for (int i = 0; i < N; i++) {
                boolean[] seen = new boolean[N + 1];
                for (int j = 0; j < N; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats[t]++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
            
            // Calculate column repeats
            colRepeats[t] = 0;
            for (int j = 0; j < N; j++) {
                boolean[] seen = new boolean[N + 1];
                for (int i = 0; i < N; i++) {
                    if (seen[matrix[i][j]]) {
                        colRepeats[t]++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }
        }
        
        sc.close();
        
        // Output results
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowRepeats[i] + " " + colRepeats[i]);
        }
    }
}