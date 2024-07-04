import java.io.*;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input");
        int T = Integer.parseInt(br.readLine());
        int caseNumber = 0;

        if (T >= 1 && T <= 100) {
            for (int k = 0; k < T; k++) {
                int N = Integer.parseInt(br.readLine());
                int trace = 0, rowRepeats = 0, colRepeats = 0;

                if (N >= 2 && N <= 100) {
                    int[][] matrix = new int[N][N];

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            int value = Integer.parseInt(br.readLine());
                            if (value >= 1 && value <= N) {
                                matrix[i][j] = value;
                            }
                        }
                    }
                    caseNumber++;

                    // Print the matrix (for debugging purposes)
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(matrix[i][j] + "\t");
                        }
                        System.out.println();
                    }

                    // Calculate trace
                    for (int i = 0; i < N; i++) {
                        trace += matrix[i][i];
                    }

                    // Check for row repeats
                    for (int i = 0; i < N; i++) {
                        boolean[] seen = new boolean[N + 1];
                        for (int j = 0; j < N; j++) {
                            if (seen[matrix[i][j]]) {
                                rowRepeats++;
                                break;
                            }
                            seen[matrix[i][j]] = true;
                        }
                    }

                    // Check for column repeats
                    for (int i = 0; i < N; i++) {
                        boolean[] seen = new boolean[N + 1];
                        for (int j = 0; j < N; j++) {
                            if (seen[matrix[j][i]]) {
                                colRepeats++;
                                break;
                            }
                            seen[matrix[j][i]] = true;
                        }
                    }

                    System.out.println("Output");
                    System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
                }
            }
        }
    }
}