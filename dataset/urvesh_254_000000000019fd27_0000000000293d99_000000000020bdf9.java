import java.util.Scanner;

class CJ3
{
	static boolean check(int[] temp,int[] s,int[] e,int n,int j)
	{
		for(int i=0;i<n;i++)
		{
			if((e[temp[i]]>s[j] && s[temp[i]]<s[j]) || (e[temp[i]]>e[j] && s[temp[i]]<e[j]))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt(),i;
		
	
		for(i=0;i<T;i++)
		{
			boolean J=true,C=true;
			boolean f=false;
			int n=sc.nextInt();
			int s[]=new int[n];
			int e[]=new int[n];
			int jp[]=new int[n];
			int c[]=new int[n];
			
			int j,ct=0,jt=0;
			String str="";
			
			for(j=0;j<n;j++)
			{
				s[j]=sc.nextInt();
				e[j]=sc.nextInt();
			}
			
			for(j=0;j<n;j++)
			{
				J=check(jp,s,e,jt,j);
				C=check(c,s,e,ct,j);
				if(J)
				{
					str+="J";
					jp[jt++]=j;
				}
				else if(C)
				{
					str+="C";
					c[ct++]=j;
				}
				else
				{
					f=true;
					break;
				}
			}
			if(f)
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			else
				System.out.println("Case #"+(i+1)+": "+str);
		}
	}
}