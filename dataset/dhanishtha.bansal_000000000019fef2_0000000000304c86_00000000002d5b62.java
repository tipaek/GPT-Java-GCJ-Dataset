import java.util.*;
import java.lang.*;
import java.lang.Math.*;
import java.io.*;
public class Solution
 {
    static StringBuffer str = new StringBuffer("");
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine()); 
  
	    for(int idx = 1; idx <= test; idx++) {
	        String[] line = br.readLine().trim().split(" ");
	        long x = Long.parseLong(line[0]);
	        long y = Long.parseLong(line[1]);
	        
	        long units = Math.abs(x) + Math.abs(y);
	        long val = 1;
	        long i = 1;
	        while(units > val) {
	            val += (long) Math.pow(2, i);
	            i++;
	        }
	        if(getJumps(x, y, i, val)) {
	            System.out.println("Case #" + idx + ": " + str);
	             str = new StringBuffer("");
	        }
	        else {
	            System.out.println("Case #" + idx + ": IMPOSSIBLE");
	             str = new StringBuffer("");
	        }
	        
	    }
	}
	
	static boolean getJumps(long x, long y, long k, long val) {
	    
	    
	    if(val == 1) {
	        if((Math.abs(x) + Math.abs(y)) == val) {
	            if(x == 1 && y == 0) {
	                str.insert(0, 'E');
	            }
	            else if(x == -1 && y == 0) {
	                str.insert(0, 'W');
	            }
	            else if(x == 0 && y ==1) {
	                str.insert(0, 'N');
	            }
	            else if(x == 0 && y == -1) {
	                str.insert(0, 'S');
	            }
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	    long power = (long) Math.pow(2, k-1);
	    long x1 = x;
	    long y1 = y + power;
	    long x2 = x;
	    long y2 = y- power;
	    long x3 = x + power;
	    long y3 = y;
	    long x4 = x - power;
	    long y4 = y;
	   
	    
	    if((Math.abs(x1) + Math.abs(y1)) <= val) {
	      //  System.out.println("x1, y1 " + x1 + "," + y1);
	        
	        if(getJumps(x1, y1, k-1, val-power)) {
	            str.append("S");
	            //System.out.println(str);
	            //System.out.println(k);
	            return true;
	        }
	        /*else {
	            str = "";
	            return false;
	        }*/
	    }
	    if((Math.abs(x2) + Math.abs(y2)) <= val) {
	       // System.out.println("x2, y2 " + x2 + "," + y2);
	        if(getJumps(x2, y2, k-1, val-power)) {
	            str.append("N");
	            //System.out.println(str);
	            //System.out.println(k);
	            return true;
	        }
	        /*else {
	            str = "";
	            return false;
	        }*/
	    }
	    if((Math.abs(x3) + Math.abs(y3)) <= val) {
	     //  System.out.println("x3, y3 " + x3 + "," + y3);
	        if(getJumps(x3, y3, k-1, val-power)) {
	            str.append("W");
	       //     System.out.println(str);
	        //    System.out.println(k);
	            return true;
	        }
	        /*else {
	            str = "";
	            return false;
	        }*/
	    }
	    if((Math.abs(x4) + Math.abs(y4)) <= val) {
	     //  System.out.println("x4, y4 " + x4 + "," + y4);
	        if(getJumps(x4, y4, k-1, val-power)) {
	            str.append("E");
	       //     System.out.println(str);
	         //   System.out.println(k);
	            return true;
	        }
	        /*else {
	            str = "";
	            return false;
	        }*/
	    }
	    return false;
	}
 }