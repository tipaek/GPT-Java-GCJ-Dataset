import java.util.Scanner;

public class Solution {
	static String go(int a)
	{
		String res= "";
		while (res.length()<a)
			res = res+"(";
		return res;
	}
	static String gc(int a)
	{
		
		String res= "";
		while (res.length()<a)
			res = res+")";
		return res;
	}
	static String helper(String str)
	{
		int c = 0;
		int ld = str.charAt(str.length()-1)-'0';
		String res = str.charAt(str.length()-1)+gc(ld);
		c = ld;
		for (int i=str.length()-2;i>=0;i--)
		{
			int cd = str.charAt(i)-'0';
			if (c-cd==0)
				continue;
			else if (c-cd>0)
			{
			res = go(c-cd)+res;
			c = c - (c-cd);
			}
			else
			{
				res = gc(cd-c)+res;
				c = c+(cd-c);
			}		
			res = str.charAt(i)+res;
		}
		res = go(c)+res;
		return res;
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int z=1;
        while(z<=t)
        {
            	String str=s.next();
           String ans="Case #"+z+": "+helper(str);
       
            System.out.println(ans);
            z++;
        }
	}

}
