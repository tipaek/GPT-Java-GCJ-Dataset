import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			int m = sc.nextInt();
			int[][] a = new int[m][2];
			for(int j = 0; j < m; j++) {
				a[j][0] = sc.nextInt();
				a[j][1] = sc.nextInt();
			}
			String res = getSeq(a);
			System.out.println("Case #" + i + ": " + res);
		}
		sc.close();
	}

	private static String getSeq(int[][] arr) {
		Map<int[], Integer> map = new HashMap<int[], Integer>();
		for(int i = 0; i < arr.length; i++) map.put(arr[i], i);
		
		Arrays.sort(arr, (a, b) -> {
			return a[0] - b[0];
		});
		Queue<Character> Q = new LinkedList<Character>();
		Q.add('J'); Q.add('C');
		PriorityQueue<Finish> PQ = new PriorityQueue<Finish>((obj1, obj2) ->  {
			return obj1.finishTime - obj2.finishTime;
		});
		char[] res = new char[arr.length];
		char c = Q.remove();
		PQ.add(new Finish(c, arr[0][1]));
		StringBuilder sb = new StringBuilder();
		res[map.get(arr[0])] = c;
//		sb.append(c);
		for(int i = 1; i < arr.length; i++) {
			if(arr[i][0] < arr[i - 1][1]) {
				Finish peek = PQ.peek();
				if(peek.finishTime <= arr[i][0]) {
					Finish remove = PQ.remove();
					res[map.get(arr[i])] = remove.parent;
//					sb.append(remove.parent);
					remove.finishTime = arr[i][1];
					PQ.add(remove);
				} else if(!Q.isEmpty()) {
					char parent = Q.remove();
					Finish obj = new Finish(parent, arr[i][1]);
					res[map.get(arr[i])] = parent;
//					sb.append(parent);
					PQ.add(obj);
				} else {
					return "IMPOSSIBLE";
				}
			} else {
				Finish remove = PQ.remove();
				res[map.get(arr[i])] = remove.parent;
//				sb.append(remove.parent);
				remove.finishTime = arr[i][1];
				PQ.add(remove);
			}
		}
		return new String(res);
	}
	
	static class Finish {
		char parent;
		int finishTime;
		Finish(char c, int time) {
			this.parent = c;
			this.finishTime = time;
		}
	}

}
