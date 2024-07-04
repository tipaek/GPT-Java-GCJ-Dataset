import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	private static class Pair implements Comparable<Pair> {
		int s, e,in;
		char ch;

		public Pair(int i, int j,int k) {

			s = i;
			e = j;
			in=k;
		}

		@Override
		public int compareTo(Pair o) {
			if(s==o.s) {
				return e-o.e;
			}
			
			return s-o.s;
		}
	}
	
	private static class Pair_Compare implements Comparator<Pair>{

		

		@Override
		public int compare(Pair o1, Pair o2) {
			
			return o1.in-o2.in;
		}
		
	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int q = 1; q <= t; q++) {
			int n = sc.nextInt();
			PriorityQueue<Pair> hp = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				hp.add(new Pair(sc.nextInt(),sc.nextInt(),i));
			}
			PriorityQueue<Pair> hp2=new PriorityQueue<>(new Pair_Compare());
			int jb=-1,cb=-1,im=0;
			while(!hp.isEmpty()) {
				Pair p=hp.remove();
				if(jb<=p.s) {
					jb=p.e;
					p.ch='J';
				}else if(cb<=p.s){
					cb=p.e;
					p.ch='C';
				}else {
					im=1;break;
				}
				hp2.add(p);
			}
			if(im==1) {
				System.out.println("Case #"+q+": IMPOSSIBLE");
			}else {
				System.out.print("Case #"+q+": ");
				while(!hp2.isEmpty()) {
					System.out.print(hp2.remove().ch);
				}
				System.out.println();
			}
			
		}
	}

}
