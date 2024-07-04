import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		Scanner entrada = new Scanner(System.in);
		int casos = Integer.parseInt(entrada.next());
		int tamanno=0;
		int [][] matrix;
		int diago=0;
		for (int i = 0; i < casos; i++) {
			tamanno = Integer.parseInt(entrada.next());
			matrix = new int[tamanno][tamanno];
			for (int j = 0; j < matrix.length; j++) {
				for (int j2 = 0; j2 < matrix.length; j2++) {
					matrix[j][j2]=Integer.parseInt(entrada.next());

				}
				diago+=matrix[j][j];
			}
			System.out.println("Case #"+(i+1)+": "+diago+" "+solveForX(matrix)+" "+solveForY(matrix));
			diago=0;
		}
	}

	public static int solveForX(int[][]arr) {
		int ret=0;
		Set<Integer> set = new HashSet<Integer>();
		int []nums = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {	
			for (int j = 0; j < nums.length; j++) {
				nums[j]=arr[i][j];
			}
			for (int i2=0;i2<nums.length;i2++) {
				set.add(nums[i2]);
			}
			if(set.size()!=nums.length)ret++;
		
		}
		return ret;
	}
	
	public static int solveForY(int[][]arr) {
		int ret=0;
		Set<Integer> set = new HashSet<Integer>();
		int []nums = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {	
			for (int j = 0; j < nums.length; j++) {
				nums[j]=arr[j][i];
			}
			for (int i2=0;i2<nums.length;i2++) {
				set.add(nums[i2]);
			}
			if(set.size()!=nums.length)ret++;
			set.clear();
		}
		return ret;
	}



}
