import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution {

	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
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
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
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
  
        public double nextDouble() throws IOException 
        { 
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
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
	
	public static void main(String[] args) throws IOException {
		Reader reader = new Reader();
		int t = reader.nextInt(), testCase = 1;
		while(testCase <= t) {
			int n = reader.nextInt();
			int[][] arr = new int[n][3];
			for(int i = 0; i < n; i++) {
				arr[i][0] = reader.nextInt();
				arr[i][1] = reader.nextInt();
				arr[i][2] = i;
			}
			boolean impossible = false;
			Arrays.sort(arr, (A, B) -> (A[0] == B[0] ? A[1] - B[1] : A[0] - B[0]));
			char[] str = new char[n];
			for(int i = 0; i < n; i++) {
				boolean jamie = false, cameron = false;
				for(int j = i + 1; j < n; j++) {
					if(arr[i][1] > arr[j][0]) {
						if(str[j] == 'J') {
							jamie = true;
						} else if(str[j] == 'C'){
							cameron = true;
						}
					} else {
						break;
					}
				}
				if((jamie && str[i] == 'J') || (cameron && str[i] == 'C')) {
					impossible = true;
					break;
				}
				if(str[i] != 'J' && str[i] != 'C') {
					str[i] = jamie ? 'C': 'J';
				}
				for(int j = i + 1; j < n; j++) {
					if(arr[i][1] > arr[j][0]) {
						if(str[i] == 'J') {
							str[j] = 'C';
						} else if(str[i] == 'C'){
							str[j] = 'J';
						}
					} else {
						break;
					}
				}
			}
			char[] ans = new char[n];
			for(int i = 0; i < n; i++) {
				ans[arr[i][2]] = str[i];
			}
			System.out.println("Case #" + testCase++ + ": " + (impossible ? "IMPOSSIBLE" : new String(ans)));
		}
	}

}
