import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("inp.txt"));
		
		int p,t,i,j,n;
        String s;
        StringBuilder sb;

		p=t=sc.nextInt();

		while(t-->0)
		{
			s=sc.next();
            n=s.length();

            sb=new StringBuilder();
            
            for(j=1;j<=(int)s.charAt(0)-48;j++)
                sb.append('(');
            sb.append(s.charAt(0));

            for(i=1;i<n;i++)
            {
                if(s.charAt(i)>s.charAt(i-1))
                {
                    for(j=1;j<=(int)s.charAt(i)-(int)s.charAt(i-1);j++)
                        sb.append('(');
                }
                else if(s.charAt(i)<s.charAt(i-1))
                {
                    for(j=1;j<=(int)s.charAt(i-1)-(int)s.charAt(i);j++)
                        sb.append(')');
                }
                sb.append(s.charAt(i));
            }

            for(j=1;j<=(int)s.charAt(n-1)-48;j++)
                sb.append(')');

			System.out.println("Case #"+(p-t)+": "+sb);
		}
	}
}