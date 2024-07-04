import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
      
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    for (int k = 1; k <= t; ++k) {
        
        String s = in.next();
        process(s, k);
      
    }
  }
  
  private static void process(String s, int k) {
	    
	    Deque<Character> stack = new ArrayDeque<>();
	    
	    int left = 0;
	    int right = 0;
	    
	    int n = s.length();
	    
	    for(int i=0; i<n; i++) {
	        int count = 0;
	        int d = s.charAt(i) - '0';
	        
	        if(stack.isEmpty()) {
	            
	            for(int j=1; j<=d; j++) {
	                
	                stack.push('(');
	                left++;
	            }
	            
	            stack.push(s.charAt(i));
	            
	            for(int j=1; j<=d; j++) {
	                
	                stack.push(')');
	                right++;
	            }
	        } else {
	            
	            while(stack.peek() == ')' && count<d) {
	                stack.pop();
	                right--;
	                count++;
	            }
	           
	            if(count == d) {
	                
	                while(left < d) {
	                    stack.push('(');
	                    left++;
	                }
	                
	            } else {
	                
	                while(count < d) {
	                    stack.push('(');
	                    left++;
	                    count++;
	                }
	                
	            }
	         
	            stack.push(s.charAt(i));
	                
                while(right < left) {
                    
                    stack.push(')');
                    right++;
                }
	            
	        }
	        
	    }
	    
	    System.out.print("Case #" + k + ": ");
	    
	    while(!stack.isEmpty()) {
	        System.out.print(stack.pollLast());
	    }
	    System.out.println();
	    
	}
} 