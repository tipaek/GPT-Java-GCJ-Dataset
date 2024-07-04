import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int t = scn.nextInt();
		for (int _case_ = 1; _case_ <= t; _case_++) {
			ans.append("Case #").append(_case_).append(": ");
			
			//code
			int n = scn.nextInt(), m = scn.nextInt();
			Node[][] arr = new Node[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = new Node(scn.nextInt());
				}
			}
			connect(arr);
			long sum = 0;
			sum += sum(arr);
			while (eliminate(arr)) {
				sum += sum(arr);
				optimise(arr);
			}
			ans.append(sum);
			ans.append("\n");
		}
		System.out.println(ans);
	}
	
	private static void optimise(Node[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j]!=null){
					int sum=0;
					int count=0;
					if (arr[i][j].left!=null){
						sum+=arr[i][j].left.data;
						count++;
					}
					if (arr[i][j].right!=null){
						sum+=arr[i][j].right.data;
						count++;
					}
					if (arr[i][j].top!=null){
						sum+=arr[i][j].top.data;
						count++;
					}
					if (arr[i][j].bottom!=null){
						sum+=arr[i][j].bottom.data;
						count++;
					}
					arr[i][j].sum=sum;
					arr[i][j].count=count;
				}
			}
		}
	}
	
	private static long sum(Node[][] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != null) {
					sum += arr[i][j].data;
				}
			}
		}
		return sum;
	}
	
	private static boolean eliminate(Node[][] arr) {
		boolean ret = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != null) {
					if (!ret) {
						ret = check(arr[i][j],i,j,arr);
					} else {
						check(arr[i][j], i, j, arr);
					}
				}
			}
		}
		return ret;
	}
	
	private static boolean check(Node node, int i, int j, Node[][] arr) {
		int itself = node.data * node.count;
		int nbrs = node.sum;
		if (itself < nbrs) {
			arr[i][j]=null;
			Node l = node.left, r = node.right, t = node.top, b = node.bottom;
			if (l==null&&r==null){
			
			}else if (l == null){
				r.left=null;
			}else if (r == null){
				l.right=null;
			}else {
				l.right=r;
				r.left=l;
			}
			
			if (t==null&&b==null){
			
			}else if (t == null){
				b.top=null;
			}else if (b == null){
				t.bottom=null;
			}else {
				t.bottom=b;
				b.top=t;
			}
			
			return true;
		}
		return false;
	}
	
	private static void connect(Node[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j != 0) {
					arr[i][j].left = arr[i][j - 1];
					arr[i][j].sum += arr[i][j].left.data;
					arr[i][j].count++;
				}
				if (i != 0) {
					arr[i][j].top = arr[i - 1][j];
					arr[i][j].sum += arr[i][j].top.data;
					arr[i][j].count++;
				}
				if (i != arr.length - 1) {
					arr[i][j].bottom = arr[i + 1][j];
					arr[i][j].sum += arr[i][j].bottom.data;
					arr[i][j].count++;
				}
				if (j != arr[i].length - 1) {
					arr[i][j].right = arr[i][j + 1];
					arr[i][j].sum += arr[i][j].right.data;
					arr[i][j].count++;
				}
			}
		}
	}
	
	static class Node {
		int data;
		int sum;
		int count;
		
		Node(int data) {
			this.data = data;
			sum = 0;
			count = 0;
		}
		
		Node left, right, top, bottom;
		
	}
	
}
