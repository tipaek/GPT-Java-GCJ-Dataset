import java.util.*;
class Solution{


public static void main(String args[])
{
    Scanner scan = new Scanner(System.in);
    int t= scan.nextInt();
    for(int i=0;i<t;i++)
    {
        int size = scan.nextInt();
        int trace=0;
        int[][] mat=new int[size][size];
        for(int j=0;i<size;i++)
        {
            for(int k=0;k<size;k++)
            {
                mat[j][k]=scan.nextInt();
                if(j==k)
                {
                    trace=trace+mat[j][k];
                }
            }
            
        }
        int rcount=0,colcount=0;
        for(int j=0;j<size;j++)
        {
            for(int k=0;k<size-1;k++)
            {
                if(mat[j][k]==mat[j][k+1])
                {
                    rcount++;
                    break;
                }
            }
        }
         for(int j=0;j<size;j++)
        {
            for(int k=0;k<size-1;k++)
            {
                if(mat[k][j]==mat[j][k+1])
                {
                    colcount++;
                    break;
                }
            }
        }
        
        System.out.println("Case #"+i+":"+" "+trace+" "+rcount+" "+colcount);
        
    }
}}