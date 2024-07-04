
 

 
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
     int t=sc.nextInt();
       
       int m=t;
       while(t--!=0)
       {
          StringBuilder h=new StringBuilder();
           String s1=sc.next();
           String []s = s1.split("");
           //System.out.println(s1);
           int n=s1.length();
           int a[]=new int[n];
           int sum=0;
           for(int i=0;i<n;i++)
           {
               a[i]=Integer.parseInt(s[i]);
              // System.out.println(a[i]);
           }
           for(int i=0;i<a[0];i++)
           {
               h.append("(");
             //  System.out.println(h+"KKKKKK");
           }
           h.append(a[0]);
          // System.out.println(h);
           for(int i=1;i<n;i++)
           {
           
               int mod=(a[i]-a[i-1]);
               //System.out.println(mod);
               if(mod>=0)
               {
                   for(int j=0;j<mod;j++)
                   {
                       h.append("(");
                      // System.out.println(h);
                   }
                       h.append(a[i]);
                      // System.out.println(h);
               }
               else
               {
                   mod=Math.abs(mod);
                   //System.out.println(mod+"mod");
                   for(int j=0;j<mod;j++)
                   {
                     h.append(")"); 
                     //System.out.println(h);
                   }
                   
                   h.append(a[i]);
               }
               
           }
           for(int i=0;i<a[n-1];i++)
           {
               h.append(")");
           }
          System.out.println("Case #"+(m-t)+": "+h);
           
       }

    }
 
}
    

