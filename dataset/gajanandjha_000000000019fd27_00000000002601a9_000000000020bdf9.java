import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			boolean[] C = new boolean[60*24];
			boolean[] J = new boolean[60*24];
			int N = Integer.parseInt(br.readLine().trim());
			boolean im = false;
			int[][] sten = new int[N][2];
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				String[] spl = br.readLine().trim().split("\\s+");
				sten[i][0] = Integer.parseInt(spl[0]);
				sten[i][1] = Integer.parseInt(spl[1]);
			}
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
						sb.append("J");
						for(int m = sten[i][0]; m < sten[i][1]; m++) {
							J[m] = true;
						}
					}
				} else {
					sb.append("C");
					for(int l = sten[i][0]; l < sten[i][1]; l++) {
						C[l] = true;
					}
				}
				if(im) {
					break;
				}
			}
			if(im) System.out.println("Case #" + t + ": IMPOSSIBLE");
			else System.out.println("Case #" + t + ": " + sb.toString());
		}
	}
}
