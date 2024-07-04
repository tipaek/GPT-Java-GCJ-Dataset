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
 static long comb(int N , int K)
	{
		if(K > N)
			return 0;
		long res = 1;
		for(int i = 1; i <= K; ++i)
			res = (N - K + i) * res / i;
		return res;
	}
      
    public static void main(String[] args) 
    { 
       FastReader sc =new FastReader();
      int t = sc.nextInt();
      int te=1;
      while(t-->0)
      {
      int n = sc.nextInt();
	  int[][] a = new int[n][n];
	  int k=0,r=0,c=0;
	  for(int i=0; i<n;i++)
     {	  
    for(int j=0; j<n;j++)
	{
	    a[i][j]=sc.nextInt();
	    if(i==j)
	    k+=a[i][j];
     }  	
   }
   HashSet<Integer> h=new HashSet<>();
   HashSet<Integer> h1=new HashSet<>();
   for(int i=0; i<n;i++)
     {	  
    for(int j=0; j<n;j++)
	{
	    h.add(a[i][j]);
	    h1.add(a[j][i]);
	 }
	 if(h.size()!=n)
	    r++;
	    if(h1.size()!=n)
	    c++;
	    h.clear();
	    h1.clear();
   }
   System.out.println("Case #"+te+": "+k+" "+r+" "+c);
	 te++;
	
      }
	
	}
 } 