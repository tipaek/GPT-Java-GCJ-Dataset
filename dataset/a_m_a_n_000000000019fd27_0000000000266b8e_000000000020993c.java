import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
public class Solution {
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int k=1;
       int t= scn.nextInt();
       while(t-->0)
       {
         int n  =scn.nextInt();
         long trace=0;
         long r=0;
         long c=0;
         int [][]a = new int[n][n];
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<n;j++)
             {
                 a[i][j]=scn.nextInt(); 
                 if(i==j)
                 {
                     trace+=a[i][j];                
                 }
                 
             }
            
         }
         for(int i=0;i<n;i++)
         {
            HashSet<Integer>set = new HashSet<>();
             for(int j=0;j<n;j++)
             {
               if(!set.contains(a[i][j]))
               {
                   set.add(a[i][j]);
               }else{
                   r++;
                   break;
               }
                 
             }
             
            
         }
         for(int i=0;i<n;i++)
         {
            HashSet<Integer>set = new HashSet<>();
             for(int j=0;j<n;j++)
             {
                 if(!set.contains(a[j][i]))
               {
                   set.add(a[j][i]);
               }else{
                   c++;
                   break;
               }
             }
             
            
         }
         
         System.out.println("Case #"+(k++)+": "+trace+" "+r+" "+c);
         
          
       }
  }
}
