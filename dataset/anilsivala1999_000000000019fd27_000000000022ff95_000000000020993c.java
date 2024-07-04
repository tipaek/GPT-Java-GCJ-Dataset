import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            int sum=(n*(n+1))/2;
            int trace=0,rsum=0,csum=0;
            int rc=0,cc=0;
            for(int j=0;j<n;j++){
                rsum=0;
                for(int k=0;k<n;k++){
                    arr[j][k]=sc.nextInt();
                    rsum+=arr[j][k];
                    if(j==k)
                        trace+=arr[j][k];
                }
                if(rsum!=sum)
                    rc++;
            }
            for(int j=0;j<n;j++){
                csum=0;
                for(int k=0;k<n;k++)
                    csum+=arr[k][j];
                if(csum!=sum)
                    cc++;
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+rc+" "+cc);
        }
    }
}