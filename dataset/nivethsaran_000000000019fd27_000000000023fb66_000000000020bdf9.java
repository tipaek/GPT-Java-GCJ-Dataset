import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

	public static void main(String args[]) {
// 		getDataFromFile();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int it=1;
		while (t-- > 0) 
		{
			int n=in.nextInt();
			Pair s[]=new Pair[n];
			
			for(int i=0;i<n;i++)
			{
				int a,b;
				a=in.nextInt();
				b=in.nextInt();
				s[i]=new Pair(a,b);
			}
			Arrays.sort(s, new Comparator<Pair>() {
				@Override
				public int compare(Pair a,Pair b)
				{
					return a.b-b.b;
				}
			});
			String answer="J";
			String p="J";
			boolean flag=false;
			boolean impossible=false;
			for(int i=1;i<n;i++)
			{
				
				if(s[i].a<s[i-1].b)
				{
					if(flag==true)
					{
						if(s[i].a<s[i-2].b)
						{
							impossible = true;
						}
						else
						{
							flag = false;
							answer += p;
						}
					}
					else
					{
					flag=true;
					if(p.equals("C"))
					p="J";
					else
					p="C";
					answer+=p;
					}
				}
				else
				{
					flag=false;
					if (p.equals("C"))
						p = "J";
					else
						p = "C";
					answer+=p;
				}
					
					
			}
			if(!impossible)
			System.out.println("Case #"+(it++)+": "+answer);
			else
			System.out.println("Case #"+(it++)+": IMPOSSIBLE");

		}
		in.close();
	}

	static class Pair
	{
		int a;
		int b;
		Pair(int a,int b)
		{
			this.a=a;
			this.b=b;
		}
	}



	static void getDataFromFile() {
		try {
			FileInputStream fin = new FileInputStream(new File("input.txt"));

			InputStream cin = System.in;
			System.setIn(fin);
			PrintStream o = null;
			PrintStream err = null;
			o = new PrintStream(new File("output.txt"));
			err = new PrintStream(new File("error.txt"));
			PrintStream console = System.out;
			System.setOut(o);
			System.setErr(err);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}