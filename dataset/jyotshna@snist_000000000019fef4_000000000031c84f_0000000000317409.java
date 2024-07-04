import java.util.*;
 class Solution
{
	public static void main(String ar[])
	{
		Scanner scan=new Scanner(System.in);
		int test=scan.nextInt();
		//int fan[]=int fan[2];
		int n=0;
		while(n++<test)
		{
			int pepper[]=new int[2];
			pepper[0]=scan.nextInt();
			pepper[1]=scan.nextInt();

			int fan[]=new int[2];
			String s=scan.next();
			int count=1;boolean check=false;
			if(pepper[0]==pepper[1])
			{
				count=pepper[0];
				check=true;
			}
			else{
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='S')
					pepper[1]-=1;
				else if(s.charAt(i)=='N')
					pepper[1]+=1;
				else if(s.charAt(i)=='E')
					pepper[0]+=1;
				else
					pepper[0]-=1;
				int x=fan[0],y=fan[1];
				int min=Integer.MAX_VALUE;
				if((int)Math.sqrt(Math.pow(fan[0]-pepper[0],2)+Math.pow(fan[1]-pepper[1],2))==0)
				{
					check=true;
					break;
				}	
				int sum=(int)Math.sqrt(Math.pow(x+1-pepper[0],2)+Math.pow(y-pepper[1],2));
				if(sum==0)
				{
					check=true;
					break;
				}
				if(sum<min)
				{	fan[0]=x+1;
					min=sum;
				}
				sum=(int)Math.sqrt(Math.pow(x-1-pepper[0],2)+Math.pow(y-pepper[1],2));
				if(sum==0)
				{
					check=true;
					break;
				}
				if(sum<min)
				{
					fan[0]=x-1;
					min=sum;
				}
				sum=(int)Math.sqrt(Math.pow(x-pepper[0],2)+Math.pow(y+1-pepper[1],2));
				if(sum==0)
				{
					check=true;
					break;
				}
				if(sum<min)
				{
					fan[1]=y+1;
					min=sum;
				}
				sum=(int)Math.sqrt(Math.pow(x-pepper[0],2)+Math.pow(y-1-pepper[1],2));
				if(sum==0)
				{
					check=true;
					break;
				}
				if(sum<min)
				{
					fan[1]=y-1;
					min=sum;
				}





				count++;
			}
			}
			









			if(!check)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println("Case #"+n+": "+count);
		}
	}
}

