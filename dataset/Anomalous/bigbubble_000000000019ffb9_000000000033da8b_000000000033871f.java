import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int C = sc.nextInt();
            int D = sc.nextInt();

            int[] before = new int[C];
            int[] checked = new int[C];
            ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>();
            int[][] connections = new int[C][C];

            for (int j = 0; j < C; j++) {
                neighbors.add(new ArrayList<>());
                if (j > 0) {
                    before[j] = -sc.nextInt();
                    checked[j] = -1;
                }
            }
            checked[0] = 0;
            before[0] = Integer.MAX_VALUE;

            int[][] directConnections = new int[D][2];
            for (int j = 0; j < D; j++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                neighbors.get(a).add(b);
                neighbors.get(b).add(a);
                directConnections[j][0] = a;
                directConnections[j][1] = b;
            }

            int currentMin = 1;
            int currentTime = 1;
            int numChecked = 1;

            while (numChecked < C) {
                for (int j = 1; j < C; j++) {
                    if (before[j] == currentMin && checked[j] == -1) {
                        for (int neighbor : neighbors.get(j)) {
                            if (checked[neighbor] != -1) {
                                connections[neighbor][j] = Math.max(currentTime - checked[neighbor], 1);
                                connections[j][neighbor] = Math.max(currentTime - checked[neighbor], 1);
                            }
                        }
                        numChecked++;
                        checked[j] = currentTime;
                    }
                    if (j == C - 1) {
                        currentMin++;
                        currentTime++;
                    }
                }
            }

            System.out.print("Case #" + i + ": ");
            for (int j = 0; j < D; j++) {
                System.out.print(connections[directConnections[j][0]][directConnections[j][1]] + " ");
            }
            System.out.println();
        }
    }
}