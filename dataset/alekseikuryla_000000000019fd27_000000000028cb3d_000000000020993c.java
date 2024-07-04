import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numCases = Integer.parseInt(in.nextLine());
        
        for (int currCase = 1; currCase <= numCases; currCase++) {
        	int N = Integer.parseInt(in.nextLine());
        	int[][] matrix = new int[N][N];
        	
        	for (int i = 0; i < N; i++) {
        		String[] currArr = in.nextLine().split(" ");
        		for (int j = 0; j < N; j++) {
        			matrix[i][j] = Integer.parseInt(currArr[j]);
        		}
        	}
        	
        	int trace = 0;
        	
        	for (int i = 0; i < N; i++) {
        		trace += matrix[i][i];
        	}
        	
        	int rowCnt = 0;
        	
        	for (int i = 0; i < N ; i++) {
        		boolean[] seen = new boolean[N];
        		boolean cont = true;
        		int j = 0;
        		while(j < N && cont) {
        			int currInt = matrix[i][j];
        			if (currInt <= 0 || currInt > N || seen[currInt - 1]) {
        				rowCnt++;
        				cont = false;
        			} else {
        				seen[currInt - 1] = true;
        			}
        			j++;
        		}
        	}
        	
        	int colCnt = 0;
        	
        	for (int i = 0; i < N ; i++) {
        		boolean[] seen = new boolean[N];
        		boolean cont = true;
        		int j = 0;
        		while(j < N && cont) {
        			int currInt = matrix[j][i];
        			if (currInt <= 0 || currInt > N || seen[currInt - 1]) {
        				colCnt++;
        				cont = false;
        			} else {
        				seen[currInt - 1] = true;
        			}
        			j++;
        		}
        	}
        	
        	System.out.println("Case #" + currCase + ": " + trace + " " + rowCnt + " " + colCnt);
        }
	}
}