import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner y = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int k,suml,t,r,e,c,temp=0;
        t=y.nextInt();
        
        for(int w=0;w<t;w++)
        {
            int n=y.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=y.nextInt();
                }
            }
            
              suml=0;
              k=0;
            for(int i=0;i<n;i++)
            {
                suml=suml+a[k][k];
                k++;
            }
            r=e=0;
            for(int i=0;i<n;i++)
            {
                e=0;
                for(int l=0;l<n;l++)
                {
                    temp=a[i][l];
                    for(int m=l+1;m<n;m++)
                    {
                        if(temp==a[i][m] && e<1)
                        {
                            r++;
                            e++;
                        }
                    }
                }
            }
            c=e=0;
            for(int i=0;i<n;i++)
            {
                e=0;
                for(int l=0;l<n;l++)
                {
                    temp=a[l][i];
                    for(int m=l+1;m<n;m++)
                    {
                        if(temp==a[m][i] && e<1)
                        {
                            c++;
                            e++;
                        }
                    }
                }
            }
            System.out.println("Case #"+(w+1)+": "+suml+" "+r+" "+c);
        }
    }
}
