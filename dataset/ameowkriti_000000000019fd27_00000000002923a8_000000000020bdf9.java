
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution{

	static class quad {

		int start;
		int end;
		int index;
		Character ch;

		public quad(int a, int b, int c) {
			this.start = a;
			this.end = b;
			this.index = c;
		}

	}

	static class comp1 implements Comparator<quad> {
		public int compare(quad a, quad b) {
			return a.start - b.start;
		}
	}

	static class comp2 implements Comparator<quad> {
		public int compare(quad a, quad b) {
			return a.index - b.index;
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int c = 1;
		while (t-- > 0) {

			int N = scan.nextInt();

			ArrayList<quad> list = new ArrayList<>();

			for (int i = 0; i < N; i++) {

				quad q = new quad(scan.nextInt(), scan.nextInt(), i);
				list.add(q);

			}

			Collections.sort(list, new comp1());
			String ans = function(list, N);
			System.out.print("Case #" + c + ": ");
			System.out.print(ans);
			System.out.println();
			c++;
		}

	}

	public static String function(ArrayList<quad> list, int n) {
		
		
		ArrayList<quad> c = new ArrayList<>();
		ArrayList<quad> j = new ArrayList<>();
		
		int cmax = Integer.MIN_VALUE;
		int jmax = Integer.MIN_VALUE;
		
		quad a = list.get(0);
		c.add(a);
		a.ch = 'C';
		
		if(a.end > cmax)
			cmax = a.end;
		
		for(int i = 1; i<list.size(); i++) {
			
			quad next = list.get(i);
			
			if(next.start >= cmax) {
				c.add(next);
				next.ch = 'C';
				
				if(next.end > cmax)
					cmax = next.end;
			}
			
			else if(next.start >= jmax) {
			
				j.add(next);
				next.ch = 'J';
				
				if(next.end > jmax)
					jmax = next.end;
			
			}
			
			else return "IMPOSSIBLE";
			
		}
	   
		c.addAll(j);
		Collections.sort(c, new comp2());
		String ans = "";
		
		for(int i = 0; i<c.size(); i++) {
			
			quad qd = c.get(i);
			ans += qd.ch;
		
		}
		
		return ans;
	}

}
