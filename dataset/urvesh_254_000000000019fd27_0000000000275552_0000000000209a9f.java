import java.util.Scanner;

class Solution
{
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt(),i;
		for(i=0;i<T;i++)
		{
			String str=sc.next();
			String newStr="";
			int ct=0,k,j,a=0,b;
			int d=Integer.parseInt(String.valueOf(str.charAt(0)));
			
			for(j=0;j<str.length();j++)
			{	
				for(k=0;k<d;k++)
				{
					newStr+="(";
				}
				ct+=d;
				newStr+=str.charAt(j);
				a=Integer.parseInt(String.valueOf(str.charAt(j)));
				b=(j==str.length()-1)?0:Integer.parseInt(String.valueOf(str.charAt(j+1)));
				d=b-a;
				if(d<0)
				{
					for(k=0;k<-1*d;k++)
						newStr+=")";
					ct-=-1*d;
				}
				
			}
			System.out.println("Case #"+(i+1)+": "+newStr);
		}
		
	}
}