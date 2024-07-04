import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

public class Solution{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Indicium solver = new Indicium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Indicium {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int k = in.readInt();
            int[][] mat = new int[n][n];
            int[] data = new int[n];
            int[] temp = new int[n];
            String result = "IMPOSSIBLE";
            for(int i = 0; i < n; i++){
                data[i] = i + 1;
            }
            AllPermutation perm = new AllPermutation(data);
            temp = perm.GetFirst();
            while(perm.HasNext()){
            
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = temp[j];
                }
            }

            for(int i = 0; i < n; i++){
                rotate(mat[i], n, i);
            }

            int trace = 0;
            for(int i = 0; i < n; i++){
                    trace += mat[i][i];
            }
            if(trace == k){
                result = "POSSIBLE";
                break;
            }
            temp = perm.GetNext();
        }
            System.out.println("Case #" + testNumber + ": " + result);
            if(result == "POSSIBLE"){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print(mat[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        public void rotate(int[] data, int n, int s){
            int temp, i, j;
            for(i = 0; i < s; i++){
                temp = data[0];
                for(j = 1; j <= (n-1); j++){
                    data[j-1] = data[j];
                }
                data[n-1] = temp;
            }
        }
    }

    // Java implementation of the approach 
static class AllPermutation 
{ 

	// The input array for permutation 
	private final int Arr[]; 

	// Index array to store indexes of input array 
	private int Indexes[]; 

	// The index of the first "increase" 
	// in the Index array which is the smallest 
	// i such that Indexes[i] < Indexes[i + 1] 
	private int Increase; 

	// Constructor 
	public AllPermutation(int arr[]) 
	{ 
		this.Arr = arr; 
		this.Increase = -1; 
		this.Indexes = new int[this.Arr.length]; 
	} 

	// Initialize and output 
	// the first permutation 
	public int[] GetFirst() 
	{ 

		// Allocate memory for Indexes array 
		this.Indexes = new int[this.Arr.length]; 

		// Initialize the values in Index array 
		// from 0 to n - 1 
		for (int i = 0; i < Indexes.length; ++i) 
		{ 
			this.Indexes[i] = i; 
		} 

		// Set the Increase to 0 
		// since Indexes[0] = 0 < Indexes[1] = 1 
		this.Increase = 0; 

		// Output the first permutation 
		return this.Arr; 
	} 

	// Function that returns true if it is 
	// possible to generate the next permutation 
	public boolean HasNext() 
	{ 

		// When Increase is in the end of the array, 
		// it is not possible to have next one 
		return this.Increase != (this.Indexes.length - 1); 
	} 

	// Output the next permutation 
	public int[] GetNext() 
	{ 

		// Increase is at the very beginning 
		if (this.Increase == 0) 
		{ 

			// Swap Index[0] and Index[1] 
			this.Swap(this.Increase, this.Increase + 1); 

			// Update Increase 
			this.Increase += 1; 
			while (this.Increase < this.Indexes.length - 1
				&& this.Indexes[this.Increase] 
						> this.Indexes[this.Increase + 1]) 
			{ 
				++this.Increase; 
			} 
		} 
		else
		{ 

			// Value at Indexes[Increase + 1] is greater than Indexes[0] 
			// no need for binary search, 
			// just swap Indexes[Increase + 1] and Indexes[0] 
			if (this.Indexes[this.Increase + 1] > this.Indexes[0]) 
			{ 
				this.Swap(this.Increase + 1, 0); 
			} 
			else
			{ 

				// Binary search to find the greatest value 
				// which is less than Indexes[Increase + 1] 
				int start = 0; 
				int end = this.Increase; 
				int mid = (start + end) / 2; 
				int tVal = this.Indexes[this.Increase + 1]; 
				while (!(this.Indexes[mid]<tVal&& this.Indexes[mid - 1]> tVal)) 
				{ 
					if (this.Indexes[mid] < tVal) 
					{ 
						end = mid - 1; 
					} 
					else
					{ 
						start = mid + 1; 
					} 
					mid = (start + end) / 2; 
				} 

				// Swap 
				this.Swap(this.Increase + 1, mid); 
			} 

			// Invert 0 to Increase 
			for (int i = 0; i <= this.Increase / 2; ++i) 
			{ 
				this.Swap(i, this.Increase - i); 
			} 

			// Reset Increase 
			this.Increase = 0; 
		} 
		return this.Arr; 
	} 
	// Swap two values in the Indexes array 
	private void Swap(int p, int q) 
	{ 
		int tmp = this.Indexes[p]; 
		this.Indexes[p] = this.Indexes[q]; 
		this.Indexes[q] = tmp; 
	} 
} 
    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

