import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
		int test_case=Integer.parseInt(in.next());
		int i=0;
		do {
			i++;
			String str=in.next();
			int r=0;
			int l=0;
			char[] test=str.toCharArray();
			ArrayList<String> res= new ArrayList<String>();
			
			for(int j=0;j<test.length;j++)
			{
				int a=Integer.parseInt(String.valueOf(test[j]));
				
				if(a==r)
				{
					res.add(""+a);
				}
				else if(a>r)
				{
					int add=a-r;
						
					for(int k=0;k<add;k++)
					{
						res.add("(");
						
					}
					res.add(""+a);
					r=a;
				}
				else if(a<r)
				{
					int add1=r-a;
					
					for(int k=0;k<add1;k++)
					{
						res.add(")");
						
					}
					res.add(""+a);
					r=a;
					
				}	
			}

			for(int j=0;j<r;j++)
			{
				res.add(")");
			}
		System.out.println("Case #"+i+": "+toStr(res));
		test_case--;
		}while(test_case>0);
		
	}
	
	public static String toStr(ArrayList<String> arr)
	{
		String res="";
		
		for(int i=0;i<arr.size();i++)
		{
			
			res=res+arr.get(i);
		}
		
		return res;
	}
	
}
