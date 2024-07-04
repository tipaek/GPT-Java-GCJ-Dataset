import java.util.Arrays;
import java.util.Scanner;

/*

Every qturn, they can independently choose to flip equal pairs, and choose to flip non-equal pairs
if we keep both counts, we know
 */
public class Solution {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=1;t<=T;t++) {
			int n = in.nextInt();
//			int[] mock = new int[n];
//			for (int i=0;i<n;i++) {
//				mock[i] = Math.random() < .5 ? 1 : 0;
//			}
			Env e = new Env(n, null);
			int[] ans = e.solve();
			System.out.printf("Case #%d: ", t);
			for (int i=0;i<n;i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
		}
	}
	
	static class Env {
		int n, QC = 0;
		int[] mockArr;
		public Env(int n, int[] mockArr) {
			this.n = n;
			this.mockArr = mockArr;
		}
		
		int equalCache = -1, nonEqualCache = -1;
		void clearCache() {
			equalCache = -1;
			nonEqualCache = -1;
		}
		public int[] solve() {
			boolean[] equal = new boolean[n/2];
			int[] base = new int[n/2];
			
			int firstEqual = -1, firstNonEqual = -1;

			for (int i=0;i<n/2;i++) {
				if (QC % 10 == 9) {
					poll(0);
				}
				if (QC % 10 == 0) {
					clearCache();
				}
				base[i] = poll(i);
				equal[i] = base[i] == poll(n-1-i);
				if (equal[i]) {
					if (firstEqual == -1) {
						firstEqual = i;
					} else {
						if (QC % 10 == 0 && equalCache == -1) {
							base[i] = poll(i);
						}
						int poll = equalCache == -1 ? poll(firstEqual) : equalCache;
						equalCache = poll;
						int flips = poll ^ base[firstEqual];
						base[i] ^= flips;
					}
				} else {
					if (firstNonEqual == -1) {
						firstNonEqual = i;
					} else {
						if (QC % 10 == 0 && nonEqualCache == -1) {
							base[i] = poll(i);
						}
						int poll = nonEqualCache == -1 ? poll(firstNonEqual) : nonEqualCache;
						nonEqualCache = poll;
						int flips = poll ^ base[firstNonEqual];
						base[i] ^= flips;
					}
				}
			}
			
			while(QC % 10 >= 8) { /// 9?
				poll(0);
			}
			
			int equalFlips = 0, nonEqualFlips = 0;
			if (firstEqual != -1) {
				equalFlips = poll(firstEqual) ^ base[firstEqual];
			}
			if (firstNonEqual != -1) {
				nonEqualFlips = poll(firstNonEqual) ^ base[firstNonEqual];
			}
			
			int[] ans = new int[n];
			for (int i=0;i<n/2;i++) {
				if (equal[i]) {
					ans[i] = base[i] ^ equalFlips;
					ans[n-1-i] = ans[i];
				} else {
					ans[i] = base[i] ^ nonEqualFlips;
					ans[n-1-i] = 1- ans[i];
				}
			}
			return ans;
		}
		int poll(int qi) {
			if(mockArr != null) {
				if (QC % 10 == 0) {
					boolean swap = Math.random() < .5;
					boolean neg = Math.random() < .5;
					if (neg) {
						for(int x=0;x<n;x++) {
							mockArr[x] = 1-mockArr[x];
						}
					}
					if (swap) {
						for(int x=0;x<n/2;x++) {
							int a = mockArr[x];
							mockArr[x] = mockArr[n-1-x];
							mockArr[n-1-x] = a;
						}
					}
				}
				QC++;
				return mockArr[qi];
			}
			QC++;
			System.out.println(qi+1);
			System.out.flush();
			return in.nextInt();
		}
	}
}
