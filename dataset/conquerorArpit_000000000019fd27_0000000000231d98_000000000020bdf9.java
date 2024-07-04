import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public void printArray(int arr[]) throws IOException {
			for (int i = 0; i < arr.length; i++) {
				if (i == arr.length - 1) {
					System.out.println(arr[i]);
				}
				System.out.print(arr[i] + " ");
			}
		}

		public int[] intArray(int n) throws IOException {
			Reader r = new Reader();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = r.nextInt();
			}
			return arr;
		}

		public long[] longArray(int n) throws IOException {
			Reader r = new Reader();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = r.nextInt();
			}
			return arr;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException {

		Reader r = new Reader();

		int t = r.nextInt();
		int j = 1;
		StringBuilder ans = new StringBuilder();

		while (t-- > 0) {

			int n = r.nextInt();

			ArrayList<Map.Entry<Map.Entry<Integer, Integer>, Integer>> sorted = new ArrayList<>();

			for (int i = 0; i < n; i++) {

				int start = r.nextInt();
				int end = r.nextInt();

				// adding {{start, end} , i} as an entry in list
				sorted.add(new AbstractMap.SimpleEntry(new AbstractMap.SimpleEntry(start, end), i));

			}

			// sorting the list acc. to the start time
			Collections.sort(sorted, new Comparator<Map.Entry<Map.Entry<Integer, Integer>, Integer>>() {
				@Override
				public int compare(Entry<Entry<Integer, Integer>, Integer> o1,
						Entry<Entry<Integer, Integer>, Integer> o2) {
					return o1.getKey().getKey() - o2.getKey().getKey();
				}
			});

			boolean flag = true;
			char res[] = new char[n];
			int cameron = 0, jamie = 0;

			for (int i = 0; i < n; i++) {

				int start = sorted.get(i).getKey().getKey();
				int end = sorted.get(i).getKey().getValue();

				if (start >= cameron) {
					res[sorted.get(i).getValue()] = 'C';
					cameron = end;
				} else if (start >= jamie) {
					res[sorted.get(i).getValue()] = 'J';
					jamie = end;
				} else {
					flag = false;
					break;
				}

			}

			ans.append("Case #").append(j++).append(": ").append((flag ? String.valueOf(res) : "IMPOSSIBLE"))
					.append("\n");
		}

		System.out.print(ans);

	}

}