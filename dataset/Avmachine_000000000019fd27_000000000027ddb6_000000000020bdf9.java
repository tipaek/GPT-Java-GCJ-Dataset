import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		String ans="";
		
		for(int x=1;x<=t;x++)
		{
			int n=sc.nextInt();
			
			String y="",y1="";
			
			int []s=new int[n];
			int []e=new int[n];
			
			int []s1=new int[n];
			int []e1=new int[n];
			
			int cs=-1,ce=-1,js=-1,je=-1,temp=0;
			
			for(int nn=0;nn<n;nn++)
			{
				s[nn]=sc.nextInt();
				s1[nn]=s[nn];
				e[nn]=sc.nextInt();
				e1[nn]=e[nn];
				
				for(int i=0;i<nn;i++)
				{
					if(s[i]>s[i+1])
					{
						temp=s[i];
						s[i]=s[i+1];
						s[i+1]=temp;
						
						temp=e[i];
						e[i]=e[i+1];
						e[i+1]=temp;
					}
				}
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
			
			if(y=="IMPOSSIBLE")
			{
				y1=y;
			}
			else
			{
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<n;j++)
					{
						if(s[i]==s1[j] && e[i]==e1[j])
						{
							y1+=y.charAt(j);
							s1[j]=e1[j]=-1;
							break;
						}
					}
				}
			}
			
				System.out.println("Case #"+x+": "+y1);
		}
		
		sc.close();
	}

}
