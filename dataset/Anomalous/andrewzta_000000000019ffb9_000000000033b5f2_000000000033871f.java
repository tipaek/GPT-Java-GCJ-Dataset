import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        SecurityUpdate solver = new SecurityUpdate();
        int testCases = Integer.parseInt(scanner.next());
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, scanner, writer);
        }
        writer.close();
    }

    static class SecurityUpdate {
        public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int[] x = new int[c];
            for (int i = 1; i < c; i++) {
                x[i] = scanner.nextInt();
            }

            int[][] adjacencyMatrix = new int[c][c];
            int[] u = new int[d];
            int[] v = new int[d];
            for (int i = 0; i < d; i++) {
                u[i] = scanner.nextInt() - 1;
                v[i] = scanner.nextInt() - 1;
                adjacencyMatrix[u[i]][v[i]] = adjacencyMatrix[v[i]][u[i]] = -1;
            }

            int[] distances = new int[c];
            Arrays.fill(distances, -1);
            distances[0] = 0;
            int completed = 1;
            int lastDistance = 0;

            while (completed < c) {
                int stepsThisRound = 0;
                for (int i = 0; i < c; i++) {
                    if (distances[i] == -1 && (-x[i] == completed || x[i] == lastDistance + 1)) {
                        for (int j = 0; j < c; j++) {
                            if (distances[j] != -1 && distances[j] <= lastDistance && adjacencyMatrix[i][j] == -1) {
                                adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = lastDistance + 1 - distances[j];
                            }
                        }
                        distances[i] = lastDistance + 1;
                        stepsThisRound++;
                    }
                }
                completed += stepsThisRound;
                lastDistance++;
            }

            for (int i = 0; i < d; i++) {
                if (adjacencyMatrix[u[i]][v[i]] == -1) {
                    adjacencyMatrix[u[i]][v[i]] = adjacencyMatrix[v[i]][u[i]] = 1000000;
                }
            }

            writer.print("Case #" + testNumber + ":");
            for (int i = 0; i < d; i++) {
                writer.print(" " + adjacencyMatrix[u[i]][v[i]]);
            }
            writer.println();
        }
    }
}