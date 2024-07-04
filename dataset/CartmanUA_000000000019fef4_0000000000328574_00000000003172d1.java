import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		int n;
		int d;
		for (int test=1; test<=tests;test++) {
			n = in.nextInt();
			d = in.nextInt();
			double[] slices = new double[n];
			for (int i=0; i<n; i++) {
				slices[i]=(double)in.nextLong();
			}
			print(test, slices, d);
		}
	}
	
	private static void print(int test, double[] slices, int d) {
		String answer="";
		int min_n = -1;
		int n;
		//System.out.println(Arrays.toString(slices));
		/*for (int i=0; i<slices.length; i++) {
			n = count(slices, slices[i], d);
			//System.out.println(slices[i] + " " + n);
			if (n == -1) continue;
			if (min_n == -1 || n < min_n) {
				min_n = n;
			}
			if (min_n==0) break;
		}
		if (min_n != -1) {
			answer = ""+min_n;
			System.out.println("Case #" + test +": "+answer);
			return;
		}*/
		for(int tries=1; tries<20;tries++) {
		    //if (tries == 4) continue;
			for (int i=0; i<slices.length; i++) {
				n = count(slices, slices[i]/(double)tries, d);
				if (n == -1) continue;
				if (min_n == -1 || n < min_n) {
					min_n = n;
				}
			}
		}
		if (min_n != -1) {
			answer = ""+min_n;
			System.out.println("Case #" + test +": "+answer);
			return;
		}
		/*for(int tries=20; tries<40;tries++) {
			for (int i=0; i<slices.length; i++) {
				n = count(slices, slices[i]/tries, d);
				if (n == -1) continue;
				if (min_n == -1 || n < min_n) {
					min_n = n;
				}
			}
		}
		if (min_n != -1) {
			answer = ""+min_n;
			System.out.println("Case #" + test +": "+answer);
			return;
		}*/
	}
	
	private static int count(double[] slices, double size, int d) {
		long[][] cuts = new long[slices.length][3];
		double[] eff = new double[slices.length]; 
		for (int i=0; i<cuts.length; i++) {
			cuts[i][0] = (int)slices[i];
			cuts[i][1] = 0;
			cuts[i][2] = 0;
			if (slices[i]<size) {
				continue;
			}
			cuts[i][1] = (long) (slices[i] / size);
			//System.out.println(slices[i] % size);
			if (slices[i] % size <= 0.000000000000001) {
				cuts[i][2] = cuts[i][1]-1;
			} else cuts[i][2] = cuts[i][1];
		}
		
		for (int i=0; i<cuts.length; i++) {
			if(cuts[i][1] == 0) {
				eff[i] = -1;
			} else {
				eff[i] = (double)cuts[i][2] / cuts[i][1];
			}
			//System.out.println(cuts[i][0] + " "+cuts[i][1] + " "+cuts[i][2] + " " + eff[i]);
		}
		
		int n_cuts=0;
		int pieces=0;
		while (pieces < d) {
			double min = -1.0;
			int min_n = -1;
			for(int i=0; i<eff.length; i++) {
				if (eff[i] != -1.0) {
					if (eff[i] < min || min == -1.0) {
						min = eff[i];
						min_n=i;
					}
				}
			}
			if (min_n == -1) return -1;
			eff[min_n] = -1.0;
			if (pieces + cuts[min_n][1] <= d) {
				pieces += cuts[min_n][1];
				n_cuts += cuts[min_n][2];
			} else {
				n_cuts+=(d-pieces);
				pieces = d;
			}
		}
		//System.out.println(n_cuts+" "+size);
		return n_cuts;
	}
}
