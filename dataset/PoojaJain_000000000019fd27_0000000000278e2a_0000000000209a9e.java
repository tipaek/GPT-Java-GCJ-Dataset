
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int noOfTestCases = in.nextInt();
		int sizeOfArray = in.nextInt();

		for (int i = 0; i < noOfTestCases; i++) {

			if (sizeOfArray == 10) {
				int j = 1;
				StringBuilder s = new StringBuilder();
				for (int trial = 1; trial <= 150; trial++) {
					if (j > sizeOfArray) {
						break;
					}
					/*
					 * if (trial % 10 == 1) { System.out.println(sizeOfArray);
					 * System.out.flush(); String judgeReponse = in.next(); if
					 * (judgeReponse.equals("N")) { System.exit(0); } } else {
					 */
					System.out.println(j);
					System.out.flush();
					String judgeReponse = in.next();
					if (judgeReponse.equals("N")) {
						System.exit(0);
					} else {
						s.append(judgeReponse);
					}

					j++;
					// }

				}

				System.out.println(s);
				System.out.flush();
				String judgeReponse = in.next();
				if (judgeReponse.equals("Y")) {
					continue;
				} else {
					System.exit(0);
				}

			} else if (sizeOfArray == 20) {

				int[] ans = new int[sizeOfArray];

				for (int a = 1, b = sizeOfArray; a <= 5; a++, b--) {
					System.out.println(a);
					System.out.flush();
					ans[a - 1] = Integer.parseInt(in.next());
					System.out.println(b);
					System.out.flush();
					ans[b - 1] = Integer.parseInt(in.next());
				}

				ans = arrayAfterFluctuation(in, sizeOfArray, ans,null);

				for (int a = 6; a <= 10; a++) {
					System.out.println(a);
					System.out.flush();
					ans[a - 1] = Integer.parseInt(in.next());
				}
				StringBuilder reverse = new StringBuilder ("0");
				ans = arrayAfterFluctuation(in, sizeOfArray, ans,reverse);

				if (reverse.toString().equals("1")) {
					for (int a = 6; a <= 10; a++) {
						System.out.println(a);
						System.out.flush();
						ans[a - 1] = Integer.parseInt(in.next());
					}
				} else {
					for (int a = 11; a <= 15; a++) {
						System.out.println(a);
						System.out.flush();
						ans[a - 1] = Integer.parseInt(in.next());
					}
				}
				
				String esab = Arrays.toString(ans);
				esab= esab.replace(", ", "");
				esab= esab.replace("[", "");
				esab= esab.replace("]", "");
				System.out.println(esab);
				System.out.flush();
				String judgeReponse = in.next();
				if (judgeReponse.equals("Y")) {
					continue;
				} else {
					System.exit(0);
				}

			}

		}

		in.close();

	}

	private static int[] arrayAfterFluctuation(Scanner in, int sizeOfArray, int[] ans,StringBuilder reverse) {
		int temp = sizeOfArray;
		int[] tempArray = new int[5];
		for (int a = temp; a > 15; a--) {
			System.out.println(temp);
			System.out.flush();
			tempArray[a - 16] = Integer.parseInt(in.next());
			temp--;
		}
		if (equal(ans, tempArray, sizeOfArray)) {

		} else if (reverse(ans, tempArray)) {
			int temp1[] = new int[sizeOfArray];
			int l = sizeOfArray;
			for (int t = 0; t < sizeOfArray; t++) {
				temp1[t] = ans[l - 1];
				l--;
			}
			ans = temp1;
			if(reverse != null){
			reverse.delete(0, 1);
			reverse.append("1");}

		} else if (complement(ans, tempArray, sizeOfArray)) {

			for (int t = 0; t < sizeOfArray; t++) {
				if (ans[t] == 0) {
					ans[t] = 1;
				}else if (ans[t] == 1) {
					ans[t] = 0;
				}
			}
		} else if (complementReverse(ans, tempArray)) {
			for (int t = 0; t < sizeOfArray; t++) {
				if (ans[t] == 0) {
					ans[t] = 1;
				}else if (ans[t] == 1) {
					ans[t] = 0;
				}
			}
			int temp1[] = new int[sizeOfArray];
			int l = sizeOfArray;
			for (int t = 0; t < sizeOfArray; t++) {
				temp1[t] = ans[l - 1];
				l--;
			}
			ans = temp1;
			if(reverse != null){
				reverse.delete(0, 1);
				reverse.append("1");}
		}
		return ans;
	}

	public static boolean equal(int[] ans, int[] temp, int sizeOfArray) {

		boolean answer = true;

		for (int p = 4; p >= 0; p--) {
			if (ans[sizeOfArray - 1] != temp[p]) {
				answer = false;
				break;
			}
			sizeOfArray--;
		}

		return answer;
	}

	public static boolean reverse(int[] ans, int[] temp) {

		boolean answer = true;

		for (int p = 4, q = 0; p >= 0; p--, q++) {
			if (ans[q] != temp[p]) {
				answer = false;
				break;
			}
		}

		return answer;
	}

	public static boolean complement(int[] ans, int[] temp, int sizeOfArray) {

		boolean answer = true;

		for (int p = 4; p >= 0; p--) {
			if ((ans[sizeOfArray - 1] == 1 && temp[p] != 0) || (ans[sizeOfArray - 1] == 0 && temp[p] != 1)) {
				answer = false;
				break;
			}
			sizeOfArray--;
		}

		return answer;
	}

	public static boolean complementReverse(int[] ans, int[] temp) {

		boolean answer = true;

		for (int p = 4, q = 0; p >= 0; p--, q++) {
			if ((ans[q] == 1 && temp[p] != 0) || (ans[q] == 0 && temp[p] != 1)) {
				answer = false;
				break;
			}
		}

		return answer;
	}
	// 0001101111
}
