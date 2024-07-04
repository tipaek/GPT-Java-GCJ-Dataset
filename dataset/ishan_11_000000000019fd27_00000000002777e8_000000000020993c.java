package javaprojectslabs;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		int test = m.nextInt();
		for (int i=0; i<test; i++) {
			int n= m.nextInt();
			int[][] arr = new int[n][n];
			for (int j=0; j<n;j++) {
				for (int z=0; z<n; z++) {
					arr[j][z] = m.nextInt();
				}
			}
			int trace = 0;
			for (int k=0; k<n; k++) {
				trace = trace + arr[k][k];
			}
			int row=0;
			int col=0;
			for (int q=0;q<n;q++) {
				boolean dup =false;
				for (int w=0; w<n;w++) {
					for (int e=w+1;e<n; e++) {
						if (arr[q][w]==arr[q][e])
							dup = true;
							//break;
					}
				}
				if (dup)
					row++;
			}
			for (int q=0;q<n;q++) {
				boolean dup =false;
				for (int w=0; w<n;w++) {
					for (int e=w+1;e<n;e++) {
						if (arr[w][q]==arr[e][q])
							dup = true;
							//break;
					}
				}
				if (dup)
					col++;
			}
			System.out.println("Case #" + (i + 1) + ": " + trace +" " + row + " " + col );
		}
	}

}
