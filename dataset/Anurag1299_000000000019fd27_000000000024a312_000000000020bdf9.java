import java.util.*;
import java.io.*;

class Solution{
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

    static class Activity{
    	int start;
    	int end;
    	int srNo;
    	int assignedTo = 0;
    	Activity(int start, int end, int srNo){
    		this.start = start;
    		this.end = end;
    		this.srNo = srNo;
    	}

    	public String toString(){
    		return "srNo = "+srNo+" start = "+start+" , end = "+end+" assignedTo = "+assignedTo+"\n";
    	}
    }

    //MAIN HERE------------------->

    public static void main(String[] args) throws IOException{
    	Reader r = new Reader();
    	int t = r.nextInt();
    	for (int z=0;z<t ;z++ ) {
    		int n = r.nextInt();
    		Activity ac[] = new Activity[n];
    		for (int i=0;i<n ;i++ ) {
    			int start = r.nextInt();
    			int end = r.nextInt();
    			ac[i] = new Activity(start,end,i+1);
    		}
    		Arrays.sort(ac, new Comparator<Activity>(){
    			public int compare(Activity a1, Activity a2){
    				if(a1.end == a2.end){
    					return 0;
    				}else if(a1.end > a2.end){
    					return 1;
    				}else{
    					return -1;
    				}
    			}
    		});
    		boolean j = false;
    		boolean c = false;
    		boolean impossible = false;
    		int lastAssignedC = -1, lastAssignedJ = -1;
    		for (int i=0;i<n ;i++ ) {
    			
    			if(i==0){
    				j = true;
    				lastAssignedJ = ac[i].end;
    				ac[i].assignedTo = 1;
    				continue;
    			}
    			if(!j || lastAssignedJ <= ac[i].start){
    				j = true;
    				lastAssignedJ = ac[i].end;
    				ac[i].assignedTo = 1;
    			}else if(!c || lastAssignedC <= ac[i].start){
    				c = true;
    				lastAssignedC = ac[i].end;
    				ac[i].assignedTo = 2;
    			}else{
    				impossible = true;
    				break;
    			}
    			

    		}
    		if(impossible){
    			System.out.println("Case #"+(z+1)+": "+"IMPOSSIBLE");
    			continue;
    		}

    		Arrays.sort(ac, new Comparator<Activity>(){
    			public int compare(Activity a1, Activity a2){
    				if(a1.srNo == a2.srNo){
    					return 0;
    				}else if(a1.srNo > a2.srNo){
    					return 1;
    				}else {
    					return -1;
    				}
    			}
    		});
    		StringBuffer ans = new StringBuffer("Case #"+(z+1)+": ");
    		for (int i=0;i<n ;i++ ) {
    			if(ac[i].assignedTo == 1){
    				ans.append('J');

    			}else{
    				ans.append('C');
    			}
    		}
    		System.out.println(ans);

    		
    	}
    }
}