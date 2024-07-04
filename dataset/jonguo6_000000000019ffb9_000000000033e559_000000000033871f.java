import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=0;test<tests;test++) {
			String answer = "";
			String[] inp = in.nextLine().split(" ");
			int c = Integer.parseInt(inp[0]);
			int d = Integer.parseInt(inp[1]);
			computer[] net = new computer[c];
			edge[] edges = new edge[d];
			computer source = new computer(0);
			net[0] = source;
			String[] inn = in.nextLine().split(" ");
			for(int i=1;i<c;i++) {
				net[i] = new computer(i);
				int num = Integer.parseInt(inn[i-1]);
				if(num < 0) {
					net[i].rank = -1*num;
				} else {
					net[i].time = num;
				}
			}
			computer[] sort = new computer[c];
			LinkedList<computer> unranked = new LinkedList<computer>();
			sort[0] = source;
			for(int i=1;i<d;i++) {
				computer cc = net[i];
				if(cc.rank != -123123) {
					sort[cc.rank]= cc; 
				} else {
					unranked.add(cc);
				}
			}
			Collections.sort(unranked);
			int prevtime = 0;
			for(int i=1;i<d;i++) {
				if(sort[i] == null) {
					sort[i] = unranked.remove();
					prevtime = sort[i].time;
				} else {
					sort[i].time = prevtime+1;
				}
			}
			
			for(int i=0;i<d;i++) {
				String[] input = in.nextLine().split(" ");
				int v = Integer.parseInt(input[0])-1;
				int w = Integer.parseInt(input[1])-1;
				net[v].con.add(net[w]);
				net[w].con.add(net[v]);
				edges[i] = new edge(v,w);
			}
			for(int i=0;i<d;i++) {
				edge ec = edges[i];
				int edgetime = Math.abs(net[ec.v].time - net[ec.w].time);
				if(edgetime == 0) edgetime = 1;
				answer = answer + edgetime;
				if(i != d-1) answer = answer + " ";
			}
			System.out.println("Case #"+(test+1)+": "+answer);
		}
		in.close();
	}
	static class edge {
		int v, w;
		public edge(int a, int b) {
			v = a;
			w = b;
		}
	}
	static class computer implements Comparable<computer> {
		int index;
		LinkedList<computer> con = new LinkedList<computer>();
		int time = 0;
		int rank = -123123;
		boolean source;
		public computer(int a) {
			index = a;
			source = (index==0);
		}
		@Override
		public int compareTo(computer o) {
			
			return Integer.compare(time, o.time);
		}
	}
}