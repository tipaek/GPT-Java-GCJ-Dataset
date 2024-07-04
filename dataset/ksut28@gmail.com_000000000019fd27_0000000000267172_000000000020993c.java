
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

 class Solution {

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		Reader s = new Reader();
		int testCases = s.nextInt();

		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();

		for (int i = 1; i <= testCases; i++) {
			int rowCount = 0;
			int colCount = 0;
			int trace = 0;
			int matrixSize = s.nextInt();
			int[][] matrix = new int[matrixSize][matrixSize];

			for (int r = 0; r < matrixSize; r++) {
				for (int c = 0; c < matrixSize; c++) {
					matrix[r][c] = s.nextInt();
					if (r == c)
						trace += matrix[r][c];
				}
			}
			for (int j = 0; j < matrixSize; j++) {
				for (int k = 0; k < matrixSize; k++) {
					if (row.contains(matrix[j][k])) {
						rowCount++;
						break;
					} else {
						row.add(matrix[j][k]);
					}
				}
				for (int k = 0; k < matrixSize; k++) {
					if (col.contains(matrix[k][j])) {
						colCount++;
						break;
					} else {
						col.add(matrix[k][j]);
					}
				}
				row.clear();
				col.clear();
			}
			System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);

		}

	}

}
