import java.util.Scanner;
import java.io.*;

public class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int t;
        t=in.nextInt();
        int i;
        
        for(i=0;i<t;i++)
        {
            
            int x=in.nextInt();
            int [][]arr=new int[x+1][x+1];
            for(int r=0;r<x;r++)
            {
                for(int c=0;c<x;c++)
                {
                    arr[r][c]=in.nextInt();
                }
                
            }
            int tr=0;
            
                for(int c=0;c<x;c++)
                {
                    
                    tr=tr+arr[c][c];
                }
                
            
            int row_count=0;
            for(int r=0;r<x;r++)
            {
                int k=0;
                for(int b=0;b<x;b++)
                {
                for(int c=b+1;c<x;c++)
                {
                  if(arr[r][b]==arr[r][c])
                  {
                    
                    k=1;
                    break;
                  }
                }
                if(k==1)
                {
                row_count++;
                break;
                }
                    
                }
            }
            int col_count=0;
            for(int r=0;r<x;r++)
            {
                outer:
                for(int b=0;b<x;b++)
                {
                for(int c=b+1;c<x;c++)
                {
                  if(arr[b][r]==arr[c][r])
                  {
                    col_count++;
                    break outer;
                  }
                }
                }
            }
            System.out.println("Case #"+(i+1)+": "+tr+" "+row_count+" "+col_count);
        }
        
    }
}
        

    
    
    