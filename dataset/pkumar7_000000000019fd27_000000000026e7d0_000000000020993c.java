import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       /* do {
            in.nextInt();
        } while (in.hasNextLine());*/
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int case_number = 1; case_number <= t; ++case_number) {
            int N = in.nextInt();

            int[][] matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = in.nextInt();
					//System.out.print("matrix = " + matrix[i][j] + "\t");
				}
			//	System.out.println();
			}
            String output = isLatinSquare(matrix, case_number, N);
            System.out.println(output);
        }
    }

    static String isLatinSquare(int[][] matrix , int case_number, int N){
		int rowsDup = 0;
		int colsDup = 0;
		int trace = 0;

		for (int i = 0; i < matrix.length; i++) {
			trace += matrix[i][i];
		}
		for (int i = 0; i < matrix.length; i++) {
			Set<Integer> sets = new HashSet<>();
			for (int j = 0; j <matrix[i].length; j++) {
				if(!sets.add(matrix[i][j])){
					rowsDup++;
					break;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			Set<Integer> sets = new HashSet<>();
			for (int j = 0; j <matrix[i].length; j++) {
				if(!sets.add(matrix[j][i])){
					colsDup++;
					break;
				}
			}
		}

		String res = "Case #" + case_number + ": " + trace + " " + rowsDup +" " + colsDup;
		//System.out.println("res = " + res);
		return res;
	}

}