import java.io.*;
import java.util.*;

public class Solution implements Runnable {
	boolean judge = true;
	FastReader scn;
	PrintWriter out;
	String INPUT = "";

	void solve() {
		int T = scn.nextInt();
		for (int tt = 1; tt <= T; tt++) {
			out.print("Case #" + tt + ": ");

			int u = scn.nextInt(), n = (int) 1e4;
			long[] arr = new long[n];
			String[] s = new String[n];
			boolean z = false;
			HashSet<Character> set = new HashSet<Character>();
			for(int i = 0; i < n; i++) {
				arr[i] = scn.nextLong();
				if(arr[i] == -1){
				    z = true;
				}
				s[i] = scn.next();
				for(int j = 0; j < s[i].length(); j++) {
					set.add(s[i].charAt(j));
				}
			}
			
			int[] per = new int[10];
			u = 0;
			for(char c : set) {
				per[u++] = c - 'A';
			}
			per = scn.shuffle(per);
			
			int[] nums = new int[10];
			for(int i = 0; i < 10; i++) {
				nums[i] = i;
			}
			
			HashMap<Character, Integer> code = new HashMap<>();
			String ans = "";
			do {
				code.clear();
				for(int i = 0; i < 10; i++) {
					code.put((char)(per[nums[i]] + 'A'), i);
				}
				
				boolean ok = true;
				if(z){
    				here: for (int i = 0; i < n; i++) {
    					long num = 0;
    					for (int j = 0; j < s[i].length(); j++) {
    						num = 10 * num + code.get(s[i].charAt(j));
    						if (num > 0) {
    							break here;
    						}
    					}
    				}
				} else {
				    here: for (int i = 0; i < n; i++) {
    					long num = 0;
    					for (int j = 0; j < s[i].length(); j++) {
    						num = 10 * num + code.get(s[i].charAt(j));
    						if (num == 0 || num > arr[i]) {
						        ok = false;
							    break here;
						    }
    					}
    				}
				}

				if(ok) {
					for(int i = 0; i < 10; i++) {
						ans = ans + (char)(per[nums[i]] + 'A');
					}
					break;
				}
				
			} while(nextPermutation(nums));
			
			out.println(ans);
		}
	}
	
	boolean nextPermutation(int[] nums) {
		// Find the last location where an element is smaller than its right neighbor.
		int left = -1, first = nums[0];
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				left = i - 1;
				break;
			}
		}

		// If no element smaller than right neighbor was found, sort entire array and
		// exit.
		if (left == -1) {
			Arrays.sort(nums);
			return nums[0] >= first;
		}

		// Find the *smallest* element to the right of "left" that is larger than "left"
		int right = -1;
		for (int i = left + 1; i < nums.length; i++) {
			int n = nums[i];
			int l = nums[left];
			if ((n > l && right == -1) || n > l && n < nums[right]) {
				right = i;
			}
		}

		// Swap the values of left and right
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;

		// Sort all elements to the right of lefts index
		Arrays.sort(nums, left + 1, nums.length);

		return nums[0] >= first && nums.length > 1;
	}

	public void run() {
		long time = System.currentTimeMillis();
		boolean oj = System.getProperty("ONLINE_JUDGE") != null || judge;
		out = new PrintWriter(System.out);
		scn = new FastReader(oj);
		solve();
		out.flush();
		if (!oj) {
			System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
		}
	}

	public static void main(String[] args) {
		new Thread(null, new Solution(), "Main", 1 << 28).start();
	}

	class FastReader {
		InputStream is;

		public FastReader(boolean onlineJudge) {
			is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		}

		public FastReader() {
			is = System.in;
		}

		byte[] inbuf = new byte[1024];
		public int lenbuf = 0, ptrbuf = 0;

		int readByte() {
			if (lenbuf == -1)
				throw new InputMismatchException();
			if (ptrbuf >= lenbuf) {
				ptrbuf = 0;
				try {
					lenbuf = is.read(inbuf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return -1;
			}
			return inbuf[ptrbuf++];
		}

		boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		char nextChar() {
			return (char) skip();
		}

		String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		String nextLine() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while ((!isSpaceChar(b) || b == ' ')) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		char[] next(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		char[][] nextMatrix(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++)
				map[i] = next(m);
			return map;
		}

		int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		int[][] next2DInt(int n, int m) {
			int[][] arr = new int[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextIntArray(m);
			}
			return arr;
		}

		long[][] next2DLong(int n, int m) {
			long[][] arr = new long[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLongArray(m);
			}
			return arr;
		}

		int[] shuffle(int[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				int c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		long[] shuffle(long[] arr) {
			Random r = new Random();
			for (int i = 1, j; i < arr.length; i++) {
				j = r.nextInt(i);
				long c = arr[i];
				arr[i] = arr[j];
				arr[j] = c;
			}
			return arr;
		}

		int[] uniq(int[] arr) {
			Arrays.sort(arr);
			int[] rv = new int[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		long[] uniq(long[] arr) {
			Arrays.sort(arr);
			long[] rv = new long[arr.length];
			int pos = 0;
			rv[pos++] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] != arr[i - 1]) {
					rv[pos++] = arr[i];
				}
			}
			return Arrays.copyOf(rv, pos);
		}

		int[] reverse(int[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}

		long[] reverse(long[] arr) {
			int l = 0, r = arr.length - 1;
			while (l < r) {
				arr[l] = arr[l] ^ arr[r];
				arr[r] = arr[l] ^ arr[r];
				arr[l] = arr[l] ^ arr[r];
				l++;
				r--;
			}
			return arr;
		}

		int[] compress(int[] arr) {
			int n = arr.length;
			int[] rv = Arrays.copyOf(arr, n);
			rv = uniq(rv);
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.binarySearch(rv, arr[i]);
			}
			return arr;
		}

		long[] compress(long[] arr) {
			int n = arr.length;
			long[] rv = Arrays.copyOf(arr, n);
			rv = uniq(rv);
			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.binarySearch(rv, arr[i]);
			}
			return arr;
		}

		void deepFillInt(Object array, int val) {
			if (!array.getClass().isArray()) {
				throw new IllegalArgumentException();
			}
			if (array instanceof int[]) {
				int[] intArray = (int[]) array;
				Arrays.fill(intArray, val);
			} else {
				Object[] objArray = (Object[]) array;
				for (Object obj : objArray) {
					deepFillInt(obj, val);
				}
			}
		}

		void deepFillLong(Object array, long val) {
			if (!array.getClass().isArray()) {
				throw new IllegalArgumentException();
			}
			if (array instanceof long[]) {
				long[] intArray = (long[]) array;
				Arrays.fill(intArray, val);
			} else {
				Object[] objArray = (Object[]) array;
				for (Object obj : objArray) {
					deepFillLong(obj, val);
				}
			}
		}
	}
}