import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.valueOf(in.readLine());
        for(int i = 0;i < time;++i) {
            int n = Integer.valueOf(in.readLine());
            int[][] arr = new int[n][n];
            for(int j = 0;j < n;++j) {
                String[] line = in.readLine().replaceAll("\\s+$", "").split(" ");
                for(int k = 0;k < n;++k) {
                    arr[j][k] = Integer.valueOf(line[k]);
                }
            }
            int[] res = solve(n,arr);
            System.out.println("Case #"+(i+1)+": "+res[0]+" "+res[1]+" "+res[2]);
        }
    }
    private static int[] solve(int n,int[][] arr) {
        int[] res = new int[3];
        Set<Integer>[] sets = new HashSet[n];
        for(int i = 0;i < n;++i) sets[i] = new HashSet<>();
        for(int i = 0;i < n;++i) {
            Set<Integer> set = new HashSet<>();
            for(int j = 0;j < n;++j) {
                if(i==j) res[0]+=arr[i][j];
                if(set!=null) {
                    if(set.contains(arr[i][j])) {
                        res[1]++;
                        set = null;
                    }else {
                        set.add(arr[i][j]);
                    }
                }
                if(sets[j]!=null) {
                    if(sets[j].contains(arr[i][j])) {
                        res[2]++;
                        sets[j] = null;
                    }else {
                        sets[j].add(arr[i][j]);
                    }
                }
            }
        }
        return res;
    }
}