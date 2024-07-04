

import java.util.Scanner;

class Solution {
	
	public static void main(String[] args) {
		int flag=0;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	
		for (int i = 0; i < t; i++) {
			
			String s=sc.next();
			StringBuffer ans=new StringBuffer();
			int j=0;
			while(j<s.length() && s.charAt(j)!='1')
			{
				
				ans.append(s.charAt(j));
				j++;
			}
			if(j<s.length())
			{
			ans.append('(');
			ans.append(s.charAt(j));
			flag=1;
			}
			int k=j+1;
			for(k=j+1;k<s.length();k++)
			{
				if( s.charAt(k)!=s.charAt(k-1))
				{
			          if(flag==1)
			          {
			        		ans.append(')');
			        		flag=0;
			          }
			          else
			          {
			        	  ans.append('(');
			        	  flag=1;
			          }
				}
				ans.append(s.charAt(k));
			}
			if(s.charAt(s.length()-1)=='1')
			{
			ans.append(')');
			
			}
			System.out.print("Case #");
			System.out.print((i + 1) + ": ");
			System.out.print(ans);
			System.out.println();
		}
	}

}
