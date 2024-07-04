

import java.util.Arrays;
import java.util.Scanner;

public class vestigium{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        int p=1;
        while(t--!=0)
        {
            int n=in.nextInt();
            int trace=0,r=0,c=0;
            int a[][]= new int [n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    a[i][j]=in.nextInt();
            }
            for(int i=0;i<n;i++)
                trace+=a[i][i];
            //row testing
            for(int i=0;i<n;i++)
            {
                int sum[] = new int[n];
                Arrays.fill(sum,0);
                for(int j=0;j<n;j++)
                {
                    sum[a[i][j]-1]++;
                    if(sum[a[i][j]-1]>1)
                    {
                        r++;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                int sum[] = new int[n];
                Arrays.fill(sum,0);
                for(int j=0;j<n;j++)
                {
                    sum[a[j][i]-1]++;
                    if(sum[a[j][i]-1]>1)
                    {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+p+": "+trace+" "+r+" "+c);

            p++;
        }
    }
}
