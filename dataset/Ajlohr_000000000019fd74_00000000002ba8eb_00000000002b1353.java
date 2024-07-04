import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      long n = in.nextLong();
      System.out.println("Case #" + i + ": ");
      //down left while large, then switch for tail
      long row = 0;
      int count =0;
      int lastk =1;
      while(n>0)
      {
    	  row++;
          System.out.println(row+" 1");
          if (lastk>1)
          {

    		  System.out.println("FAIL");
    		  return;
          }
          lastk=1;
          n--;
          count ++;
    	  while(n>(row+1))
    	  {
    		  row++;
    		  System.out.println(row+" 2");
              if (lastk>2)
              {

        		  System.out.println("FAIL");
        		  return;
              }
              lastk=2;
    		  count++;
    		  n-=row-1;
    		  while(n>row*(row+1)/2+row+1)
    		  {
    			  row++;
    			  System.out.println(row+" 3");
    	          if (lastk>3)
    	          {

    	    		  System.out.println("FAIL");
    	    		  return;
    	          }
    	          lastk=3;
    			  count++;
    			  n-=(row-2)*(row-1)/2;    		  
        		  while(n>row*(row+1)*(row+2)/6+row*(row+1)/2+row+1)
        		  {
        			  row++;
        			  System.out.println(row+" 4");
        	          if (lastk>4)
        	          {

        	    		  System.out.println("FAIL");
        	    		  return;
        	          }
        	          lastk=4;
        			  count++;
        			  n-=(row-2)*(row-1)*(row-3)/6;    		  
            		  while(n>row*(row+1)*(row+2)*(row+3)/24 + row*(row+1)*(row+2)/6+row*(row+1)/2+row+1)
            		  {
            			  row++;
            			  System.out.println(row+" 5");
            	          lastk=5;
            			  count++;
            			  n-=(row-2)*(row-1)*(row-3)*(row-4)/24;    		  
            		  }
            		  if (lastk==5)
            		  {
            			  System.out.println(row+" 4");
            	          lastk=4;
            			  n-=(row-2)*(row-1)*(row-3)/6;   
            		  }
        		  }
        		  if (lastk==4)
        		  {
        			  System.out.println(row+" 3");
        	          lastk=3;
        			  n-=(row-2)*(row-1)/2;    
        		  }
    		  }
    		  if (lastk==3)
    		  {
    			  System.out.println(row+" 2");
    	          lastk=2;

        		  n-=row-1;   
    		  }
    	  }
		  if (lastk==2)
		  {
			  System.out.println(row+" 1");
	          lastk=1;

    		  n-=1;   
		  }
      }
      //System.out.println(n);

      //System.out.println(count);
      }
  }
}