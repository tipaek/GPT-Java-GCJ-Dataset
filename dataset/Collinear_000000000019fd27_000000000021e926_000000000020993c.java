import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		Scanner input = new Scanner(new File("test.in"));
		int cases = input.nextInt();
		for(int i = 0; i<cases; i++){
			int size = input.nextInt();
			int[][] A = new int[size][size];
			int trace = 0;
			int cols = 0; // num of cols that have repeats
			int rows = 0; // "" rows ""
			// input
			for(int r = 0; r<size; r++){
				for(int c = 0; c<size; c++){
					A[r][c] = input.nextInt();
				}
			}
			// calculating trace
			for(int r = 0; r<size; r++){
				for(int c = 0; c<size; c++){
					if(r==c){
						trace+=A[r][c];
					}
				}
			}
			// calculating cols
			for(int c = 0; c<size; c++){
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int r = 0; r<size; r++){
					if(list.contains(A[r][c])){
						cols++;
						break;
					}
					else{
						list.add(A[r][c]);
					}
				}
			}
			// calculating rows
			for(int r = 0; r<size; r++){
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int c = 0; c<size; c++){
					if(list.contains(A[r][c])){
						rows++;
						break;
					}
					else{
						list.add(A[r][c]);
					}
				}
			}
			// displaying output
			System.out.println("Case #" + (i+1) + ": " + trace + " " + rows + " " + cols);
		}
		
	}

}
