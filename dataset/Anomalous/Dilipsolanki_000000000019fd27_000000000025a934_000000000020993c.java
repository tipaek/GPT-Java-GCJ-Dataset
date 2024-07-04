package bomber;

import java.util.Scanner;

public class Bomber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][3];
        
        for (int k = 0; k < t; k++) { // Test Case
            int n = sc.nextInt(); // Row Col
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt(); // Input Matrix
                }
            }
            
            // Diagonal Sum Calculation
            results[k][0] = 0;
            for (int i = 0; i < n; i++) {
                results[k][0] += arr[i][i];
            }
            
            // Row Repeat Calculation
            results[k][1] = 0;
            for (int i = 0; i < n; i++) {
                boolean rowHasRepeats = false;
                for (int j = 0; j < n; j++) {
                    int current = arr[i][j];
                    int count = 0;
                    for (int p = 0; p < n; p++) {
                        if (current == arr[i][p]) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        rowHasRepeats = true;
                        break;
                    }
                }
                if (rowHasRepeats) {
                    results[k][1]++;
                }
            }
            
            // Column Repeat Calculation
            results[k][2] = 0;
            for (int i = 0; i < n; i++) {
                boolean colHasRepeats = false;
                for (int j = 0; j < n; j++) {
                    int current = arr[j][i];
                    int count = 0;
                    for (int p = 0; p < n; p++) {
                        if (current == arr[p][i]) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        colHasRepeats = true;
                        break;
                    }
                }
                if (colHasRepeats) {
                    results[k][2]++;
                }
            }
            
            // Print Results for the Current Test Case
            System.out.print("Case #" + (k + 1) + ": ");
            for (int q = 0; q < 3; q++) {
                System.out.print(results[k][q] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}