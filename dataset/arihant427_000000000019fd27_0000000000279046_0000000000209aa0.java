import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) {
		int t;
		Scanner scn = new Scanner(System.in);
		t = scn.nextInt();
		int input[][] = new int[t][2];
		for (int i = 1; i <= t; i++) {
			input[i - 1][0] = scn.nextInt();
			input[i - 1][1] = scn.nextInt();
		}
		for (int i = 1; i <= t; i++) {
			int n = input[i - 1][0];
			int m = input[i - 1][1];
			if (m < n) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else if (n * n < m) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				int[][] finalArr = new int[n][n];
				int num = m / n;
				if (num * n == m) {
					for (int j = 0; j < n; j++) {
						finalArr[j][j] = num;
					}
				} else {
					int h = m - (num * n);
					if (h <= (n - num)) {
						for (int j = 0; j < n; j++) {
							finalArr[j][j] = num;
						}
						finalArr[0][0] = num + h;
					} else {
						for (int j = 0; j < n; j++) {
							if (h == 0)
								finalArr[j][j] = num;
							else {
								finalArr[j][j] = num + 1;
								h = --h;
							}
						}
					}
				}
				Set s = new HashSet();
				for (int j = 0; j < n; j++) {
					s.add(finalArr[j][j]);
				}
				if (s.size() != 1 && (n - s.size() + 1) >= (n % 2 == 0 ? n / 2 : n / 2 + 1)) {
					System.out.println("Case #" + i + ": IMPOSSIBLE");
				} else {

					for (int j = 0; j < n; j++) {
						for (int j2 = n - 1; j2 >= 0; j2--) {
							if (j == j2) {
								continue;
							}
							List<String> list = new ArrayList<>();
							for (int k = 0; k < n; k++) {
								list.add(String.valueOf(k + 1));
							}
							for (int k = 0; k < n; k++) {
								// if(k == j2)continue;
								if (list.contains(String.valueOf(finalArr[j][k]))) {
									list.remove(String.valueOf(finalArr[j][k]));
								} // doubt
							}
							for (int k = 0; k < n; k++) {
								// if(k == j2)continue;
								if (list.contains(String.valueOf(finalArr[k][j2]))) {
									list.remove(String.valueOf(finalArr[k][j2]));
								} // doubt
							}
							if (list.size() == 0) {
								System.out.println("Case #" + i + ": IMPOSSIBLE");
								System.exit(0);
							} else {

								/*for (int k = 0; k < finalArr.length; k++) {
									for (int k2 = 0; k2 < finalArr.length; k2++) {
										if (list.contains(finalArr[k][k2])) {
											finalArr[j][j2] = finalArr[k][k2];
										}
									}
								}*/
									if(!(j<1) && !(j2<1) && finalArr[j-1][j2-1] !=0){
										finalArr[j][j2] = finalArr[j-1][j2-1];
									}else
									finalArr[j][j2] = Integer.parseInt(list.get(0));
								
							}

						}

					}
System.out.println("Case #" + i + ": POSSIBLE");
					for (int i3 = 0; i3 < n; i3++) {
						for (int i2 = 0; i2 < n; i2++) {
							System.out.print(finalArr[i3][i2] + " ");
						}
						System.out.println();
					}
					
				}


			}

		}
	}

}
