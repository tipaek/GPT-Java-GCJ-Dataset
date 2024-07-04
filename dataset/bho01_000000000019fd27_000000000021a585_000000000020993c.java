import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vestigium {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Scanner inStr = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i = 0; i < t; i++) {
			int size = in.nextInt();		
			int[][] matrix = new int[size][];
			
			for(int j = 0; j < size; j++) {
				String row = inStr.nextLine();
				matrix[j] = converter(row, size);
			}
			int k = trace(matrix);
			int r = rows(matrix);
			int c = cols(matrix);
			System.out.println("Case #" + (i + 1) + ": " + (k) + " " + (r) + " " + (c));		
		}
	}
	
	public static int trace(int[][] mat) {
		int sum = 0;
		
		for(int i = 0; i < mat.length; i++) {
			sum += mat[i][i];
			System.out.println(sum);
		}
		
		return sum;
	}
	
	public static int rows(int[][] mat) {
		int counter = 0;
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				boolean checker = false;
				for(int k = j + 1; k < mat[i].length; k++) {
					if(mat[i][j] == mat[i][k]) {
						//System.out.println("rows ran inner");
						counter++;
						checker = true;
						break;
					}
				}
				if(checker) {
					break;
				}
			}
		}
		
		return counter;
	}
	
	public static int cols(int [][] mat) {
		int counter = 0;
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				boolean checker = false;
				for(int k = j + 1; k < mat.length; k++) {
					if(mat[j][i] == mat[k][i]) {
						counter++;
						checker = true;
						break;
					}
				}
				if(checker) {
					break;
				}
			}
		}
		
		return counter;
	}
	
	public static int[] converter(String yoink, int size) {
		int[] arr = new int[size];
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(yoink);
		int k = 0;
        while(m.find() && k < size) {
            System.out.println(m.group());
            arr[k] = Integer.parseInt(m.group());
        }
		return arr;
	}
	
}
