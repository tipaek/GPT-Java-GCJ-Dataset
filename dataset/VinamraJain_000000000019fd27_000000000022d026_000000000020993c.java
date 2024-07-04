import java.io.*;
import java.util.*;
public class Solution {
    
    public static void solve(int x,int arr[][]) {
        int k=0,r=0,c=0;
        for(int i=0;i<arr.length;i++) {
            HashSet<Integer> row = new HashSet<>();
            HashSet<Integer> col = new HashSet<>();
            for(int j=0;j<arr.length;j++) {
                row.add(arr[i][j]);
                col.add(arr[j][i]);
                if(i==j){
                    k += arr[i][j];
                }
            }
            if(row.size()!=arr.length) r++;
            if(col.size()!=arr.length) c++;
        }
        System.out.printf("Case #%d: %d %d %d\n",x+1,k,r,c);
    }
    
    public static void main(String[] args)throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);
        int t = Integer.parseInt(in.readLine());
        for(int m=0;m<t;m++) {
            int n = Integer.parseInt(in.readLine());
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++) {
                String input[] = in.readLine().split(" ");
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }
            solve(m,arr);
        }
    }
}