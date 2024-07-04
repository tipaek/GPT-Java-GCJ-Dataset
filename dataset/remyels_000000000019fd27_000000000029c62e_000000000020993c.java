import java.util.*;
import java.io.*;

public class Solution {
    static int n;
    
    static int[][] graph;
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int t = console.nextInt();
        for (int i = 0; i<t;i++) {
            System.out.print("Case #"+(i+1)+": ");
            n = console.nextInt();
            graph = new int[n][n];
            for (int j = 0; j<n; j++) {
                for (int k = 0; k<n; k++) {
                    graph[j][k] = console.nextInt();
                }
            }
            solve();
        }
    }
    
    public static void solve() {
        int trace = 0;
        for (int i = 0; i<n; i++) {
            trace+= graph[i][i];
        }
        int dupCol = 0;
        int dupRow = 0;
        for (int i = 0; i<n; i++) {
            Set<Integer> count = new HashSet<>();
            for (int j = 0; j<n; j++) {
                count.add(graph[i][j]);
            }
            if (count.size()!=n) {
                dupRow++;
            }
        }
        for (int i = 0; i<n; i++) {
            Set<Integer> count = new HashSet<>();
            for (int j = 0; j<n; j++) {
                count.add(graph[j][i]);
            }
            if (count.size()!=n) {
                dupCol++;
            }
        }
        System.out.println(trace+" "+dupRow+" "+dupCol);
    }
}