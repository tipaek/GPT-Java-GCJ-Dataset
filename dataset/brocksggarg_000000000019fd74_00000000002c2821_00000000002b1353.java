import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		create();
		for (int i = 1; i <= t; i++) {
			System.out.println("Case #"+i+":");
			solve(br, i);
		}
	}
	private static void create() {
		for(int n=1;n<500;n++) {
			for(int r=1;r<500;r++) {
				if(n==r) {
					arr[n][r]=1;
					arr[n][r+1]=-1;
					break;
				}
				if(r==1) {
					arr[n][r]=1;
				}else {
					arr[n][r]=arr[n-1][r-1]+arr[n-1][r];
				}
			}
		}
		
	}
	static int arr[][]=new int[501][501];
	static boolean vis[][]=new boolean[501][501];
	private static String solve(BufferedReader br, int i) throws NumberFormatException, IOException {
		
		vis=new boolean[501][501];
		int n=Integer.parseInt(br.readLine());
		req=n;
		
		vis[1][1]=true;
		calculate(2,1,1);
		System.out.println(1+" "+1);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		return "";
	}
	static int req=0;
	static Stack<String> stack=new Stack<>();
	private static boolean calculate(int i, int j, int sum) {
		if(invalid(i,j) || vis[i][j] || arr[i][j]<0 || (sum+arr[i][i])>req) {
			return false;
		}
		if(sum+arr[i][j]==req) {
			stack.push(i+" "+j);
			return true;
		}
		vis[i][j]=true;
		if(calculate(i+1, j+1, sum+arr[i][j])) {
			stack.push(i+" "+j);
			return true;
		}else if(calculate(i+1, j, sum+arr[i][j])) {
			stack.push(i+" "+j);
			return true;
		}else if(calculate(i, j-1, sum+arr[i][j])) {
			stack.push(i+" "+j);
			return true;
		}else if(calculate(i-1, j-1, sum+arr[i][j])) {
			stack.push(i+" "+j);
			return true;
		}else if(calculate(i-1, j, sum+arr[i][j])) {
			stack.push(i+" "+j);
			return true;
		}else if(calculate(i, j+1, sum+arr[i][j])) {
			stack.push(i+" "+j);
			return true;
		}
		vis[i][j]=false;
		return false;
	}
	private static boolean invalid(int i, int j) {
		if(i>500 || j>500 || i<1 || j<1) {
			return true;
		}
		return false;
	}
}
