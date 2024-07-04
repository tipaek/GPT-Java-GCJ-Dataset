
import java.util.*;
import java.io.*;
public class Solution
{
		
	public static void main(String[] args) 
	{
// 		try
// 		{
// 			System.setIn(new FileInputStream("C:\\Data\\Projects\\codejam\\2020\\round1Bproblem1.in"));
// 		}
// 		catch (FileNotFoundException e) 
// 		{
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
				
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i)
		{	
			int [] target = new int[2];

			int x = in.nextInt();
			int y = in.nextInt();

			target[0] = Math.abs(x);
			target[1] = Math.abs(y);		


			String sum = Integer.toBinaryString(target[0] + target[1]);
			int zeros = 0;
			
			for(int c=0; c<sum.length()-1; ++c)
			{
				if(sum.charAt(c) == '0')
					++zeros;
				if(sum.charAt(c) == '1')
					break;
			}
			sum = sum.substring(zeros);

			zeros = 0;
			int where = 0;
			for(int c=sum.length()-1; c>=0; --c)
			{
				if(sum.charAt(c) == '0')
				{
					++zeros;
					where = c;
				}				
			}
			
			int even = 1;
			int odd = 0;				
			if (target[0] % 2 == 0)
			{
				even = 0;
				odd = 1;				
			}
			
			if (zeros > 1 || sum.charAt(sum.length()-1) == '0')
			{
				System.out.println("Case #"  + i + ": IMPOSSIBLE");
				break;
			}
			
			StringBuilder oResult = new StringBuilder();

			if (zeros == 1)
			{
				if (odd == 1)
				{
					oResult.append('S');
				}
				else
				{
					oResult.append('W');
				}
			}
			else
			{
				if (odd == 1)
				{
					oResult.append('N');
				}
				else
				{
					oResult.append('E');
				}				
			}

			for (int c=1;c<sum.length();++c)
			{
				if ((target[0] & ((int)Math.pow(2, c))) == ((int)Math.pow(2, c)))
				{
					oResult.append('E');
				}
				else
				{
					oResult.append('N');
				}				

			}
			
			String strResult = oResult.toString();			
			
			if (x<0)
			{
				strResult = strResult.replaceAll("E", "X");
				strResult = strResult.replaceAll("W", "E");
				strResult = strResult.replaceAll("X", "W");				
			}
			if (y<0)
			{
				strResult = strResult.replaceAll("S", "X");
				strResult = strResult.replaceAll("N", "S");
				strResult = strResult.replaceAll("X", "N");				
			}
			
			
			System.out.println("Case #"  + i + ": " + strResult);			
						
		}

		in.close();
	}
}
