/* package codechef; // don't place package name! */

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*; 
import java.lang.*; 
import java.io.*;
import java.math.BigInteger; 
import java.math.*;

class Solution {
     
	static	class Pair{
		  int x,y;
		  String s;
		  Pair(int x,int y,String s){
		    this.x=x;this.y=y;this.s=s;
		  }
		}
	public static void main(String[] args) {
		
		InputStream inputStream = System.in;

		InputReader sc = new InputReader(inputStream);

				
		 int t=sc.nextInt();
		 long c=1000000007;
		 for(int j=1;j<=t;j++){
		   int a=sc.nextInt();
		   int b=sc.nextInt();
		   
		   int flag=0;
		   Queue<Pair> q= new LinkedList<>();
		   q.add(new Pair(0,0,""));
		   String res="";
		   for(int i=0;i<4;i++){
		     for(int k=0;k<Math.pow(10,i);k++){
		       Pair p1=q.peek();
		       if(p1.x==a && p1.y==b){
		         flag=1;
		         res=p1.s;
		         break;
		       }
		       else{
		         q.poll();
		         int f1=(int)Math.pow(2,i);
		          q.add(new Pair(p1.x+f1,p1.y,p1.s+"E"));
		           q.add(new Pair(p1.x,p1.y+f1,p1.s+"N"));
		            q.add(new Pair(p1.x-f1,p1.y,p1.s+"W"));
		             q.add(new Pair(p1.x,p1.y-f1,p1.s+"S"));
		       }
		     }
		     if(flag==1)break;
		   }
		     
		     if(flag!=1){
		       res="IMPOSSIBLE";
		     }
		     System.out.println("Case #"+j+": "+res);
		   
		  
		 }
	
	    
	}
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
				    tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
				    throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public float nextFloat() {
			return Float.parseFloat(next());
		}
		
		
	}
}