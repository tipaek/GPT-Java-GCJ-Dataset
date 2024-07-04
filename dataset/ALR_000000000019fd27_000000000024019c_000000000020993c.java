
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	

	static class Input{
		int N;
		int[][] matrix;

		public Input(int n, int[][] matrix) {
			this.N = n;
			this.matrix = matrix;
		}
	}


	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("./data/data1.in"));

		int T = scan.nextInt();
		for (int ks = 1; ks <= T; ks++) {
			Input in = readInput(scan);
			String  sol = solve(in);
			System.out.println("Case #"+ks+ ": "+sol);
		}
	}


	private static String solve(Input in) {
		int sum=0;
		int n=in.N;
		for(int i=0;i<n;i++) {
			sum+=in.matrix[i][i];
		}
		int r=0;
		for(int i=0;i<n;i++) {
			Set<Integer> s= new TreeSet<Integer>();
			for(int j=0;j<n;j++) {
				if(s.contains(in.matrix[i][j])) {
					r++;
					break;
				}
				else {
					s.add(in.matrix[i][j]);
				}
			}
		}
		int c=0;
		for(int j=0;j<n;j++) {
			Set<Integer> s= new TreeSet<Integer>();
			for(int i=0;i<n;i++) {
				if(s.contains(in.matrix[i][j])) {
					c++;
					break;
				}
				else {
					s.add(in.matrix[i][j]);
				}
			}
		}
		return sum+" "+r+" "+c;
	}


	private static Input readInput(Scanner scan) {
		int N = scan.nextInt();
		int[][] matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		Input input = new Input(N,matrix);
		return input;
	}








}
