import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = getInt(input);
        
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            
            int r = getInt(input);
            int c = getInt(input);
            long totalSum = 0;
            int[][] floor = new int[r][c];

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    floor[j][k] = getInt(input);
                }
            }

            while (true) {
                List<int[]> toEliminate = new LinkedList<>();
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (floor[j][k] == 0) continue;
                        
                        totalSum += floor[j][k];
                        int neighbourCount = 0;
                        int sumOfNeighbours = 0;

                        // Check left
                        for (int a = k - 1; a >= 0; a--) {
                            if (floor[j][a] != 0) {
                                sumOfNeighbours += floor[j][a];
                                neighbourCount++;
                                break;
                            }
                        }

                        // Check right
                        for (int a = k + 1; a < c; a++) {
                            if (floor[j][a] != 0) {
                                sumOfNeighbours += floor[j][a];
                                neighbourCount++;
                                break;
                            }
                        }

                        // Check up
                        for (int a = j - 1; a >= 0; a--) {
                            if (floor[a][k] != 0) {
                                sumOfNeighbours += floor[a][k];
                                neighbourCount++;
                                break;
                            }
                        }

                        // Check down
                        for (int a = j + 1; a < r; a++) {
                            if (floor[a][k] != 0) {
                                sumOfNeighbours += floor[a][k];
                                neighbourCount++;
                                break;
                            }
                        }

                        if (neighbourCount > 0 && floor[j][k] * neighbourCount < sumOfNeighbours) {
                            toEliminate.add(new int[]{j, k});
                        }
                    }
                }

                if (toEliminate.isEmpty()) break;

                for (int[] cell : toEliminate) {
                    floor[cell[0]][cell[1]] = 0;
                }
            }

            System.out.println(totalSum);
        }
    }

    private static int getInt(BufferedReader input) throws IOException {
        int c = skipSpace(input);
        boolean isNegative = (char) c == '-';
        int result = 0;
        
        if (isNegative) c = input.read();
        
        do {
            result = result * 10 + (c - '0');
            c = input.read();
        } while (c >= '0' && c <= '9');
        
        return isNegative ? -result : result;
    }

    private static int skipSpace(BufferedReader input) throws IOException {
        int s = input.read();
        while (s == ' ' || s == '\n' || s == '\r') {
            s = input.read();
        }
        return s;
    }
}