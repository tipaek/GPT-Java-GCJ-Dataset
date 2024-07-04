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
		int[][] A=new int[n][n];
		int trace=0;
		int[] mostrecent_row=new int[n];
		int[] mostrecent_col=new int[n];
		boolean[] duplicate_row=new boolean[n];
		boolean[] duplicate_col=new boolean[n];
		for (int i=0;i<n;++i) {
			mostrecent_row[i]=-1;
			mostrecent_col[i]=-1;
			duplicate_row[i]=false;
			duplicate_col[i]=false;
		}
		int dupl_rows=0;
		int dupl_cols=0;
		for (int i=0;i<n;++i) {
			for (int j=0;j<n;++j) {
			int x=in.readInt();
			if (i==j) trace+=x;
			if (mostrecent_row[x-1]<i) {
				mostrecent_row[x-1]=i;
			}else {
				if (!duplicate_row[i])
					dupl_rows++;
				duplicate_row[i]=true;
			}
			A[i][j]=x;
			}
		
		}
		for (int j=0;j<n;++j) {
			for (int i=0;i<n;++i) {
				int x=A[i][j]-1;
				if (mostrecent_col[x]<j) {
					mostrecent_col[x]=j;
				}else {
					if (!duplicate_col[j]) {
						dupl_cols++;
						duplicate_col[j]=true;
					}
				}
			}
		}
		out.printLine("Case #"+(t+1)+": "+trace+" "+dupl_rows+" "+dupl_cols);
	}
}
}