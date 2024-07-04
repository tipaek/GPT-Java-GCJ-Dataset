import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String args[]){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	     int t = in.nextInt(); 
	     for (int i = 1; i <= t; ++i) {
	    	 int p = in.nextInt();
	    	 List<String> firstHalf = new ArrayList<>();
	    	 List<String> secondHalf = new ArrayList<>();
	    	 Set<String> stringSet = new HashSet<>();
	    	 String firstHi = "";
	    	 String secondHi = "";
	    	 for(int j = 0; j < p; j++){
	    		 String s = in.next();
	    		 String f = s.substring(0,s.indexOf("*"));
    			 String l = s.substring(s.lastIndexOf("*")+1,s.length());
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
	    		 stringSet.addAll(middleString(s));
	    	 }
	    	 System.out.println("Case #" + i + ": " + patternString(firstHi, secondHi, firstHalf, secondHalf,stringSet));
	    	 
	     }
	     in.close();
	}
	
	static String patternString(String firstHi, String secondHi, List<String> firstHalf,List<String> secondHalf,Set<String> stringSet){
		StringBuilder sb = new StringBuilder();
		 for(String s : firstHalf){
    		 if(!firstHi.startsWith(s))
    			 return "*";
    	 }
		 for(String s : secondHalf){
    		 if(!secondHi.endsWith(s))
    			 return "*";
    	 }
		 sb.append(firstHi);
		 for(String s :stringSet){
			 sb.append(s);
		 }
		 sb.append(secondHi);
		return sb.toString();
	}
	
	static Set<String> middleString(String s){
		Set<String> stringSet = new HashSet<>();  
		while(s.contains("*")){
			s = s.substring(s.indexOf("*")+1);
			if(s.contains("*")){
				String str = s.substring(0,s.indexOf("*"));
				if(str.length() > 0)
				stringSet.add(str);
			}
		}
		return stringSet;
	}
	
}