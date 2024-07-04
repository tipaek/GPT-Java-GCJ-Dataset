
import java.util.*;
public class Trace
{
    public static void main(String args[])
    {
        int ar[][]=new int[100][100];
        int i, j;
        int sum = 0;
        int r = 0, c = 0;
Scanner s = new Scanner(System.in);
int t= s.nextInt();
int n= s.nextInt();
for(i = 0; i < n; i++)
  {
    for(j = 0; j < n; j++) 
     {
        ar[i][j] = s.nextInt();
                
      }
  }
for(i = 0; i < n; i++)
  {  
     for(j = 0; j < n; j++)
         {
              if(i == j)
               {
                   sum = sum + (ar[i][j]);
                }
           }
  }
        
for(i = 0 ; i < n ; i++)
{
  for(j = 0 ; j < n ; j++)
  {
    if(ar[i][j]==ar[i][j+1])
    {
      c++;
    }
    if(ar[i][j]==ar[i+1][j])
    {
      r++;
    }
  }
  
}
    for(i=0;i<t;i++)
    {
       System.out.print("Case #" + t + ":");
       System.out.print(sum + " ");
       System.out.print(r + " ");
       System.out.print(c);
       System.out.println();
       }
    }
 }