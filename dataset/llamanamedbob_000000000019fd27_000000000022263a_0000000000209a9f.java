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
            String S = scan.nextToken();
            
            String newString = "";
            int curr = 0;
            for(int i=0; i<S.length(); i++) {
                int n = Character.getNumericValue(S.charAt(i));

                int diff = n - curr;

                if(diff < 0) {
                    while(diff != 0) {
                        newString = newString + ")";
                        diff++;
                    }
                } else if(diff > 0) {
                    while(diff != 0) {
                        newString = newString + "(";
                        diff--;
                    }
                }

                curr = n;
                newString = newString + S.charAt(i);

            }

            int n = 0;
            int diff = n - curr;

            if(diff < 0) {
                while(diff != 0) {
                    newString = newString + ")";
                    diff++;
                }
            } else if(diff > 0) {
                while(diff != 0) {
                    newString = newString + "(";
                    diff--;
                }
            }
            ans[tc] = newString;
        }
        
        System.out.println(Arrays.toString(ans));

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