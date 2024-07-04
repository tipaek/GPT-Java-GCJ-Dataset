import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {
	
	public static void main(String[] args) {
		vestigium();
	}

	private static void vestigium() {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int lines = 0, columns = 0, trace = 0;
		
		int totalTests = in.nextInt();
		
		for (int i = 0; i < totalTests; i++) {
			int size = in.nextInt();
			int[][] tempMat = new int[size][size];
			lines = 0;
			
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					tempMat[j][k] = in.nextInt();
				}
				
				if (!isCorrectLine(tempMat[j])) {
					lines++;
				}
			}
			columns = getColumnsTotal(tempMat);
			
			trace = calculateTrace(tempMat);
			
			// write output
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + lines + " " + columns);
		}
		
		in.close();
	}

	private static boolean isCorrectLine(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[i] == elements[j]) {
					return false;
				}
			}
		}
		
		return true;
	}

	private static int getColumnsTotal(int[][] mat) {
		int dup = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				for (int k = j + 1; k < mat.length; k++) {
					if (mat[j][i] == mat[k][i]) {
						dup++;
						j = mat.length - 1;
						break;
					}
				}
			}
		}

		return dup;
	}

	private static int calculateTrace(int[][] mat) {
		int sum = 0;
		for (int i = 0; i < mat.length; i++) {
			sum += mat[i][i];
		}

		return sum;
	}

}
