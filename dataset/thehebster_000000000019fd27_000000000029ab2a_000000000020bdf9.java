import java.util.*; 
// 3
// 360 480
// 420 540
// 600 660
public class Solution
{
	public static void main(String[] args)
	{
		Scanner scanny = new Scanner(System.in); 
		int numCases = scanny.nextInt(); 

		for(int i = 0; i < numCases; i++)
		{	
			boolean[] c; 
			boolean[] j;
			ArrayList<Integer> start = new ArrayList<>();
			ArrayList<Integer> end = new ArrayList<>();
			int numActivities = scanny.nextInt(); 
			char[] schedule = new char[numActivities];
			//System.out.println("num Activities: " + numActivities);
			boolean cbusy = false;
			boolean jbusy = false;
			boolean impossible = false;

			// Store start and end times for each activity 
			for (int k = 0; k < numActivities; k++)
			{
				start.add(scanny.nextInt()); 
				end.add(scanny.nextInt());
			}

			// Find the last finish time
			int max = 0; 
			for (int time: end)
			{
				if (time > max)
				{
					max = time;
				}
			}

			c = new boolean[max + 1]; 
			j = new boolean[max + 1]; 

			//System.out.println("last finish time: " + max);

			// for each time interval, try to assign an activity to cameron or jamie
			for (int k = 0; k < numActivities; k++)
			{
				int s = start.get(k); 
				int e = end.get(k); 
				cbusy = false;
				jbusy = false;

				//System.out.println("Range: " + s + " - " + e);
	
				// First, check cameron's schecule minute by minute
				for(int l = s; l < e; l++)
				{
					// Check if cameron is busy
					if (c[l] == true)
					{
						cbusy = true;
						//System.out.println("cameron busy at minute " + l);
					}

				}

				if(!cbusy)
				{
					Arrays.fill(c, s, e, true);
					schedule[k] = 'C';
				}

				// try giving jamie the activity if cameron is busy
				else
				{
					for(int l = s; l < e; l++)
					{
						// give jamie the activity if she's not busy
						if (j[l] == true)
						{
							jbusy = true;
							//System.out.println("jamie busy at minute " + l);
						}

					}

					if (!jbusy)
					{
						Arrays.fill(j, s, e, true);
						schedule[k] = 'J';
					}

				}

				//System.out.println(impossible);


			}

			if (cbusy && jbusy)
				{
					impossible = true;
				}

				if(impossible)
				{
					
					System.out.printf("Case #%d: IMPOSSIBLE\n", (i +1));
				}
				
				else
				{

					System.out.printf("Case #%d: ", (i + 1));
					for (char ch: schedule)
					{
						System.out.print(ch);
					}

					System.out.println();
				}

			//System.out.println(Arrays.toString(c));
			//System.out.println(Arrays.toString(schedule));


		}
	}
}