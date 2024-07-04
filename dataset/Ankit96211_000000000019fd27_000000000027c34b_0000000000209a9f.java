import java.util.*;
 class Solution {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int t;
	t=sc.nextInt();
	for(int p=0;p<t;p++)
	{
		String s=sc.next();

	    int dep=0;
	    String ans="";
	    for(int i=0;i<s.length();i++)
	    {String c=String.valueOf(s.charAt(i));
	 
	        int newdep=Integer.valueOf(c);
	        
	          while(newdep>dep)
	        {
	            ++dep;
	            ans+="(";

	        }
	        while(newdep<dep)
	        {
	            --dep;
	            ans+=")";

	        }
	        ans+=c;

	    }

	    while(dep>0)
	    {
	        --dep;
	        ans+=")";
	    }
	    System.out.println("Case #"+(p+1)+": "+ans);
		}
}
}

