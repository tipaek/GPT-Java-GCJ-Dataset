import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int b=sc.nextInt();
		for(int x=1;x<=t;x++)
		{
			String s="";
			String s1="",s2="",s3="",s4="",t1="",t2="";
			int p=0;
			int aa=0,cc=0,ans=0;
			
			for(int j=1;j<=150;j++)
			{
					
					if(cc!=0)
					{
						System.out.print(aa+1);
						System.out.flush();
						t1=sc.next();
						++j;
						
						System.out.print(cc+1);
						System.out.flush();
						t2=sc.next();
						
						if(s1.charAt(aa)==t1.charAt(0) && s1.charAt(cc)==t2.charAt(0))
						{
							s4=s1;
						}
						else if(s2.charAt(aa)==t1.charAt(0) && s2.charAt(cc)==t2.charAt(0))
						{
							s4=s2;
						}
						else if(s3.charAt(aa)==t1.charAt(0) && s3.charAt(cc)==t2.charAt(0))
						{
							s4=s3;
						}
						
						ans=1;
						aa=0;
						cc=0;
						
					}
					else
					{
						
						if(p<b)
						{
							++p;
							System.out.print(p);
							System.out.flush();
							s=sc.next();
							s4+=s;
						}
						else
						{
							System.out.print(1);
							System.out.flush();
						}
					}
					
					if(j%10==0)
					{
						s1=comp(s4);
						s2=reve(s4);
						s3=comp(s4);
						s3=reve(s3);
						ans=0;
						aa=0;
						cc=1;
						
						for(int a=0;a<p-1;a++)
						{
							
							for(int c=a+1;c<p;c++)
							{
								if((s1.charAt(a)=='0' && s1.charAt(c)=='0') && (s2.charAt(a)=='0' && s2.charAt(c)=='1') && (s3.charAt(a)=='1' && s3.charAt(c)=='0') && (s4.charAt(a)=='1' && s4.charAt(c)=='1'))
								{
									aa=a;
									cc=c;
									break;
								}
								else if((s1.charAt(a)=='0' && s1.charAt(c)=='1') && (s2.charAt(a)=='1' && s2.charAt(c)=='0') && (s3.charAt(a)=='1' && s3.charAt(c)=='1') && (s4.charAt(a)=='0' && s4.charAt(c)=='0'))
								{
									aa=a;
									cc=c;
									break;
								}
								else if((s1.charAt(a)=='1' && s1.charAt(c)=='0') && (s2.charAt(a)=='1' && s2.charAt(c)=='1') && (s3.charAt(a)=='0' && s3.charAt(c)=='0') && (s4.charAt(a)=='0' && s4.charAt(c)=='1'))
								{
									aa=a;
									cc=c;
									break;
								}
								else if((s1.charAt(a)=='1' && s1.charAt(c)=='1') && (s2.charAt(a)=='0' && s2.charAt(c)=='0') && (s3.charAt(a)=='0' && s3.charAt(c)=='1') && (s4.charAt(a)=='1' && s4.charAt(c)=='0'))
								{
									aa=a;
									cc=c;
									break;
								}
								
							}
							
							if(cc!=0)
							{
								break;
							}
							
						}
					}
					
					if(p==b && ans==1)
					{
						System.out.print(s4);
						System.out.flush();
						s=sc.next();
						if(s.equals("Y"))
						{
						break;
						}
						else
						{
							System.exit(0);
						}
					}
			}
			
		}

	}

	private static String reve(String s2) {
		String ans="";
		for(int i=s2.length()-1;i>=0;i--)
		{
			ans+=s2.charAt(i);
		}
		return ans;
	}

	private static String comp(String s1) {
		String ans="";
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)=='0')
			{
				ans+="1";
			}
			else
			{
				ans+="0";
			}
		}
		return ans;
	}

}
