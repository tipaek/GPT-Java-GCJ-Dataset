import java.util.*;
import java.io.*;
public class Solution
{
		
	public static void main(String[] args) 
	{
//		try
//		{
//			System.setIn(new FileInputStream("C:\\Data\\Projects\\codejam\\2020\\round1Aproblem2.in"));
//		}
//		catch (FileNotFoundException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		
		for (int c = 1; c <= t; ++c)
		{	
			int A = in.nextInt();
			int B = in.nextInt();

			boolean bFound = false;
			int mode = 0;
			int limit = 1000000000;
			int [] hit = new int [2]; 
			int [] left = new int [2];
			int [] right = new int [2];
			int [] up = new int [2];
			int [] down = new int [2];
			for(int e=0;e<300;++e)
			{
			
				int X = 0; //center of wall = 0,0
				int Y = 0;

				switch (mode)
				{
					case 0:
						X = 0;
						Y = 0;
						break;
					case 1:
						X = -limit/2;
						Y = -limit/2;
						break;
					case 2:
						X = limit/2;
						Y = -limit/2;
						break;
					case 3:
						X = -limit/2;
						Y = limit/2;
						break;
					case 4:
						X = limit/2;
						Y = limit/2;
						break;
					case -1:
						X = (left[0] + left[1])/2;
						Y = hit[1];
						break;
					case -2:
						X = (right[0] + right[1])/2;
						Y = hit[1];
						break;
					case -3:
						X = (left[0] + right[0])/2;
						Y = (up[0] + up[1])/2;
						break;
					case -4:
						X = (left[0] + right[0])/2;
						Y = (down[0] + down[1])/2;
						break;
					case -5:
						X = (left[0] + right[0])/2;
						Y = (up[0] + down[0])/2;
						break;						
				}
				
				
				System.out.println(X + " " + Y);
				String result = in.next();				
				
				switch (result)
				{
					case "HIT":
							switch (mode)
							{
								case 0:
								case 1:
								case 2:
								case 3:
								case 4:
									hit[0] = X;
									hit[1] = Y;
									left[0] = -limit;
									left[1] = X;
									right[0] = X;
									right[1] = limit;
									up[0] = Y;
									up[1] = limit;
									down[0] = -limit;
									down[1] = Y;
									mode = -1;
									break;
								case -1:
									left[1] = X;
									if(left[1] == left[0])
										--mode;
									break;
								case -2:
									right[0] = X;
									if(right[1] == right[0])
									{
										--mode;
									}
									break;
								case -3:
									up[0] = Y;
									if(up[1] == up[0])
										--mode;
									break;
								case -4:
									down[1] = Y;
									if(down[1] == down[0])
										--mode;
									break;
							}
							break;
					case "MISS":
						switch (mode)
						{
							case 0:
								++mode;
								break;
							case -1:
								left[0] = X;
								break;
							case -2:
								right[1] = X;
								break;
							case -3:
								up[1] = Y;
								break;
							case -4:
								down[0] = Y;
								break;
						}

						break;
					case "CENTER":
							bFound = true;
							break;
					case "WRONG":
							e = 301;
							break;
				}
				if (bFound)
					break;
			}

			if (!bFound)
				break;

		}

		in.close();
	}
}
