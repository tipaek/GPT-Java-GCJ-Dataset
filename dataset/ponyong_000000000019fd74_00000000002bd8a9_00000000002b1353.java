
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static class Path_list {
		int row, col, dist;
		String path;
		public Path_list(int row, int col, int dist, String oldPath) {
			super();
			this.row = row;
			this.col = col;
			this.dist = dist;
	        if("".equals(oldPath)) {
	            this.path = (row + 1) + " " + (col + 1); 
	        }
	        else {
	            this.path = oldPath + "\n" + (row + 1) + " " + (col + 1); 
	        }
		}
	}
	public static int rows;
	public static int cols;
	public static int[][] map;
	public static String path = "";
	public static int target;
	public static boolean flag;
	public static int tc;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(tc = 1; tc <= T; tc++) {
			
			target = Integer.parseInt(br.readLine());
			rows = target + 1;
			cols = target + 1;
			map = new int[rows][cols];
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					if(i == j || j == 0) {
						map[i][j] = 1;
					}
					else if(i < j ) {
						map[i][j] = -1;
					}
					else {
						map[i][j] = map[i-1][j-1] + map[i-1][j]; 
					}
				}
			}
			path = "";
			int curRow = 0;
			int curCol = 0;
			int curDist = 1;
			String curPath = "";
			flag = false;
			dfs(new Path_list(curRow, curCol,curDist, curPath));

		}
		 
	}
	private static void dfs(Path_list path_list) {
        int curRow = 0; 
        int curCol = 0;  
        int curDist = 0;  
        String curPath = "";
 
        curRow = path_list.row;
        curCol = path_list.col;
        curDist = path_list.dist;
        curPath = path_list.path;
        path = curPath;
        int temp = map[curRow][curCol];
        map[curRow][curCol] = -1;
        if(curDist == target + 1 && flag == false) {
            System.out.println("Case #" + tc + ": \n" + path);
            flag = true;
        }
        else if(curDist > target) {
        	return;
        }
        if(curRow-1 >= 0 && curCol-1 >= 0 && map[curRow-1][curCol-1] > 0) {
            dfs(new Path_list(curRow-1, curCol-1, curDist + map[curRow-1][curCol-1], curPath));
        }
        
        if(curRow-1 >= 0 && map[curRow-1][curCol] > 0) {
            dfs(new Path_list(curRow-1, curCol, curDist + map[curRow-1][curCol], curPath));
        }
        
        if(curRow-1 >= 0 && curCol + 1 < 5 && map[curRow-1][curCol+1] > 0) {
            dfs(new Path_list(curRow-1, curCol+1, curDist + map[curRow-1][curCol+1], curPath));
        }
        
        if(curCol + 1 < 5 && map[curRow][curCol + 1] > 0) {
            dfs(new Path_list(curRow, curCol + 1, curDist + map[curRow][curCol+1], curPath));
        }

        if(curRow + 1 < 5 && curCol + 1 < 5 && map[curRow+1][curCol+1] > 0) {
            dfs(new Path_list(curRow+1, curCol+1, curDist + map[curRow+1][curCol+1], curPath));
        }
        
        if(curRow + 1 < 5 && map[curRow + 1][curCol] > 0) {
            dfs(new Path_list(curRow + 1, curCol, curDist + map[curRow+1][curCol], curPath));
        }
        
        if(curRow + 1 < 5 && curCol-1 >= 0 && map[curRow + 1][curCol-1] > 0) {
            dfs(new Path_list(curRow + 1, curCol-1, curDist + map[curRow+1][curCol-1], curPath));
        }
        
        if(curCol-1 >= 0 && map[curRow][curCol-1] > 0) {
            dfs(new Path_list(curRow, curCol-1, curDist + map[curRow][curCol-1], curPath));
        }
        
        map[curRow][curCol] = temp;

	}
}
