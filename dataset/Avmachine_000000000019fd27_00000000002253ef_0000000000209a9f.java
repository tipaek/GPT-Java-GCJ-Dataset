import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int x=1;x<=t;x++)
		{
			String s=sc.next();
			
			String y="";
			
			int b=0;
			
			for(int i=0;i<s.length();i++)
			{
				int d=std(s.charAt(i));
				
					for(int j=0;j<=9;j++)
					{
						if(d==j)
						{
							if(b<d)
							{
								for(int i1=b;i1<d;i1++,b++)
								{
									y=y+"(";
								}
								
							}
							else if(b>d)
							{
								for(int i1=b;i1>d;i1--,b--)
								{
									y=y+")";
								}
							}
							
							y=y+""+d;
						}
						
					}
				}
			
			for(int i1=b;i1>0;i1--)
			{
				y=y+")";
			}
			
			
			System.out.println("Case #"+x+": "+y);
			
		}

	}

	private static int std(char charAt) {
		
		for(int q=0,w=48;q<=9;q++,w++)
		{
			if(charAt==w)
			{
				return q;

			}
		}
		return 0;
	}

}
