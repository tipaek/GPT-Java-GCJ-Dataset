

import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {


			int valuesForNext = in.nextInt();

			int array[][]=new int [valuesForNext][2];
			char results[]= new char[valuesForNext];

			for (int value = 0; value < valuesForNext; value++) {
				String line = in.nextLine(); 
				if (line.isEmpty())
				{
					value--;
					continue;
				}
				String[] lineParts = line.split(" ");

				array[value][0]=Integer.parseInt(lineParts[0]);
				array[value][1]=Integer.parseInt(lineParts[1]);
			}
			for (int setup=0; setup<valuesForNext;setup++)
			{
				results[setup]='C';
			}
			//checking impossible casses
			int numberOfOverlaps[]=new int[valuesForNext];
			int overlaps[][]=new int[valuesForNext][2];
			boolean breaked = false;
			for (int index=0;index<valuesForNext;index++)
			{
				boolean overlapped=false;
				int overlappedIndex = 0;
				for (int innerindex=index+1;innerindex<valuesForNext;innerindex++)
				{
					int x1 = array[index][0];
					int x2 =array[index][1];
					int y1 =array[innerindex][0];
					int y2 =array[innerindex][1];
					if (x1 < y2 && y1 < x2)
					{
						if (!overlapped)
							overlappedIndex=innerindex;
						overlapped=true;
						numberOfOverlaps[index]++;	
						if(numberOfOverlaps[index]>=3)
						{
							System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
							breaked=true;
							break;
						}

						overlaps[index][numberOfOverlaps[index]-1]=innerindex;
						if  (numberOfOverlaps[index]==2)
						{
							int index0 = overlaps[index][0];
							int index1 = overlaps[index][1];		
							int testvalue1 = array[index0][0];
							int testvalue2 =array[index0][1];
							int testvalue3 =array[index1][0];
							int testvalue4 =array[index1][1];
							if (testvalue1 < testvalue4 && testvalue3 < testvalue2)
							{
								System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
								breaked=true;
								break;
							}
							else
							{
								results[index0]='J';
								results[index1]='J';
							}
						}
					}

				}

			}



			//			

			for (int index=0;index<valuesForNext;index++)
			{
				boolean overlapped=false;
				int overlappedIndex = 0;
				for (int innerindex=index+1;innerindex<valuesForNext;innerindex++)
				{

					int value1 = array[index][0];
					int value2 =array[index][1];
					int value3 =array[innerindex][0];
					int value4 =array[innerindex][1];
					if (value1 < value4 && value3 < value2)
					{
						if (!overlapped)
							overlappedIndex=innerindex;

						overlapped=true;

					}

				}
				if (overlapped)
				{

					if((results[overlappedIndex]=='C'))
					{
						results[index]='J';
					}
				}
			}


			if(breaked)
				continue;
			System.out.print("Case #" + i + ": " );
			for (int resultsIndex=0;resultsIndex<results.length;resultsIndex++)
			{
				System.out.print(results[resultsIndex]);
			}
			System.out.println();
		}
	}
}
