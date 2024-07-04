import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution sol = new Solution();
		Scanner scan = new Scanner(System.in);
		int totalCase = scan.nextInt();
		for(int i=0; i<totalCase; i++) {
			int times = scan.nextInt();
			StringBuilder sb = new StringBuilder();
			boolean possible = true;
			Node[] nodes = new Node[times];
			for(int j=0; j<times; j++) {
				int begin = scan.nextInt();
				int end = scan.nextInt();
				nodes[j] = sol.new Node(begin, end);
			}
			
			Arrays.sort(nodes, sol.new NodeComperator());
			PriorityQueue<Node> pq = new PriorityQueue<Node>(sol.new PriorityComperator());
			
			List<String> responses = new ArrayList<String>();
			responses.add("C");
			responses.add("J");
			for(int j=0; j<times; j++) {
				while(!pq.isEmpty()&&pq.peek().end<=nodes[j].begin) {
					Node temp = pq.poll();
					responses.add(temp.responsible);
				}
				
				if(responses.size()==0) {
					possible = false;
					break;
				}
				
				sb.append(responses.get(0));
				nodes[j].responsible = responses.get(0);
				responses.remove(0);
				pq.offer(nodes[j]);
			}
			
			if(possible) {
				System.out.println("Case #" + (i+1) + " " + sb.toString());
			}
			else {
				System.out.println("Case #" + (i+1) + " IMPOSSIBLE");
			}
		}
	}
	
	class Node{
		int begin;
		int end;
		String responsible;
		public Node(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
	}
	
	public class NodeComperator implements Comparator<Node>{
		@Override
		public int compare(Node arg0, Node arg1) {
			return arg0.begin - arg1.begin;
		}
	}
	
	public class PriorityComperator implements Comparator<Node>{
		@Override
		public int compare(Node arg0, Node arg1) {
			return arg0.end - arg1.end;
		}
	}
}
