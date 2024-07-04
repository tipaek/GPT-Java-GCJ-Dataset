import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.valueOf(br.readLine());
		
		for(int tada=1; tada<=t;tada++)
		{
			
			String data=br.readLine();
			int arr[]=new int[data.length()];
			int cnt=0;
			for(char s:data.toCharArray())
			{
				arr[cnt]=s-48;
				cnt++;
			}
			
			int prev=-1;
			int currentBracket=0;
			StringBuilder stringBuilder=new StringBuilder("");
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i]>currentBracket)
				{
					for(;currentBracket<arr[i];currentBracket++)
					{
						stringBuilder.append("(");
					}
				}
				else if(arr[i]<currentBracket)
				{
					for(;currentBracket>arr[i];currentBracket--)
					{
						stringBuilder.append(")");
					}
				}
				stringBuilder.append(arr[i]);
			}
			for(;currentBracket>0;currentBracket--)
			{
				stringBuilder.append(")");
			}
			
			System.out.println("Case #"+tada+": "+stringBuilder.toString());
			
			
		}
	}

}
