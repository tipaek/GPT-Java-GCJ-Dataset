import java.util.*;
import java.io.*;

public class Solution {
	
	public static int r;
	public static int s;
	public static int totalcards;
	public static boolean correctorder[];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int tc=1;
		while (t>0)
		{
			String inp[]=br.readLine().split(" ");
			r=Integer.parseInt(inp[0]);
			s=Integer.parseInt(inp[1]);
			totalcards=r*s;
			correctorder=new boolean[r];
			int a=r;
			int c=1;
			int b=totalcards-a-c;
			int chances=0;
			ArrayList<String> ans=new ArrayList<>();
			while (a>0 && b>0)
			{
				if (a==1 && b==1)
					break;
				ans.add(a+" "+b);
				if ((c+1)%s==0)
				{
					c++;
					a--;
				}
				c++;
				b=totalcards-a-c;
			}
			System.out.println("Case #"+tc+": "+ans.size());
			for (int i=0;i<ans.size();i++)
					System.out.println(ans.get(i));
			t--;
			tc++;
		}
	}
}