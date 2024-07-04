import java.util.Scanner;
import java.io.*;

public class Vestigium{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n;
        n=in.nextInt();
        int i;
        
        for(i=0;i<n;i++)
        {
            
            int x=in.nextInt();
            int [][]arr=new int[x+1][x+1];
            for(int r=0;r<x;r++)
            {
                for(int c=0;c<x;c++)
                {
                    arr[r][c]=in.nextInt();
                }
                //System.out.println();
            }//trace of matrix
            int trace=0;
            
                for(int c=0;c<x;c++)
                {
                    
                    trace=trace+arr[c][c];
                }
                
            //unique elements of row
            int row=0;
            for(int r=0;r<x;r++)
            {
                outerloop:
                for(int b=0;b<x;b++)
                {
                for(int c=b;c<x;c++)
                {
                  if(arr[r][b]==arr[r][c])
                  {
                    row++;
                    break outerloop;
                  }
                }
                }
            }
            int col=0;
            for(int r=0;r<x;r++)
            {
                outerloop:
                for(int b=0;b<x;b++)
                {
                for(int c=b;c<x;c++)
                {
                  if(arr[b][r]==arr[c][r])
                  {
                    col++;
                    break outerloop;
                  }
                }
                }
            }
            System.out.println("Case #"+(i+1)+" :"+trace+" "+row+" "+col);
        }
        
    }
}
