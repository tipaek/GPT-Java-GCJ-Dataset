import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int x=1;x<=t;x++)
		{
			int n=sc.nextInt();
			
			int [] s= new int[n];
			int [] e= new int[n];
			int cs=0,ce=0,js=0,je=0;
			
			String y="";
			
			for(int i=0;i<n;i++)
			{
				s[i]=sc.nextInt();
				e[i]=sc.nextInt();
				
				if(y!="IMPOSSIBLE")
				{
	
					if(ce<=s[i] || cs>=e[i])
					{
						y=y+"C";
						
						if(cs>s[i] || i==0)
						{
							cs=s[i];
						}
						
						if(ce<e[i] || i==0)
						{
							ce=e[i];
						}
					}
					else if(je<=s[i] || js>=e[i])
					{
						y=y+"J";
						
						if(js>s[i] || i==0)
						{
							js=s[i];
						}
						
						if(je<e[i] || i==0)
						{
							je=e[i];
						}
					}
					else
					{
						y="IMPOSSIBLE";
					}
					
				}
				
			}
			
			System.out.println("Case #"+x+": "+y);
			
		}

	}

}
