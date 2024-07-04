/*import java.util.*;
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
            {  
                mat[j][k]=scan.nextInt();
                if(j==k)
                {
                    trace=trace+mat[j][k];
                }
               // System.out.print(" "+mat[j][k]);}
            }
           // System.out.println();
            
        }
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
        if(rcount!=0){rcount++;}
     System.out.println("Case #"+(i+1)+":"+" "+trace+" "+rcount+" "+colcount);
        
    }
}
}
*/
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
        int rcount=0,colcount=0;
        int[][] mat=new int[size][size];
        int flag1=0;
        int flag2=0;
        int [] b= new int[100];
        for(int c=0;c<100;c++){
            b[c]=0;
        }
        //System.out.println("size "+size);
        for(int j=0;j<size;j++)
        {   flag1=0;
            for(int k=0;k<size;k++)
            {  
                mat[j][k]=scan.nextInt();
                if(j==k)
                {
                    trace=trace+mat[j][k];
                }
               // System.out.print(" "+mat[j][k]);}
           // System.out.println();
            
    
        //System.out.println("trace "+trace);
                if(flag1==0)
                 { for(int m=0;m<k;m++)
                  {
                    if(mat[j][k]==mat[j][m])
                    {
                    rcount++;
                    flag1=1;
                    //break;
                    }
                  }
                 }
               if (b[k]==0)
                 {  for(int n=0;n<j;n++)
                   {
                     if(mat[n][k]==mat[j][k])
                    {
                        b[k]=1;
                        colcount++;
                    }
                   }}
                
            }
            
        }
     System.out.println("Case #"+(i+1)+":"+" "+trace+" "+rcount+" "+colcount);
            
            
        
    }
}
}
