import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static boolean flag;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		Queue<Queue<int[]>> qu;
		for (int p = 0; p < n; p++) {
			int a = sc.nextInt();
			Queue<int[]> pair = new LinkedList<>();
			qu = new LinkedList<>();
			flag = false;
			ArrayList<ArrayList<Integer>> trng = solve(1000);
			System.out.println("Case #" + (p + 1) + ":");
			dfs(0, 0, 0, a, trng, pair, qu);
			
		}
		sc.close();
	}

	public static void dfs(int start, int end, int row, int sum, ArrayList<ArrayList<Integer>> trng, Queue<int[]> pair,
			Queue<Queue<int[]>> qu) {
		if (start > row || start < row || row < 0 || row >= trng.size() || end >= trng.get(row).size() || end < 0
				|| trng.get(start).get(end) == 0 || sum<0 || flag)
			return;
		if (sum == 0) {
			for(int arr[]:pair)
				System.out.println((arr[0]+1) + " "+(arr[1]+1));
			flag = true;
			return;
		}
		sum = sum - trng.get(start).get(end);
		trng.get(row).set(end, 0);
		int temp[] = {start,end};
		pair.add(temp);
		dfs(start - 1, end - 1, row - 1, sum, trng, pair, qu);
		dfs(start - 1, end, row - 1, sum, trng, pair, qu);
		dfs(start, end - 1, row, sum, trng, pair, qu);
		dfs(start, end + 1, row, sum, trng, pair, qu);
		dfs(start + 1, end, row + 1, sum, trng, pair, qu);
		dfs(start + 1, end + 1, row + 1, sum, trng, pair, qu);
		pair.remove(temp);
	}

	public static ArrayList<ArrayList<Integer>> solve(int A) {
		int numRows = A;
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		if (A == 0)
			return res;

		res.add(new ArrayList<>());
		res.get(0).add(1);

		for (int i = 1; i < numRows; i++) {

			res.add(new ArrayList<>());

			res.get(i).add(1);

			for (int j = 0; j < i - 1; j++) {
				int num = res.get(i - 1).get(j) + res.get(i - 1).get(j + 1);
				res.get(i).add(num);
			}

			res.get(i).add(1);

		}

		return res;
	}
}