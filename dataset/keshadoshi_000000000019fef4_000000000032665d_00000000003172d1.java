import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int cases = 1; cases <= t; cases++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			long[] angle = new long[n];
			for (int i = 0; i < n; i++) {
				angle[i] = sc.nextLong();
			}
			if (n==1) {
				System.out.println("Case #" + cases + ": "+(d-1));
				continue;
			}
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					if (angle[i] > angle[j]) {
						long temp = angle[i];
						angle[i] = angle[j];
						angle[j] = temp;
					}
				}
			}
			int max_cut=Integer.MAX_VALUE;
			boolean found=false;
			for (int i = 0; i < n; i++) {
				int piece=1;
				int cut=0;
				int extra_cut = 0;
				int extra_piece=0;
				for (int j = i+1; j < n; j++) {
					if (angle[j] % angle[i] == 0) {
						piece += angle[j] / angle[i];
						cut += (angle[j] / angle[i]) - 1;
						if (piece == d || piece == d+1) {
							if (max_cut > cut) {
								max_cut = cut;
							}
							found=true;
							break;
						} else if (piece > d) {
							cut -= piece - d;
							if (max_cut > cut) {
								max_cut = cut;
							}
							found=true;
							break;
						}
					} else {
						extra_piece += angle[j] / angle[i];
						extra_cut += angle[j] / angle[i];
						if (piece + extra_piece == d || piece + extra_piece == d+1) {
							if (max_cut > cut + extra_cut) {
								max_cut = cut + extra_cut;
							}
							found=true;
							break;
						} else if (piece + extra_piece > d) {
							extra_cut -= piece + extra_piece - d;
							if (max_cut > cut + extra_cut) {
								max_cut = cut + extra_cut;
							}
							found=true;
							break;
						}
					}
					
				}
			}
			if (found) {
				System.out.println("Case #" + cases + ": "+ max_cut);
			} else {
				System.out.println("Case #" + cases + ": IMPOSSIBLE");
			}
		}
		sc.close();
	}
}