import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
String[] ar=new String[t];
    for (int i = 1; i <= t; ++i) {
    //  int m = in.nextInt();
		String x=in.next();
		Stack<Integer> stack = new Stack<Integer>();
		String y="";
		for(int j=0; j<x.length(); j++) {
         String z="";
         z+=x.charAt(j);
	
         int w=Integer.parseInt(z);
			
			if(w>0) {
				if(stack.isEmpty()) {
				stack.push(w);
					for(int e=0 ; e<w; e++) {
					y+="(";
				}
					y+=w;
			}
				else {
				  int f=stack.peek();
				  if(f>w) {
					  stack.pop();
					  
					  stack.push((w));
						for(int e=0 ; e<f-w; e++) {
							y+=")";
						}  
				       
						y+=w;
				  }
				  else if (w>f) {
					  for(int e=0 ; e<w-f; e++) {
							y+="(";
						}
					   y+=w;
					  for(int e=0 ; e<w-f; e++) {
							y+=")";
						} 
				      
				  }
				  else {
					  y+=w;
				  }
				}
			
			
			}
			else {
				if(!stack.isEmpty()) {
				       while(!stack.isEmpty()) {
				    	   int p=stack.pop();
				    	   for(int r=0; r<p; r++) {
				    		   y+=")";
				    	   }
				       }
				}
				
				y+="0";}
			
		}
       while(!stack.isEmpty()) {
    	   int p=stack.pop();
    	   for(int j=0; j<p; j++) {
    		   y+=")";
    	   }
       }
     //  System.out.println("Case #" + i + ": " +y);
       //System.out.println(y.length());
     ar[i-1]="Case #" + i + ": " +y;
    }
   for(int i=0; i<ar.length; i++) {
	   System.out.println(ar[i]);
   }
  
}}