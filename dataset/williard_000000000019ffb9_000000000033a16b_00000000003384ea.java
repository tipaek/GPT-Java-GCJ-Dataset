import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int casenum = 1; casenum <= T; casenum++) {
			int L = sc.nextInt();
			int R = sc.nextInt();
			int served = 0;
			for (int i = 1; i <= 1000; i++) {
				if (L >= R) {
					if (L >= i) {
						served = i;
						L -= i;
					}
					else
						break;
				}
				else {
					if (R >= i) {
						served = i;
						R -= i;
					}
					else
						break;
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", casenum, served, L, R);
		}
	}
}
