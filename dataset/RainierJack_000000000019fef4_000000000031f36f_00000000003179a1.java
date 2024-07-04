import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	public static class Freq {
		char c;
		int cpt;
		public Freq (char c) {
			this.c = c;
			cpt = -1;
		}
	}
	public static class FreqComparator implements Comparator<Freq> {

		@Override
		public int compare(Freq arg0, Freq arg1) {
			return arg0.cpt-arg1.cpt;
		}
		
	}

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int U = in.nextInt();
			int size = 10000;
			long[] Q = new long[size];
			String[] R = new String[size];
			for (int i=0; i<size; i++) {
				Q[i] = in.nextLong();
				R[i] = in.next();
			}

			@SuppressWarnings("unused")
			long MAX = (long) Math.pow(10, U);
	
			Freq[] l2d = new Freq[26];
			for (int i=0; i<26; i++) {
				l2d[i] = new Freq((char) ('A'+i));
			}
			char[] D = new char[10];
			
			// identify letters
			int found = 0;
			int i=0, j=0;
			while (found <10) {
				char c = R[i].charAt(j);
				if (l2d[c-'A'].cpt == -1) {
					l2d[c-'A'].cpt++;
					found++;
				}
				j++;
				if (j == R[i].length()) {
					i++;
					j=0;
				}
			}
			
			for (i=0; i<size; i++) {
				char c = R[i].charAt(0);
				l2d[c-'A'].cpt++;
			}			
			Arrays.sort(l2d, new FreqComparator());
			
			int cur = 9;
			for (i=0; i<26; i++) {
				if (l2d[i].cpt == -1)
					continue;
				if (l2d[i].cpt == 0)
					D[0] = l2d[i].c;
				else {
					D[cur] = l2d[i].c;
					cur--;
				}
			}
			
			String res = String.valueOf(D);
			out.println(String.format("Case #%d: %s", t+1, res));
		}
		
		in.close();
	}

}
