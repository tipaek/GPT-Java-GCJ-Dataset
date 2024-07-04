import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		String ans="";
		
		for(int x=1;x<=t;x++)
		{
			int n=sc.nextInt();
			
			String y="";
			
			int []s=new int[n];
			int []e=new int[n];
			
			int cs=-1,ce=-1,js=-1,je=-1;
			
			for(int nn=0;nn<n;nn++)
			{
				s[nn]=sc.nextInt();
				e[nn]=sc.nextInt();
			}
			
			for(int i=0;i<n;i++)
			{
				if(ce<=s[i] || cs>=e[i])
				{
					y+="C";
					
					if(cs==-1)
					{
						cs=s[i];
						ce=e[i];
					}
					else
					{
						if(cs>s[i])
						{
							cs=s[i];
						}
						
						if(ce<e[i])
						{
							ce=e[i];
						}
					}
				}
				else if(je<=s[i] || js>=e[i])
				{
					y+="J";
					
					if(js==-1)
					{
						js=s[i];
						je=e[i];
					}
					else
					{
						if(js>s[i])
						{
							js=s[i];
						}
						
						if(je<e[i])
						{
							je=e[i];
						}
					}
				}
				else
				{
					y="IMPOSSIBLE";
					break;
				}
			}
			
			if(x!=t)
			{
				ans+="Case #"+x+": "+y+"\n";
			}
			else
			{
				ans+="Case #"+x+": "+y;
			}
			
		}
		
		System.out.print(ans);
		
		sc.close();
	}

}
