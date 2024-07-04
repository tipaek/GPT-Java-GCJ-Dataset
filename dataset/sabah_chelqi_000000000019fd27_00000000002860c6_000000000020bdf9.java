import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);		
		int T = in.nextInt();
		
		for(int i = 1; i <= T; i++)
		{
			int N = in.nextInt();		
			int [][] timing = new int[N][2];
			StringBuilder path = new StringBuilder();
			
			for(int j = 0; j < N; j++)
			{
				timing[j][0] = Integer.parseInt(in.next());
				timing[j][1] = Integer.parseInt(in.next());				
			}
		
			path.append("C");
			
			LinkedList<Integer> cam = new LinkedList<>();
			cam.add(0);
			
			LinkedList<Integer> jam = new LinkedList<>();
			
			boolean cam_found = false, jam_found = false;
			boolean cam_out = false;
			boolean jam_out = false;
			
			if(timing[0][0] == 0 && timing[0][1] == 24*60)
			{
				cam_out = true;
			}

			for(int d = 1; d < N; )
			{
				cam_found = false;
				jam_found = false;
				
				if(!cam_out)
				{
					cam_found = find(cam,  timing,  d);
					if(cam_found)
					{
						path.append("C");
						
						if(timing[d][0] == 0 && timing[d][1] == 24*60)
						{
							cam_out = true;
						}

						d++;
					}
				}

				
				
				if(jam.size() == 0 && !cam_found)
				{
					path.append("J");
					jam_found = true;
					
					if(timing[d][0] == 0 && timing[d][1] == 24*60)
					{
						jam_out = true;
					}

					jam.add(d++);
				}
				else if(!jam_out &&  d < N)
				{

					jam_found = find(jam,  timing,  d);
					if(jam_found)
					{
						path.append("J");
						if(timing[d][0] == 0 && timing[d][1] == 24*60)
						{
							jam_out = true;
						}
						d++;
					}
				}
				
				
				if( (!cam_found && !jam_found) )
				{
					path = new StringBuilder("IMPOSSIBLE");
					break;
				}
					
			}
			
			
			System.out.printf("Case #%d: %s%n", i, path.toString());
			
		}
		in.close();
		
	}
	
	
	public static boolean find(LinkedList<Integer> ids, int [][] timing, int d)
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
						ids.add(c+1,d);
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
					if(c == 0)
						ids.add(0,d);
					else
						ids.add(c-1,d);
					break;
				}
			}

		}
			
		return found;
	}
	
	
	

}
