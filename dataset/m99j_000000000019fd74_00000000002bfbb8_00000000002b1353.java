import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int tc=1;
		while (t>0)
		{
			int n=Integer.parseInt(br.readLine());
			if (n<10)
			{
				System.out.println("Case #"+tc+":");
				for (int i=1;i<=n;i++)
					System.out.println(i+" 1");
				t--;
				tc++;
				continue;
			}
			
			double log2=Math.log(n)/Math.log(2);
			int row=(int)Math.floor(log2);
			System.out.println("Case #"+tc+":");
			boolean test=false;
			for (int i=1;i<=row;i++)
			{
				if (test) {
				for (int j=1;j<=i;j++)
					System.out.println(i+" "+j);
				test=false;
				}
				else
				{
					for (int j=i;j>=1;j--)
						System.out.println(i+" "+j);
					test=true;
				}
			}
			//System.out.println(row);
			long leftover=n-(int)(Math.pow(2, row))+1;
			int end=-1;
			if (row%2==0)
				end=0;
			else
				end=1;
			row++;
			for (int i=1;i<=leftover;i++)
			{
				if (end==1)
					System.out.println(row+" "+end);
				else
					System.out.println(row+" "+row);
				row++;
			}
			t--;
			tc++;
		}
	}
}