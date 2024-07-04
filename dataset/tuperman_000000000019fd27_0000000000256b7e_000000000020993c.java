import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Solution {

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		int T = s.nextInt();
		int N, repeatedRows, repeatedCols, trace, testCaseCounter = 1, current;
		int[][] rowsArr, colsArr;
		
		while (testCaseCounter <= T) {
			
			N = s.nextInt();
			repeatedRows = 0; 
			repeatedCols = 0;
			trace = 0;
			
			// Initializes Arrays
			rowsArr = new int[N][N+1];
			colsArr = new int[N][N+1];

			// Reads from stdin and checks both rows and column immediately
			
			for (int rowCounter = 0; rowCounter < N; rowCounter++) {
				for (int columnCounter = 0; columnCounter < N; columnCounter++) {
					current = s.nextInt();
					
					if(rowCounter == columnCounter)
						trace += current;
					
					// 1 represents row has already turned out to be repetitive
					if(rowsArr[rowCounter][0] == 0) {
						if(rowsArr[rowCounter][current] == 1) {
							rowsArr[rowCounter][0] = 1;
							repeatedRows++;
						}
						else {
							rowsArr[rowCounter][current] = 1;
						}
					}
					
					
					// 1 represents row has already turned out to be repetitive
					if(colsArr[columnCounter][0] == 0) {
						if(colsArr[columnCounter][current] == 1) {
							colsArr[columnCounter][0] = 1;
							repeatedCols++;
						}
						else {
							colsArr[columnCounter][current] = 1;
						}
					}
					
					
				}
			}
			System.out.println("Case #"+testCaseCounter+": "+trace+" "+repeatedRows+" "+repeatedCols);
			testCaseCounter++;
		} // end of while loop

	}

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

}