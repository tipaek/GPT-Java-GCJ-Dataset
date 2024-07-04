import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();
        int []N = new int[numTestCase];
        int []K = new int[numTestCase];
        for (int i = 0; i < numTestCase; ++i) {
        	N[i] = in.nextInt();
        	K[i] = in.nextInt();
        }
        in.close();
        for (int i = 0; i < numTestCase; ++i) {
        	checkTrace(i+1, N[i], K[i]);
        }
	}
	
	static void checkTrace(int testCase, int N, int K){
		if(K < N*N && K % N == 0){
			System.out.println("Case #" + testCase + ": POSSIBLE");
			generateLatinSquare(N, K/N);
		}
		else{
			System.out.println("Case #" + testCase + ": IMPOSSIBLE");
		}		
	}
	
	static void generateLatinSquare(int N, int startNumber){
		int [][]square = new int[N][N];
		int number;
		for (int i = 0; i < N; i++) {
			number = startNumber;
			for (int j = i; j < N; j++) {
				square[i][j] = number;
				square[j][i] = number;
				number ++;
				if(number > N) number %= N;
			}
		}
				
		printLatinSquare(square);
	}
	
	static void printLatinSquare(int square[][]){
		int N = square.length;
		for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if(j != 0){
    				System.out.print(" ");
    			}
    			System.out.print(square[i][j]);
    		}
    		System.out.println();
    	}
	}
}	