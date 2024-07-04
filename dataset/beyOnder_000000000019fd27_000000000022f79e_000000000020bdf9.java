

import java.util.*;
import java.io.*;

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

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
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
		}

		}

class IOUtils {

		public static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readInt();
			return array;
		}

}



  public class Solution{
  	static InputReader in = new InputReader(System.in);
    static OutputWriter out	= new OutputWriter(System.out);

	  public static void sortbyColumn(int arr[][], int col)
	  {
		  // Using built-in sort function Arrays.sort
		  Arrays.sort(arr, new Comparator<int[]>() {

			  @Override
			  // Compare values according to columns
			  public int compare(final int[] entry1,
								 final int[] entry2) {

				  // To sort in descending order revert
				  // the '>' Operator
				  if (entry1[col] > entry2[col])
					  return 1;
				  else if(entry1[col] < entry2[col])
					  return -1;
				  else{
					  return (entry1[col-1] > entry2[col-1])?1:-1;
				  }
			  }
		  });  // End of function call sort().

	  }
	static void printAns(int arr[][],int n,int h){
    	HashMap<Integer,Character> map = new HashMap<>();

		int lastc = arr[0][1],lastj = 0;
		map.put(arr[0][2],'C');
		for(int i=1;i<n;i++){
			if(arr[i][0]>=lastc&&arr[i][0]<lastj){
				lastc=arr[i][1];
				map.put(arr[i][2],'C');
			}
			else if(arr[i][0]>=lastc&&arr[i][0]>=lastj){
			    if(lastc>=lastj){
                    lastc=arr[i][1];
                    map.put(arr[i][2],'C');
                }
			    else{
                    lastj = arr[i][1];
                    map.put(arr[i][2],'J');
                }
            }
			else if(arr[i][0]>=lastj){
				lastj = arr[i][1];
				map.put(arr[i][2],'J');
			}
			else{
				out.printLine("Case #"+h+": IMPOSSIBLE");
				return;
			}
		}
		out.print("Case #"+h+": ");
		for(int i=0;i<n;i++){
			out.print(map.get(i));
		}
		out.printLine();

	}
   	public static void main(String[] args){
        int t = in.readInt();
        for(int h=1;h<=t;h++){
            int n=in.readInt();
            int arr[][] = new int[n][3];
            for(int i=0;i<n;i++){
            	arr[i][0] = in.readInt();
            	arr[i][1] = in.readInt();
            	arr[i][2] = i;
			}
            sortbyColumn(arr,1);
            printAns(arr,n,h);

        }

   		out.flush();
   		out.close();
   	}
  }