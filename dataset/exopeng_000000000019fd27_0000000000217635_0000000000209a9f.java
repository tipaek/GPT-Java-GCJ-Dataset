import java.io.*;
import java.util.*;



public class Solution {
	public static void main(String[] args) throws IOException {
		//get input separately
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer s = new StringTokenizer(b.readLine());
		int cases = Integer.parseInt(s.nextToken());
		//store the answers in an int array
		for (int i = 0; i < cases; i++) {
			s = new StringTokenizer(b.readLine());
			String fin = s.nextToken();
			String pa = "";
			String pas = "";
			for (int j = 0; j < fin.length(); j++) {
				pa = "";
				pas = "";
				if (fin.substring(j, j + 1).equals(")")) {
					break;
				}
 				int mes = Integer.parseInt(fin.substring(j, j + 1));
				int initial = j;
				//System.out.println(mes);
				for (int f = 0; f < mes; f++) {
					pa += "(";
					pas += ")";
				}
				//System.out.println(pa + pas);
				while (Integer.parseInt(fin.substring(j, j + 1)) == mes) {
					j++;
					if (j == fin.length()) {
						break;
					}
				}
				j--;
				//System.out.println(j);
				int len = initial + pa.length() + j - initial + pas.length();
				fin = fin.substring(0, initial) + pa + fin.substring(initial, j + 1) + pas + fin.substring(j + 1);
				j = len;	
				//System.out.println(j);
				//System.out.println(fin);
			}
			p.println("Case #" + (i + 1) + ": " +  fin);
		}
		p.close();
		

	}
	
	// you should actually read the stuff at the bottom

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
