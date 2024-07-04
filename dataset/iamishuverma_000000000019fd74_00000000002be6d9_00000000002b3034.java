import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,n,i,j,in=0;
	String fir,last,mid,pre,suf;
	String[] p=new String[50];
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{	
		fir="";
		last="";
		mid="";
		boolean flag=true;
		n=scan.nextInt();
		for(j=0;j<n;++j)
			{
			p[j]=scan.next();
			pre=p[j].substring(0,p[j].indexOf('*'));
			suf=p[j].substring(p[j].lastIndexOf('*')+1,p[j].length());
			if(p[j].indexOf('*')<p[j].lastIndexOf('*'))
				mid+=p[j].substring(p[j].indexOf('*')+1,p[j].lastIndexOf('*'));
			if(pre.length()>=fir.length())
				{
				String temp;
				temp=pre;
				pre=fir;
				fir=temp;
				}	
			if(suf.length()>=last.length())
				{
				String temp=suf;
				suf=last;
				last=temp;
				}
			if(j>0)
				{
				if((fir.indexOf(pre)!=0)||(last.lastIndexOf(suf)!=last.length()-suf.length()))
					flag=false;
				}
			}
		System.out.print("Case #"+i+": ");
		if(flag)
			{
			in=mid.indexOf('*');
			while(in>-1)
				{
				mid=mid.substring(0,in)+mid.substring(in+1,mid.length());
				in=mid.indexOf('*');
				}
			System.out.println(fir+mid+last);
			}
		else
			System.out.println("*");
		}
	}
}