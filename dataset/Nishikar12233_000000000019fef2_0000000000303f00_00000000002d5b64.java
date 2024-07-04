import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test= sc.nextInt();
		for(int g=0;g<test;g++)
		{
			int r=sc.nextInt();
			int s=sc.nextInt();
			int tot=r*s-1-r;
			int temp=r;
			int ans=(r-1)*(s-1);
			int unsort=tot+1;
			System.out.println("Case #"+ (g+1)+ ": "+ ans);
			//System.out.println(r);
			//System.out.println(s);
			//System.out.println(ans);
			
			/*while(tot!=r)
			{
				System.out.println(temp+ " "+ (tot-temp));
				tot--;
				if(tot-temp-1==temp)
				{
					temp--;
					//tot--;
				}
			}*/
			for(int x=r;x>1;x--)
			{
				for(int y=0;y<s-1;y++)
				{
					System.out.println(x+ " "+ tot);
					tot--;
				}
			}
			/*for(int x=r;x>1;x--)
			{
				for(int y=s;y>1;y--)
				{
					System.out.println(x+ " "+ (tot-x) );
					tot--;
				}
				tot--;
			}*/
		}
	}

}
