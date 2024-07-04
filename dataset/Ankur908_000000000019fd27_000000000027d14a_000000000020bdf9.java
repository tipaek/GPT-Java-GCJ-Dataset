import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
      int test=scan.nextInt();
      int i=0,k=0,a=0,b=0,d=0,e=0,f=0,g=0,c=0;
      for(k=0;k<test;k++) {
    	  StringBuffer s=new StringBuffer();
    	 int n=scan.nextInt();
    	// System.out.println(l);
    	  int[] integers = new int[2*n];
    	  for(i = 0; i < 2*n; i++)
    	  {
    	      integers[i] = scan.nextInt();
    	      c+=1;
    	      if(c==2) {
    	    	  scan.nextLine();
    	    	  c=0;
    	      }
    	      
    	  }
    	  s.append('C');
    	  d=integers[1];
		  g=integers[0];
    	  
    	  for(i=2;i<2*n;i+=2) {
    		  
    		  a=integers[i];
    		  b=integers[i+1];
    		  
    		  if(a<d && a<e)
    		  {		
    			  if(b<g && a>0) {
    				  s.append('C');
    				 g=a;
    			  }
    			  s.setLength(0);
    			  s.append("IMPOSSIBLE");
    			  break;
    		  }
    		  else if(a<d && a>=e)
    		  {
    			  s.append("J");
    			  e=b;
    			  f=a;
    		  }
    		  else if(a>=d){
    			  s.append('C');
    			  d=b;
    		  }
    		  
    	  }
    	  System.out.println("Case #"+(k+1)+": "+s);
      }	
		scan.close();
  }
  }
