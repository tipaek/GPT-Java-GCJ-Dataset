import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

 class Solution {

	private static final String NEWLINE = "\n";
	private static final String SPACE = " ";
	private static final String COLON = ":";
	private static final String CASE = "Case #";

	public static void main(String args[]) throws IOException {
		Reader in = new Reader();
		int T = in.nextInt();
		int t = 1;
		StringBuilder sb = new StringBuilder();
		while (t<=T) {
			String s = in.readLine();
			String res = get(s);
			sb.append(CASE).append(t).append(COLON).append(SPACE).append(res)
			  .append(NEWLINE);
			t++;
		}
		System.out.println(sb);
		in.close();
	}
	
	private static String get(String s) {
		List<Integer> list = new ArrayList<Integer>();
		int n = s.length();
		for (int i=0;i<n;i++) {
			if (s.charAt(i) == '0' || s.charAt(i) == '1') {
				list.add(s.charAt(i)-'0');
			}
		}

		int m = list.size();
		int a[] = new int[m];
		for (int i=0;i<m;i++) a[i] = list.get(i);
		
		int l = 0;
		StringBuilder sb = new StringBuilder();
		while (l<m) {
			if (a[l] == 0) {
				sb.append(a[l]);
				l++;
			} else {
				sb.append("(");
				while (l<m && a[l] == 1) {
					sb.append(a[l]);
					l++;
				}
				sb.append(")");
			}
		}
		return sb.toString();
	}

	private static class Pair {
		Integer x;
		Integer y;
		private Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof Pair))
				return false;
			Pair cor = (Pair)o;
			return x.equals(cor.x) && y.equals(cor.y);
		}
		
		@Override
		public int hashCode() {
			int result = 17;
			result = result + 31*x;
			result = result + 31*y;
			return result;
		}
		
		static class PairComparatorX implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.x.compareTo(o2.x);
			}
			
		}

		static class PairComparatorY implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.y.compareTo(o2.y);
			}
			
		}

	}
	
	static class Reader {
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

}
