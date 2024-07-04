import java.io.*;
import java.util.*;


public class Solution {
    static class FastReader 
    {
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
        
        String[] nextStrArray() {
            return nextLine().split("\\s+");
        }
        
        Integer[] nextIntArray() {
            String[] arr = nextStrArray();
            Integer[] iarr = new Integer[arr.length];
            for(int i = 0 ; i < iarr.length ; i++) {
                iarr[i] = Integer.valueOf(arr[i]);
            }
            return iarr;
        }
    }
    
    static class Interval {
        int i,s,e;
        public Interval(int i, int s, int e) {
            this.i = i;
            this.s = s;
            this.e = e;
        }
    }
    
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int tt = t;
	    while(t-- > 0) {
	        int n = fr.nextInt();
	        StringBuilder sb = new StringBuilder();
	        int nn = n;
	        List<Interval> list = new ArrayList<Interval>();
	        char ans[] = new char[nn];
	        int ce = 0, je = 0;
            while(n-- > 0) {
                Interval i = new Interval(nn - n - 1, fr.nextInt(), fr.nextInt());
                list.add(i);
            }
            Collections.sort(list, (l1, l2) -> {
                if(l1.s < l2.s)
                    return -1;
                if(l1.s > l2.s)
                    return 1;
                if(l1.e < l2.e)
                    return -1;
                if(l1.e > l2.e)
                    return 1;
                return 0;
            });
            for(Interval i1 : list) {
                if(ce <= i1.s) {
                    ans[i1.i] = 'C';
                    ce = i1.e;
                }
                else if(je <= i1.s) {
                    ans[i1.i] = 'J';
                    je = i1.e;
                }
                else {
                    sb = new StringBuilder("IMPOSSIBLE");
                }
            }
            if(sb.toString().isEmpty()) {
                for(char c : ans) {
                    sb.append(c);
                }
            }
	        System.out.println("Case #"+(tt-t)+": "+sb.toString());
	        
    	}
    }
}