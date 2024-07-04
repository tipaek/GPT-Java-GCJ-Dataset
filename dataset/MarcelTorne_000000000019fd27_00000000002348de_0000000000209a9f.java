

	import java.util.*;
	import java.io.*;
	public class Solution {
	  public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    in.nextLine();
	    for (int i = 1; i <= t; ++i) {
	    	if(in.hasNext()) {
	        String s = in.nextLine();

	        String sprime = "";
	        int previousPar = 0;
	        for(int j = 0; j<s.length();++j) {
	        	int v = (int)s.charAt(j)-48;

	        	if(v>previousPar) {
	        		for(int k = previousPar;k<v;++k) {
	        			sprime = sprime +"(";
	        		}
	        	}else {
	        		for(int k=v;k<previousPar;++k) {
	        			sprime = sprime +")";
	        		}
	        		
	        	}
	        	previousPar = v;
	        	sprime = sprime + (char) (v+48);  	
	        	
	        }
	        for(int k=0; k<previousPar;++k) {
	        	sprime = sprime + ")";
	        }
	      System.out.println("Case #" + i + ": " + sprime);
	    	}
	    }
	  }
	}
