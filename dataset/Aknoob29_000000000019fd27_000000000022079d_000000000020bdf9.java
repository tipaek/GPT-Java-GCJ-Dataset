//package notDecidedYet;
import java.io.*;
import java.util.*;
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
		// TODO Auto-generated method stub
Reader sc=new Reader();
/*
int a1[]= {1,2,3,4,6};
for(int i=0;i<a1.length;i++) {
System.out.print(Arrays.binarySearch(a1,a1[i]));
}
*/
/*
int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int a[][];
			int N=sc.nextInt();
			a=new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					a[r][c]=sc.nextInt();
				}
			}
			int k=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(r==c) {
						k=k+a[r][c];
					}
				}
			}
			int nor=0,noc=0;
			
			int trr[]=new int[N];int trc[]=new int[N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
			        trr[c]=a[r][c];
			        trc[c]=a[c][r];
				}
				Arrays.sort(trr);
				Arrays.sort(trc);
				for(int p=0;p<trr.length;p++) {
					
					for(int p1=0;p1<trr.length;p1++) {
						if(Arrays.binarySearch(trr,trr[p1])==p && p!=p1) {
							nor++; p1=trr.length+p1;
							p=p+trr.length;
						}
						
					}
				}
                       for(int p=0;p<trr.length;p++) {
					
					for(int p1=0;p1<trr.length;p1++) {
						if(Arrays.binarySearch(trc,trc[p1])==p && p!=p1) {
							noc++; p1=trc.length+p1;
							p=p+trc.length;
						}
						
					}
				}
			
			
		
			
		}
			System.out.println("Case #"+(i+1)+": "+k+" "+nor+" "+noc);
	}

		*/
		
int t=sc.nextInt();
for(int i=0;i<t;i++) {
	int N=sc.nextInt();
	LinkedList<Integer> sl=new 	LinkedList<Integer>();
	LinkedList<Integer> el=new 	LinkedList<Integer>(); LinkedList<String> st=new 	LinkedList<String>();
	for(int j=0;j<N;j++) {
		sl.add(j,sc.nextInt()); el.add(j,sc.nextInt()); //System.out.println(55);
	} st.add(0,"ok");
	for(int j=0;j<N;j++) { //System.out.println(55);
	     if((j+1)<N && el.get(j)>sl.get(j+1)) {
	    	 st.add(j+1,"overlap"); //System.out.println(55);
	     }else if((j+1)<N){
	    	 st.add(j+1,"nooverlap");
	     }
	}
	//System.out.println(66);
	StringBuilder s=new  StringBuilder();
	s.append("C");
	for(int j=0;j<N;j++) {
		if((j+1)<N && st.get(j+1).equals("overlap") ){
		if(s.charAt(j)=='C') {
			s.append("J");
		}else {
			s.append("C");
		}
		}
		else if((j+1)<N && st.get(j+1).equals("nooverlap") ) {
			s.append("C");
		}
	}int tert=0; 
	for(int j=0;j<st.size();j++) {
		if(st.get(j).equals("overlap")) {
			tert++;
		}
	}
	if(tert==st.size()-1) {
		System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
	}
	else {
		System.out.println("Case #"+(i+1)+": "+s);
	}
	
}



}
}