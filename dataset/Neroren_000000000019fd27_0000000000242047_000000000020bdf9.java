import java.io.*;
import java.util.*;
public class Solution {
	static class Node{
		int idx;
		int start;
		int end;
		char person;
		Node(int idx, int start, int end){
			this.idx = idx;
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1 ;tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			Node[] arr = new Node[n];
			int[] time = new int[1441];
			StringTokenizer st;
			boolean check = true;
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				arr[i] = new Node(i,s,e);
				if(check) {
					for(; s < e; ++s) {
						time[s]++;
						if(time[s]>2) {
							check = false;
							break;
						}
					}
				}
			}
			if(check) {
				Arrays.sort(arr, new Comparator<Node>() {
					@Override
					public int compare(Node n1, Node n2) {
						return Integer.compare(n1.start, n2.start);
					}
				});
				for(int i = 0; i < arr.length; ++i) {
					if(i%2==0) {
						arr[i].person='J';
					}else {
						arr[i].person='C';
					}
				}
				Arrays.sort(arr, new Comparator<Node>() {
					@Override
					public int compare(Node o1, Node o2) {
						return Integer.compare(o1.idx, o2.idx);
					}
				});
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < arr.length; ++i) {
					sb.append(arr[i].person);
				}
				ans.append("Case #"+tc+": "+sb+"\n");
			}else {
				ans.append("Case #"+tc+": IMPPOSIBLE\n");
			}
		}
		System.out.println(ans);
	}
}