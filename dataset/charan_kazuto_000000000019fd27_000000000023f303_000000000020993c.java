import java.io.*;
import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
 Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
 int t,n,b=0;
 t=s.nextInt();
 for(int i=0;i<t;i++)
 {
int k=0,r=0,c=0,q=0,w=0;
     n=s.nextInt();
     int[][] kr=new int[n][n];
     for(int j=0;j<n;j++)
     {
         for(int y=0;y<n;y++)
         {
            kr[j][y]=s.nextInt();
         }
     }
     for(int j=0;j<n;j++)
     {
         for(int y=0;y<n;y++)
         {
           if(j==y)
               k=k+kr[j][y];
         }
     }
     for(int j=0;j<n;j++)
     {
         for(int y=0;y<n;y++)
         {
             for(int u=y+1;u<n;u++)
             {
                 if(kr[j][y]==kr[j][u])
{
                     r=r+1;
                    
}  
           }
}
             if(r>1)
{
             q=q+1;
}
}
for(int j=0;j<n;j++)
     {
         for(int y=0;y<n;y++)
         {

             for(int g=j+1;g<n;g++)
             {
                 if(kr[j][y]==kr[g][y]) 
{
                  c=c+1;

  }    
      }
         }
if(c>1)
w=w+1;

     }
System.out.println("Case "+"#"+b+": "+k+" "+q+" "+w);
b=b+1;
}    
    } 
}