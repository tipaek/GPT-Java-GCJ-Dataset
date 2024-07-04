import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int     t  = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if ((k % n) != 0) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + i + ": POSSIBLE");
				int           num  = k / n;
				List<Integer> list = new ArrayList<Integer>();
				list.add(num);
				for (int j = 1; j <= n; j++) {
					if (j != num) {
						list.add(j);
					}
				}
				for (int j = 1; j <= n; j++) {
					for (int l = 0; l < n; l++) {
						System.out.print(list.get(l));
						if(l!=(n-1)) {
							System.out.print(" ");
						}
					}
					System.out.println();
					Collections.rotate(list, 1);
				}

			}
		}
		sc.close();
	}

}
