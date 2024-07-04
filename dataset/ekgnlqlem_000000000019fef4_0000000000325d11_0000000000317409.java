import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 1; t <= T; t++){
            int x = input.nextInt();
            int y = input.nextInt();
            String M = input.next();
			
			int[][] map = new int[2000][2000];
			for(int[] row : map) Arrays.fill(row, -1);
			map[999+y][999-x] = 0;
			
			Queue<String> queue = new LinkedList();
			StringBuilder sb = new StringBuilder();
			sb.append(999+y).append(",").append(999-x);
			queue.add(sb.toString());
			int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
			
			int N = 999 - M.length();
			int S = 999 + M.length();
			int W = 999 - M.length();
			int E = 999 + M.length();
			
            int step = 1;
			
			while(!queue.isEmpty()){
				int sz = queue.size();
				for(int i = 0; i < sz; i++){
					String curr = queue.poll();
					String[] arr = curr.split(",");
					for(int[] d : dirs){
						int p = Integer.parseInt(arr[0]) + d[0];
						int q = Integer.parseInt(arr[1]) + d[1];
						if(p >= N && q >= W && p <= S && q <= E && map[p][q] == -1){
							map[p][q] = step;
							//if(step <= 8) System.out.println(p+" "+q+" "+step);
							queue.add(p+","+q);
						}
					}
				}
				step++;
			}
            
			
            
            int i = 999, j = 999;
			int count = 0;
			int result = Integer.MAX_VALUE;
            for(char c : M.toCharArray()){
				
                if(c == 'W')
                    j--;
                else if(c == 'E')
                    j++;
                else if(c == 'N')
                    i--;
                else 
                    i++;
				count++;
				//System.out.println(i+" "+j+" "+count+" "+map[i][j]);
				if(map[i][j] != -1 && map[i][j] <= count) result = Math.min(result, count);
            }

			if(result == Integer.MAX_VALUE) System.out.println("Case #"+t+": IMPOSSIBLE");
			else System.out.println("Case #"+t+": "+result);
    
            
			
        }
    }
}