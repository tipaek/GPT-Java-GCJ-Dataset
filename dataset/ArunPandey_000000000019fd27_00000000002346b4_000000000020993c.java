import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution 
{     
    public static void main(String[] args) 
    {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       for(int i=0;i<t;i++)
       {
           int n = sc.nextInt();
           int a[][] = new int[n][n];
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   a[j][k]=sc.nextInt();
               }
           }
           int k = 0,r = 0,c = 0;
           for(int j=0;j<n;j++)
           {
               k+=a[j][j];
           }
           for(int j=0;j<n;j++)
           {
               Set<Integer> Setty = new HashSet<Integer>();
               for(int k1=0;k1<n;k1++)
               {
                   Setty.add(a[j][k1]);
               }
               if(Setty.size()<n)
               {
                   r++;
               }
           }
           for(int j=0;j<n;j++)
           {
               Set<Integer> Setty = new HashSet<Integer>();
               for(int k1=0;k1<n;k1++)
               {
                   Setty.add(a[k1][j]);
               }
               if(Setty.size()<n)
               {
                   c++;
               }
           }
           System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
       }
    }
}