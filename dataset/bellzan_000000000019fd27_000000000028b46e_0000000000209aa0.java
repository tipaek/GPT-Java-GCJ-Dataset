import java.io.*;
import java.util.*;

class Solution {
	static int[][] currentGrid;
	static int N;
	static int K;
	/*public static int[] comeUpWithDiagnal(int traceGoal) {
		int[] diagnal = new int[N];
		//int i = 0;
		int tryingToAdd = 1;
		for (int i = 0; i < N; i++) {
			//Coming up with the ith number:
			while ((traceGoal-tryingToAdd) > (N-i-1)) {
				tryingToAdd++;
			}
			if ((traceGoal-tryingToAdd) == (N-i-1)) {
				for (int j = i; j < N; j++) {
					diagnal[j] = tryingToAdd;
				}
				i = N;
			} else {
				diagnal[i] = tryingToAdd;
			}
		}
		return diagnal;
	}*/
    public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int startA;
        int endA;
        int b,c;
        int goal;
        boolean possible;
        int[] sequence;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	currentGrid = new int[N][N];
        	sequence = new int[N];
        	
        	startA = (int) (K/N) - 5;
        	endA = (int) (K/N) + 6;
        	possible = false;
        	
        	if (K % N == 0) {
        		//System.out.println(K/N);
        		possible = true;
        		sequence[0] = K/N;
        		for (int j = 1; j < N; j++) {
        			sequence[j] = j;
        			if (j == K/N) {
        				sequence[j] = N;
        			}
        		}
        	}
        	
        	if (!possible && N != 2) {
        		for (int a = startA; a <= endA; a++) {
            		goal = K - a*(N-2);
            		for (int j = 1; j <= goal/2; j++) {
            			//Try b = j, c = goal-j
            			if (j != (goal-j) && j != a && (goal-j) != a && j > 0 && j < N && (goal-j) > 0 && (goal-j) < N) {
            				possible = true;
            				sequence[0] = a;
            				sequence[1] = goal-j;
            				sequence[N-1] = j;
            				for (int k = 2; k < (N-1); k++) {
            					sequence[k] = k;
            					if (k == a) {
            						sequence[k] = N;
            					} else if (k == goal-j) {
            						sequence[k] = 1;
            					} else if (k == j) {
            						sequence[k] = N-1;
            					}
            				}
            				j = goal/2+1;
            				a = endA+1;
            			}
            		}
            	}
        	}
        	
        	
        	//sequence = new int[]{1,2,3,4,5};
        	
        	if (possible) {
        		for (int j = 0; j < N; j++) {
            		for (int k = 0; k < N; k++) {
            			currentGrid[j][k] = sequence[(k+N-j) % N];
            		}
            	}
        		System.out.println("Case #"+(i+1)+": POSSIBLE");
        		for (int j = 0; j < N; j++) {
            		for (int k = 0; k < N; k++) {
            			System.out.print(currentGrid[j][k]+" ");
            		}
            		System.out.println();
            	}
        	} else {
        		System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        	}
        	
        	
        }
        f.close();
    }
}