import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int[] trace = new int[t]; 
            int[] rowDuplicates = new int[t];  
            int[] colDuplicates = new int[t];

            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                int traceSum = 0;

                // Reading matrix and computing trace
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        matrix[j][k] = sc.nextInt();
                        if (j == k) {
                            traceSum += matrix[j][k];
                        }
                    }
                }

                // Check for row duplicates
                int rowDupCount = 0;
                for (int j = 0; j < n; j++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int k = 0; k < n; k++) {
                        if (!rowSet.add(matrix[j][k])) {
                            rowDupCount++;
                            break;
                        }
                    }
                }

                // Check for column duplicates
                int colDupCount = 0;
                for (int j = 0; j < n; j++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int k = 0; k < n; k++) {
                        if (!colSet.add(matrix[k][j])) {
                            colDupCount++;
                            break;
                        }
                    }
                }

                trace[i] = traceSum;
                rowDuplicates[i] = rowDupCount;
                colDuplicates[i] = colDupCount;
            }

            for (int i = 0; i < t; i++) {
                System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowDuplicates[i] + " " + colDuplicates[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}