import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int n1 = sc.nextInt();
			ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>(n1);
			ArrayList<ArrayList<Integer>> bList = new ArrayList<ArrayList<Integer>>(n1);
			int sum = 0;
			int nc = 0;
			int nr = 0;
			for (int j = 0; j < n1; j++) {
				ArrayList<Integer> z = new ArrayList<Integer>(n1);
				for (int k = 0; k < n1; k++) {
					int e = sc.nextInt();
					z.add(e);
				}
				aList.add(z);
			}
			for (int j = 0; j < n1; j++) {
				ArrayList<Integer> z = new ArrayList<Integer>(n1);
				for (int k = 0; k < n1; k++) {
					int e = aList.get(k).get(j);
					z.add(e);
				}
				bList.add(z);
			}
			for (int j = 0; j < n1; j++) {
				for (int k = 1; k <= n1; k++)
					if (!aList.get(j).contains(k)) {
						nc++;
						break;
					}
				for (int k = 1; k <= n1; k++)
					if (!bList.get(j).contains(k)) {
						nr++;
						break;
					}
				sum += aList.get(j).get(j);
			}
			System.out.println("Case #" + (i + 1) + ": " + sum + " " + nc + " " + nr);
		}
		sc.close();
	}
}