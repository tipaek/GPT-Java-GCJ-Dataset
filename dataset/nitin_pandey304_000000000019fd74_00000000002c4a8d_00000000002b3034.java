import java.util.*;
import java.io.*;
public class Solution {

    //Reader from https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/?ref=rp
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
			byte[] buf = new byte[110]; // line length 
			int cnt = 0, c; 
			while ((c = read()) != -1) 
			{ 
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
			do
			{ 
				ret = ret * 10 + c - '0'; 
			} while ((c = read()) >= '0' && c <= '9'); 

			if (neg) 
				return -ret; 
			return ret; 
		} 

		public long nextLong() throws IOException { 
			long ret = 0; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 
			do { 
				ret = ret * 10 + c - '0'; 
			} 
			while ((c = read()) >= '0' && c <= '9'); 
			if (neg) 
				return -ret; 
			return ret; 
		} 

		public double nextDouble() throws IOException { 
			double ret = 0, div = 1; 
			byte c = read(); 
			while (c <= ' ') 
				c = read(); 
			boolean neg = (c == '-'); 
			if (neg) 
				c = read(); 

			do { 
				ret = ret * 10 + c - '0'; 
			} 
			while ((c = read()) >= '0' && c <= '9'); 

			if (c == '.') 
			{ 
				while ((c = read()) >= '0' && c <= '9') 
				{ 
					ret += (c - '0') / (div *= 10); 
				} 
			} 

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
    
    //Main code starts from here

    private static String solve(String[] arr, int maxLen, int maxI) {
        int n = arr.length;

        char last = arr[maxI].charAt(arr[maxI].length()-1);

        for(int pos = 1 ;  pos < maxLen ; pos++) {
            for(int i = 0 ; i <  n ; i++) {
                char checkChar;
                if(arr[i].length() > pos) {
                    checkChar = arr[i].charAt(arr[i].length() - pos);
                } else {
                    checkChar = '*';
                }
                if(last != checkChar && checkChar != '*') {
                    return "*";
                }
            }
            last = arr[maxI].length()-pos-1 >= 0 ? arr[maxI].charAt(arr[maxI].length()-pos-1) : '*';
        }
        return arr[maxI].substring(1);
    }

    private static String extractStart(String str) {
        String out = "";

        for(int i = 0 ; i < str.length() ; i++) {
            out = out + str.charAt(i);
            if(str.charAt(i) == '*') {
                break;
            }
        }
        return out.substring(0, out.length()-1);
    }

    private static String extractEnd(String str) {
        String out = "";

        for(int i = str.length() -1 ; i >= 0 ; i--) {
            out = str.charAt(i) + out;
            if(str.charAt(i) == '*') {
                break;
            }
        }
        return out.substring(1);
    }

    //new logic
    private static String solve1(String[] arr, int maxLen, int maxI) {
        int n = arr.length;

        String start = "", end = "";

        for(int i = 0 ; i <  n ; i++) {
            String f = extractStart(arr[i]);
            String l = extractEnd(arr[i]);
            if(!start.equals("")) {
                if(start.length() < f.length()) {
                    String temp = start;
                    start = f;
                    f = temp;
                }
                if(!start.contains(f) && !f.equals("*")) {
                    return "*";
                }
            } else {
                start = f;
            }
            if(!end.equals("")) {
                if(end.length() < l.length()) {
                    String temp = end;
                    end = l;
                    l = temp;
                }
                if(!end.contains(l) && !l.equals("*")) {
                    return "*";
                }
            } else {
                end = l;
            }
        }

        String ans = "";

        for(int i = 0 ; i <  n ; i++) {
            String str = arr[i];
            str = str.substring(extractStart(str).length());
            str = str.substring(0, str.length() - extractEnd(str).length());
            // System.out.println(str);
            String out = "";
            for(int j = 1 ; j < str.length() -1 ; j++) {
                if(str.charAt(j) != '*') {
                    out += str.charAt(j);
                }
            }
            // System.out.println(out);
            ans += out;
        }
        // if(start.length() > 1) {
        //     ans = start.substring(0, start.length()-1) + ans;
        // }
        // if(end.length() > 1) {
        //     ans = ans + end.substring(1);
        // }
        return start + ans + end;
    }

    public static void main(String[] args) throws Exception {
        Reader s=new Reader(); 
        int t = s.nextInt();
        for(int k = 0 ; k < t ; k++){ 
            int n = s.nextInt();
            String[] arr = new String[n];
            int maxLen = -1;
            int maxI = -1;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = s.readLine();
                if(arr[i].length() > maxLen) {
                    maxI = i;
                    maxLen = arr[i].length();
                }
            }
            String ans = solve1(arr, maxLen, maxI);
			System.out.println("Case #"+(k+1)+": " + ans); 
		} 
    }
}