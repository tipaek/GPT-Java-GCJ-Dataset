
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
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
				System.out.println("Case #"+(i+1)+":");
				System.out.println("1 1");
				continue;
			} else if (n==2) {
				System.out.println("Case #"+(i+1)+":");
				System.out.println("1 1");
				System.out.println("2 1");
				continue;
			} else if (n==3) {
				System.out.println("Case #"+(i+1)+":");
				System.out.println("1 1");
				System.out.println("2 1");
				System.out.println("2 2");
				continue;
			} else if (n==4) {
				System.out.println("Case #"+(i+1)+":");
				System.out.println("1 1");
				System.out.println("2 1");
				System.out.println("3 2");
				continue;
			}
			
			ArrayList<Pair> pairs = new ArrayList<Pair>();
			pairs.add(new Pair(1,1));
			pairs.add(new Pair(2,1));
			
			int sum = 2;
			int nextNum = 2;
			int nextRow = 3;
			
			while (sum+nextNum<n) {
				pairs.add(new Pair(nextRow, 2));
				sum+=nextNum;
				nextNum++;
				nextRow++;
			}
			nextRow--;
			while (sum<n) {
				pairs.add(new Pair(nextRow, 1));
				nextRow++;
				sum++;
			}
			System.out.println("Case #"+(i+1)+":");
			for (int j = 0;j<pairs.size();j++) {
				Pair pair = pairs.get(j);
				System.out.println(pair.n1+" "+pair.n2);
			}
		}
	}
}