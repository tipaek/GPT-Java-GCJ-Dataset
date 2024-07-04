import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			String n = in.next();
			char[] aux = n.toCharArray();
			String res = "";
			int op = 0;
			int cl = 0;
			for (int k = 0; k < aux.length; k++) {
				char c=aux[k];
				String res2="";
				if(c=='0')
				{
					res+=c;
				}
				else
				{
					if(k!=0)
					{
						if(c!=aux[k-1])//&&!res.endsWith(")"))
						{
							for (int j = 0; j < Integer.parseInt(""+c); j++) {
								res2="("+res2;
							}
						}
					}
					else
					{

						//res2="("+res2;
						for (int j = 0; j < Integer.parseInt(""+c); j++) {
							res2="("+res2;
						}
					}
					res2+=c;
					if(k< aux.length-1 )
					{
						if(c!=aux[k+1])
						{
							for (int j = 0; j <Integer.parseInt(""+c); j++) {
								res2=res2+")";
							}
						}
						
					}
					else
					{
						//res2=res2+")";
						for (int j = 0; j <Integer.parseInt(""+c); j++) {
							res2=res2+")";
						}
					}
				}
				res+=res2;
				
			}
			boolean tiene=res.contains(")(");
			while(tiene)
			{
				String[] ayuda = res.split("\\)"+"\\(");
				res="";
				for (String string : ayuda) {
					res+=string;
				}
				tiene=res.contains(")(");
			}
			
			System.out.println("Case #" + i + ": " + res);
		}
	}
}