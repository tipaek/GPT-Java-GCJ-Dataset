import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		for (int i = 0; i < n; i++) {
	
			int k = in.nextInt();
			String ar[] = new String[k];
			String lar = new String();
			String input = new String();
			for (int j = 0; j < k; j++) {
				input = in.next();
				ar[j] = input.substring(1);
				if (j == 0) {
					lar = ar[j];
				} else {
					if (lar.length() < ar[j].length()) {
						lar = ar[j];
					}
				}
			}
			int count = 0;
			for (int j = 0; j < k; j++) {

				if (lar.contains(ar[j])) {
					count++;
				}
			}
			if (count == k) {
				System.out.println("Case #" + (i+1) + ": "+lar);

			} else {
				System.out.println("Case #" + (i+1) + ": *");
			}


		}
	}
}
