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

        int[][] ans = new int[T][3];
        for(int tc=0; tc<T; tc++) {
            int N = scan.nextInt();

            int[][] grid = new int[N][N];
            
            int sum = 0;
            int r = 0;
            for(int i=0; i<N; i++) {
                Set<Integer> row = new HashSet<Integer>();
                boolean found = false;

                for(int j=0; j<N; j++) {
                    grid[i][j] = scan.nextInt();
                    
                    if(row.contains(grid[i][j]) && !found) {
                        r++;
                        found = true;
                    }
                    if(i == j) sum += grid[i][j];

                    row.add(grid[i][j]);
                }
            }
            ans[tc][0] = sum;
            ans[tc][1] = r;
            
            int c = 0;
            for(int i=0; i<N; i++) {
                Set<Integer> col = new HashSet<Integer>();
                boolean found = false;

                for(int j=0; j<N; j++) {
                    if(col.contains(grid[j][i]) && !found) {
                        c++;
                        found = true;
                    }
                    col.add(grid[j][i]);
                }
            }
            ans[tc][2] = c;
            
        }
        
        for(int tc=1; tc<=T; tc++) {
            System.out.print("Case #" + tc + ": ");
            System.out.print(ans[tc-1][0]);
            System.out.print(" " + ans[tc-1][1]);
            System.out.print(" " + ans[tc-1][2]);

            System.out.println();
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
                // TODO Auto-generated catch block
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
                    // TODO Auto-generated catch block
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
                // TODO Auto-generated catch block
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