

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {

			Scanner in = new Scanner(System.in);
			int t = in.nextInt();
			for (int a = 1; a <= t; a++) {
				int x = in.nextInt();
				String s = "";
				int[] arr = new int[x];
				int[] arr2 = new int[x];
				
				Set<Double> set = new HashSet<Double>();
				Set<Double> set2 = new HashSet<Double>();
				boolean test = false;
//reading data
				for (int i = 0; i < x; i++) {
					arr[i] = in.nextInt();
					arr2[i] = in.nextInt();
				}
				//comparing data
				for (int i = 0; i < x; i++) {
					boolean s1 = false;
					boolean s2 = false;
					for (Double c = (double)arr[i]; c <= arr2[i]; c+= 0.5) {

						if (set.contains(c) == false) {
						} else if (set2.contains(c) == false) {
							s1 = true;
						} else {
							s1 = true;
							s2 = true;
						}
					}
				//adding data
					if (s1 == false && s2 == false) {
						set.add(arr[i]+0.1);
						set.add(arr2[i]-0.1);
						for (Double g = (double)arr[i]+0.5; g < arr2[i]; g+=0.5) {
							set.add(g);
							
						}
						s = s + "J";
					} else if (s1 == true && s2 == false) {
						set2.add(arr[i]+0.1);
						set2.add(arr2[i]-0.1);
						for (Double g = (double)arr[i]+0.5; g < arr2[i]; g+=0.5) {
							set2.add(g);

						}

						s = s + "C";
					} else {
						System.out.println("Case #" + a + ": IMPOSSIBLE");
						test = true;
						break;
					}
				}
				if (test == false) {
					System.out.println("Case #" + a + ": " + s);
				}
			}
	}
}
