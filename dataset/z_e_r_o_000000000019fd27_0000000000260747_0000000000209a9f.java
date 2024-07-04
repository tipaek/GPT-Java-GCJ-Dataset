import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=sc.nextInt();
		String temp;
		for(int i=0;i<T;i++){
			temp=sc.next();
			System.out.println("Case #"+(i+1)+": "+getNestedString(temp));
		}
	}
	private static String getNestedString(String str){
		int open=0;
		String result="";
		int n=str.length();
		for(int i=0;i<n;i++){
			int temp=str.charAt(i)-48;
			for(int j=0;j<temp-open;j++)
			result+='(';
			result+=temp;
			open=temp;
			int next= (i==n-1)?0:str.charAt(i+1)-48;
			if(next<temp){
				for(int k=0;k<(temp-next);k++){
					result+=')';
					open--;
				}
			}
		}
		return result;
	}
}