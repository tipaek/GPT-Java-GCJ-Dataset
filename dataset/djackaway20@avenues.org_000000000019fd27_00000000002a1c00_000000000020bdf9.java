import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); //Number of cases
        for (int i = 1; i <= t; ++i) {
        	int n = in.nextInt(); //Matrix size
        	System.out.println(n);
        	int[] matrix = new int[n*n];
        	for(int j = 0; j < matrix.length; j++){
        		int a = in.nextInt();
        		System.out.println(j+","+a);
        		matrix[j] = a;
        		System.out.println(matrix[j]);
        	}
        	System.out.println(n+","+matrix);
        }
	}
}