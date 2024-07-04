import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    sc.nextLine();
    for(int h=1;h<=t;h++){
    	String  str = sc.next();
    	StringBuilder result = new StringBuilder("Case #"+h+": ");
    	Stack<Character> stack1 = new Stack<>();
    	Stack<Character> stack2 = new Stack<>();
    	for(int i=str.length()-1;i>=0;i--){
    			stack1.push(str.charAt(i));
    	}
    	Character temp ='*';
    	while(!stack1.isEmpty()){
    		Character chr = stack1.peek();
    		if(chr.equals(temp)) result.append(chr);
    		else{
    			if(chr == '1'){
    				result.append("(1");
    				stack2.push(')');	
    			} 
    			else{
    				if(stack2.isEmpty()) result.append("0");
    				else{
						result.append(")0");
						stack2.pop();
						}
    			} 
    			temp = chr;
    		}
    		stack1.pop();
    	}
    	if(!stack2.isEmpty()) result.append(")");
    	System.out.println(result);
    }
  }
}