import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=Integer.parseInt(sc.nextLine());
		for(int test=1;test<=testcase;test++)
		{
			String S=sc.nextLine();
			int toOpen=0;
			int toClose=0;
			int open=0;
			int close=0;
			String ans="";
			for(int i=0;i<S.length();i++)
			{
				int number=Integer.parseInt(S.charAt(i)+"");
				
				if(S.length()==1)
				{
					toOpen=number;
					toClose=number;
					ans=addOpening(ans,toOpen);
					ans=ans+number;
					ans=addClosing(ans,toClose);
					break;
					
				}
				if(i==0)
				{
					
					if(number==0)
					{
						ans=ans+"0";
						continue;
					}
					open=number+open;
					toOpen=open-toOpen;
					toClose=open;
					ans=addOpening(ans,toOpen);
					ans=ans+""+number;
					continue;
				}
				if(i>0 && number==Integer.parseInt(S.charAt(i-1)+""))
				{
					if(number==0)
					{
						ans=ans+number;
						continue;
					}
					ans=ans+number;
				}
				
				
				if(open<number)
				{
					toOpen=number-open;
					toClose=open+toOpen;
					open=toOpen;
					ans=addOpening(ans,toOpen);
					ans=ans+""+number;
				}
				else if(open>number)
				{
					toClose=toClose-number;
					toOpen=open-toClose;
					open=open-toClose;
					ans=addClosing(ans,toClose);
					ans=ans+""+number;
			    }
				else if(number==0)
				{
					ans=ans+0;
				}
				
				if(i==S.length()-1)
				{
					ans=addClosing(ans,toClose);
				}
				 
				
				
			}
			System.out.println("Case #"+test+": "+ans);
			
			
		}
		
	}
	private static String addOpening(String ans, int number) {
		for(int i=0;i<number;i++)
		{
			ans=ans+"(";
		}
		return ans;
	}
	private static String addClosing(String ans, int number) {
		
		for(int i=0;i<number;i++)
		{
			ans=ans+")";
		}
		return ans;
	}
	

}
