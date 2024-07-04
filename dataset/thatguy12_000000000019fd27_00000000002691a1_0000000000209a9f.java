import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;


public class Solution{

	int caseNumber = 0;
	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args){

        Solution sol = new Solution();
        
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++){
        	sol.caseNumber = i;
            
        	
        	
            sol.solve(  sc.nextLine()  );
        }
        
        sc.close();
    }
    
    public Solution() {
    	
    }
    
    public void solve( String s   ){
    	String answer = "";
    	int prevd = 0;
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		int d = c - 48;
    		for (int j = prevd; j < d; j++) {
    			answer += '(';
    		}
    		for (int j = prevd; j > d; j--) {
    			answer += ')';
    		}
    		answer += d;
    		prevd = d;
    	}
		for (int j = prevd; j > 0; j--) {
			answer += ')';
		}
        System.out.println("Case #" + caseNumber + ": " +  answer );
    }
}