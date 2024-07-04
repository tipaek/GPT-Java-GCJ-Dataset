import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Solution {

	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int T = reader.nextInt();
		int testCaseCounter = 1;
		String currentLine;
		NestedInt[] nestedInts;
		StringBuilder str = new StringBuilder(); 
		
		while (testCaseCounter <= T) {
			currentLine = reader.readLine();
			nestedInts = new NestedInt[currentLine.length()];
			// Creates first element of array of ADT
			nestedInts[0] = new NestedInt( Character.getNumericValue(currentLine.charAt(0)) );
			// Creates other elements of array
			for (int i = 1; i < nestedInts.length; i++) {
				nestedInts[i] = new NestedInt( Character.getNumericValue(currentLine.charAt(i)));
				// Newcomers decrease #closings of the preceding one and #openings of itself
				nestedInts[i].updateNumberOfOpenings(nestedInts[i-1].updateNumberOfClosings(nestedInts[i].value));
			}
			
			str.append("Case #"+testCaseCounter+": ");

			for (int i = 0; i < nestedInts.length; i++) {
				for (int j = 0; j < nestedInts[i].numberOfOpenings; j++) {
					str.append('(');
				}
				str.append(nestedInts[i].value);
				for (int j = 0; j < nestedInts[i].numberOfClosings; j++) {
					str.append(')');
				}
			}
			str.append('\n');
			testCaseCounter++;
		}
		System.out.print(str.toString());
		
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

class NestedInt {
	int value;
	int numberOfOpenings;
	int numberOfClosings;
	
	public NestedInt(int givenValue) {
		this.value = givenValue;
		this.numberOfOpenings = givenValue;
		this.numberOfClosings = givenValue;
	}
	public NestedInt() {
		this.value = 0;
		this.numberOfOpenings = 0;
		this.numberOfClosings = 0;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}
	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}
	public int getNumberOfClosings() {
		return numberOfClosings;
	}
	public void setNumberOfClosings(int numberOfClosings) {
		this.numberOfClosings = numberOfClosings;
	}
	public int updateNumberOfClosings(int givenNumber) {
		if(givenNumber <= this.getNumberOfClosings()) {
			this.setNumberOfClosings(this.getNumberOfClosings() - givenNumber);
			return givenNumber;
		}
		else {
			int buffer = this.getNumberOfClosings();
			this.setNumberOfClosings(0);
			return buffer;
		}
	}
	public void updateNumberOfOpenings(int givenNumber) {
		this.setNumberOfOpenings(this.getNumberOfOpenings() - givenNumber);
	}
	
}
