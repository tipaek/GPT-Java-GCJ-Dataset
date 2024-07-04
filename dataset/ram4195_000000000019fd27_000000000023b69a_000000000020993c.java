import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();
        int km=0;
        for(km=1;km<=testcases;km++)
        {
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int i=0;i<n;i++)
                {
                    arr[j][i] = sc.nextInt();
                }
            }
            int trace=0;
            for(int j=0;j<n;j++)
            {
                for(int i=0;i<n;i++)
                {
                    if(j==i)
                    {
                        trace=trace+arr[j][i];
                    }
                }
            }
            int rows=0;
            int columns=0;
            int check;
            int dup=0;
            for(int j=0;j<n;j++)
            {
                dup=0;
                int j1;
                for(j1=0;j1<n;j1++)
                {
                    check=arr[j][j1];
                    for(int j2=0;j2<n;j2++)
                    {
                        if(check==arr[j][j2]&&j1!=j2)
                        {
                            dup=1;
                        }
                    } 
                }
                if(dup==1)
                {
                    rows++;
                }

            }





            for(int j=0;j<n;j++)
            {
                int j1;
                dup=0;
                for(j1=0;j1<n;j1++)
                {
                    check=arr[j1][j];
                    for(int j2=0;j2<n;j2++)
                    {
                        if(check==arr[j2][j]&&j1!=j2)
                        {
                           dup=1;   
                        }
                    }
                   
                }
                if(dup==1)
                {
                columns++;
                }

            }
            System.out.println("Case #"+km+": "+trace+" "+rows+" "+columns);    
        }

    }
    

}