
import java.io.*;
import java.util.ArrayList;
public class Solution {
	static long x,y;
	static StringBuilder res ;
	static boolean expohelper(long xi , long yi , int i , ArrayList<Character> cur)
	{
		if (xi==x && yi==y)
		{
			if (res==null || res.length()>cur.size())
			{
				res = new StringBuilder();
				for (char c:cur)
					res.append(c);
			}
			return true;
		}
		else if (Math.abs(xi)>Math.abs(x) ||Math.abs(yi)>Math.abs(y))
			return false;
		boolean ans = false;
		cur.add('E');
		ans = expohelper(xi+(long)Math.pow(2,i) , yi ,i+1, cur);
		cur.remove(cur.size()-1);
		cur.add('S');
		ans |=  expohelper(xi-(long)Math.pow(2,i) , yi ,i+1, cur);
		cur.remove(cur.size()-1);
		cur.add('N');
		ans |=  expohelper(xi , yi+(long)Math.pow(2,i) ,i+1, cur);
		cur.remove(cur.size()-1);
		cur.add('S');
		ans |=  expohelper(xi , yi-(long)Math.pow(2,i) ,i+1, cur);
		cur.remove(cur.size()-1);
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		int t=1;
		while(t<=q)
		{
			String[] s = br.readLine().trim().split(" ");
			x = Long.parseLong(s[0]); y = Long.parseLong(s[1]);
			if ((x%2==0 && y%2==0)||(x%2!=0 && y%2!=0))
				System.out.println("Case #"+t+": IMPOSSIBLE");
			else
			{
				res = null;
				expohelper(0,0,0,new ArrayList<Character>());
				System.out.println("Case #"+t+": "+res);
			}
			t++;
		}

	}

}