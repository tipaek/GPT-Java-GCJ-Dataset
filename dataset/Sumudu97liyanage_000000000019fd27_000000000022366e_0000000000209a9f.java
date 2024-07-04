
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	 public static void solve(int t,String s) {
	     
	     int n = s.length();
	     
	     String op = "(";
	     String end = ")";
	     String result = "";
	     
	     for (int i=0;i<n;i++){
	         
	         //for the beginning
	         if (i==0){
	             int p = s.charAt(0)-48;
	             String s0 = new String(new char[p]).replace("\0", op);
	             result = s0+s.charAt(0);
	         }
	         else{
	            int nii = s.charAt(i)-48;
	            int ni = s.charAt(i-1)-48;
	            
	            if (ni>nii){
	                int p = ni-nii;
	                String s0 = new String(new char[p]).replace("\0", end);
	                result=result+s0+s.charAt(i);
	            }
	            
	            else if (ni<nii){
	                int p = nii-ni;
	                String s0 = new String(new char[p]).replace("\0", op);
	                result=result+s0+s.charAt(i);
	            }
	            
	            else{
	                result = result+s.charAt(i);
	            }
	         }
	         
	         //for the end
	         if (i==(n-1)){
	             int p = s.charAt(n-1)-48;
	             String s0 = new String(new char[p]).replace("\0", end);
	             result = result+s0;
	         }
	     }
	     
	     
	     
		
		 System.out.println("Case #" + t + ": " + result);
	 }
    
    
    
     public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 1; i <= t; ++i) {
            String str = in.next();
            	
            solve(i,str);
          
        }
      }
      
      
    }