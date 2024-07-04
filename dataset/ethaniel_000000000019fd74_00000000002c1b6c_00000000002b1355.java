import java.util.ArrayList;
import java.io.*;
public class Solution {
	public static void main(String [] args) throws IOException{
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(cin.readLine());
		for(int t = 1; t <= T; t++) {
			String[] x = cin.readLine().split(" ");
			int r = Integer.parseInt(x[0]);
			int c = Integer.parseInt(x[1]);
			int[][] grid = new int[r][c];

			for (int i = 0; i < r; i++){
				String[] nums = cin.readLine().split(" ");
				for (int j = 0; j < c; j++){
					grid[i][j] = Integer.parseInt(nums[j]);
				}
			}

			System.out.println("Case #" + t + ": " + getInterest(grid));
		}
	}

	public static int getInterest(int[][] grid){
		int rlen = grid.length;
		int clen = grid[0].length;
		int total = 0;
		int lasttotal = -1;
		int full = 0;
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		while(lasttotal != total){
			ArrayList<int[]> rid = new ArrayList<int[]>();
			for (int r = 0; r < rlen; r++){
				for (int c = 0; c < clen; c++){
					int available = 0;
					double average = 0.0;
					for (int[] d : dirs){
						int py = r+d[0];
						int px = c+d[1];
						boolean found = false;
						while (py >= 0 && py < rlen && px >= 0 && px < clen){
							if (grid[py][px] != 0){
								found = true;
								break;
							}
							py += d[0];
							px += d[1];
						}
						if (found){
							available++;
							average += grid[py][px];
						}
					}

					if (available == 0) continue;
					if (grid[r][c] < average/available) rid.add(new int[]{r, c});
				}
			}

			int s = 0;
			for (int[] r : grid){
				for (int c : r){
					s += c;
				}
			}
			full += total;
			lasttotal = total;
			total = s;

			for (int[] i : rid){
				grid[i[0]][i[1]] = 0;
			}

		}
		return full;
		
	}
}
