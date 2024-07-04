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
			strToPrint.append("Case #"+testCaseCounter+": ");
			currentLine = reader.readLine();
			
			if(currentLine.length()==1) {
				int buffer = Character.getNumericValue(currentLine.charAt(0));
				if(buffer == 0) {
					strToPrint.append("0\n");
				}
				else {
					for (int i = 0; i < buffer; i++) {
						strToPrint.append('(');
					}
					strToPrint.append(currentLine);
					for (int i = 0; i < buffer; i++) {
						strToPrint.append(')');
					}
					strToPrint.append('\n');
				}
				testCaseCounter++;
				continue;
			}
			
			StringBuilder bufferBuilder = new StringBuilder();
			int following = Character.getNumericValue(currentLine.charAt(0));
			for (int i = 0; i < following; i++) {
				bufferBuilder.append('(');
			}
			strToPrint.append(evaluateLine(currentLine, currentLine.length()-1, 1, bufferBuilder));
			testCaseCounter++;
		}// end of while loop
		System.out.print(strToPrint.toString());
		
	} // end of main
	
	static StringBuilder evaluateLine(String line, int length, int offset, StringBuilder givenStrBuilder) {
		int preceding = Character.getNumericValue(line.charAt(offset-1));
		int following = Character.getNumericValue(line.charAt(offset));
		
		// Handles 0
		if(following==0) {
			givenStrBuilder.append(preceding);
			for (int i = 0; i < preceding; i++) {
				givenStrBuilder.append(')');
			}
			//Base for 0
			if(length == offset) {
				givenStrBuilder.append(following);
				givenStrBuilder.append('\n');
				return givenStrBuilder;
			}
			else {
				return evaluateLine(line, length, offset+1, givenStrBuilder);
			}
		}
		
		int min = Math.min(preceding, following);
		
		givenStrBuilder.append(preceding);
		for (int i = 0; i < preceding-min; i++) {
			givenStrBuilder.append(')');
		}
		for (int i = 0; i < following-min; i++) {
			givenStrBuilder.append('(');
		}
		
		//Base case
		if(length == offset) {
			givenStrBuilder.append(following);
			for (int i = 0; i < following; i++) {
				givenStrBuilder.append(')');
			}
			givenStrBuilder.append('\n');
			return givenStrBuilder;
		}
		else {
			return evaluateLine(line, length, offset+1, givenStrBuilder);
		}
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
