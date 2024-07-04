import java.util.*;
public class Solution
{
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		int a,b,c,d,e,f,g,h,i,j,k;
		String s, t,u,v;
		a=in.nextInt();
		for(b=1;b<=a;b++)
		{
			c=in.nextInt();
			int[]z=new int[10000];
			String[]x=new String[10000];
			String[]y=new String[10];
			for(d=0;d<10000;d++)
			{
				z[d]=in.nextInt();
				x[d]=in.next();
			}
			for(d=1;d<=10;d++)
			{
				for(e=0;e<10000;e++)
				{
					if(z[e]==d)
					{
						if(d==1)
						{
							y[1]=x[e];
							break;
						}
						else if(d==2&&!(x[e].equals(y[1])))
						{
							y[2]=x[e];
							break;
						}
						else if(d==3&&!(x[e].equals(y[1]))&&!(x[e].equals(y[2])))
						{
							y[3]=x[e];
							break;
						}
						else if(d==4&&!(x[e].equals(y[1]))&&!(x[e].equals(y[2]))&&!(x[e].equals(y[3])))
						{
							y[4]=x[e];
							break;
						}
						else if(d==5&&!(x[e].equals(y[1]))&&!(x[e].equals(y[2]))&&!(x[e].equals(y[3]))&&!(x[e].equals(y[4])))
						{
							y[5]=x[e];
							break;
						}
						else if(d==6&&!(x[e].equals(y[1]))&&!(x[e].equals(y[2]))&&!(x[e].equals(y[3]))&&!(x[e].equals(y[4]))&&!(x[e].equals(y[5])))
						{
							y[6]=x[e];
							break;
						}
						else if(d==7&&!(x[e].equals(y[1]))&&!(x[e].equals(y[2]))&&!(x[e].equals(y[3]))&&!(x[e].equals(y[4]))&&!(x[e].equals(y[5]))&&!(x[e].equals(y[6])))
						{
							y[7]=x[e];
							break;
						}
						else if(z[e]==8&&!(x[e].equals(y[1]))&&!(x[e].equals(y[2]))&&!(x[e].equals(y[3]))&&!(x[e].equals(y[4]))&&!(x[e].equals(y[5]))&&!(x[e].equals(y[6]))&&!(x[e].equals(y[7])))
						{
							y[8]=x[e];
							break;
						}
						else if(z[e]==9&&!(x[e].equals(y[1]))&&!(x[e].equals(y[2]))&&!(x[e].equals(y[3]))&&!(x[e].equals(y[4]))&&!(x[e].equals(y[5]))&&!(x[e].equals(y[6]))&&!(x[e].equals(y[7]))&&!(x[e].equals(y[8])))
						{
							y[9]=x[e];
							break;
						}
						else if(z[e]==10&&x[e].length()==2&&!(x[e].charAt(0)==x[e].charAt(1)))
						{
							y[0]=String.valueOf(x[e].charAt(1));
						}
					}
				}
			}
			s=y[0]+y[1]+y[2]+y[3]+y[4]+y[5]+y[6]+y[7]+y[8]+y[9];
			System.out.println("Case #"+b+": "+s);
		}
	}
}