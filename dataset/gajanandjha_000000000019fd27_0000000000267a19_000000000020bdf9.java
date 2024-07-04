import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		Random r = new Random();
		for(int t = 1; t <= test; t++) {
			boolean[] C = new boolean[60*24];
			boolean[] J = new boolean[60*24];
			int N = Integer.parseInt(br.readLine().trim());
			Map<Integer, Character> map = new HashMap<Integer, Character>();
			boolean im = false;
			int[][] sten = new int[N][3];
			for(int i = 0; i < N; i++) {
				String[] spl = br.readLine().trim().split("\\s+");
				sten[i][0] = Integer.parseInt(spl[0]);
				sten[i][1] = Integer.parseInt(spl[1]);
				sten[i][2] = Integer.parseInt(spl[0] + "" + spl[1] + "" + r.nextInt(99));
			}
			int[][] sten1 = new int[N][3];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 3; j++) {
					sten1[i][j] = sten[i][j];
				}
			}
			bubbleSort(sten);
			for(int i = 0; i < N; i++) {
				boolean flag1 = false;
				for(int j = sten[i][0]; j < sten[i][1]; j++) {
					if(C[j]) {
						flag1 = true;
						break;
					}
				}
				if(flag1) {
					boolean flag2 = false;
					for(int k = sten[i][0]; k < sten[i][1]; k++) {
						if(J[k]) {
							flag2 = true;
							break;
						}
					}
					if(flag2) {
						im = true;
					} else {
						map.put(sten[i][2], 'J');
						for(int m = sten[i][0]; m < sten[i][1]; m++) {
							J[m] = true;
						}
					}
				} else {
					map.put(sten[i][2], 'C');
					for(int l = sten[i][0]; l < sten[i][1]; l++) {
						C[l] = true;
					}
				}
				if(im) {
					break;
				}
			}
			if(im) System.out.println("Case #" + t + ": IMPOSSIBLE");
			else {
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < N; i++) {
					sb.append(map.get(sten1[i][2]));
				}
				System.out.println("Case #" + t + ": " + sb.toString());
			}
		}
	}

	static void bubbleSort(int[][] arr) {
		int n = arr.length;
		int temp = 0;
		for(int i=0; i < n; i++) {
			for(int j=1; j < (n-i); j++) {
				if(arr[j-1][0] > arr[j][0]) {
					temp = arr[j-1][0];
					arr[j-1][0] = arr[j][0];
					arr[j][0] = temp;
					temp = arr[j-1][1];
					arr[j-1][1] = arr[j][1];
					arr[j][1] = temp;
					temp = arr[j-1][2];
					arr[j-1][2] = arr[j][2];
					arr[j][2] = temp;
				}

			}
		}
	}  
}
