import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static Pair[] pre,end;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for(int test=1;test<=tests;test++) {
			N = in.nextInt();
			pre = new Pair[N];
			end = new Pair[N];
			for(int i=0;i<N;i++) {
				String[] ss = in.next().split("\\*");
				pre[i] = Pair.make(ss[0],ss[0].length());
				end[i] = Pair.make(ss[1],ss[1].length());
			}
			Arrays.parallelSort(pre);
			Arrays.parallelSort(end);
			
			boolean can = true;
			for(int i=0;i+1<N;i++) {
				if(pre[i].getLength()==0) continue;
				String s1 = pre[i].getSt(),s2 = pre[i+1].getSt();
				int l1 = pre[i].getLength();
				if(!s1.equals(s2.substring(0, l1))) {
					can = false;
					break;
				}
			}
			if(!can) {
				System.out.printf("Case #%d: %c\n",test,'*');
				continue;
			}
			for(int i=N-1;i>=1;i--) {
				if(end[i-1].getLength()==0) break;
				String s1 = end[i].getSt(),s2 = end[i-1].getSt();
				int l1 = end[i].getLength(),l2 = end[i-1].getLength();
				if(!s2.equals(s1.substring(l1-l2,l1))){
					can = false;
					break;
				}
			}
			if(!can) {
				System.out.printf("Case #%d: %c\n",test,'*');
				continue;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(pre[N-1].getSt());
			sb.append(end[N-1].getSt());
			
			System.out.printf("Case #%d: %s\n",test,sb.toString());
		}
	}
	static class Pair implements Comparable<Pair> {
		private String st;
		private int length;
		private Pair(String st,int length) {
			this.st = st;
			this.length = length;
		}
		public static Pair make(String st,int length) {
			return new Pair(st,length);
		}
		public String getSt() {
			return st;
		}
		public int getLength() {
			return length;
		}
		public int compareTo(Pair p) {
			return length<p.getLength()?-1:1;
		}
	}
	
}

