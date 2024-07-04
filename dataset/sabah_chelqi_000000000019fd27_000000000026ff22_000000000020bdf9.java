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

				
				for(int c = 0 ; c < cam.size(); c++)
				{
					int x = cam.get(c);
					
					if(  timing[d][0] >= timing[x][1]  )
					{
						if(( c == cam.size() - 1 ) ||( c + 1 < cam.size() && timing[d][1] <= timing[cam.get(c+1)][0]) )
						{
							cam_found = true;
						}
						if(cam_found)
						{
							path.append("C");
							if( c == cam.size() - 1)
								cam.add(d++);
							else
								cam.add(c,d++);
							break;
						}

					}
					else if( timing[d][1] <= timing[x][0])
					{
						if(( c == 0 ) ||( c -1 >= 0 && timing[d][0] >= timing[cam.get(c-1)][1]) )
						{
							cam_found = true;
							
						}
						if(cam_found)
						{
							path.append("C");
							cam.add(c,d++);
							break;
						}
					}
		
				}
					
				
				
				if(jam.size() == 0 && !cam_found)
				{
					path.append("J");
					jam_found = true;
					jam.add(d++);
				}
				else if( d < N)
				{

					for(int c = 0 ; c < jam.size(); c++)
					{
						int x = jam.get(c);
						
						if(  timing[d][0] >= timing[x][1]  )
						{

							if(( c == jam.size() - 1 ) ||( c + 1 < jam.size() && timing[d][1] <= timing[jam.get(c+1)][0]) )
							{
								jam_found = true;
							}
							if(jam_found)
							{
								path.append("J");
								if( c == jam.size() - 1)
									jam.add(d++);
								else
									jam.add(c,d++);
								
								break;
							}

						}
						else if( timing[d][1] <= timing[x][0])
						{
							if(( c == 0 ) ||( c -1 >= 0 && timing[d][0] >= timing[jam.get(c-1)][1]) )
							{
								jam_found = true;
							}
							if(jam_found)
							{
								path.append("J");
								jam.add(c,d++);
								break;
								
							}
						}
	
					}
	
				}
				
				if(!cam_found && ! jam_found)
				{
					path = new StringBuilder("IMPOSSIBLE");
					break;
				}
					
			}
			
			
			System.out.printf("Case #%d: %s\n", i, path);
			
		}
		
		in.close();
	}

}
