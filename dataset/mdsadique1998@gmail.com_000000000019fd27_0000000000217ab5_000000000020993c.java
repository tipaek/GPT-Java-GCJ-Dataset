import java.util.HashMap;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int a = 1;
		while(a<=t) {
			int n = scn.nextInt();
			int trace = 0;
			int arr[][] = new int[n][n];
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					arr[i][j] = scn.nextInt();
					if(i==j) {
						trace +=arr[i][j];
					}
				}
			}
			int r =0;
			for(int i = 0;i<n;i++) {
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int j = 0;j<n;j++) {
					if(map.containsKey(arr[i][j])) {
						r++;
						break;
					}else {
						map.put(arr[i][j], 1);
					}
				}
				map.clear();
			}
			
			int c =0;
			for(int i = 0;i<n;i++) {
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int j = 0;j<n;j++) {
					if(map.containsKey(arr[j][i])) {
						c++;
						break;
					}else {
						map.put(arr[j][i], 1);
					}
				}
				map.clear();
			}
			
			System.out.println("Case "+a+": "+trace+" "+r+" "+c);
			a++;
		}

	}

}
