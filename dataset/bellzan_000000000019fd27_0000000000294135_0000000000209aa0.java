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
	public static int findR() {
		boolean[] seen;
		int problemCount = 0;
		int currentSquare;
		for (int m = 0; m < N; m++) {
			seen = new boolean[N+1];
			for (int l = 0; l < N; l++) {
				currentSquare = currentGrid[m][l];
				//System.out.println(currentSquare);
				if (seen[currentSquare] == false) {
					seen[currentSquare] = true;
				} else {
					problemCount++;
					l = N;
				}
			}
		}
		return problemCount;
	};
	public static int findC() {
		boolean[] seen;
		int problemCount = 0;
		int currentSquare;
		for (int m = 0; m < N; m++) {
			seen = new boolean[N+1];
			for (int l = 0; l < N; l++) {
				currentSquare = currentGrid[l][m];
				//System.out.println(currentSquare);
				if (seen[currentSquare] == false) {
					seen[currentSquare] = true;
				} else {
					problemCount++;
					l = N;
				}
			}
		}
		return problemCount;
	};
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
        int[] temp;
        int type;
        ArrayList<Integer> available;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	currentGrid = new int[N][N];
        	available = new ArrayList<Integer>();
        	for (int j = 1; j <= N; j++) {
        		available.add(j);
        	}
        	sequence = new int[N];
        	type = -1;
        	
        	startA = (int) (K/N) - 5;
        	if (startA < 1) {
        		startA = 1;
        	}
        	endA = (int) (K/N) + 6;
        	if (endA > N) {
        		endA = N;
        	}
        	possible = false;
        	
        	if (K % N == 0 && K/N <= N) {
        		//System.out.println(K/N);
        		possible = true;
        		type = 0;
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
            		//System.out.println(a+" "+goal);
            		for (int j = 1; j <= goal/2; j++) {
            			//Try b = j, c = goal-j
            			if (j != (goal-j) && j != a && (goal-j) != a && j > 0 && j < N && (goal-j) > 0 && (goal-j) < N) {
            				possible = true;
            				type = 1;
            				sequence[0] = a;
            				//System.out.println("Hi: "+a+" "+j+" "+(goal-j));
            				sequence[1] = goal-j;
            				sequence[N-1] = j;
            				available.remove(new Integer(a));
            				available.remove(new Integer(goal-j));
            				available.remove(new Integer(j));
            				for (int k = 2; k < (N-1); k++) {
            					sequence[k] = available.get(k-2);
            				}
            				j = goal/2+1;
            				a = endA+1;
            			} else if (N == 4 && j != a && (goal-j) != a && j > 0 && j < N && (goal-j) > 0 && (goal-j) < N) {
            				possible = true;
            				type = 2;
            				available.remove(new Integer(a));
            				available.remove(new Integer(j));
            				
            				currentGrid[0][0] = a;
            				currentGrid[0][1] = j;
            				currentGrid[1][0] = j;
            				currentGrid[1][1] = a;
            				currentGrid[2][2] = j;
            				currentGrid[2][3] = a;
            				currentGrid[3][2] = a;
            				currentGrid[3][3] = j;
            				
            				currentGrid[0][2] = available.get(0);
            				currentGrid[0][3] = available.get(1);
            				currentGrid[1][2] = available.get(1);
            				currentGrid[1][3] = available.get(0);
            				currentGrid[2][0] = available.get(1);
            				currentGrid[2][1] = available.get(0);
            				currentGrid[3][0] = available.get(0);
            				currentGrid[3][1] = available.get(1);
            				j = goal/2+1;
            				a = endA+1;
            			}
            		}
            	}
        	}
        	
        	
        	//sequence = new int[]{1,2,3,4,5};
        	
        	if (possible) {
        		if (type == 0 || type == 1) {
        			for (int j = 0; j < N; j++) {
                		for (int k = 0; k < N; k++) {
                			currentGrid[j][k] = sequence[(k+N-j) % N];
                		}
                	}
            		if (type == 1) {
                		temp = Arrays.copyOf(currentGrid[N-1], N);
                		currentGrid[N-1] = currentGrid[N-2];
                		currentGrid[N-2] = temp;
            		}
        		}
        		System.out.println("Case #"+(i+1)+": POSSIBLE");
        		for (int j = 0; j < N; j++) {
            		for (int k = 0; k < N; k++) {
            			System.out.print(currentGrid[j][k]+" ");
            		}
            		System.out.println();
            	}
        		
        		if (findR() > 0 || findC() > 0) {
        			System.out.println("Oh, no!");
        		}
        	} else {
        		System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        	}
        	
        	
        }
        f.close();
    }
}