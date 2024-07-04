/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int start = 1; start<=t;start++){
		    String str = s.next();
		    Stack<Character> stack = new Stack<>();
		    HashSet<Character> set = new HashSet<>();
		    String ans = "";
		    for(int i=0;i<str.length();i++){
		        if(str.charAt(i) == '0'){
		            while(!stack.empty()){
		                ans=ans+")";
		                stack.pop();
		         }
		         set.clear();
		         ans+=str.charAt(i);
		        }
		        else if(!set.contains(str.charAt(i)) || str.charAt(i)-'0'>stack.peek())
		        {
		            set.add(str.charAt(i));
		            stack.push(str.charAt(i));
		            for(int j=0;j<Math.abs(stack.size()-(str.charAt(i) - '0'))+1;j++){
		                ans = ans+"(";
		            }
		            ans+=str.charAt(i);
		        }
		        else if(set.contains(str.charAt(i)) && str.charAt(i) == stack.peek()){
		            ans=ans+str.charAt(i);
		        }
		        else if(set.contains(str.charAt(i)) && str.charAt(i) <stack.peek()){
		            int top = stack.peek();
		            stack.pop();
		            set.remove(top);
		            ans=ans+")"+str.charAt(i);
		        }
		        
		    }
		    if(stack.size() == (stack.peek()-'0')){
		        while(!stack.empty()){
		            ans+=")";
		            stack.pop();
		        }
		    }
		    else{
		    int close = Math.abs(stack.size()-(stack.peek()-'0'))+1;
		    System.out.println(close);
		    while(close>=0){
		        ans=ans+")";
		        close--;
		    }
		    }
		
		    System.out.println("Case #"+start+": "+ans);
		}
	}
}
