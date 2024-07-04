import java.util.*;
import java.io.*;

public class Solution {
	
	static int n;
	static int[] array;
	
	public static void rev() {
		for(int i = 0; i < n / 2; i++) {
			int j = n - i - 1;
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	
	public static void comp() {
		for(int i = 0; i < n; i++)
			array[i] = 1 - array[i];
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);		
		
		int t = sc.nextInt();
		n = sc.nextInt();
		while(t-->0) {
			array = new int[n];
			TreeSet<Integer> typeA = new TreeSet<>();
			TreeSet<Integer> typeB = new TreeSet<>();
			int q = 0;
			int index = 0;
			while(q < 10) {
				System.out.println(index + 1);
				System.out.flush();
				q++;
				int x = sc.nextInt();
				System.out.println(n - index);
				System.out.flush();
				q++;
				int y = sc.nextInt();
				
				array[index] = x;
				array[n - index - 1] = y;
				if(x == y)
					typeA.add(index);
				else
					typeB.add(index);
				index++;
			}
			
			while(index < n / 2) {
				q = 0;
				if(typeA.size() == 0) {
					int i = typeB.first();
					System.out.println(i + 1);
					System.out.flush();
					q++;
					int x = sc.nextInt();
					System.out.println(n - i);
					System.out.flush();
					int y = sc.nextInt();
					q++;
					if(x != array[i]) {
						rev();
					}
				} else if(typeB.size() == 0) {
					int i = typeA.first();
					System.out.println(i + 1);
					System.out.flush();
					q++;
					int x = sc.nextInt();
					System.out.println(n - i);
					System.out.flush();
					int y = sc.nextInt();
					q++;
					if(x != array[i]) {
						comp();
					}
				} else {
					int i = typeA.first();
					System.out.println(i + 1);
					System.out.flush();
					q++;
					int x = sc.nextInt();
					int j = typeB.first();
					System.out.println(j + 1);
					System.out.flush();
					q++;
					int y = sc.nextInt();
					if(x == array[i]) {
						if(y == array[j]) {
							
						} else {
							rev();
						}
					} else {
						if(y == array[j]) {
							rev();
							comp();
						} else {
							comp();
						}
					}
				}
				
				while(q < 10 && index < n / 2) {
					System.out.println(index + 1);
					System.out.flush();
					q++;
					int x = sc.nextInt();
					System.out.println(n - index);
					System.out.flush();
					q++;
					int y = sc.nextInt();
					
					array[index] = x;
					array[n - index - 1] = y;
					if(x == y)
						typeA.add(index);
					else
						typeB.add(index);
					index++;
				}
			}
			
			StringBuilder sb = new StringBuilder("");
			for(int i = 0; i < n; i++)
				sb.append(Integer.toString(array[i]));
			System.out.println(sb);
			System.out.flush();
			
			String res = sc.next();
			if(res.equals("N"))
				break;
		}
	}

	public static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();
			return array;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] array = new Integer[n];
			for (int i = 0; i < n; i++)
				array[i] = new Integer(nextInt());
			return array;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();
			return array;
		}

		public double[] nextDoubleArray(int n) throws IOException {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();
			return array;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}
