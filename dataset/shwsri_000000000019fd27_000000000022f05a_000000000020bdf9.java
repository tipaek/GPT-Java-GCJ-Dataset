import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
  
      int m = in.nextInt();
      int flag =0;
      int timex[] = new int[m];
      int timey[] = new int[m];
      int timexc[] = new int[m];
      int timeyc[] = new int[m];
      int timexj[] = new int[m];
      int timeyj[] = new int[m];
      String output ="";
      for (int j =0;j<m;j++) {
    	  timex[j]=in.nextInt();
    	  timey[j]=in.nextInt();
    	  if(j==0) {
    		  output = output + "C";
    		  timexc[j]=timex[j];
    		  timeyc[j]=timey[j];
    	  }
    	  else {
    		  flag =0;
    		  for(int k =0;k<j;k++) {
//    			  System.out.println("timexc="+timexc[k]);
//    			  System.out.println("timeyc="+timeyc[k]);
//    			  System.out.println("timex="+timex[j]);
    			  if(timexc[k]<=timex[j]&&timeyc[k]<=timex[j]) {
//    				  output = output + "C";
//    				  flag =0;
    				  continue;
    			  }
    			  else if(timexc[k]>=timex[j]&&timexc[k]>=timey[j]) {
//    				  output = output + "C";
//    				  flag =0;
    				  continue;
    			  }
    			  else {
    				  flag =1;
    				  break;
    			  }
    		  }
//    		  System.out.println("flag="+flag);
    		  if(flag==0) {
//    			  System.out.println("Entered");
    			  output = output + "C";
    			  timexc[j]=timex[j];
        		  timeyc[j]=timey[j];
    		  }
    		  else if(flag==1) {
//    			  System.out.println("Else if entered");
        		  for(int k =0;k<j;k++) {
        			
        			  if(timexj[k]<=timex[j]&&timeyj[k]<=timex[j]) {
//        				  output = output + "C";
        				  flag =2;
        			  }
        			  else if(timexj[k]>=timex[j]&&timexj[k]>=timey[j]) {
//        				  output = output + "C";
        				  flag =2;
        			  }
        			  else {
        				  flag =1;
        				  break;
        			  }
        		  }
    		  }
//    		  System.out.println(output);
    		  if(flag==2) {
//    			  System.out.println("Entered j");
    			  output = output + "J"; 
    			  timexj[j]=timex[j];
    			  timeyj[j]=timey[j];
    			 
    		  }
//    		  System.out.println("flag="+flag);
    		  else if(flag == 1) {
    			  output = "IMPOSSIBLE";
    		  }
    	  }
      }

    System.out.println("Case #" + i + ": " + output);
    }
  }
}