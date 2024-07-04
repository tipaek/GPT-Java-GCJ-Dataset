import java.util.*;
import java.io.*;
public class Solution {

	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = nextInt();
		int l = 1;
		while(t --> 0) {
			int r = nextInt();
			int c = nextInt();
			int[][] arr = new int[r][c];
			Contestant[][] arr1 = new Contestant[r][c];
			long sum = 0;
			long tot = 0;
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++) {
					arr[i][j] = nextInt();
					tot += arr[i][j];
				}
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					arr1[i][j] = new Contestant(arr[i][j], i,j, arr1);
			sum += tot;
			boolean died = false;
			do {
				died = false;
//				if(l == 3)
//					System.out.println(tot);
				ArrayList<Contestant> kill = new ArrayList<Contestant>();
				for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++) {
						if(arr1[i][j] != null && arr1[i][j].checkDies()) {
//							System.out.println(i + " " + j);
							died = true;
							tot -= arr[i][j];
							kill.add(arr1[i][j]);
						}
					}
				for(int i = 0; i < kill.size(); i++) {
					kill.get(i).propogate(arr1);
					arr1[kill.get(i).r][kill.get(i).c] = null;
				}
				if(died)
					sum += tot;
			} while(died == true);
			System.out.println("Case #" + l++ + ": " + sum);
		}
	}

	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
class Contestant {
	int r, c, val;
	// u d l r
	Contestant[] neighbors;
	public Contestant(int val, int r, int c, Contestant[][] arr) {
		super();
		this.r = r;
		this.c = c;
		this.val = val;
		neighbors = new Contestant[4];
		if(r > 0) {neighbors[0] = arr[r - 1][c]; arr[r-1][c].neighbors[1] = this;}
		if(c > 0) {neighbors[2] = arr[r][c - 1]; arr[r][c - 1].neighbors[3] = this;}
	}
	public boolean checkDies() {
		long sum = 0;
		int tot = 0;
		for(int i = 0; i < 4; i++)
			if(neighbors[i] != null) {sum += neighbors[i].val; tot++;}
		if(sum > val * tot) return true;
		return false;
	}
	public void propogate(Contestant[][] arr) {
		if(neighbors[0] != null) neighbors[0].neighbors[1] = neighbors[1];
		if(neighbors[1] != null) neighbors[1].neighbors[0] = neighbors[0];
		if(neighbors[2] != null) neighbors[2].neighbors[3] = neighbors[3];
		if(neighbors[3] != null) neighbors[3].neighbors[2] = neighbors[2];
	}
	
}