import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = 1;
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] arr = new int[R][C];
            long sum = 0;
            
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] = sc.nextInt();
                    sum += arr[i][j];
                }
            }
            
            int[][] vis = new int[R][C];
            
            while (true) {
                boolean flag = false;
                List<Pair> x = new ArrayList<>();
                List<Pair> y = new ArrayList<>();
                List<Pair> z = new ArrayList<>();
                
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (vis[i][j] == 0) {
                            double total = 0;
                            int count = 0;
                            int[] neighbors = {-1, -1, -1, -1}; // p, q, r, s
                            
                            // Check down
                            for (int k = i + 1; k < R; k++) {
                                if (vis[k][j] == 0) {
                                    total += arr[k][j];
                                    neighbors[0] = k;
                                    count++;
                                    break;
                                }
                            }
                            // Check up
                            for (int k = i - 1; k >= 0; k--) {
                                if (vis[k][j] == 0) {
                                    total += arr[k][j];
                                    neighbors[1] = k;
                                    count++;
                                    break;
                                }
                            }
                            // Check right
                            for (int k = j + 1; k < C; k++) {
                                if (vis[i][k] == 0) {
                                    total += arr[i][k];
                                    neighbors[2] = k;
                                    count++;
                                    break;
                                }
                            }
                            // Check left
                            for (int k = j - 1; k >= 0; k--) {
                                if (vis[i][k] == 0) {
                                    total += arr[i][k];
                                    neighbors[3] = k;
                                    count++;
                                    break;
                                }
                            }
                            
                            if (total / count > arr[i][j]) {
                                if (neighbors[0] != -1) x.add(new Pair(neighbors[0], j));
                                if (neighbors[1] != -1) x.add(new Pair(neighbors[1], j));
                                if (neighbors[2] != -1) y.add(new Pair(i, neighbors[2]));
                                if (neighbors[3] != -1) y.add(new Pair(i, neighbors[3]));
                                flag = true;
                                z.add(new Pair(i, j));
                            }
                        }
                    }
                }
                
                if (!flag) break;
                
                for (Pair p : z) {
                    vis[p.x][p.y] = 1;
                    arr[p.x][p.y] = 0;
                }
                
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (vis[i][j] == 0) {
                            sum += arr[i][j];
                        }
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + sum);
            caseNumber++;
        }
    }
}

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}