import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int t=1;t<=test_case;t++) {
			int n = sc.nextInt();
			int tot = 0, c=0, r=0;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int[][] matrix = new int[n][n];
			for(int i=0;i<n;i++) {
				map.clear();
				for(int j=0;j<n;j++) {
					matrix[i][j] = sc.nextInt();
					if(i==j) tot += matrix[i][j];
					
				}
			}
			for(int i=0;i<n;i++) {
				map.clear();
				for(int j=0;j<n;j++) {
					if(map.containsKey(matrix[i][j])) {
						r++;
						break;
					}
					else map.put(matrix[i][j], 1);
				}
			}
			for(int i=0;i<n;i++) {
				map.clear();
				for(int j=0;j<n;j++) {
					if(map.containsKey(matrix[j][i])) {
						c++;
						break;
					}
					else map.put(matrix[j][i], 1);
				}
			}
			System.out.println("Case #"+t+": "+tot+" "+r+" "+c);
		}
		
	}
}
