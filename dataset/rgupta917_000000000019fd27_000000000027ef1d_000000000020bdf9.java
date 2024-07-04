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
 
 class Triplet { 
    int x; 
    int y; 
    int z;
  
public Triplet(int x, int y,int z) 
    { 
        this.x = x; 
        this.y = y; 
        this.z = z; 
    } 
} 
class Compare { 
  
    static void compare(Triplet a[], int n) 
    { 
        Arrays.sort(a, new Comparator<Triplet>() { 
            @Override public int compare(Triplet p1, Triplet p2) 
            { 
                return p1.y - p2.y; 
            } 
        }); 
  
        
    } 
} 
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
      int n=sc.nextInt();
      Triplet a[] = new Triplet[n]; 
  
	  for(int i=0; i<n;i++)
     {	  
         int a1=sc.nextInt();
         int b=sc.nextInt();
         a[i] = new Triplet(a1, b,i);
     }
     Compare obj = new Compare(); 
  
        obj.compare(a, n); 
        char arr[]=new char[n];
        int ce=0,je=0,f=0;
        for (int i = 0; i < n; i++) { 
            if(ce<=a[i].x)
            {
                ce=a[i].y;
             arr[a[i].z]='C';
            }
            else if(je<=a[i].x)
            {
                je=a[i].y;
             arr[a[i].z]='J';
            }
            else
            {
                f=1;
                break;
            }
        } 
        //System.out.println(); 
        if(f==1)
   System.out.println("Case #"+te+": IMPOSSIBLE");
   else
   System.out.println("Case #"+te+": "+String.valueOf(arr));
	 te++;
	
      }
	
	}
 } 