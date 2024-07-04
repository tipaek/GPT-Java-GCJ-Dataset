
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ns = in.readLine();
		int n = Integer.parseInt(ns);
		for (int i = 0; i < n; i++) {
			String si = in.readLine();
			int size = Integer.parseInt(si);
			int[][] map = new int[size][size];
			for (int j = 0; j < size; j++) {
				String ss = in.readLine();
				String[] s = ss.split(" ");
				for (int k = 0; k < s.length; k++) {
					map[j][k] = Integer.parseInt(s[k]);
				}
			}
			int trace = trace(map);
			int rowoff = rows(map);
			int coloff = cols(map);
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowoff + " " + coloff);
		}
	}

	public static int rows(int[][] map) {
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < map[0].length; j++) {
				set.add(map[i][j]);
			}
			if(set.size() != map.length) {
				count++;
			}
		}	
		return count;
	}

	public static int cols(int[][] map) {
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < map[0].length; j++) {
				set.add(map[j][i]);
			}
			if(set.size() != map.length) {
				count++;
			}
		}	
		return count;
	}

	public static int trace(int[][] map) {
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (i == j) {
					sum += map[i][j];
				}
			}
		}
		return sum;
	}

}
