import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T;
		
		do
		{
			T=sc.nextInt();
		} while(T<1 || T>100);
		
		String[] result=new String[T];
		try
		{		

			for(int i=0;i<T;i++)
			{
				String S,finalStr="";
				int index=0;
				
				do
				{
					S=sc.nextLine();
				} while(S.length()>100);
				
				int[] positions=new int[S.length()];
				
				for(int in=0;in<S.length();in++)
				{
					int val=0;
					String tempStr="";
				
					try
					{
						val=new Integer(S.charAt(in));
						val-=48;
					} catch(Exception e)
					{
						e.printStackTrace();
						S=sc.nextLine();
						finalStr="";
						in=-1;
					    continue;	
					}
					
					char[] opArr=new char[val], cpArr=new char[val];
					
					for(int j=0;j<val;j++)
					{
						opArr[j]='(';
						cpArr[j]=')';
					}
					
					String opStr=new String(opArr), cpStr=new String(cpArr);
					index+=opArr.length;
					positions[in]=index;
					finalStr=finalStr.concat(opStr+String.valueOf(val)+cpStr);
					index=finalStr.length();
				}
				
				for(int in=0;in<positions.length-1;in++)
				{
					char c=finalStr.charAt(positions[in]);
					int val=new Integer(c);
					val-=48;
					
					int cp=positions[in+1]-(positions[in]+val+1);
					int del=cp<val?cp:val;
					
					String firstHalf=finalStr.substring(0,positions[in]+val+1-del);
					String secondHalf=finalStr.substring(positions[in]+val+1+del, finalStr.length());
					
					finalStr=firstHalf.concat(secondHalf);
					
					for(int j=in+1;j<positions.length;j++)
					{
						positions[j]-=(del*2);
					}
				}
				
				result[i]="Case #"+(i+1)+": "+finalStr;
			}
			
			for(int i=0;i<T;i++)
			{
				System.out.println(result[i]);
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		sc.close();
	}

}
