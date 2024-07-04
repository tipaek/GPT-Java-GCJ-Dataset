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

        String[] ans = new String[T];
        for(int tc=0; tc<T; tc++) {
            int N = scan.nextInt();

            int[][] errands = new int[N][2];
            for(int i=0; i<N; i++) {
                errands[i][0] = scan.nextInt();
                errands[i][1] = scan.nextInt();
            }

            Arrays.sort(errands, (a,b) -> a[0] - b[0]);

            String ret = "";
            int time = 0;
            boolean usedC = false;
            boolean usedJ = false;

            int errJ = 0;
            int errC = 0;
            for(int i=0; i<N; i++) {

                time = errands[i][0];

                if(usedC && time >= errands[errC][1]) usedC = false;
                if(usedJ && time >= errands[errJ][1]) usedJ = false;

                if(usedC && usedJ) {
                    ret = "IMPOSSIBLE";
                    break;
                }

              
                if(usedC && !usedJ) {
                    usedJ = true;
                    ret = ret + "J";
                    errJ = i;
                } else if(usedJ && !usedC) {
                    usedC = true;
                    ret = ret + "C";
                    errC = i;
                } else if(!usedJ && !usedC) {
                    usedC = true;
                    ret = ret + "C";
                    errC = i;
                } else {
                    ret = "IMPOSSIBLE";
                    break;
                }

            }
            ans[tc] = ret;
        }

        for(int tc=1; tc<=T; tc++) {
            System.out.print("Case #" + tc + ": ");
            System.out.print(ans[tc-1]);

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