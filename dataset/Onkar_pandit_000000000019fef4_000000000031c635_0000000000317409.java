import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        for (int index = 1;index<=t;index++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.nextLine();
            HashMap<int [], Integer> map = new HashMap<int [], Integer>();
            generatePath(x, y, path, map);
            int ans = dfsAndCheck(map);
            System.out.println("Case #"+index+": "+(ans == -1 ? "IMPOSSIBLE" : ans));
        }
        sc.close();
	}
	
	public static int dfsAndCheck(HashMap<int [], Integer> map) {
		for (Map.Entry<int [], Integer> entry : map.entrySet()) {
			int [] val = entry.getKey();
			int time = entry.getValue();
			if (Math.abs(val[0]) + Math.abs(val[1]) <= time) {
				return time;
			}
		}
		return -1;
	}
	
	public static void generatePath(int x, int y, String path, HashMap<int [], Integer> map) {
        map.put(new int[] {x, y}, 0);
        int n = path.length();
        int time = 0;
        for (int i =0;i<n;i++) {
        	char move = path.charAt(i);
        	switch(move) {
        	case 'N' : {
        		y+=1;
        	}
        	case 'S' : {
        		y-=1;
        	}
        	case 'W' : {
        		x-=1;
        	}
        	case 'E' : {
        		x+=1;
        	}
        	default: {
        		break;
        	}
        	}
        	map.put(new int[]{x,y}, time);
    		time++;
        }
    }

	public static int gcd(int a, int b) {

		if (a == 0 || b == 0)
			return 0;
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair p) {
			return this.a - p.a;
		}
	}

	public static long modMul(long a, long b, long mod) {
		long res = 0;
		a = a % mod;
		while (b > 0) {
			if (b % 2 == 1) {
				res = (res + a) % mod;
			}

			a = (a * 2) % mod;

			b /= 2;
		}

		// Return result
		return res % mod;
	}

	static int power(int x, int y, int p) {
		int res = 1;

		x = x % p;

		while (y > 0) {

			if ((y & 1) == 1)
				res = (res * x) % p;

			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

}

class FastReader {

	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

}