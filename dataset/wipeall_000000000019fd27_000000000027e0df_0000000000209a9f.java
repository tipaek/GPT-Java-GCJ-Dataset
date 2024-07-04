
import java.util.*;
    import java.io.*;
    public class Solution
    {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
          String n = in.nextLine();
           int a[]=new int[n.length()];
          for(int i=0;i<n.length();i++)
              
          {
            a[i]=Integer.parseInt(String.valueOf((n.charAt(i)))); 
          }
          System.out.print("Case #" + k + ": "+" ");
          int w=a[0];
          for(int i=0;i<w;i++)
                System.out.print("(");
                
                
           if(a.length==1)
                System.out.print(w);     
            else
          for(int i=0;i<a.length-1;i++)
          {
              int p=a[i];
              int q=a[i+1];
              if(i==0)
              System.out.print(p);
              
              if(q>=p)
              {
                  w=q-p;
                for(int j=0;j<w;j++)
                System.out.print("(");
                  System.out.print(q);
              }
              else
              {
                  w=p-q;
                for(int j=0;j<w;j++)
                System.out.print(")");
                  System.out.print(q);
              }
                  
          }
          int q=a[a.length-1];
           for(int j=0;j<q;j++)
                System.out.print(")");
          System.out.println("");
          
        
         
         // System.out.println("Case #" + k + ": "+trace+" "+(cr) + " " + (cc));
        }
      }
    }
