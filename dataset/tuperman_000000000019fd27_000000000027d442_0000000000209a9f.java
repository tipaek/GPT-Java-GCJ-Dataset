import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int T = reader.nextInt();
		int testCaseCounter = 1;
		String currentLine;
		StringBuilder strToPrint = new StringBuilder();

		while (testCaseCounter <= T) {
			System.out.print("Case #" + testCaseCounter + ": ");
			currentLine = reader.readLine();

			if (currentLine.length() == 1) {
				if (currentLine.charAt(0) == '0') {
					System.out.print("0\n");
				} else {
					System.out.print("(1)\n");
				}
				testCaseCounter++;
				continue;
			}

			if (currentLine.charAt(0) == '1') {
				System.out.print("(");
			}
			
			int i = 1;
			for (; i < currentLine.length(); i++) {
				// Handles 0
				if (currentLine.charAt(i) == '0') {
					if(currentLine.charAt(i-1) == '0')
						System.out.print("0");
					else
						System.out.print("1)");
				}
				// Handles 1
				else {
					if(currentLine.charAt(i-1) == '0')
						System.out.print("0(");
					else
						System.out.print("1");
				}
			}
			// Handles last char's situation
			if (currentLine.charAt(i-1) == '0') 
				System.out.print("0\n");
			else
				System.out.print("1)\n");
			testCaseCounter++;
		} // end of while loop

	} // end of main


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
