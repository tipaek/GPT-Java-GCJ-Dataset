import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		FastReader fr = new FastReader();

		int t = fr.nextInt();

		for(int i = 0; i < t; i++) {
			int N = fr.nextInt();

			Map<Integer, Set<Integer>> colWise = new HashMap<>();
			Set<Integer> r = new HashSet<>();
			Set<Integer> c = new HashSet<>();
			int trace = 0;
			for(int j = 0; j < N; j++) {
				
				Set<Integer> ele = new HashSet<>();
				for(int k = 0; k < N; k++) {

					// if it is first row, it means we have to initialise
					// map
					if(j == 0) {
						colWise.put(k, new HashSet<>());
					}

					int p = fr.nextInt();
					if(j == k) {
						trace += p;
					}
					if(ele.contains(p)) {
						r.add(j);
					}
					else {
						ele.add(p);
					}
					Set<Integer> st = colWise.get(k);
					if(st.contains(p)) {
						c.add(k);
					}
					else {
						st.add(p);
					}
				}
			}

			System.out.println("Case #" + (i+1) + ": " + trace + " " + r.size() + " " + c.size());
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