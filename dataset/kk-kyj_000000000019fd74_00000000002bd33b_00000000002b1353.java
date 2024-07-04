import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	static int[][] pascalArr;
	
	static class Info {
		int i,j;
		public Info(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public String toString() {
			return "("+i+","+j+")";
		}
	}
	
	static ArrayList<Info> arr;
	public static void main(String[] args) {
		try {
			precal();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(br.readLine());
			for(int t = 1; t <= tc; t++) {
				int n = Integer.parseInt(br.readLine());
				
				arr = new ArrayList<>();
				
				boolean[][] visited = new boolean[501][501];
				visited[1][1] = true;
				n--;
				arr.add(new Info(1,1));
				solve(1,1, visited, n, new ArrayList<Info>());
				System.out.println("Case #"+t+":");
				for(Info tmp : arr) {
					System.out.println(tmp.i +" "+tmp.j);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void solve(int i, int j, boolean[][] visited, int n, ArrayList<Info> s) {
		// TODO Auto-generated method stub
		if(n < 0 || arr.size() > 1) {
			return;
		}
		//System.out.println(i+","+j+">>"+s);
		if(n == 0) {
			arr.addAll(s);
			return;
		}
		
		int[][] idx = {{-1,-1}, {-1,0}, {0,-1}, {0,1}, {1,0}, {1,1}};
		for(int k = 0; k < idx.length; k++) {
			if(inBound(i,j,idx[k])) {
				int nextI = i+idx[k][0];
				int nextJ = j+idx[k][1];
				if(!visited[nextI][nextJ]) {
					s.add(new Info(nextI, nextJ));
					visited[nextI][nextJ] = true;
					solve(nextI, nextJ, visited, n-pascalArr[nextI][nextJ], s);
					visited[nextI][nextJ] = false;
					s.remove(s.size()-1);
				}
			}
		}
	}

	private static boolean inBound(int i, int j, int[] ks) {
		int nextI = i+ks[0];
		int nextJ = j+ks[1];
		return nextI >= 1 && nextI <= 500 && nextJ >= 1 && nextJ <= nextI;
	}

	private static void precal() {
		pascalArr = new int[501][501];
		pascalArr[1][1] = 1;
		for(int i = 2; i < pascalArr.length; i++) {
			for(int j = 1; j <= i; j++) {
				pascalArr[i][j] = pascalArr[i-1][j-1]+pascalArr[i-1][j];
			}
		}
	}
}
