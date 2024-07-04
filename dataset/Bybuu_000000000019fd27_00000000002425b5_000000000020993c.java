import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
		int m = 0;
		for (int r = 0; r<recursive; r++) {
			m = scanner.nextInt();
			int vequal = 0;
			int hequal = 0;
			int trace = 0;
			boolean [] boolarray = new boolean[m];
			boolean curhequal = false;
			HashSet[]hharray = new HashSet[m];
			for (int i = 0; i < m; i++) {
				HashSet<Integer>vh = new HashSet<Integer>();
				for (int j = 0; j < m; j++) {
					if (hharray[j] == null) {
						hharray[j] = new HashSet<Integer>();
						boolarray[i] = false;
					}
					int number = scanner.nextInt();
					if(j==i) trace +=number;
					if(vh.contains(number)) curhequal = true;
					else vh.add(number);
					if(hharray[j].contains(number)) {
						vequal += !boolarray[j]?1:0;
						boolarray[j] = true;
					}
					else hharray[j].add(number);
				}
				hequal += curhequal ? 1:0;
			}
			System.out.println("Case #" +r+1+": "+trace+" "+hequal+" "+vequal);
		}
	}
}