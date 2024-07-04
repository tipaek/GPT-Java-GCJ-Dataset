
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	     int t = in.nextInt(); 
	     for (int i = 1; i <= t; ++i) {
	    	 int p = in.nextInt();
	    	 List<String> firstHalf = new ArrayList<>();
	    	 List<String> secondHalf = new ArrayList<>();
	    	 String firstHi = "";
	    	 String secondHi = "";
	    	 for(int j = 0; j < p; j++){
	    		 String s = in.next();
	    		 String f = s.substring(0,s.indexOf("*"));
    			 String l = s.substring(s.indexOf("*")+1,s.length());
	    		 if(f.length() > 0){
	    			 firstHalf.add(f);
	    			 if(f.length() > firstHi.length()){
	    				 firstHi = f;
	    			 }
	    		 }
	    		 if(l.length() > 0){
	    			 secondHalf.add(l);
	    			 if(l.length() > secondHi.length()){
	    				 secondHi = l;
	    			 }
	    		 }
	    	 }
	    	 System.out.println("Case #" + i + ": " + patternString(firstHi, secondHi, firstHalf, secondHalf));
	    	 
	     }
	     in.close();
	}
	
	static String patternString(String firstHi, String secondHi, List<String> firstHalf,List<String> secondHalf ){
		StringBuilder sb = new StringBuilder();
		 for(String s : firstHalf){
    		 if(!firstHi.startsWith(s))
    			 return "*";
    	 }
		 for(String s : secondHalf){
    		 if(!secondHi.endsWith(s))
    			 return "*";
    	 }
		 sb.append(firstHi).append(secondHi);
		return sb.toString();
	}
	
}
