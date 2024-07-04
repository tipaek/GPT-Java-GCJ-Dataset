import java.util.*;

public class Solution {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": ");
			solve();
		}
	}
	static void solve() {
		int n = sc.nextInt();
		if(n <= 500) {
			for(int i = 1; i <= n; ++i) {
				System.out.println(i + " "+ 1);
			}
		}else {
			n -= 33;
			int left = 0;
			int lvl = 1;
			int cnt = 0;
			for(int i = 0; i < 32 ; ++i) {
				if(((1<<i) & n) != 0) {
					for(int j = lvl; j < i+1; ++j) {
						cnt++;
						if(left == 0) {
							System.out.println(j + " " + j);
						}else {
							System.out.println(j + " " + 1);
						}
					}
					lvl = i + 1;
					for(int j = 1; j <= lvl; ++j) {
						if(left == 0) {
							System.out.println(lvl + " " + (lvl-j+1));
						}else{
							System.out.println(lvl + " " + j);
						}
					}
					left = (left==0?1:0);
					lvl++;
				}
			}
			for(int i  = 0; i < 33 - cnt; ++i) {
				if(left == 0) {
					System.out.println(lvl + " " + (lvl++));
				}else {
					System.out.println((lvl++) + " " + 1);
				}
			}
		}
	}

}
