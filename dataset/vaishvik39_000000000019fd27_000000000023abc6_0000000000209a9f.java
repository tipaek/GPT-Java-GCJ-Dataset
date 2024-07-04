import java.util.Scanner;
import java.lang.*; 
public class Solution {
    public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     int i,j,k=0,l,m,n=0,p=0;
     int t = sc.nextInt();
     for(i=0;i<t;i++)
     {
         k=0;
         
         String s = sc.next();
         n=s.length();
         char c[] = new char[n];
         for(j=0;j<n;j++)
         {
             c[j] = s.charAt(j);
         }
         
         System.out.print("Case"+" "+"#"+(i+1)+":"+" ");
         for(j=0;j<n;j++)
         {
             p=c[j] - '0';
             if(p>k)
             {
                 for(l=0;l<(p-k);l++)
                 {
                     System.out.print("(");
                     
                 }
                 k=k+l;
                 System.out.print(p);
             }
             else if(p<k)
             {
                 for(l=0;l<(k-p);l++)
                 {
                     System.out.print(")");
                     
                 }
                 k=k-l;
                 System.out.print(p);
             }
             else
             {
                 System.out.print(p);
             }
         }
         for(j=0;j<k;j++)
         {
             System.out.print(")");
         }
         System.out.println(" ");
     }
    }
}