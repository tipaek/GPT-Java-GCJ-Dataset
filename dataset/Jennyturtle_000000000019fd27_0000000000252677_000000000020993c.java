import java.util.Scanner;

public class Solution {
	static int s[][] = new int[110][110];
	static int mp[] = new int[110];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m;
		n = in.nextInt();
		for(int t = 1; t <= n; t++) {
			m = in.nextInt();
			int c = 0, r = 0;
			int sum = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < m; j++) {
					s[i][j] = in.nextInt();
				}
				sum += s[i][i];
			}
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < m; j++) {
					if(mp[s[i][j]] == 0) {
						mp[s[i][j]] = 1;
					} else if(mp[s[i][j]] == 1) {
						r++;
						break;
					}
				}
				for(int j = 0; j < m; j++) {
					mp[s[i][j]] = 0;
				}
			}
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < m; j++) {
					if(mp[s[j][i]] == 0) {
						mp[s[j][i]] = 1;
					} else if(mp[s[j][i]] == 1) {
						c++;
						break;
					}
				}
				for(int j = 0; j < m; j++) {
					mp[s[j][i]] = 0;
				}
			}
			System.out.println("Case #" + t + ": " + sum + " "
					+ r + " " + c);
		}
		in.close();
	}
}