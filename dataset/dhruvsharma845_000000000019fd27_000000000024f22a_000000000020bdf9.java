import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int T = fr.nextInt();

		for(int k = 0; k < T; k++) {

            int N = fr.nextInt();

            Interval[] intervals = new Interval[N];
            for (int i = 0; i < N; i++) {
                int s = fr.nextInt();
                int e = fr.nextInt();

                Interval interval = new Interval(s, e, i);
                intervals[i] = interval;
            }

            Arrays.sort(intervals, (a, b) -> a.e - b.e);

            Interval cInt = null;
            Interval jInt = null;
            StringBuilder sb = new StringBuilder(N);
            sb.setLength(N);
            
            cInt = intervals[0];
            sb.setCharAt(cInt.index, 'C');
            for (int i = 1; i < N; i++) {
                Interval curInt = intervals[i];
                if(curInt.s < cInt.e) {
                    if(jInt != null && curInt.s < jInt.e) {
                        sb = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                    jInt = curInt;
                    sb.setCharAt(jInt.index, 'J');
                } 
                else {
                    cInt = curInt;
                    sb.setCharAt(cInt.index, 'C');
                }
            }

            System.out.println("Case #" + (k+1) + ": " + sb.toString());
		}

	}

    static class Interval {
        public int s;
        public int e;
        public int index;

        public Interval(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }
    }

	static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
}