import java.util.*;
import java.io.*;
public class Solution{
    public static void solve(int i,int[][] arr){
        int r=0;
        int c=0;
        int trace=0;
        int size = arr.length;
        for(int j=0;j<size;j++){
            trace = trace + arr[j][j];
        }
        int flag=0;
        for(int j=0;j<size;j++){
            flag=0;
             HashSet<Integer> hs = new HashSet<>();
             HashSet<Integer> hs1 = new HashSet<>();
            for(int k=0;k<size;k++){
                if(!hs.contains(arr[j][k])){
                    hs.add(arr[j][k]);
                }
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                r=r+1;
            }
            flag=0;
            for(int k=0;k<size;k++){
                if(!hs1.contains(arr[k][j])){
                    hs1.add(arr[k][j]);
                }
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                c=c+1;
            }
        }
         System.out.printf("Case #%d: %d %d %d\n",i+1,trace,r,c);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(ip.readLine());
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(ip.readLine());
            int arr[][] = new int[n][n];
            for(int j=0;j<n;j++) {
                String input[] = ip.readLine().split(" ");
                for(int k=0;k<n;k++) {
                    arr[j][k] = Integer.parseInt(input[k]);
                }
            }
            solve(i,arr);
        }
    }
}

