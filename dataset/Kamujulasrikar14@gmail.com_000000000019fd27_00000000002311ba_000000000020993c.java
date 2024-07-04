import java.io.*;
import java.util.*;
class Vesti {
    public static void main(String args[]) throws java.lang.Exception
    {
     int t=0;
     Scanner s=new Scanner(System.in);
     if(s.hasNext())
     t=s.nextInt();
     while(t>0 && t<=100)
     {
       int r=0;
       int rsum=0;
       int csum=0;
       int[][] arr;
       int trace=0;
       if(s.hasNext())
       r=s.nextInt();
       if(r>=2 && r<=100)
       {
         arr=new int[r][r];
         for(int i=0;i<r;i++)
         {
             for(int j=0;j<r;j++)
             {
                 arr[i][j]=s.nextInt();
             }
         }
         for(int k=0;k<r;k++)
         {
            for(int m=0;m<r;m++)
            {
                if(k==m)
                {
                    trace+=arr[k][m];
                }
            }
         }
         for(int row=0;row<r;row++)
         {
             outer:
             for(int col=0;col<r;col++)
             {
                 for(int cntr=col+1;cntr<r;cntr++)
                 {
                 if(arr[row][col]==arr[row][cntr])
                 {
                         rsum++;
                        break outer;
                 }
                 }
             }
         }
         for(int row1=0;row1<r;row1++)
         {
             inner:
             for(int col1=0;col1<r;col1++)
             {
                 for(int cntr1=col1+1;cntr1<r;cntr1++)
                 {
                     if(arr[col1][row1]==arr[cntr1][row1])
                     {
                            csum++;
                            break inner;
                     }
                 }
             }
         }
         System.out.println(trace + " " + rsum + " " +csum);
       }
       t--;
     }
    }
}