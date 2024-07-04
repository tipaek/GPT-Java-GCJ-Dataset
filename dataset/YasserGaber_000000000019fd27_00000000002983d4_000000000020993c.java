import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    int[][] result = new int[T][4];
	    
	    for (int x = 0; x < T; x++) {
	        
	    int k = 0;
	    int r = 0; 
	    int c = 0;
	    
	    int N = scanner.nextInt();
	    int[][] arr = new int[N][N];
	    int[] repeatedElements = new int[N];
	    
	    for (int i = 0; i < N; i++)
	        for (int j = 0; j < N; j++) {
	            arr[i][j] = scanner.nextInt();
	            if (i == j) k += arr[i][i];
	        }

		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        int element = arr[i][j] - 1;
		        if (repeatedElements[element] == i + 1) {
		            r++;
		            break;
		        } else {repeatedElements[element] = i + 1;}
		    }
		}
		
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        int element = arr[j][i] - 1;
		        if (repeatedElements[element] == i + N + 1) {
		            c++;
		            break;
		        } else {repeatedElements[element] = i + N + 1;}
		    }
		}
		
		result[x][0] = x + 1;
		result[x][1] = k;
		result[x][2] = r;
		result[x][3] = c;
	}
	
	for (int i = 0; i < T; i++)
	    System.out.println("Case #" + result[i][0] + ": " + result[i][1] + " " + result[i][2] + " " + result[i][3]);
	}
}
