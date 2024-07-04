import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	
		
		int T = in.nextInt();
		
		for(int i = 1; i <= T; i++)
		{
			int N = in.nextInt();		
			int [][] timing = new int[N][2];
			StringBuilder path = new StringBuilder();
			
			for(int j = 0; j < N; j++)
			{
				timing[j][0] = in.nextInt();
				timing[j][1] = in.nextInt();				
			}
		
			path.append("C");
			
			List<Integer> cam = new ArrayList<>();
			cam.add(0);
			
			List<Integer> jam = new ArrayList<>();
			boolean cam_found, jam_found;

			for(int d = 1; d < N; )
			{
				cam_found = false;
				jam_found = false;

				cam_found = find(cam,  timing,  d);
				if(cam_found)
				{
					path.append("C");
					d++;
				}
				
				
				if(jam.size() == 0 && !cam_found)
				{
					path.append("J");
					jam_found = true;
					jam.add(d++);
				}
				else if( d < N)
				{

					jam_found = find(jam,  timing,  d);
					if(jam_found)
					{
						path.append("J");
						d++;
					}
				}
				
				if(!cam_found && ! jam_found)
				{
					path = new StringBuilder("IMPOSSIBLE");
					break;
				}
					
			}
			
			
			System.out.printf("Case #%d: %s%n", i, path);
			
		}
		
		in.close();
	}
	
	
	public static boolean find(List<Integer> ids, int [][] timing, int d)
	{
		
		boolean found = false;
		
		for(int c = 0 ; c < ids.size(); c++)
		{
			int x = ids.get(c);
			
			if(  timing[d][0] >= timing[x][1]  )
			{
				if(( c == ids.size() - 1 ) ||( c + 1 < ids.size() && timing[d][1] <= timing[ids.get(c+1)][0]) )
				{
					found = true;
				}
				if(found)
				{
					if( c == ids.size() - 1)
						ids.add(d);
					else
						ids.add(c,d);
					break;
				}

			}
			else if( timing[d][1] <= timing[x][0])
			{
				if(( c == 0 ) ||( c -1 >= 0 && timing[d][0] >= timing[ids.get(c-1)][1]) )
				{
					found = true;
					
				}
				if(found)
				{
					ids.add(c,d);
					break;
				}
			}

		}
			
		return found;
	}

}
