
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        int tt=1;
        while(tt<=t)
        {int n=sc.nextInt();
            int a[][]=new int[n][n];
            int row_count=0;
            int col_count=0;
           int rev=0;
            for(int i=0;i<n;i++)
            {HashSet <Integer>hm=new HashSet<Integer>();
                int flag=0;
                for(int j=0;j<n;j++)
                { a[i][j]=sc.nextInt();
                 if(hm.contains(a[i][j]))
                 {
                     flag=1;
                 }
                 else{
                     hm.add(a[i][j]);
                 }
                 if(i==j){
                     rev+=a[i][j];
                 }
                }
                if(flag==1){
                    row_count++;
                }
            }
            for(int i=0;i<n;i++)
            {HashSet <Integer>hm=new HashSet<Integer>();
                int flag=0;
                for(int j=0;j<n;j++)
                    {
                        if(hm.contains(a[j][i]))
                        {
                            flag=1;
                        }
                        else{hm.add(a[j][i]);}
                      
                       }
                       if(flag==1){
                           col_count++;
                       }
                    }
            System.out.println("Case #"+tt+": "+rev+" "+row_count+" "+col_count);
            tt++;
        }
        sc.close();
    }
}