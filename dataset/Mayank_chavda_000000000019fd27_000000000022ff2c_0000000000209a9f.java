import java.util.*;
public class Solution {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		s.nextLine();
		for(int k=0;k<T;k++)
		{
			String val=s.nextLine();
			ArrayList<Character> l=new ArrayList<Character>();
			ArrayList<Character> l1=new ArrayList<Character>();
			ArrayList<Integer> l2=new ArrayList<Integer>();
			for(int i=0;i<val.length();i++)
				l.add(val.charAt(i));
			l.add(0, '0');
			l.add('0');
			int count=0;
			for(int i=0;i<l.size()-1;i++)
			{
				String s1="",s2="";
				if(l.get(i)!='(' && l.get(i)!=')' && l.get(i+1)!='(' && l.get(i+1)!=')')
				{
					s1+=l.get(i);
					s2+=l.get(i+1);
				//	System.out.println(s1+" "+s2);
					int a=Integer.parseInt(s1);
					int b=Integer.parseInt(s2);
					int x=a-b;
					//System.out.println("x= "+x);
					if(x<0)
					{
						x=(-1)*x;
						for(int j=0;j<x;j++)
						{
							int a11=j+i+1;
							char x11='(';
						//	System.out.println("a11= "+a11+" x11= "+x11);
							
							l.add(j+i+1,'(');
						}
					}
					else if(x>0)
					{
						for(int j=0;j<x;j++)
						{
							int a11=j+i+1;
							char x11=')';
							//System.out.println("a11= "+a11+" x11= "+x11);
							l.add(j+i+1, ')');
						}
					}
				}
			}
			String ans="";
			for(int m=1;m<l.size()-1;m++)
				ans+=l.get(m);
			int m1=k+1;
			System.out.println("Case #"+m1+": "+ans);
		}
	}
}
