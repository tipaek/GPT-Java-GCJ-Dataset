import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=Integer.parseInt(sc.nextLine());
		for(int test=1;test<=testcase;test++)
		{
			System.out.println("Case #"+test+": "+solve());
			
		}
		
	}

	private static String solve() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine());
		String s[]=new String[N];
		for(int i=0;i<N;i++)
		{
			s[i]=sc.nextLine();
		}
		
		
		
		
		
		
		
		String revString[]=new String[N];
		for(int i=0;i<N;i++)
		{
			 StringBuilder input1 = new StringBuilder(); 
			 input1.append(s[i]);
			 input1=input1.reverse();
			revString[i]=input1.toString();
			
		}
		
		
		
		for(int i=0;i<N;i++)
		{
			String temp="";
			String rev=revString[i];
			for(int j=0;j<revString[i].length();j++)
			{
				char m=rev.charAt(j);
				
				if(m=='*')
				{
					revString[i]=temp;
					break;
				}
				else
				{
					temp=temp+m;
				}
			}
			System.out.println(revString[i]);
			
		}
		String ja="";
		
		int largestIndex=0;
		int large=-1;
		for(int i=0;i<N;i++)
		{
			if(revString[i].length()>large)
			{
				large=revString[i].length();
				ja=ja+i+" ";
				largestIndex=i;
			}
		}
		
		
		
		

		for(int i=0;i<N;i++)
		{
			if(revString[i].length()!=large)
			{
				int len=revString[i].length();
				int final1=large-len;
				String temp="";
				for(int j=0;j<final1;j++)
				{
					temp+="|";
				}
				revString[i]=revString[i]+temp;
			}
			System.out.println(revString[i]);
		}
		String ans[]=new String[large];
		char rv[][]=new char[N][large];
		
		for(int i=0;i<N;i++)
		{
			String inp=revString[i];
			for(int j = 0;j<large;j++)
			{
				char m=inp.charAt(j);
				rv[i][j]=m;
			}
		}
		
		int x=0;
		for(int i=0;i<large;i++)
		{
			for(int j=1;j<N;j++)
			{
				if(rv[j][i]==revString[largestIndex].charAt(i) ||rv[j][i]=='|')
				{

					ans[i]=""+revString[largestIndex].charAt(i);
				}
				else
				{
					break;
				}
				
			}
		}
		String result="";
		for(int i=0;i<large;i++)
		{
			
			System.out.println(ans[i]);
			if(ans[i]==null)
			{
				return "*";
			}
			else
			{
				if(ans[i]=="|")
				{
					result=result+"";
				}
				else
				{
					result=result+ans[i];
				}
			}
		}
			StringBuilder input1 = new StringBuilder(); 
			input1.append(result);
			input1=input1.reverse();
			result=input1.toString();
		return result;
		
	}

	
}