

import java.util.*;
import java.lang.*;
import java.io.*;


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
		        else if(!set.contains(str.charAt(i)))
		        {
		            set.add(str.charAt(i));
		            stack.push(str.charAt(i));
		            for(int j=0;j<stack.size()-(str.charAt(i) - '0')+1;j++){
		                ans = ans+"(";
		            }
		            ans+=str.charAt(i);
		        }
		        else if(set.contains(str.charAt(i)) && str.charAt(i) == stack.peek()){
		            ans=ans+str.charAt(i);
		        }
		        else if(set.contains(str.charAt(i)) && str.charAt(i) !=stack.peek()){
		            stack.pop();
		            set.remove(str.charAt(i));
		            ans=ans+")";
		        }
		        
		    }
		    while(!stack.empty()){
		        ans=ans+")";
		        stack.pop();
		    }
		    
		
		    System.out.println("Case #"+start+": "+ans);
		}
	}
}
