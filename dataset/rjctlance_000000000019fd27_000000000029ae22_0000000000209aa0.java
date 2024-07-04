import java.io.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
	public static int[][] process(int nz, int sum) {
		int start = -1;
		if(sum%nz == 0) {
			start = sum/nz-1;
		}else
		{
			return null;
		}
		int[][] bo = new int[nz][nz];
		int k=start;
		
		for(int i=0; i<nz; i++) {
			for(int j=0;j<nz;j++) {
				bo[i][j] = (k%nz+1);
				k++;
			}
			k--;
		}
		
		int d = 0;
		for(int i=0; i<nz; i++) {
			for(int j=0;j<nz;j++) {
				if(i == j) { d+= bo[i][j]; }
			}
		}
		
		if(d == sum) {
			return bo;
		}
		
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		String text = in.next();
		int N = Integer.parseInt(text);

		for (int i = 0; i < N; i++) {

			text = in.next();
			int nz = Integer.parseInt(text);
			
			text = in.next();
			int sum = Integer.parseInt(text);
			
			int[][] outRes = process(nz, sum);
			
			if(outRes != null) { 
				System.out.println("Case #"+(i+1)+": POSSIBLE");
				for(int k=0;k<nz;k++) {
					for(int l=0;l<nz;l++) {
						System.out.print(outRes[k][l] + " ");
					}
					System.out.print("\n");
				}
			}else{
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
		}
		in.close();
	}
}
