import java.util.*;

public class Solution
{
 public static void main(String args[])
 {
     Scanner scan = new Scanner(System.in);
     int n=0,t=0,i=0,j=0,k=0,l=0,m=0,curr=0,prev=0,c=0;
     t = scan.nextInt();
     for(m=0;m<t;m++)
     {
         String input= scan.next();
           c++;
	 // String ans ="";
	   Stack<String> ans 
            = new Stack<String>(); 
	    
	    prev=0;
	    for(i=0;i<input.length();i++)
	    {
	        curr=input.charAt(i)-'0';
	        if(curr>prev)
	        {
	            int diff=0;
	             diff=curr-prev;
	             for(j=0;j<diff;j++){
	                //ans=ans+Character.toString(input.charAt('('));
	                  ans.push(Character.toString('('));
	            }
	             ans.push(Character.toString(input.charAt(i)));
	        }
	        else if(curr==prev)
	        {
	            ans.push(Character.toString(input.charAt(i)));
	        }
	        else if(curr<prev)
	        {
	            int diff=prev-curr;
	            for(j=0;j<diff;j++){
	                  ans.push(Character.toString(')'));
	            }
	            ans.push(Character.toString(input.charAt(i)));
	        }
	        prev=curr;
	    }
	   for(j=0;j<prev;j++)
	    {
	         ans.push(Character.toString(')'));
	    }
        String ans2=String.join("", ans);
		System.out.println("Case #" +c+": "+ans2);
		ans.clear();
		//cout << ans << endl;
         
     }
 }
}