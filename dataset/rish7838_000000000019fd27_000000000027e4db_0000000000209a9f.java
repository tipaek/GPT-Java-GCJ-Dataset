import java.util.*;

class Solution
{
	public static void main(String s[])
	{
		
		
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		ArrayList<String> list = new ArrayList(t);
		for(int k=0;k<t;k++)
		{
		       // System.out.println("Working");
				String s1 = sc.nextLine();
				StringBuilder sb;
				int level = 0;
				sb = new StringBuilder();
				for(int j=0;j<s1.length();j++)
				{
					int a = s1.charAt(j) - '0';
					int p = 0;
					if(level<a){
						for(p=level;p<a;p++)
						{
							sb.append("(");
							
						}
						
						level = p;
					}
					else if(level>a)
					{
						for(p=level;p>a;p--)
						{
							sb.append(")");
							
						}
						
						level = p;
					}
					
					sb.append(a);
				}
				for(int q=level;q>0;q--)
				{
					sb.append(")");
				}
				
				
				
				String ans = "Case #"+(k+1)+": "+sb.toString();
				list.add(ans);
				
			
		}
		
		for(String ans1: list)
			System.out.println(ans1);
	
		
		
			
				
	}
}