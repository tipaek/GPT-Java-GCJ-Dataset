import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//Scanner in = new Scanner(new File("solution.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(("solution.out"))));
		int cases = Integer.parseInt(in.nextLine());
		for(int x = 1; x < cases+1; x++){
			int size = in.nextInt();
			int mat[][] = new int[size][size];

			for(int r = 0; r < mat.length; r++){
				in.nextLine();
				for(int c = 0; c < mat[r].length; c++){
					mat[r][c] = Integer.parseInt(in.next());
				}
			}
			System.out.println("Cases #" + x + ": " + diagonal(mat) + " " + row(mat) + " " + column(mat));
		}

	}

	public static int diagonal(int[][] mat){
		int sum = 0; 
		for(int i = 0; i < mat.length; i++)
			sum+=mat[i][i];
		return sum;
	}

	public static int row(int[][] mat){
		int count = 0; 
		HashSet<Integer> h = new HashSet<Integer>();
		for(int r = 0; r < mat.length; r++){
			for(int c = 0; c < mat[r].length; c++){
				if(h.add(mat[r][c]) == false){
					count++;
				break;
			}
				else
					h.add(mat[r][c]);
			}
			h.clear();
		}
		return count;
	}

	public static int column(int[][] mat){
		int count = 0; 
		HashSet<Integer> h = new HashSet<Integer>();
		for(int r = 0; r < mat.length; r++){
			for(int c = 0; c < mat[r].length; c++){
				if(h.add(mat[c][r]) == false){
					count++;
				break;
			}
				else
					h.add(mat[r][c]);
			}
			h.clear();
		}
		return count;
	}

}