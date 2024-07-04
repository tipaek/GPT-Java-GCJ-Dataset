import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k = 0; k<t; k++){
            int n=sc.nextInt();
            int[][] arr = new int[n][n];
            int sum=0, r=0,c=0;
            for(int i=0;i<n;i++){
                int[] countr =new int[256];
                for(int e=0;e<256;e++){
                    countr[e]=0;
                }
                for(int j = 0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j){
                        sum+=arr[i][j];
                    }
                    countr[arr[i][j]]++;
                    if(countr[arr[i][j]]>1)
                    {
                        if(r<=i)
                            r++;
                    }
                }
            }
            for (int i = 0; i < n; ++i)
            {
                int[] countc = new int[256];
                for(int e=0;e<256;e++){
                    countc[e]=0;
                }

                for (int j = 0;j < n; ++j)
                {
                    countc[arr[j][i]]++;
                    if(countc[arr[j][i]] >1)
                    {
                        if(c<=j)
                            c++;
                    }
                }
            }

            System.out.println("Case #"+(k+1) +": " + (sum)+ " " + (r) + " "+ (c));
        }
    }
}