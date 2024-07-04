import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Solution {

	public static void main(String[] args) throws IOException {
		Reader s = new Reader();
		int T = s.nextInt(), N;
		int testCaseCounter = 1;
		StringBuilder strToPrint = new StringBuilder();
		Person bufferCandidate;

		while (testCaseCounter <= T) {
			StringBuilder strBuffer = new StringBuilder();
			strToPrint.append("Case #"+testCaseCounter+": ");
			N = s.nextInt();
			Person firstCandidate = new Person("C", N), secondCandidate = new Person("J", N);
			while(N-- > 0) {
				Activity newActivity = new Activity();
				newActivity.setStart(s.nextInt());
				newActivity.setEnd(s.nextInt());
				if(firstCandidate.isAvailable(newActivity)) {
					strBuffer.append(firstCandidate.addActivity(newActivity));
				}
				else if(secondCandidate.isAvailable(newActivity)) {
					strBuffer.append(secondCandidate.addActivity(newActivity));
				}
				else {
					strBuffer = new StringBuilder("IMPOSSIBLE");
					break;
				}
				bufferCandidate = firstCandidate;
				firstCandidate = secondCandidate;
				secondCandidate = bufferCandidate;
			}
			strToPrint.append(strBuffer+"\n");
			testCaseCounter++;
		} // end of while loop
		System.out.println(strToPrint.toString());
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


class Activity{
	public int start;
	public int end;
	
	public Activity() {
		this.start=0;
		this.end=0;
	}
	public Activity(int s, int e) {
		this.start=s;
		this.end=e;
	}
	
	public boolean overlaps(Activity that) {
		if( (this.start <= that.start && this.end > that.start) ||
				(this.start < that.end && this.end >= that.end) ||
				(this.start == that.start && this.end == that.end) )
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}

class Person{
	public String name;
	public int assigned;
	public Activity[] activities;
	
	public Person(String name, int N) {
		this.name = name;
		this.assigned = 0;
		this.activities = new Activity[N];
	}
	
	public boolean isAvailable(Activity givenActivity) {
		for (int i = 0; i < assigned; i++) {
			if(activities[i].overlaps(givenActivity))
				return false;
		}
		return true;
	}
	
	public String addActivity(Activity givenActivity) {
		activities[assigned] = givenActivity;
		this.assigned++;
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAssigned() {
		return assigned;
	}

	public void setAssigned(int assigned) {
		this.assigned = assigned;
	}

	public Activity[] getActivities() {
		return activities;
	}

	public void setActivities(Activity[] activities) {
		this.activities = activities;
	}
	
}
