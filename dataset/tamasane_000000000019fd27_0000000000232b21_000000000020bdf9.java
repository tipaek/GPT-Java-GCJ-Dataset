import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
    
    private static String manage(int[][] arr, int n){
        StringBuilder sb = new StringBuilder();
        int[] alloc = new int[n];
        int prevC=-1, prevJ=-1;

        for(int i=0; i<n; i++){
            if(prevC==-1 || arr[0][i] >= arr[1][prevC]) {alloc[i] = 0; prevC = i;}
            else if(prevJ==-1 || arr[0][i]>= arr[1][prevJ]){ alloc[i] = 1; prevJ = i;}
            else { alloc[i] = 0; prevC = i;}
        }
        for(int a: alloc)
            if(a==0) sb.append("C");
            else sb.append("J");
        return sb.toString().trim();
    }

    private static int need(int[] a, int[] d, int n) {
        int count =1;
        int[] arr = Arrays.copyOf(a, n);
        int[] dep = Arrays.copyOf(d, n);
        Arrays.sort(arr);
        Arrays.sort(dep);
        int needed=1;
        int i=1, j=0;
        while(i<n && j<n){
            if(arr[i]<dep[j]){
                needed++;
                if(count<needed) count = needed;
                i++;
            }
            else{
                j++;
                needed--;
            }
        }
        return count;
    }
    
    public static String solve(int[][] arr, int n){
        int p = need(arr[0], arr[1], n);
        if(p>2) return "IMPOSSIBLE";
        return manage(arr, n);
    }
    
    public static void main(String...args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine().trim());
        int t = 1;
        while(t<=test){
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[2][n];
            for(int i=0; i<n; i++){
                String s[] = br.readLine().trim().split(" +");
                arr[0][i] = Integer.parseInt(s[0]);
                arr[1][i] = Integer.parseInt(s[1]);
            }
            sb.append("Case #").append(t++).append(": ").append(solve(arr, n)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}