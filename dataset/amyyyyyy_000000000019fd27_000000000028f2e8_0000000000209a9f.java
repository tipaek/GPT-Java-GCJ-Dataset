import java.io.*;
import java.util.*;
public class Solution {
/*
4
0000
101
111000
1
*/
	public static void main(String[]args) throws IOException{
		
				BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
				int test=Integer.parseInt(br.readLine());   //b0 is before contest
				char [] c;
				int count = 0;
				boolean tf = false;
				StringBuilder sb = new StringBuilder();
				for(int t = 1; t <= test; t++) {
					c = br.readLine().toCharArray();
					int [] a = new int [c.length];
					for (int i=0; i<c.length; i++)
					{
						a[i]=Character.getNumericValue(c[i]);
						if (a[i]==0)
						{
							if (tf==true)
							{
								//for (int j=0; j<count; j++)
									//sb.append("1");
								sb.append(")");
								tf = false;
								count=0;
							}
							sb.append("0");
						}
						else
						{
							if (tf==false)
								sb.append("(");
							sb.append("1");
							count++;
							tf = true;
						}
						
					}
					if (tf==true)
					{
						//for (int j=0; j<count; j++)
							//sb.append("1");
						sb.append(")");
						tf = false;
					}
					count = 0;
					System.out.println("Case #" + t + ": " + sb);
					sb.delete(0,sb.length());
				}
	}
}
