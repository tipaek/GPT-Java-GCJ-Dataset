import java.util.Set;
import java.util.Scanner;
import java.util.HashSet;

public class Solution
{
     private static Scanner sc;
     static int tn=1;
     
     public static void main(String args[])
     {
         sc=new Scanner(System.in);
         
         int t=sc.nextInt();
         sc.nextLine();
         
         while(t-- >0)
         {
             solve();
         }
     }
     private static void solve()
     {
         String s=sc.nextLine();
         StringBuilder sb=new StringBuilder();
         char[] chars=S.toCharArray();
        
         int pairs=0;
         
         for(int i=0;i<chars.length;i++)
         {
             int d = Character.getNumericValue(chars[i]);
             
             pairs=d;
             
             if(sb.length()==0)
             {
                 for(int j=0;j<d;j++)
                 {
                     sb.append('(');
                 }
             }
             sb.append(d);
             
             for(int j=0;j<d;j++)
             {
                 sb.append('(');
             }
         }
         System.out.println("Case #"+(tn++)+": "+sb.toString());
             
            
         }
     }
