import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
  
public class Solution 
{ 
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
            byte[] buf = new byte[100]; // line length 
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

    static class People implements Comparable<People> {
    	int st;
    	int en;
    	int p;
		int pos;
		
		public String toString() {
			return "st: " + this.st + ", en:" + this.en + ", pos:" + pos;
		}
    	
    	public People(int st, int en, int pos){
    		this.st = st;
    		this.en = en;
    		this.p = -1;
			this.pos = pos;
    	}

	    public int compareTo(People b) 
	    { 
	        if(this.st == b.st){
	        	return this.en - b.en;
	        }
	        return this.st - b.st;
	    } 
    }
    
    static class SortByPos implements Comparator<People> 
	{ 
	    // Used for sorting in ascending order of 
	    // roll name 
	    public int compare(People a, People b) 
	    { 
	        return a.pos- b.pos; 
	    } 
	} 

    public static void solution(int tcase, People[] arr) {
    	
    	// System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));

		boolean c = true;
		boolean j = true;
		int endc = -1;
		int endj = -1;
		
		for(int i=0;i<arr.length;i++){
			
			People p = arr[i];
			
			if(!c && endc <= p.st) {
				c = true;
				endc = -1;
			}
			if(!j && endj <= p.st) {
				j = true;
				endj = -1;
			}
			
			if(c) {
				p.p = 1;
				c = false;
				endc = p.en;
			}
			else if(j) {
				p.p = 2;
				j = false;
				endj = p.en;
			}
			else{
				System.out.println("Case #" + tcase + ": " + "IMPOSSIBLE");
				return;
			}
		}
		
		Arrays.sort(arr, new SortByPos());
		StringBuilder sb = new StringBuilder();
		String init = "Case #" + tcase + ": ";
		sb.append(init);
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i].p == 1 ? 'C': 'J');
		}
		System.out.println(sb.toString());
    }
  
    public static void main(String[] args) throws IOException 

    { 
        Reader s=new Reader(); 
        int t = s.nextInt(); 
        int cnt=1;
        
        while (cnt<=t) 
        {
        	int n = s.nextInt();
        	People[] ass = new People[n];
        	for(int i=0;i<n;i++){
        		ass[i] = new People(s.nextInt(), s.nextInt(), i);
        	}
        	
        	solution(cnt++, ass);
               
        } 
    } 
} 
