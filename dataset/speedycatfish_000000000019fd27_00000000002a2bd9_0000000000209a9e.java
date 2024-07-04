import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufread.readLine());
		int t = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());
		for (int counter = 0; counter < t; counter++) {
			int baseSame = 0;
			int baseDifferent = 0;
			boolean sameFlip = false;
			boolean differentFlip = false;
			boolean[] database = new boolean[size / 2 + 1];
			ArrayDeque<Integer> sameIndices = new ArrayDeque<>();
			ArrayDeque<Integer> differentIndices = new ArrayDeque<>();
			int reqNum = 1;
			for (int i = 1; i <= size / 2; i++) {
				if (reqNum % 10 == 1 && baseSame != 0) {
					System.out.println(baseSame);
					sameFlip = Integer.parseInt(bufread.readLine()) == 1;
					reqNum++;
					i--;
					continue;
				}
				if (reqNum % 10 == 1 && baseDifferent != 0) {
					System.out.println(baseDifferent);
					differentFlip = Integer.parseInt(bufread.readLine()) == 1;
					reqNum++;
					i--;
					continue;
				}
				if (reqNum % 10 == 2 && baseDifferent != 0) {
					System.out.println(baseDifferent);
					differentFlip = Integer.parseInt(bufread.readLine()) == 1;
					reqNum++;
					i--;
					continue;
				}
				if (reqNum % 10 == 2 && baseSame != 0) {
					System.out.println(baseSame);
					sameFlip = Integer.parseInt(bufread.readLine()) == 1;
					reqNum++;
					i--;
					continue;
				}
				System.out.println(i);
				int b1 = Integer.parseInt(bufread.readLine());
				System.out.println(size - i + 1);
				int b2 = Integer.parseInt(bufread.readLine());
				if (b1 == b2) {
					if (baseSame == 0) {
						baseSame = i;
						if (b1 == 1) {
							sameFlip = true;
						}
					} else {
						sameIndices.add(i);
						database[i] = (b1 == 1) ^ sameFlip;
					}
				} else {
					if (baseDifferent == 0) {
						baseDifferent = i;
						if (b1 == 1) {
							differentFlip = true;
						}
					} else {
						differentIndices.add(i);
						database[i] = (b1 == 1) ^ differentFlip;
					}
				}
				reqNum += 2;
			}
			boolean[] fullDatabase = new boolean[size + 1];
			if (baseSame != 0) {
				fullDatabase[baseSame] = sameFlip;
				fullDatabase[size - baseSame + 1] = sameFlip;
			}
			if (baseDifferent != 0) {
				fullDatabase[baseDifferent] = differentFlip;
				fullDatabase[size - baseDifferent + 1] = differentFlip ^ true;
			}
			for (int sameIndex : sameIndices) {
				fullDatabase[sameIndex] = database[sameIndex] ^ sameFlip;
				fullDatabase[size - sameIndex + 1] = fullDatabase[sameIndex];
			}
			for (int differentIndex : differentIndices) {
				fullDatabase[differentIndex] = database[differentIndex] ^ differentFlip;
				fullDatabase[size - differentIndex + 1] = fullDatabase[differentIndex] ^ true;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= size; i++) {
				if (fullDatabase[i] == true) {
					sb.append("1");
				} else {
					sb.append("0");
				}
			}
			System.out.println(sb.toString());
			String result = bufread.readLine();
			if (result.equals("N")) {
				break;
			}
		}
		bufread.close();
	}

}
