import java.util.ArrayList;
import java.util.Collections;
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
				ArrayList<Integer> sArrayList1=new ArrayList<Integer>();
				findCombinationsUtil(sArrayList1,dSize - 1, new int[trace - diagonal], 0,
						trace - diagonal, trace - diagonal);

				LinkedList<int[]> linkedList = new LinkedList<int[]>();

				for (int k = 0; k < 2500; k++) {
					linkedList.add(new int[1000]);
				}
				if (sArrayList.size() == 0 || sArrayList1 == null || sArrayList1.size() == 0) {
					System.out.println("Case #" + (i + 1) + ":" + " " + "IMPOSSIBLE");
				} else {
					for (int j = 0; j < dSize; j++) {

						int pos = 0;

						for (int j2 = 0; j2 < dSize; j2++) {

							if (j == j2) {
								arr[j][j2] = sArrayList.get(j);
							} else {

								if (linkedList.get(j2)[sArrayList1.get(pos)] == 0) {
									arr[j][j2] = sArrayList1.get(pos);
									int arp[] = linkedList.get(j2);
									arp[sArrayList1.get(pos)] += 1;
									linkedList.set(j2, arp);
									pos++;
									// arrr.remove(pos);
								} else {
									// pos++;
									// System.out.println(sArrayList1.get(pos) + "gndbfg");
									arr[j][j2] = sArrayList1.get(pos);

									int arp[] = linkedList.get(j2);
									arp[sArrayList1.get(pos)] += 1;
									linkedList.set(j2, arp);
									// arrr.remove(pos);
									pos++;
								}

							}
						}
						Collections.reverse(sArrayList1);
						
					}

				}

				
				  System.out.println("Case #" + (i + 1) + ":" + " " + "POSSIBLE"); for (int j =
				  0; j < dSize; j++) { for (int j2 = 0; j2 < dSize; j2++) {
				  System.out.print(arr[j][j2] + " "); } System.out.println(); }
				 

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

	static void findCombinationsUtil(ArrayList<Integer>arrayList,int dSize, int arr[], int index, int num, int reducedNum) {
// Base condition 
		if (reducedNum < 0)
			return;

// If combination is  
// found, print it 
		if (reducedNum == 0) {

			if (index == dSize) {
				for (int i = 0; i < index; i++) {
					for (int j = 0; j < index; j++) {
						if (i != j) {
							if (arr[i] != arr[j]) {
								System.out.print(arr[i] + " ");
								arrayList.add(arr[i]);
							}
						}
					}
				}
				System.out.println();
			}

			return;
		}

// Find the previous number  
// stored in arr[]. It helps  
// in maintaining increasing  
// order 
		int prev = (index == 0) ? 1 : arr[index - 1];

// note loop starts from  
// previous number i.e. at 
// array location index - 1 
		for (int k = prev; k <= num; k++) {
// next element of 
// array is k 
			arr[index] = k;

// call recursively with 
// reduced number 
			findCombinationsUtil(arrayList,dSize, arr, index + 1, num, reducedNum - k);
		}
		return;
	}
}
