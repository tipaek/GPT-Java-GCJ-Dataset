import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args){
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<t;i++){
		    String s = scan.nextLine();
		    String ans = solve(s,s.length());
		    System.out.println("Case #",i+1,": "+ans);
		    }
		}

	
    private static String solve(String s,int n){
    
    	int max = 0;
    	String ans = "";
            for(int i=0;i<n;i++){
                int k = Integer.parseInt(String.valueOf(s.charAt(i)));
                
                if(k>max) {
                	String b = new String(new char[k-max]).replace('\u0000', '(');
                	ans = ans + b;
                	max = k;               	
                	
                }else if(k<max) {
                	String b = new String(new char[max-k]).replace('\u0000', ')');
                	ans = ans + b;
                	max = k;
                }
                ans = ans + s.charAt(i);
            }
            
            if(max>0) {
            	String b = new String(new char[max]).replace('\u0000', ')');
            	ans = ans + b;
            }
            return ans;
       	
	}
}