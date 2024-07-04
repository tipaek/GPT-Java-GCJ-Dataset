import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int[] xs = new int[c];

            for (int i = 1; i < c; i++) {
                xs[i] = -scanner.nextInt();
            }

            boolean[][] adjacencyMatrix = new boolean[c][c];
            int[][] weights = new int[c][c];
            int[] us = new int[d];
            int[] vs = new int[d];

            for (int i = 0; i < d; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                us[i] = u;
                vs[i] = v;

                if (xs[u] == xs[v]) {
                    weights[u][v] = 1000000;
                    weights[v][u] = 1000000;
                }

                adjacencyMatrix[u][v] = true;
                adjacencyMatrix[v][u] = true;
            }

            int numProcessed = 1;
            int currentProcessing = 1;

            while (numProcessed < c) {
                for (int i = 0; i < c; i++) {
                    if (xs[i] == currentProcessing) {
                        numProcessed++;
                        for (int j = 0; j < c; j++) {
                            if (xs[j] < xs[i] && adjacencyMatrix[i][j]) {
                                int weight = (xs[i] * (xs[i] + 1)) / 2 - (xs[j] * (xs[j] + 1)) / 2;
                                weights[i][j] = weight;
                                weights[j][i] = weight;
                            }
                        }
                    }
                }
                currentProcessing = numProcessed;
            }

            System.out.print("Case #" + caseNumber + ":");
            for (int i = 0; i < d; i++) {
                System.out.print(" " + weights[us[i]][vs[i]]);
            }
            System.out.println();
        }
    }
}