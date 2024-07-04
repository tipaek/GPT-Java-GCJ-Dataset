/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    public static int posi = 0;
    public static long maxd = 1000000000;
    public static long mind = -1000000000;
    public static String oper = "";
    
    public static void recurse(long x, long y, long fx, long fy, int step, StringBuilder res){
        //System.out.println(x+" "+y);
        if(x==fx && y==fy){
            posi = 1;
            //System.out.println(x+" "+y+" "+res.toString().length());
            if(oper.equals("") || oper.length() > res.toString().length()){
                oper = res.toString();
            }
        }
        
        long dist = (long)Math.pow(2, step);
        //System.out.println(x+" "+y);
        if(step<5 && x+dist <= maxd){
            StringBuilder res1 = new StringBuilder(res);
            recurse(x+dist, y, fx,fy,step+1, res1.append("E"));
        }
        if(step<5 && x-dist >= mind){
            StringBuilder res1 = new StringBuilder(res);
            recurse(x-dist, y, fx, fy, step+1, res1.append("W"));
        }
        if(step<5 && y+dist <= maxd){
            StringBuilder res1 = new StringBuilder(res);
            recurse(x, y+dist, fx, fy,  step+1, res1.append("N"));
        }
        if(step<5 && y-dist >= mind){
            StringBuilder res1 = new StringBuilder(res);
            recurse(x, y-dist, fx, fy,  step+1, res1.append("S"));
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader sc1 = new FastReader();
		int tc = sc1.nextInt();
		int ch = 1;
		StringBuilder sb = new StringBuilder();
		
		while(ch<=tc){
		   long x = sc1.nextInt();
		   long y = sc1.nextInt();

		   int step = 0;
		   posi = 0;
		   oper = "";
		   
		   StringBuilder res = new StringBuilder();
		   
		   recurse(0,0,x,y,step,res);
		   
		   if(posi == 1){
		       sb.append("Case #"+ch+": "+oper+"\n");
		   }
		   else{
		       sb.append("Case #"+ch+": IMPOSSIBLE\n");
		   }
		   ch++;
		}
		
		System.out.print(sb.toString());
	}
	
	static class FastReader 
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
  
}
