import java.util.*;
public class Solution {
    
    public static void getfun(int[][] arr, int n, int[] res) {
        int i,j,k=0, r=0, c=0;
        for(i=0;i<n;i++) {
            k += arr[i][i];
        }
        res[0]=k;
        int[] hash=new int[n+1];
        for(i=0;i<n;i++) {
            for(j=0;j<n;j++) 
                hash[j]=0;
            for(j=0;j<n;j++) {
                hash[arr[i][j]]++;
            }
            int mh=0;
            for(j=0;j<n;j++){
                if(mh<hash[j])
                    mh = hash[j];
            } 
                
            r = Math.max(r, mh);
        }
        res[1] = r==1?r-1:r;
        for(i=0;i<n;i++) {
            for(j=0;j<n;j++) 
                hash[j]=0;
            for(j=0;j<n;j++) {
                hash[arr[j][i]]++;
            }
            int mh=0;
            for(j=0;j<n;j++){
                if(mh<hash[j])
                    mh = hash[j];
            }
            c = Math.max(c, mh);
        }
        res[2] = c==1? c-1: c;
    }
    
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t, tc=0;
        t = sc.nextInt();
        while(t>0) {
            t=t-1;
            int n;
            n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int[] res = new int[3];
            getfun(arr, n, res);
            System.out.println("Case #" + (++tc) +": " +" "+res[0]+" "+ res[1] + " " + res[2]);
        }
    }
}