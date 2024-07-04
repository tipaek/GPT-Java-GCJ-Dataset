import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			int s = Integer.parseInt(br.readLine());
			int[][] a = new int[s][s];
			for(int j = 0; j < s; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < s; k++) {
					a[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int k = countDiag(a);
			int r = countRows(a);
			int c = countCols(a);
			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
		}
	}
	
	public static int countDiag(int[][] a) {
		int answer = 0;
		for(int i = 0; i < a.length; i++) {
			answer += a[i][i];
		}
		return answer;
	}
	
	public static int countRows(int[][] a) {
		int answer = 0;
		for(int i = 0; i < a.length; i++) {
			HashSet<Integer> curr = new HashSet<>();
			for(int j = 0; j < a[0].length; j++) {
				curr.add(a[i][j]);
			}
			if(curr.size() < a.length) {
				answer++;
			}
		}
		return answer;
	}
	
	public static int countCols(int[][] a) {
		int answer = 0;
		for(int j = 0; j < a[0].length; j++) {
			HashSet<Integer> curr = new HashSet<>();
			for(int i = 0; i < a.length; i++) {
				curr.add(a[i][j]);
			}
			if(curr.size() < a.length) {
				answer++;
			}
		}
		return answer;
	}

}
