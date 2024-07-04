import java.io.*;
import java.util.*;

public class Solution {
	
	public static boolean DEBUG = true;
	
    public static void main(String[] args) throws IOException {
    	FastScanner scan;
    	PrintWriter out;
    	if (DEBUG) {
    		scan = new FastScanner();
        	out = new PrintWriter(System.out);
    	}
    	else {
        	scan = new FastScanner("test.in");
        	out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
    	}
        
        int T = scan.nextInt();

        for(int t=0; t<T; t++) {
            int R = scan.nextInt();
            int C = scan.nextInt();

            int[][] dancers = new int[R][C];
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {    
                    dancers[i][j] = scan.nextInt();
                }
            }

            boolean[][] eliminated = new boolean[R][C];

            boolean done = false;
            while(!done) {

                
                boolean[][] pastEliminated = new boolean[R][C];

                for(int i=0; i<R; i++) {
                    pastEliminated[i] = Arrays.copyOf(pastEliminated[i],pastEliminated[i].length);
                }

                done = true;
                for(int i=0; i<R; i++) {
                    for(int j=0; j<C; j++) {
                        if(eliminated[i][j]) continue;

                        int sum = 0;
                        int neighbors = 0;
                        for(int k=i; k>=0; k--) {
                            if(pastEliminated[k][j]) continue;

                            sum += dancers[k][j];
                            neighbors++;
                            done = false;
                        }
                        
                        for(int k=i; k<R; k++) {
                            if(pastEliminated[k][j]) continue;

                            sum += dancers[k][j];
                            neighbors++;
                            done = false;
                        }

                        for(int k=j; k>=0; k--) {
                            if(pastEliminated[i][k]) continue;

                            sum += dancers[i][k];
                            neighbors++;
                            done = false;
                        }
                        
                        for(int k=j; k<C; k++) {
                            if(pastEliminated[i][k]) continue;

                            sum += dancers[i][k];
                            neighbors++;
                            done = false;
                        }

                        if(dancers[i][j] < sum/neighbors) eliminated[i][j] = true;
                    }
                }
            }
        }
        
        
        out.close();
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}