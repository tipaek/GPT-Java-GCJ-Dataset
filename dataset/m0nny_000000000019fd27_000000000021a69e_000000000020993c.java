import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++){
			int n = sc.nextInt();
			int k=0; int r=0; int c = 0;
			int[][] m = new int[n][n];
			for(int j = 0; j < n; j++) {
				for(int l = 0; l < n; l++) {
					m[j][l] = sc.nextInt();
				}
			}
			for(int j = 0; j < n; j++) {
				k += m[j][j];
			}
			for(int j = 0; j < n; j++) {
				ArrayList<Integer> rList = new ArrayList<>();
				for(int l = 0; l < n; l++) {
					int cur = m[j][l];
					if(rList.contains(cur)) {
						r++;
						break;
					}
					else			rList.add(cur);
				}
			}
			for(int j = 0; j < n; j++) {
				ArrayList<Integer> cList = new ArrayList<>();
				for(int l = 0; l < n; l++) {
					int cur = m[l][j];
					if(cList.contains(cur)) {
						c++;
						break;
					}
					else			cList.add(cur);
				}
			}
			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
		}
	}
}