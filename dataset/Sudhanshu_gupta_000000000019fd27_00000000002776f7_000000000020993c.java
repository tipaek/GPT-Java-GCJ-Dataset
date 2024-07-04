import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	
public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		int kk = 1;
		while(tc -- > 0) {
			
			int n = Integer.parseInt(br.readLine().trim());
					
			int arr[][] = new int[n][n];
			boolean inc[] = new boolean[n+1];
			boolean is[] = new boolean[n+1];
			int c = 0, r = 0, k = 0;
			
			for(int i = 0; i < n; i++) {
				String str[] = br.readLine().split(" ");
				
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
					
					if(!is[i] && inc[arr[i][j]]) {
						is[i] = true;
						r++;
					}
					inc[arr[i][j]] = true;
				}
				Arrays.fill(inc, false);
			}
			
			Arrays.fill(inc, false);
			Arrays.fill(is, false);
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {				
					
					if(!is[i] && inc[arr[j][i]]) {
						is[i] = true;
						c++;
					}
					inc[arr[j][i]] = true;
					
					if(i == j)
						k += arr[i][j];
				}
				Arrays.fill(inc, false);
			}
			
			System.out.println(String.format("Case #%d: %d %d %d", kk, k, r, c));
			kk++;
			
		}
	}

}
