import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


class Vestigium {

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		int T = s.nextInt();
		int N, repeatedRows, repeatedCols, trace, testCaseCounter = 1;
		ArrayList<HashSet<Short>> rowsList, colsList;
		HashSet<Short> targetSetForRows, targetSetForCols;
		Short bufferZero = Short.valueOf((short)0);
		Short current;
		
		while (testCaseCounter <= T) {
			
			N = s.nextInt();
			repeatedRows = 0; 
			repeatedCols = 0;
			trace = 0;
			
			// Initializes lists of sets
			rowsList = new ArrayList<HashSet<Short>>();
			colsList = new ArrayList<HashSet<Short>>();
			// For each one of N rows and N columns, there is a set
			for (int i = 0; i < N; i++) {
				rowsList.add(new HashSet<Short>());
				colsList.add(new HashSet<Short>());
			}
			
			// Reads from stdin and checks both rows and column immediately
			for (int rowCounter = 0; rowCounter < N; rowCounter++) {
				targetSetForRows = rowsList.get(rowCounter);
				
				for (int columnCounter = 0; columnCounter < N; columnCounter++) {
					targetSetForCols = colsList.get(columnCounter);
					current = Short.valueOf( (short) s.nextInt() ); // reads and wraps up next number
					
					if(rowCounter == columnCounter)
						trace += current;
					
					// 0 represents row has already turned out to be repetitive
					if(!targetSetForRows.contains(bufferZero)) {
						if(targetSetForRows.contains(current)) {
							targetSetForRows.add(bufferZero);
							repeatedRows++;
						}
						else {
							targetSetForRows.add(current);
						}
					}
					// 0 represents column has already turned out to be repetitive
					if(!targetSetForCols.contains(bufferZero)) {
						if(targetSetForCols.contains(current)) {
							targetSetForCols.add(bufferZero);
							repeatedCols++;
						}
						else {
							targetSetForCols.add(current);
						}
					}
					
				} // end of inner for loop
			} // end of outer for loop
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
