
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution2 {
	
	public static class Pair {
		public final int n1;
		public final int n2;
		
		Pair(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
		}
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0;i<t;i++) {
			int n = sc.nextInt();
			if (n==1) {
				System.out.println("Case #"+(i+1)+": ");
				System.out.println("1 1");
				continue;
			}
			
			int half = n/2;
			if (n%2==1)half++;
			ArrayList<Pair> pairs = new ArrayList<Pair>();
			for (int j = 1;j<=half;j++) {
				pairs.add(new Pair(j, 1));
			}
			if (n%2==1) pairs.add(new Pair(half, 2));
			else pairs.add(new Pair(half+1, 2));
			System.out.println("Case #"+(i+1)+":");
			for (int j = 0;j<pairs.size();j++) {
				Pair pair = pairs.get(j);
				System.out.println(pair.n1+" "+pair.n2);
			}
		}
	}
}