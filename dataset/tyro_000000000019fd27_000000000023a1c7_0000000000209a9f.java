import java.util.*;
import java.lang.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		 int t,l,i,j,len,current,rem=0;
		 String s,s1;
		 char ch;
		 t=in.nextInt();
		 for(l=1;l<=t;l++)
		 {s1="";rem=0;
		 	Stack<Integer> stack=new Stack<>();
		 	s=in.next();
		 	len=s.length();
		 	for(i=0;i<len;i++)
		 	{
		 		ch=s.charAt(i);
		 		current=Character.getNumericValue(ch);
		 		if(!stack.empty())
		 		{
		 			if(current<stack.peek())
		 			{
		 				for(j=current+1;j<=stack.peek();j++)
		 					{
		 						s1+=")";rem--;
		 			}
		 		}
		 		else if(current>stack.peek())
		 		{

		 				for(j=stack.peek()+1;j<=current;j++)
		 					{
		 						s1+="(";rem++;
		 			}
		 		}
		 	}
		 	else{
		 		for(j=0;j<current;j++)
		 			{s1+="(";rem++;}
		 	}
		 			s1+=""+current;	stack.push(current);
		 }
		 for(j=0;j<rem;j++)
		 	s1+=")";
		 	System.out.println("Case #"+l+": "+s1);
	}
}
}