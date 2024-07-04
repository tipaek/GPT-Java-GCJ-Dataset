// package codejam_archives;
import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int hp=1;hp<=t;hp++)
		{
		String[] s=br.readLine().split(" ");
		int n1=Integer.parseInt(s[0].trim());
		int n2=Integer.parseInt(s[1].trim());
		String str=s[2].trim();
		int res=algo(n1 ,n2 ,str);
		if(res!=-1)
		{
			System.out.println("Case #"+hp+": "+res);
		}
		else {
			System.out.println("Case #"+hp+": IMPOSSIBLE");
		}
		}
	}

	public static int algo(int x2,int y2,String s)
	{
				int x1=0,y1=0;
		
		if(x1==x2 &&y1==y2)
		{
			return 0;
		}
		int min=0;
		
		
		for(int i=0;i<s.length();i++)
		{
			
			char c=s.charAt(i);
			if(c=='S')
			{
				y2--;
				
			}
			else if(c=='N')
			{
				y2++;
			}
			
			else if(c=='E')
			{
				x2++;
			}
			else
			{

				x2--;
			}

			if(x1==x2 && y1==y2)
			{
				return (i+1);
			}
			
			
			if((x1==x2) &&(y2>y1))
			{
			y1++;	
			}
			else if((y2<y1)) {
				min++;
				y1--;
			}
			else if(y2>=y1)
			{
				min++;
				x1++;
			}
			else if(x2<=x1)
			{
				min++;
				x1--;
			}
			
			
			if(x1==x2 && y1==y2)
			{
				return (i+1);
			}
			
			
		}
		
		
		if(x1==x2 &&y1==y2)
		{
			return s.length();
		}
		
		
		return -1;
		

		
	}
	
}
