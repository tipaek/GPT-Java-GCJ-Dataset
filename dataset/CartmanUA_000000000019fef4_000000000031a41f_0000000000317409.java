import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		int x;
		int y;
		int[][] arr;
		String path;
		for (int test=1; test<=tests;test++) {
			x = in.nextInt();
			y = in.nextInt();
			path = in.next();
			arr = new int[path.length()+1][2];
			arr[0][0] = x;
			arr[0][1] = y;
			for (int i=1; i<arr.length; i++) {
				if (path.charAt(i-1)=='W') {
					arr[i][0] = arr[i-1][0]-1;
					arr[i][1] = arr[i-1][1];
				} else if (path.charAt(i-1)=='E') {
					arr[i][0] = arr[i-1][0]+1;
					arr[i][1] = arr[i-1][1];
				} else if (path.charAt(i-1)=='N') {
					arr[i][0] = arr[i-1][0];
					arr[i][1] = arr[i-1][1]+1;
				} else if (path.charAt(i-1)=='S') {
					arr[i][0] = arr[i-1][0];
					arr[i][1] = arr[i-1][1]-1;
				}
			}
			print(test, arr);
		}
	}
	
	private static void print(int test, int[][] arr) {
		String answer="IMPOSSIBLE";
		for (int i=0; i<arr.length; i++) {
			if (Math.abs(arr[i][0])+Math.abs(arr[i][1]) <= i) {
				answer = ""+i;
				break;
			}
		}
		System.out.println("Case #" + test +": "+answer);
	}
}
