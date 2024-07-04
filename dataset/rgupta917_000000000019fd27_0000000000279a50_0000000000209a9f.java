import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.Queue;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.stream.IntStream;
 
  public class Solution
 {static class FastReader 
       { 
           BufferedReader br; 
           StringTokenizer st; 
     
           public FastReader() 
           { 
               br = new BufferedReader(new
                        InputStreamReader(System.in)); 
           } 
     
           String next() 
           { 
               while (st == null || !st.hasMoreElements()) 
               { 
                   try
                   { 
                       st = new StringTokenizer(br.readLine()); 
                   } 
                   catch (IOException  e) 
                   { 
                       e.printStackTrace(); 
                   } 
               } 
               return st.nextToken(); 
           } 
     
           int nextInt() 
           { 
               return Integer.parseInt(next()); 
           } 
     
           long nextLong() 
           { 
               return Long.parseLong(next()); 
           } 
     
           double nextDouble() 
           { 
               return Double.parseDouble(next()); 
           } 
     
           String nextLine() 
           { 
               String str = ""; 
               try
               { 
                   str = br.readLine(); 
               } 
               catch (IOException e) 
               { 
                   e.printStackTrace(); 
               } 
               return str; 
           } 
         
       }
    
    static String sum (String s)
    {
        String s1 = ""; 
        
        if(s.contains("a"))
            s1+="a";
        if(s.contains("e"))
            s1+="e";
        if(s.contains("i"))
            s1+="i";
        if(s.contains("o"))
            s1+="o";
        if(s.contains("u"))
            s1+="u";
        
            return s1;
            
        
    }
    
      
    public static void main(String[] args) 
    { 
       FastReader sc =new FastReader();
      int t = sc.nextInt();
      int te=1;
      while(t-->0)
      {
      char[] s = sc.next().toCharArray();
	  int n=s.length;
	  int start=0,d=0;
	  String p="";
	  d=s[0]-'0';
      while(d-->0)
      p+="(";
        p=p+""+s[0];
	  for(int i=0; i<n-1;i++)
     {	  
            if((s[i+1]-s[i])>0)
            {
                d=s[i+1]-s[i];
                while(d-->0)
                p+="(";
                p+=""+s[i+1];
            }
            else if((s[i+1]-s[i])<0)
            {
                d=s[i]-s[i+1];
                while(d-->0)
                p+=")";
                p+=""+s[i+1];
            }
            else if((s[i+1]-s[i])==0)
            {
                p+=""+s[i+1];
            }
     }
     d=s[n-1]-'0';
      while(d-->0)
      p+=")";
      
   System.out.println("Case #"+te+": "+p);
	 te++;
	
      }
	
	}
 } 