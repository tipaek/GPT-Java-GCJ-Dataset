import java.util.*;
import java.io.*;
class Solution {
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int n = sc.nextInt();
	while(n-->0){
		int trace=0;
		int a = sc.nextInt();
		int[][] b=new int[a][a];
		for(int i=0;i<a;i++)
			for(int j=0;j<a;j++)
				b[i][j]=sc.nextInt();
		int sR = 0;
		int sC = 0;

		for (int i = 0; i < a; i++) {
			Set<Integer> row = new HashSet<>();
			Set<Integer> col = new HashSet<>();
			for (int j = 0; j < a; j++) {
				row.add(b[i][j]);
				col.add(b[j][i]);
				if (i == j) {
					trace += b[i][j];
				}
			}
			if (row.size() < a) {
				sR++;
			}
			if (col.size() < a) {
				sC++;
			}
		}

		System.out.println(trace+" "+sR+" "+sC);
	}
	}
}
