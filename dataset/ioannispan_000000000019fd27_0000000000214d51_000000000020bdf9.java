import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
class Activity implements Comparable<Activity>{
	public int time;
	public int type;
	public int id;
	public Activity(int tm,int tp,int iid) {
		time=tm;
		type=tp;
		id=iid;
	}
	@Override
	public int compareTo(Activity other) {
		if (time<other.time) return -1;
		if (time>other.time) return 1;
		if (type<other.type) return -1;
		if (type>other.type) return 1;
		if (id<other.id) return -1;
		if (id>other.id) return 1;
		return 0;
	}
	
}
public class Solution {
public interface SpaceCharFilter {
public boolean isSpaceChar(int ch);
}

class InputReader {
private InputStream stream;
private byte[] buf = new byte[1024];
private int curChar;
private int numChars;
private SpaceCharFilter filter;
public InputReader(InputStream stream) {
this.stream = stream;
}
public int read() {
if (numChars == -1)
throw new InputMismatchException();
if (curChar >= numChars) {
curChar = 0;
try {

numChars = stream.read(buf);

} catch (IOException e) {

throw new InputMismatchException();

}

if (numChars <= 0)

return -1;

}

return buf[curChar++];

}
public int readInt() {

int c = read();

while (isSpaceChar(c))

c = read();

int sgn = 1;

if (c == '-') {

sgn = -1;

c = read();

}

int res = 0;

do {

if (c < '0' || c > '9')

throw new InputMismatchException();

res *= 10;

res += c - '0';

c = read();

} while (!isSpaceChar(c));

return res * sgn;

}


public long readLong() {

int c = read();

while (isSpaceChar(c))

c = read();

int sgn = 1;

if (c == '-') {

sgn = -1;

c = read();

}
long res = 0;
do {

if (c < '0' || c > '9')

throw new InputMismatchException();

res *= 10;

res += c - '0';

c = read();

} while (!isSpaceChar(c));

return res * sgn;

}
public String readString() {

int c = read();

while (isSpaceChar(c))
c = read();
StringBuilder res = new StringBuilder();
do {

res.appendCodePoint(c);
c = read();
} while (!isSpaceChar(c));
return res.toString();
}
public boolean isSpaceChar(int c) {

if (filter != null)

return filter.isSpaceChar(c);

return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}
public String next() {
return readString();
}
}
class OutputWriter {
private final PrintWriter writer;
public OutputWriter(OutputStream outputStream) {
writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
}
public OutputWriter(Writer writer) {
this.writer = new PrintWriter(writer);
}
public void print(Object...objects) {
for (int i = 0; i < objects.length; i++) {
if (i != 0)
writer.print(' ');
writer.print(objects[i]);
}
}
public void printLine(Object...objects) {
print(objects);
writer.println();
}
public void close() {
writer.close();
}
public void flush() {
writer.flush();
}}
InputReader in= new InputReader(System.in);
OutputWriter out = new OutputWriter(System.out);
StringTokenizer tok;
public static void main(String[] args) throws IOException
{
   new Solution().run();
}

void run() throws IOException
{  
   solve();
   out.flush();
   tok=null;
}


void solve()  throws IOException{
	int T=in.readInt();
	for (int t=0;t<T;++t) {
		int n=in.readInt();
		Activity[] acts=new Activity[2*n];
		int[] which=new int[n];
		int j=0;
		for (int i=0;i<n;++i) {
			int start=in.readInt();
			int finish=in.readInt();
			acts[j++]=new Activity(start,2,i);
			acts[j++]=new Activity(finish,1,i);
		}
		Arrays.sort(acts);
		boolean j_free=true;
		boolean c_free=true;
		boolean noans=false;
		for (int i=0;i<2*n;++i) {
			Activity curr=acts[i];
			if (curr.type==1) {
				if (which[curr.id]==1) j_free=true;
				else c_free=true;
			}else {
				if (j_free) {
					which[curr.id]=1;
					j_free=false;
				}
				else if (c_free) {
					c_free=false;
					which[curr.id]=2;
				}
				else {
					noans=true;
					break;
				}
					
			}
		}
		if (noans) {
			out.printLine("Case #"+(t+1)+": IMPOSSIBLE");
		}else {
			out.print("Case #"+(t+1)+": ");
			for (int i=0;i<n;++i) {
				if (which[i]==1) {
					out.print("J");
				}else {
					out.print("C");
				}
			}
			out.printLine("");

		}
	}
}
}