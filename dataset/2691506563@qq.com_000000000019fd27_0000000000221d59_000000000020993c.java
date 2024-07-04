import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int num=sca.nextInt();
		for (int q = 0; q < num; q++) {
			int n = sca.nextInt();
			int[][] array = new int[n][n];
			int c = 0, r = 0, k = 0;
			for (int i = 0; i < n; i++) {
				HashSet<Integer> cur = new HashSet<Integer>();
				boolean isRepeat = false;
				for (int j = 0; j < n; j++) {
					array[i][j] = sca.nextInt();
					if (i == j) {
						k += array[i][j];
					}
					if (!isRepeat) {
						if (cur.contains(array[i][j])) {
							isRepeat = true;
							r++;
						} else {
							cur.add(array[i][j]);
						}
					}
				}
			}
			for(int j=0;j<n;j++) {
				HashSet<Integer> cur = new HashSet<Integer>();
				boolean isRepeat = false;
				for(int i=0;i<n;i++) {
					if (!isRepeat) {
						if (cur.contains(array[i][j])) {
							isRepeat = true;
							c++;
						} else {
							cur.add(array[i][j]);
						}
					}else {
						break;
					}
				}
			}
			System.out.println("Case #"+(q+1)+": "+k+" "+r+" "+c);
		}
		
	}
}