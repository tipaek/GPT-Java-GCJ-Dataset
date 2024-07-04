
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {



	static class Input{
		int[] s;

		public Input(int[] s) {
			this.s = s;
		}

		@Override
		public String toString() {
			return "Input [s=" + Arrays.toString(s) + "]";
		}
	}


	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("./data/data1.in"));

		int T = Integer.parseInt(scan.nextLine());
		for (int ks = 1; ks <= T; ks++) {
			Input in = readInput(scan);
			String  sol = solve(in);
			//System.err.println(in);
			System.out.println("Case #"+ks+ ": "+sol);
		}
	}


	private static String solve(Input in) {
		String sol = "";
		int previous = 0;
		int nbOpen = 0;
		for(int i=0;i<in.s.length;i++) {
			if(in.s[i]>previous) {
				int diff = in.s[i] - previous;
				for(int k=0;k<diff;k++) sol+="(";
				sol+=in.s[i];
				nbOpen += diff;
			}
			if(in.s[i]==previous)
				sol+=in.s[i];
			if(in.s[i]<previous) {
				int diff = previous -in.s[i];
				for(int k=0;k<diff;k++) sol+=")";
				sol+=in.s[i];
				nbOpen -= diff;
			}
			previous = in.s[i];
		}
		for(int k=0;k<nbOpen;k++)
			sol+=")";
		return sol;
	}


	private static Input readInput(Scanner scan) {
		String sString = scan.nextLine();
		int[] s = new int[sString.length()];
		String[] tab = sString.split("");
		for(int i=0;i<s.length;i++) {
			s[i] = Integer.parseInt(tab[i]);

		}
		return new Input(s);
	}








}
