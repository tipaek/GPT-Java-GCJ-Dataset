import java.util.*;
import java.lang.*;
import java.io.*;

public class testing{
	public static void main(String args[]){
		Scanner stdin = new Scanner(System.in);
		int t, i, n, row, col, trace, j, k;
		int[][] matrix;
		HashSet<Integer> r, c;
		r = new HashSet<Integer>();
		c = new HashSet<>();
		t = stdin.nextInt();
		for(i=0;i<t;i++){
			n = stdin.nextInt();
			matrix = new int[n][n];

			for(j=0;j<n;j++)
				for(k=0;k<n;k++)
					matrix[j][k] = stdin.nextInt();

			trace = 0;
			for(j=0;j<n;j++){
				trace = trace + matrix[j][j];
			}

			row=0;
			col = 0;
			for(j=0;j<n;j++){
				r.clear();
				for(k=0;k<n;k++){
					if(r.contains(matrix[j][k])){
						row++;
						break;
					}
					r.add(matrix[j][k]);
				}
			}

			for(j=0;j<n;j++){
				c.clear();
				for(k=0;k<n;k++){
					if(c.contains(matrix[k][j])){
						col++;
						break;
					}
					c.add(matrix[k][j]);
				}
			}

			

			System.out.printf("Case #%d: %d %d %d\n", i+1, trace, row, col);
		}
	}
}