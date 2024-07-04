
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class Solution {
    static int d;
    static int n;
    static long cuts[],pc[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for (int tt = 1; tt <= t; tt++) {
            sb.append("Case #"+tt+": ");
            n=sc.nextInt();d=sc.nextInt();
            Long a[]=new Long[n];
            for (int i=0;i<n;i++){
                a[i]=sc.nextLong();
            }
            long ans=d-1;
            for (int i=0;i<n;i++){
                cuts=new long[n];
                pc=new long[n];
                for (int j=0;j<n;j++){
                    if (i==j){
                        pc[j]=1;
                        continue;
                    }
                    pc[j]=a[j]/a[i];
                    if (a[j]%a[i]==0){
                        cuts[j]=(a[j]/a[i])-1;
                    }else cuts[j]=a[j]/a[i];
                }
                dp=new long[n][d+1];
                for (long k[]:dp)Arrays.fill(k,-1);
                ans=Math.min(dp(0,0),ans);
            }
//            System.out.println(ans);
            sb.append(ans);
            if (tt!=t) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    static long dp[][];
    static long dp(int i,int cnt){
        if (i==n){
            if (cnt==d)return 0;
            else return (long) 1e9;
        }
        if (cnt==d)return 0;
        if (cnt>d)return (long) 1e9;
        if (dp[i][cnt]!=-1)return dp[i][cnt];
        dp[i][cnt]=(int) 1e9;
        for (int j=0;j<=d;j++){
            if (j<pc[i]){
                dp[i][cnt]=Math.min(dp(i+1,cnt+j)+j,dp[i][cnt]);
            }else if (j==pc[i]){
                dp[i][cnt]=Math.min(dp(i+1,cnt+j)+ cuts[i],dp[i][cnt]);
            }else break;
        }
        return dp[i][cnt];
    }
}