import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++)
		{
			String s=br.readLine();
			String[] s1=s.split(" ");
			int x=Integer.parseInt(s1[0]);
			int y=Integer.parseInt(s1[1]);
			String path=s1[2];
			int fx=0,fy=0;
			int minutes=0;
			int pointer=0;
			while(pointer<path.length())
			{
				char ch=path.charAt(pointer);
				if(fx!=x)
				{
					fx++;
					minutes++;
					if(ch=='N')
					{
						y++;
						pointer++;
					}
					else if(ch=='S')
					{
						y--;
						pointer++;
					}
				//	System.out.println(fx+" "+fy);
				//	System.out.println(x+" "+y);
				}
				if(fx==x)
				{
					if(fy==y)
					{
						System.out.println("Case #"+(i+1)+": "+minutes);
						break;
					}
					else
					{
						int diff=y-fy;
						if(diff==1&&ch=='N')
						{
							fy++;
							y++;
							pointer++;
							minutes++;
						}
						if(diff==-1&&ch=='S')
						{
							fy--;
							y--;
							pointer++;
							minutes++;
						}
						else if((diff==-1&&ch=='N'))
						{
							y++;
							pointer++;
							minutes++;
							System.out.println("Case #"+(i+1)+": "+minutes);
							break;
						}
						else if((diff==1&&ch=='S'))
						{
							y--;
							pointer++;
							minutes++;
							System.out.println("Case #"+(i+1)+": "+minutes);
							break;
						}
						else
						{
							if(y<0&&ch=='N')
							{
								fy--;
								y++;
								pointer++;
								minutes++;
							}
							else if(y>0&&ch=='N')
							{
								fy++;
								y++;
								pointer++;
								minutes++;
							}
							if(y>0&&ch=='S')
							{
								fy++;
								y--;
								pointer++;
								minutes++;
							}
							else if(y>0&&ch=='S')
							{
								fy--;
								y--;
								pointer++;
								minutes++;
							}
						}
					}
				}
			}
			if(x!=fx||y!=fy)
			{
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}
		}
	}
}