import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            String M = scanner.next();
            System.out.printf("Case #%d: %s\n", i + 1, helper(X, Y, M));
        }
    }
    
    public static String helper(int X, int Y, String M) {
        int n = M.length();
        int[][] distance = new int[n + 1][2];
        int idx = 1;
        distance[0][0] = X;
        distance[0][1] = Y;
        for (char c : M.toCharArray()) {
            if (c == 'W') {
                distance[idx][0] = distance[idx - 1][0] - 1;
                distance[idx][1] = distance[idx - 1][1];
            } else if (c == 'E') {
                distance[idx][0] = distance[idx - 1][0] + 1;
                distance[idx][1] = distance[idx - 1][1];
            } else if (c == 'S') {
                distance[idx][1] = distance[idx - 1][1] - 1;
                distance[idx][0] = distance[idx - 1][0];
            } else {
                distance[idx][1] = distance[idx - 1][1] + 1;
                distance[idx][0] = distance[idx - 1][0];
            }
            idx++;
        }
        for (int i = 0; i < n + 1; i++) {
            if (Math.abs(distance[i][0]) + Math.abs(distance[i][1]) <= i) {
                return Integer.toString(i);
            }
        }
        return "IMPOSSIBLE";
    }
}