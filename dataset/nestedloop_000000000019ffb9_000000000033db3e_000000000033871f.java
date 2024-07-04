import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bohdan
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test; ++t) {

            int n = in.nextInt();
            int m = in.nextInt();
            int[] dist = new int[n];
            int[][] edges = new int[n][n];
            int[][] edgelist = new int[m][2];
            for (int i = 1; i < n; i++) {
                dist[i] = in.nextInt();
            }
            dist[0] = 0;
            for (int i = 0; i < m; i++) {
                int a = in.nextInt()-1;
                int b = in.nextInt()-1;
                edges[a][b] = 1;
                edges[b][a] = 1;
                edgelist[i][0] = a;
                edgelist[i][1] = b;
            }
            boolean[] assigned = new boolean[n];

            int[] sortDist = new int[n];
            System.arraycopy(dist, 0, sortDist, 0, n);
            Arrays.sort(sortDist);
            int j = 0;
            for (j = 0; j < n; j++) {
                if (sortDist[j] >= 0) {
                    break;
                }
            }
            int currInd = j;
            int curr = 0;
            int p = 0;
            for (int i = 0; i < j; i++) {
                if ((currInd-j)+p < -sortDist[j-i-1]) {
                    if (-sortDist[j-i-1] > (currInd - j)+p+1) {
                        currInd = j - sortDist[j-i-1] - p - 1;
                        curr = sortDist[currInd];                        
                    }
                    for (int k = 0; k < n; k++) {
                        if (dist[k] == sortDist[j-i-1]) {
                            dist[k] = curr+1;
                            p = p+1;
                        }
                    }
                    curr = curr+1;
                }
            }
            
            int[] index = new int[n];
            for (int i = 0; i<n; i++){
                index[i] = i;
            }
            for (int i =0; i<n; i++){
                for(int k = i+1; k<n; k++){
                    if (dist[k]<dist[i]){
                        int tmp = dist[i];
                        dist[i] = dist[k];
                        dist[k] = tmp;
                        tmp = index[i];
                        index[i] = index[k];
                        index[k] = tmp;
                    }
                }
            }
            for (int i = 1; i<n; i++){
                for (int k = 0; k<i; k++){
                    if (edges[index[k]][index[i]]>0){
                        edges[index[k]][index[i]] = dist[i]-dist[k];
                        if (edges[index[k]][index[i]] == 0){
                            edges[index[k]][index[i]] = 1;
                        }
                        edges[index[i]][index[k]] = edges[index[k]][index[i]];
                    }
                }
            }
            

            System.out.print("Case #" + t + ":");
            for (int i = 0; i<m; i++){
                System.out.print(" "+edges[edgelist[i][0]][edgelist[i][1]]);
            }
            System.out.println();
        }
    }

}
