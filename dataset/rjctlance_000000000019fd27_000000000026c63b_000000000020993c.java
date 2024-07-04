import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static int[] process(int[][]m , int L) {
		
		int d = 0, mc = 0, mf = 0;
		
		for(int i=0; i<L; i++) {
			
			int[] fi = new int[L];
			for(int k=0;k<L;k++) { fi[k] = -1; }
			
			for(int j=0; j<L; j++) {
				if(i == j) { d+= m[i][j]; }
				fi[m[i][j]-1]++;
			}
			Arrays.sort(fi);
			int tmp = fi[L-1];
			if ( tmp>0 ) { mf++; }
		}
		
		for(int j=0; j<L; j++) {
			int[] co = new int[L];
			for(int k=0;k<L;k++) { co[k] = -1; }
			
			for(int i=0; i<L; i++) {
				co[m[i][j]-1]++;
			}
			Arrays.sort(co);
			int tmp = co[L-1];
			if ( tmp>0 ) { mc++; }
		}

		
		int[] rp = {d,mf, mc};
		return rp;
	}
	
	public static void main(String[] args) throws IOException {
		
		//Scanner in = new Scanner(new File(filename));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		String text = in.next();
		int N = Integer.parseInt(text);

		for (int i = 0; i < N; i++) {

			text = in.next();
			int num = Integer.parseInt(text);
			int[][] mxt = new int[num][num];
			
			for(int j=0; j<num; j++) {
				for (int k=0; k<num; k++) {
					text = in.next();
					int tm = Integer.parseInt(text);
					mxt[j][k] = tm; 
				}
			}
			
			int[] outRes = process(mxt, num);
			
			System.out.println("Case #"+(i+1)+": " + outRes[0] + " " + outRes[1] + " " + outRes[2]);
		}
		in.close();
	}
}
