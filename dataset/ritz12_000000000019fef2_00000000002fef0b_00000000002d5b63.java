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

  
 class Ritz {
     
	public static void main(String[] args) {
		
		InputStream inputStream = System.in;

		InputReader sc = new InputReader(inputStream);

		int t=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		int f=1000000000-5;
		int g=1000000000-50;
		int h=1000000000;
	while(t-->0){
	  int flag=0;
		 if(a==f && b==f){
		   String s="";
		   int i1=0;
		   for(int i=0;i<=10;i++){
		     i1=i;
		      System.out.println(0+" "+(h-i));
		      System.out.flush();
		     s=sc.next();
		      if(s.equals("CENTER")){
		        flag=1;break;
		      }
		      if(s.equals("HIT") ){
		        break;
		      }
		      
		   }
		   if(flag==1){
		        break;
		      }
		      
		   int y=(h-i1)-f;
		   for(int i=0;i<=10;i++){
		     i1=i;
		      System.out.println((h-i)+" "+0);
		      System.out.flush();
		       s=sc.next();
		       if(s.equals("CENTER")){
		        flag=1;break;
		      }
		      if(s.equals("HIT") ){
		        break;
		      }
		      
		   }
		   if(flag==1){
		        break;
		      }
		  int x=(h-i1)-f;
		  System.out.println(x+" "+y);
		      System.out.flush();
		       s=sc.next();
		       if(s.equals("CENTER")){
		        flag=1;break;
		      }
		 }
		 else if(a==g && b==g){
		   String s="";
		   int i1=0;
		   for(int i=0;i<=50;i++){
		     i1=i;
		      System.out.println(0+" "+(h-i));
		      System.out.flush();
		     s=sc.next();
		      if(s.equals("CENTER")){
		        flag=1;break;
		      }
		      if(s.equals("HIT") ){
		        break;
		      }
		      
		   }
		   if(flag==1){
		        break;
		      }
		      
		   int y=(h-i1)-g;
		   
		   for(int i=0;i<=50;i++){
		     i1=i;
		      System.out.println((h-i)+" "+0);
		      System.out.flush();
		      s=sc.next();
		       if(s.equals("CENTER")){
		        flag=1;break;
		      }
		      if(s.equals("HIT") ){
		        break;
		      }
		      
		   }
		   if(flag==1){
		        break;
		      }
		  int x=(h-i1)-g;
		  System.out.println(x+" "+y);
		      System.out.flush();
		       s=sc.next();
		       if(s.equals("CENTER")){
		        flag=1;break;
		      }
		 }
		// long xl=0, xu=0, yl=0, yu=0;
		
		/*long f=1000000000;
		System.out.println("Q "+0+" "+f);
		System.out.flush(); 
		long w=sc.nextLong();
		
		
		
		System.out.println("Q "+f+" "+0);
		System.out.flush(); 
		long z=sc.nextLong();
		
		
		
		System.out.println("Q "+0+" "+0);
		System.out.flush(); 
		long x=sc.nextLong();
		
		
	
		
		
		long xd1=(f-z+x)/2;
		System.out.println("Q "+xd1+" "+0);
		System.out.flush(); 
		long  yl=sc.nextLong();
		
		
		long  xl=x-yl;
		long  yu=xl+f-w;
		long   xu=f+yl-z;
		System.out.println("A "+xl+" "+yl+" "+xu+" "+yu);
		System.out.flush(); 
		long last=sc.nextLong();
			if(last!=1) break;*/
	    
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