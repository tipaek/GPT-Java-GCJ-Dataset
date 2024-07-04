import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	private static String validateTestCase(int ind, BufferedReader ob) throws Exception
	{
		String S,finalStr="";
		int index=0;
		
		do
		{
			S=ob.readLine();
		} while(S.length()>100);
		
		int[] positions=new int[S.length()];
		
		for(int i=0;i<S.length();i++)
		{
			int val=0;
			String tempStr="";
		
			try
			{
				val=new Integer(S.charAt(i));
				val-=48;
			} catch(Exception e)
			{
				e.printStackTrace();
				S=ob.readLine();
				finalStr="";
				i=-1;
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
			positions[i]=index;
			finalStr=finalStr.concat(opStr+String.valueOf(val)+cpStr);
			index=finalStr.length();
		}
		
		for(int i=0;i<positions.length-1;i++)
		{
			char c=finalStr.charAt(positions[i]);
			int val=new Integer(c);
			val-=48;
			
			int cp=positions[i+1]-(positions[i]+val+1);
			int del=cp<val?cp:val;
			
			String firstHalf=finalStr.substring(0,positions[i]+val+1-del);
			String secondHalf=finalStr.substring(positions[i]+val+1+del, finalStr.length());
			
			finalStr=firstHalf.concat(secondHalf);
			
			for(int j=i+1;j<positions.length;j++)
			{
				positions[j]-=(del*2);
			}
		}

		return finalStr;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int T;
		
		do
		{
			T=sc.nextInt();
		} while(T<1 || T>100);
			
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		
		String[] result=new String[T];
		try
		{
			for(int i=0;i<T;i++)
			{
				result[i]=validateTestCase(i, ob);
			}
			
			for(int i=0;i<T;i++)
			{
				System.out.println("Case #"+(i+1)+": "+result[i]);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		sc.close();
	}

}
