import java.util.*;

public class Solution{
    
	public static void main(String[] args) {
	    
    	Scanner s = new Scanner(System.in);
    	int tc = s.nextInt();
    	
    	for(int t = 1;t<=tc;++t){
    	    String str = s.next();
    	    int n = str.length();
    	    
    	    Stack<Character> temp = new Stack<>();
    	   // char ch = str.charAt(i);
    	   // int num1 = (int)(ch) - 48;
    	   // for(int i = 0;i<num;++i){
    	   //     s.push()
    	   // }
    	   int count = 0;
    	    for(int i = 0;i<n;++i){
    	        char ch = str.charAt(i);
    	        int num = (int)(ch) - 48;
    	        if(temp.isEmpty()){
    	            for(int j = 0;j<num;++j){
    	                temp.push('(');
    	                count++;
    	            }
    	        }
    	        else if(count>=num){
    	            int num2 = count - num;
    	            for(int j = 0;j<num2;++j){
    	                temp.push(')');
    	                count--;
    	            }
    	        }
    	        else if(count < num){
    	            int num2 = num - count;
    	            for(int j = 0;j<num2;++j){
    	                temp.push('(');
    	                count++;
    	            }
    	        }
    	        temp.push(ch);
    	    }
    	    for(int i = 0;i<count;++i){
    	        temp.push(')');
    	    }
    	    
    	    String output = "";
    	    while(!temp.isEmpty()){
    	        char ch = temp.pop();
    	        output = ch + output;
    	    }
    	    System.out.println("Case #"+t+": "+output);
    	}
    }
}