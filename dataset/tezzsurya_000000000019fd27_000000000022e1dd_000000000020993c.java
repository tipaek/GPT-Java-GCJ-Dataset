import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for(int k=1;k<=t;k++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] ar = new int[n][n];
            for(int i=0;i<n;i++) {
                String[] sar = br.readLine().trim().split(" ");
                for(int j=0;j<n;j++) {
                    ar[i][j] = Integer.parseInt(sar[j]);
                }
            }
            int rowCount = 0;
            long trace = 0L;
            for(int i=0;i<n;i++) {
                Set<Integer> set = new HashSet<>();
                boolean isDup = false;
                for(int j=0;j<n;j++) {
                    if(i == j) trace += ar[i][j];
                    if(!isDup && set.contains(ar[i][j])) {
                        rowCount++;
                        isDup = true;
                    } else {
                        set.add((ar[i][j]));
                    }
                }
            }


            int colCount = 0;
            for(int i=0;i<n;i++) {
                Set<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++) {
                    if(set.contains(ar[j][i])) {
                        colCount++;
                        break;
                    } else {
                        set.add((ar[j][i]));
                    }
                }
            }
            sb.append("Case #").append(k).append(": ").append(trace).append(" ").append(rowCount).append(" ").append(colCount);
            if(k != t) {
                sb.append("\n");
            }
            // System.out.println("Case #"+ k + ": " + trace + " "+ rowCount + " " + colCount);
        }
        System.out.println(sb.toString());
    }
}