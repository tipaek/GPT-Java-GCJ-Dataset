import java.util.*;
import java.io.*;


    public class Solution {
		
	public static void solve(ArrayList<String> strarr,int n,int t){
	    String result = "";
	    String maxstr = strarr.get(0);
	    
	    for (int i=1;i<n;i++){
	        String str = strarr.get(i);
	        if (maxstr.length()<str.length()){
	            maxstr = str;
	        }
	    }
	    int condition  = 0;
	    for (int i=0;i<n;i++){
	        String s1 = strarr.get(i);
	        int m = s1.length();
	        String s = maxstr.substring(1,m-1);
	        
	        boolean isFound = maxstr.indexOf(s) !=-1? true: false;
	        
	        if (!isFound){
	            condition=1;
	            break;
	        }
	        
	    }
	    if (condition==0){
	        result = maxstr;
	    }
	    else{
	        result = "*";
	    }
	    
	     System.out.println("Case #" + t + ": " + result);
	}
		
		
    public static void main(String[] args) {
		  
		  
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int j = 1; j <= t; ++j) {
			
			
          int n = in.nextInt();
          ArrayList<String> strarr = new ArrayList<String>();
          
          for (int i = 0;i<n;i++){
              String s = in.next();
              strarr.add(s);
          }
          
          solve(strarr,n,j);
         
        }
      }
    }