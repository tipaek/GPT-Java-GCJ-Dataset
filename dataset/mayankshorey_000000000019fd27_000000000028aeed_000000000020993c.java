import java.util.HashMap;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int tc=1;tc<=t;++tc) {
			int n = input.nextInt();
			int[][] arr = new int[n][n];
			int trace=0;
			int dupRow=0;
			int dupCol =0;
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					arr[i][j]=input.nextInt();
					if(i==j) {
						trace+=arr[i][j];
					}
				}
			}
			for(int i=0;i<n;++i) {
				HashMap<Integer,Boolean> map = new HashMap<>();
				for(int j=0;j<n;++j) {
					if(map.containsKey(arr[i][j])) {
						dupRow++;
						break;
					}
					map.put(arr[i][j],true);
				}
			}
			for(int i=0;i<n;++i) {
				HashMap<Integer,Boolean> map = new HashMap<>();
				for(int j=0;j<n;++j) {
					if(map.containsKey(arr[j][i])) {
						 dupCol++;
						break;
					}
					map.put(arr[j][i],true);
				}
			}
			System.out.println("Case #"+tc+": "+trace +" "+dupRow+" "+dupCol);
		}
	}

}
