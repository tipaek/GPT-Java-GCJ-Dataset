import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
	public void run() throws Exception {
		FastScanner f = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int times = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			out.printf("Case #%d: ", asdf);
			int r = f.nextInt(), c = f.nextInt();
			int[][] mat = new int[r][c];
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
					mat[i][j] = f.nextInt();
			long ans = 0;
			while(true) {
				boolean b = true;
				LinkedList<Integer> ll = new LinkedList<>();
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						ans += mat[i][j];
						if(mat[i][j] != 0) {
							int sum = 0, cnt = 0;
							for(int a = i-1; a >= 0; a--) {
								if(mat[a][j] != 0) {
									cnt++;
									sum+= mat[a][j];
									break;
								}
							}
							for(int a = i+1; a < r; a++) {
								if(mat[a][j] != 0) {
									cnt++;
									sum+= mat[a][j];
									break;
								}
							}
							for(int a = j-1; a >= 0; a--) {
								if(mat[i][a] != 0) {
									cnt++;
									sum+= mat[i][a];
									break;
								}
							}
							for(int a = j+1; a < c; a++) {
								if(mat[i][a] != 0) {
									cnt++;
									sum+= mat[i][a];
									break;
								}
							}
							if(sum > cnt*mat[i][j]) {
								ll.add(i);
								ll.add(j);
							}
						}
					}
				}
				if(ll.isEmpty()) break;
				while(!ll.isEmpty()) mat[ll.poll()][ll.poll()] = 0;
			}
			out.println(ans);
		}
///
		out.flush(); 
	}
///
    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }
}
