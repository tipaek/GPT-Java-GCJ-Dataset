import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/*
 * Copyright 2019 Ibrahim All rights reserved.
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();

		for (int i = 0; i < testCase; i++) {
			int dSize = scanner.nextInt();
			int trace = scanner.nextInt();

			int arr[][] = new int[dSize][dSize];
			if (trace % dSize == 0) {
				int diagonal = trace / dSize;
				ArrayList<Integer> sArrayList = split(trace, dSize);

				int p = (trace - diagonal);
				int q = p / dSize;
				int z = q + diagonal;

				Random random = new Random();
				LinkedList<int[]> linkedList = new LinkedList<int[]>();

				for (int k = 0; k < 2500; k++) {
					linkedList.add(new int[1000]);
				}
				if (sArrayList.size() == 0) {
					System.out.println("Case #" + (i + 1) + ":" + " " + "IMPOSSIBLE");
				} else {
					for (int j = 0; j < dSize; j++) {
						ArrayList<Integer> arrr = new ArrayList<Integer>();
						arrr.add(q);
						arrr.add(z);
						
						for (int j2 = 0; j2 < dSize; j2++) {
							if (j == j2) {
								arr[j][j2] = sArrayList.get(j);
							} else {

								int pos = random.nextInt(arrr.size());
								if (linkedList.get(j2)[arrr.get(pos)] > 0) {
									pos = random.nextInt(arrr.size());
									arr[j][j2] = arrr.get(pos);

									linkedList.get(j2)[arrr.get(pos)] = 1;
									arrr.remove(pos);
								
								
								} else {
									arr[j][j2] = arrr.get(pos);

									linkedList.get(j2)[arrr.get(pos)] = 1;
									arrr.remove(pos);
								}

							}
						}
					}
					
				}
				System.out.println("Case #" + (i + 1) + ":" + " " + "POSSIBLE");
				for (int j = 0; j < dSize; j++) {
					for (int j2 = 0; j2 < dSize; j2++) {
						System.out.print(arr[j][j2]+" ");
					}
					System.out.println();
				}

			} else {
				System.out.println("Case #" + (i + 1) + ":" + " " + "IMPOSSIBLE");
			}
		}

	}

	static ArrayList<Integer> split(int x, int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (x < n) {
			System.out.print("-1 ");
			return list;
		} else if (x % n == 0) {
			for (int i = 0; i < n; i++) {
				list.add((x / n));
			}
		} else {
			int zp = n - (x % n);
			int pp = x / n;
			for (int i = 0; i < n; i++) {

				if (i >= zp) {
					list.add((pp + 1));
				}

				else {
					list.add(pp);
				}

			}
		}
		return list;
	}
}
