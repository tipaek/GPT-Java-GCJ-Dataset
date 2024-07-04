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
			int[] arr = new int[r*c];
			boolean[] ex = new boolean[r*c];
			int[][] nx = new int[r*c][4];
			LinkedList<Integer> ll = new LinkedList<Integer>();
			long tot = 0;
			long ans = 0;
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++) {
					ex[i*c+j] = true;
					tot += arr[i*c+j] = f.nextInt();
					Arrays.fill(nx[i*c+j], -1);
					if(i > 0) nx[i*c+j][0] = i*c+j-c;
					if(j > 0) nx[i*c+j][1] = i*c+j-1;
					if(i < r-1) nx[i*c+j][2] = i*c+j+c;
					if(j < c-1) nx[i*c+j][3] = i*c+j+1;
				}
			for(int i = 0; i < r*c; i++) {
				int sum = 0, cnt = 0;
				for(int j =0 ; j < 4; j++)
					if(nx[i][j] != -1) {
						sum += arr[nx[i][j]];
						cnt++;
					}
				if(sum > arr[i]*cnt) ll.add(i);
			}
			LinkedList<Integer> check = new LinkedList<>();
			while(!ll.isEmpty()) {
				ans += tot;
				while(!ll.isEmpty()) {
					int i  = ll.poll();
					if(i == -1 || !ex[i]) continue;
					for(int j = 0; j < 4; j++)
						if(nx[i][j] != -1) {
							nx[nx[i][j]][j^2] = nx[i][j^2];
							check.add(nx[i][j]);
						}
					tot -= arr[i];
					ex[i] = false;
				}
				while(!check.isEmpty()) {
					int i = check.poll();
					if(i == -1) continue;
					if(ex[i]) {
						int sum = 0, cnt = 0;
						for(int j =0 ; j < 4; j++)
							if(nx[i][j] != -1) {
								sum += arr[nx[i][j]];
								cnt++;
							}
						if(sum > arr[i]*cnt) ll.add(i);
					}
				}
			}
			out.println(ans+tot);
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
