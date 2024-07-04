import java.io.*;
import java.util.*;
 
 
public class CodeJam
{
   public static void main(String[] args) throws IOException 
   {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      // Start writing your solution here. -------------------------------------
   
      
      int T      = sc.nextInt();        // read input as integer
      /*
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();    // read input as double
      String str = sc.nextLine();           // read input as String
      */
      
      for(int i=0;i<T;i++)
      {
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        int r=0,c=0;
        HashMap<Integer,Integer> rmap=new HashMap<>(); 
        HashMap<Integer,Integer> cmap=new HashMap<>(); 
        for(int j=0;j<n;j++)
        {
            String lines   = sc.nextLine();       // read whole line as String
            String[] s = lines.trim().split("\\s+");
            for(int k=0;k<n;k++)
            {
                a[j][k]=Integer.parseInt(s[k]);
                if(rmap.containsKey(a[j][k]))
                {
                    int count=rmap.get(a[j][k]);
                    rmap.put(a[j][k],count++);
                }
                else
                {
                    rmap.put(a[j][k],1);
                }
            }
            if(rmap.size()!=n)
            {
                r++;
            }
            rmap.clear();
        }
        for(int j=0;j<n;j++)
        {
            for(int k=0;k<n;k++)
            {
                if(cmap.containsKey(a[k][j]))
                {
                    int count=cmap.get(a[k][j]);
                    cmap.put(a[k][j],count++);
                }
                else
                {
                    cmap.put(a[k][j],1);
                }
            }
            if(cmap.size()!=n)
            {
                c++;
            }
            cmap.clear();
        }
        
        int trace=0;
        for(int l=0;l<n;l++)
        {
           trace=trace+a[l][l];
        }
        out.println("Case #"+i+": "+trace+" "+r+" "+c);
        
    }
    
      

      /*StringBuilder sb =new StringBuilder();
      for(int k=0;k<n;k++)
      {
        sb.append(Integer.toString(a[k])).append(" ");

      }
      String res=sb.toString();
      out.println(res);*/

//javarevisited.blogspot.com/2016/03/how-to-convert-array-to-comma-separated-string-in-java.html#ixzz69QbaGYWr
      // Stop writing your solution here. -------------------------------------
      out.close();  
   
}
   
   
   public static PrintWriter out;
   public static class MyScanner 
   {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() 
      {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() 
      {
          while (st == null || !st.hasMoreElements()) 
          {
              try 
              {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) 
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
}