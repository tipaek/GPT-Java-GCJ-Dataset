import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numcases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numcases; i++) {
			int l = Integer.parseInt(br.readLine());
			int[][] arr = new int[l][l];
			for (int j = 0; j < l ; j++) {
				String[] dummy = br.readLine().split(" ");
				for (int k = 0; k < l; k++) {
					arr[j][k] = Integer.parseInt(dummy[k]);
				}
			}
			System.out.println("l: " + l);
			int sum = 0;
			int r = 0;
			int c = 0;
			int counter = 0;
			HashSet<Integer> set = new HashSet<>();
			HashSet<Integer> set2 = new HashSet<>();
			for (int j = 0; j < l; j++) {
				for (int k = 0; k < l; k++) {
					set.add(arr[j][k]);
					set2.add(arr[k][j]);
				}
				if (set.size() < l) {
					r++;
				}
				if (set2.size() < l) {
					c++;
				}
				sum += arr[j][counter];
				counter++;
				set.clear();
				set2.clear();
			}
			System.out.println("Case #" + (i+1) + ": " + sum + " " + r + " " + c);
		}
	}

}
