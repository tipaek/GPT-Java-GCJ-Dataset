
import java.util.*;
import java.io.*;
public class Solution
{
		
	public static void main(String[] args) 
	{
//		try
//		{
//			System.setIn(new FileInputStream("C:\\Data\\Projects\\codejam\\2020\\round0problem3.in"));
//		}
//		catch (FileNotFoundException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int B = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int m = 150;
		int d = 0;
		
		int [] checkBits = new int[2];
		checkBits[0] = -1;
		checkBits[1] = -1;
		
		int [][] a = new int [2][B];
		
		for (int i = 1; i <= t; ++i)
		{	

			int q=0;
			//find two checkbits
			for (q=0; q<B/2;++q)
			{
				int front = q;
				int back = B-q-1;
				
				System.out.println(front+1);
				a[d][front] = in.nextInt();
				
				System.out.println(back+1);
				a[d][back] = in.nextInt();

				if(checkBits[0] == -1)
					if(a[d][front] == a[d][back])
						checkBits[0] = front;
				
				if(checkBits[1] == -1)
					if(a[d][front] != a[d][back])
						checkBits[1] = front;

				if( (checkBits[1]>=0) && (checkBits[0]>=0) )
				{
					break;
				}

			}
			
			if( (checkBits[1]<0) || (checkBits[0]<0) )
			{
				while(true) q = 1;
			}

			q *= 2;
			for(int c=0;c<2;++c)
			{
				System.out.println(checkBits[c]+1);
				a[d][checkBits[c]] = in.nextInt();
				++q;
			}
			
			a[d][B-checkBits[0]-1] = a[d][checkBits[0]];
			a[d][B-checkBits[1]-1] = (a[d][checkBits[1]]+1)%2;
			
			for (int b=0;b<B;++b)
			{
				
				if((q+1)%10 == 1)
				{
					int from = d;
					++d;
					d = d%2;
					int to = d;

					for(int c=0;c<2;++c)
					{
						System.out.println(checkBits[c]+1);
						a[d][checkBits[c]] = in.nextInt();
					}
					correct(a, checkBits, to, from, B);
					++q;					
					++q;					
				}
				
				if(b == checkBits[0])
					continue;

				if(b == checkBits[1])
					continue;

				if(b == B - checkBits[0] - 1)
					continue;

				if(b == B - checkBits[1] - 1)
					continue;
				
				System.out.println(b+1);
				a[d][b] = in.nextInt();			
				++q;
			}

			for(int b=0;b<B;++b)
				System.out.print(a[d][b]);
			System.out.println("");
	
			String check = in.next();
			if(check.equals("N"))
				break;			
		}

		in.close();
	}

	private static void correct(int[][]a, int[]checkBits, int to, int from, int B)
	{
		
		if ( (a[0][checkBits[0]] == a[1][checkBits[0]]) 
				&& (a[0][checkBits[1]] == a[1][checkBits[1]]))
		{
			//nothing
		}
		else if ( (a[0][checkBits[0]] != a[1][checkBits[0]]) 
				&& (a[0][checkBits[1]] != a[1][checkBits[1]]))
		{
			//flip
			for (int b=0; b<B; ++b)
				a[to][b] = (a[from][b] +1)%2; 
		}
		else if ( (a[0][checkBits[0]] != a[1][checkBits[0]]) 
				&& (a[0][checkBits[1]] == a[1][checkBits[1]]))
		{
			//flip+rev
			for (int b=0; b<B; ++b)
				a[to][b] = (a[from][B-b-1] + 1)%2; 
		}
		else if ( (a[0][checkBits[0]] == a[1][checkBits[0]]) 
				&& (a[0][checkBits[1]] != a[1][checkBits[1]]))
		{
			//rev

			for (int b=0; b<B; ++b)
				a[to][b] = a[from][B-b-1]; 
		}
	}

}
