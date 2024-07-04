import java.util.*;

class Solution
{
 public static void main(String args[])
 {
     Scanner scan = new Scanner(System.in);
     long n=0,t=0,i=0,j=0,k=0,l=0,m=0,curr=0,prev=0,c=0;
     int t = scan.nextInt();
     for(int i=0;i<t;i++)
     {
         String input= scan.next();
           c++;
	   ArrayList<String> ans = new ArrayList();
	    
	    prev=0;
	    for(i=0;i<input.length();i++)
	    {
	        curr=input.charAt(i)-'0';
	        if(curr>prev)
	        {
	            int diff=0;
	             diff=curr-prev;
	             while(diff--){
	                ans.push_back('(');
	            }
	            ans.add(input.charAt(i));
	        }
	        else if(curr==prev)
	        {
	           ans.add(input.charAt(i));
	        }
	        else if(curr<prev)
	        {
	            int diff=prev-curr;
	            while(diff--){
	                ans.add(')');
	            }
	            ans.add(input.charAt(i));
	        }
	        prev=curr;
	    }
	    while(prev--)
	    {
	        ans.add(')');
	    }
		//cout << "Case #" << c << ": " << ans << endl;
		System.out.println("Case #" +c+":"+ans.toString());
		//cout << ans << endl;
         
     }
 }
}