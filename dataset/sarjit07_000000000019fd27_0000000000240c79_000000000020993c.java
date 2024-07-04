import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int x = 0;
		while(x < t) {
			int n = in.nextInt();
			int a[][] = new int[n][n];
			for(int i =0;i <n;i++) {
				for (int j=0;j<n;j++) {
					a[i][j] = in.nextInt();
				}
			}
			int sum =0;
			int rowCount = 0;
			int colCount = 0;
			for(int i=0;i<n;i++)
				sum = sum + a[i][i];
			
			
			// computing rows
			int j =0;
			while(j<n) {
				HashSet<Integer> h = new HashSet();
				int count = 0;
				for(int i =0;i<n;i++) {
					if(h.contains(a[j][i])) {
						count = 1;
						break;
					}
					else if (!h.contains(a[j][i])) {
						h.add(a[j][i]);
					}
				}
				j = j+1;
				if (count == 1) {
					rowCount = rowCount+1;
				}

			}
			
			// computing columns
			int i =0;
			while(i<n) {
				HashSet<Integer> h = new HashSet();
				int count = 0;
				for(j =0;j<n;j++) {
					if(h.contains(a[j][i])) {
						count = 1;
						break;
					}
					else if (!h.contains(a[j][i])) {
						h.add(a[j][i]);
					}
				}
				i = i+1;
				if (count == 1) {
					colCount = colCount+1;
				}

			}
			
			System.out.println("Case #"+(x+1)+": "+sum+" "+rowCount+" "+colCount);
			x = x+1;
		}
	}

}
