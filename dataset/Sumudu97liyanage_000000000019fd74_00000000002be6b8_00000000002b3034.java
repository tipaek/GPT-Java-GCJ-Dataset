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
	    
	    int condition  = 1;
	    for (int i=0;i<n;i++){
	        String s1 = strarr.get(i);
	        int n1 = s1.length();
	        int n2 = maxstr.length();
	        
	        for (int j=1;j<=n1;j++){
	            System.out.println(s1.charAt(n1-j));
	            System.out.println(maxstr.charAt(n2-j));
	            if (s1.charAt(n1-j)==maxstr.charAt(n2-j)){
	                condition = 0;
	            }
	            else{
	                condition = 1;
	                break;
	            }
	        }
	        
	        if (condition == 1){
				break;
			}
	        
	    }
	    
	    if (condition==0){
	        result = maxstr;
	    }
	    else{
	        result = "*";
	    }
	    //System.out.println(maxstr);
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
              int len = s.length();
              String s1 = s.substring(1,len);
              
              strarr.add(s1);
          }
          
          solve(strarr,n,j);
         
        }
      }
    }
