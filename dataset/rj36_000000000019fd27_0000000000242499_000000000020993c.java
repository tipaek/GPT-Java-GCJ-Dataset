import java.util.*;
import java.lang.*;
public class Solution
{
public static void main(String args[])
{
    Scanner scan = new Scanner(System.in);
    int t= scan.nextInt();
    for(int i=0;i<t;i++)
    {
        int size = scan.nextInt();
        int trace=0;
        int[][] mat=new int[size][size];
        //System.out.println("size "+size);
        for(int j=0;j<size;j++)
        {
            for(int k=0;k<size;k++)
            {  if(j<4 && k<4){
                mat[j][k]=scan.nextInt();
                if(j==k)
                {
                    trace=trace+mat[j][k];
                }
               // System.out.print(" "+mat[j][k]);}
            }
           // System.out.println();
            
        }}
        //System.out.println("trace "+trace);
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
                if(mat[k][j]==mat[k+1][j])
                {
                    colcount++;
                    break;
                }
            }
        }
     System.out.println("Case #"+i+1+":"+" "+trace+" "+rcount+" "+colcount);
        
    }
}
}
