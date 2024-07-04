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
	//	x+="    ";
		String y="";
		int j=0;
		while(j<x.length()) {
         String z="";
         z+=x.charAt(j);
         int w=Integer.parseInt(z);

         int w2=-2;
         if(j<x.length()-1) {
         String z2="";
         z2+=x.charAt(j+1);
         
        
        	w2=	 Integer.parseInt(z2);	
         }
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
                     stack.pop();
					  
					  stack.push((w));
					  for(int e=0 ; e<w-f; e++) {
							y+="(";
						}
					   y+=w;
					   /*
					   for(int e=0 ; e<w-f; e++) {
							y+=")";
						}
					  /* else {
						   int w3=w;
						   while(w3==w) {
							   y+=w;
							   String z3="";
						         z3+=x.charAt(j+1);
						         
						   
						        	w3=	 Integer.parseInt(z3);	
							   j++;
						   }
						   j--;
					   }*/
				      
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
			
		
		j++;
		}
       while(!stack.isEmpty()) {
    	   int p=stack.pop();
    	   for(int l=0; l<p; l++) {
    		   y+=")";
    	   }
       }
       System.out.println("Case #" + i + ": " +y);
       //System.out.println(y.length());
     
       
      // String h="12356893837893829999999999999999999999999999999999999999999999999999999";
       //System.out.println(h.length());
       
       
    }

  
}}