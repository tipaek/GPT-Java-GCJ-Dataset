
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
//		ArrayList<Integer> a1 = new ArrayList<>();
//		ArrayList<Integer> a2 = new ArrayList<>();
//		ArrayList<String> a3 = new ArrayList<>();
//		ArrayList<String> a4 = new ArrayList<>();
//		int i1, i2, i3, i4;
//		double d1, d2, d3, d4;
//		String s1, s2, s3, s4;
//		int[] ia1 = new int[];
//		int[] ia2 = new int[];
//		int[] ia3 = new int[];
//		String[] sa1 = new String[];
//		String[] sa2 = new String[];
//		String[] sa3 = new String[];
		
		int N = input.nextInt();

		
		for(int i = 0; i < N; i++) {
			int n = input.nextInt();
			input.nextLine();
			int[][] a = new int[n][n];
			for(int j = 0; j < n ; j++) {
				Scanner line = new Scanner(input.nextLine());
				for(int k = 0; k < n; k++) {
					a[j][k] = line.nextInt();
				}
			}
			int sum = 0;
			for(int j = 0; j < n ; j++) {
				sum += a[j][j];
			}
			
			int t = 0;
			for(int j = 0; j < n ; j++) {
				boolean b = false;
				for(int k = 0; k < n; k++) {
					for(int z = k+1; z < n; z++) {
						if(a[j][k] == a[j][z]) {
							b = true;
							t++;
							break;
						}
					}
					if(b) {
						break;
					}
				}
			}
			
			int d = 0;
			for(int k = 0; k < n ; k++) {
				for(int j = 0; j < n; j++) {
					for(int z = j+1; z < n; z++) {
						if(a[j][k] == a[z][k]) {
							d++;
							break;
						}
					}
				}
			}
			
			System.out.println("Case #" + (i+1) + ": " + sum +" "+ t+" "+d);
		}
		
		
		input.close();
	}
}
