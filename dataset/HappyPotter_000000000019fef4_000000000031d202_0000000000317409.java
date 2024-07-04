import java.io.*;
import java.util.*;

public class Solution {
	static int T, X, Y;
	static String M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		int[][] street = new int[2001][2001];
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				street[1000+i][1000+j] = i+j;
				street[1000+i][1000-j] = i+j;
				street[1000-i][1000+j] = i+j;
				street[1000-i][1000-j] = i+j;
			}
		}
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			X = 1000 + Integer.parseInt(st.nextToken());
			Y = 1000 + Integer.parseInt(st.nextToken());
			M = st.nextToken();
			
			int time = 0;
			boolean canPicture = false;
			
			for(int i=0; i<M.length(); i++) {
				time++;
				if(M.charAt(i) == 'S') {
					Y--;
					if(street[X][Y] <= time) {
						canPicture = true;
						break;
					}
				}
				else if(M.charAt(i) == 'N') {
					Y++;
					if(street[X][Y] <= time) {
						canPicture = true;
						break;
					}
				}
				else if(M.charAt(i) == 'E') {
					X++;
					if(street[X][Y] <= time) {
						canPicture = true;
						break;
					}
				}
				else if(M.charAt(i) == 'W') {
					X--;
					if(street[X][Y] <= time) {
						canPicture = true;
						break;
					}
				}
			}
			
			if(canPicture) System.out.println("Case #"+t+": "+time);
			else System.out.println("Case #"+t+": "+"IMPOSSIBLE");			
		}

	}

}
