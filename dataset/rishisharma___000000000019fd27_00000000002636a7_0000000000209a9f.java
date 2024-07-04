import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			StringBuilder sb=new StringBuilder();
			
			String str=s.next();
			
			int open=0;
			
			for(int j=0;j<str.length();j++)
			{
				if(open<=Integer.valueOf(str.charAt(j)+""))
				{
					while(open<Integer.valueOf(str.charAt(j)+""))
					{
						sb.append("(");
						open++;
					}
					
					sb.append(str.charAt(j));
				}
				else
				{
					while(open>Integer.valueOf(str.charAt(j)+""))
					{
						sb.append(")");
						open--;
					}
					
					sb.append(str.charAt(j));
				}
				
			}
			
			while(open>0)
			{
				sb.append(")");
				open--;
			}
			
			System.out.println("Case #"+(i+1)+": "+sb);
			
		}
		
	}
	
}